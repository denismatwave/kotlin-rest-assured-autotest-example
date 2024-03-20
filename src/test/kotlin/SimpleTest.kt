import io.kotest.matchers.longs.shouldBeNonNegative
import io.kotest.matchers.nulls.shouldNotBeNull
import io.kotest.matchers.shouldBe
import models.Pet
import models.ResponseMessage
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import requests.Pet.deletePet
import requests.Pet.getPet
import requests.Pet.postPet

class SimpleTest {

    private lateinit var petRequest : Pet

    @BeforeEach
    fun setUp() {
        petRequest = Pet(name = "Pet1", status = "Test")
    }

    @Test
    fun test() {
        val pet = postPet(petRequest).extract().body().`as`(Pet::class.java)
        with (pet) {
            id.shouldNotBeNull()
            name.shouldBe(petRequest.name)
            status.shouldBe(petRequest.status)
        }
        val petId = pet.id.toString()

        getPet(petId).extract().body().jsonPath().get<Long>("id")
            .shouldBeNonNegative()
            .shouldBe(petId.toLong())

        deletePet(petId)
    }

    @Test
    fun testDeletePet() {
        val pet = postPet(petRequest).extract().body().`as`(Pet::class.java)
        deletePet(pet.id.toString())
        with(getPet(pet.id.toString(), 404).extract().body().`as`(ResponseMessage::class.java)) {
            message.shouldBe("Pet not found")
            type.shouldBe("error")
        }
    }
}