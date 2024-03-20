import io.kotest.matchers.longs.shouldBeNonNegative
import io.kotest.matchers.nulls.shouldNotBeNull
import io.kotest.matchers.shouldBe
import models.Pet
import org.junit.jupiter.api.Test
import requests.Pet.deletePet
import requests.Pet.getPet
import requests.Pet.postPet

class SimpleTest {

    @Test
    fun test() {
        val petRequest = Pet(name = "Pet1", status = "Test")

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
}