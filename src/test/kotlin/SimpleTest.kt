import io.kotest.matchers.longs.shouldBeNonNegative
import io.kotest.matchers.nulls.shouldNotBeNull
import io.kotest.matchers.shouldBe
import models.Pet
import models.PetGetResponse
import models.ResponseMessage
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
        val pet = postPet(petRequest)
        with (pet) {
            id.shouldNotBeNull()
            name.shouldBe(petRequest.name)
            status.shouldBe(petRequest.status)
        }
        val petId = pet.id.toString()

        with (getPet(petId) as PetGetResponse) {
            id?.shouldBeNonNegative()
            id.shouldBe(petId.toLong())
        }

        deletePet(petId)
    }

    @Test
    fun testDeletePet() {
        val pet = postPet(petRequest)
        deletePet(pet.id.toString())
        with(getPet(pet.id.toString(), 404) as ResponseMessage) {
            message.shouldBe("Pet not found")
            type.shouldBe("error")
        }
    }
}