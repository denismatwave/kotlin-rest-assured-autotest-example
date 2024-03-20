import io.restassured.RestAssured
import io.restassured.http.ContentType
import org.junit.jupiter.api.Test

class SimpleTest {

    @Test
    fun test() {
        RestAssured.given().baseUri("https://petstore.swagger.io/v2").basePath("/pet").accept(ContentType.JSON).contentType(ContentType.JSON).body(
            """
                {
                  "id": 0,
                  "category": {
                    "id": 0,
                    "name": "string"
                  },
                  "name": "doggie",
                  "photoUrls": [
                    "string"
                  ],
                  "tags": [
                    {
                      "id": 0,
                      "name": "string"
                    }
                  ],
                  "status": "available"
                }
            """.trimIndent()
        ).`when`().post().then().statusCode(200)
    }
}