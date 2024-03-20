package utils

import io.restassured.builder.RequestSpecBuilder
import io.restassured.filter.log.LogDetail
import io.restassured.filter.log.RequestLoggingFilter
import io.restassured.filter.log.ResponseLoggingFilter
import io.restassured.http.ContentType

object BaseRestAssured {
    val requestSpecification = RequestSpecBuilder().addFilter(RequestLoggingFilter(LogDetail.ALL))
        .addFilter(ResponseLoggingFilter(LogDetail.ALL)).setBaseUri("https://petstore.swagger.io/v2")
        .setAccept(ContentType.JSON)
        .setContentType(ContentType.JSON)
        .build()
}