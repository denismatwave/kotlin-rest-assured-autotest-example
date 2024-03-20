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
        val petId = pet.id.toString()

        getPet(petId)
        deletePet(petId)
    }
}