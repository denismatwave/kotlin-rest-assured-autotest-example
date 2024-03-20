package requests

import io.restassured.module.kotlin.extensions.Given
import io.restassured.module.kotlin.extensions.Then
import io.restassured.module.kotlin.extensions.When
import models.Pet
import utils.BaseRestAssured.requestSpecification

object Pet {

    fun postPet(petRequest: Pet) =
        Given {
            spec(requestSpecification)
            body(petRequest)
        } When {
            post()
        } Then {
            statusCode(200)
        }

    fun getPet(petId: String) =
        Given {
            spec(requestSpecification)
        } When {
            get("/$petId")
        } Then {
            statusCode(200)
        }


    fun deletePet(petId: String) =
        Given {
            spec(requestSpecification)
        } When {
            delete("/$petId")
        } Then {
            statusCode(200)
        }
}