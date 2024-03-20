package requests

import io.restassured.module.kotlin.extensions.Extract
import io.restassured.module.kotlin.extensions.Given
import io.restassured.module.kotlin.extensions.Then
import io.restassured.module.kotlin.extensions.When
import models.StoreOrder
import utils.BaseRestAssured.requestSpecification
import utils.ORDER
import utils.STORE

object Store {

    fun postStore(storeRequest: StoreOrder) =
        Given {
            spec(requestSpecification)
            body(storeRequest)
        } When {
            post(STORE.plus(ORDER))
        } Then {
            statusCode(200)
        } Extract {
            response().body().`as`(StoreOrder::class.java)
        }

    fun getStoreOrder(orderId: String, expectedStatusCode: Int = 200) =
        Given {
            spec(requestSpecification)
        } When {
            get("${STORE.plus(ORDER)}/$orderId")
        } Then {
            statusCode(expectedStatusCode)
        } 


    fun deleteStoreOrder(orderId: String) =
        Given {
            spec(requestSpecification)
        } When {
            delete("${STORE.plus(ORDER)}/$orderId")
        } Then {
            statusCode(200)
        }
}