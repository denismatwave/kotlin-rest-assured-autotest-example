import io.restassured.builder.RequestSpecBuilder
import io.restassured.filter.log.LogDetail
import io.restassured.filter.log.RequestLoggingFilter
import io.restassured.filter.log.ResponseLoggingFilter
import io.restassured.http.ContentType
import io.restassured.module.kotlin.extensions.Given
import io.restassured.module.kotlin.extensions.Then
import io.restassured.module.kotlin.extensions.When
import models.Pet
import org.junit.jupiter.api.Test

class SimpleTest {

    @Test
    fun test() {
        val requestSpecification = RequestSpecBuilder().addFilter(RequestLoggingFilter(LogDetail.ALL))
            .addFilter(ResponseLoggingFilter(LogDetail.ALL)).setBaseUri("https://petstore.swagger.io/v2")
            .setBasePath("/pet")
            .setAccept(ContentType.JSON)
            .setContentType(ContentType.JSON)
            .build()

        val petRequest = Pet(name = "Pet1", status = "Test")

        Given {
            spec(requestSpecification)
            body(petRequest)
        } When {
            post()
        } Then {
            statusCode(200)
        }
    }
}