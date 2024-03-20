package requests

import io.restassured.module.kotlin.extensions.Extract
import io.restassured.module.kotlin.extensions.Given
import io.restassured.module.kotlin.extensions.Then
import io.restassured.module.kotlin.extensions.When
import models.Pet
import models.PetGetResponse
import models.ResponseMessage
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
        } Extract {
            response().body().`as`(Pet::class.java)
        }

    fun getPet(petId: String, expectedStatusCode: Int = 200) =
        Given {
            spec(requestSpecification)
        } When {
            get("/$petId")
        } Then {
            statusCode(expectedStatusCode)
        } Extract  {
            if (expectedStatusCode != 200)
                response().body().`as`(ResponseMessage::class.java)
            else
                response().body().`as`(PetGetResponse::class.java)
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