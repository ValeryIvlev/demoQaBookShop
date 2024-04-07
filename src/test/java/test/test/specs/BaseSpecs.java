package test.test.specs;


import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.with;
import static io.restassured.filter.log.LogDetail.ALL;
import static test.test.helpers.CustomAllureListener.withCustomTemplates;


public class BaseSpecs {

    public static RequestSpecification successfulRequests = with()
            .filter(withCustomTemplates())
            .log().all()
            .contentType(ContentType.JSON)
            .baseUri("https://demoqa.com/");

    public static ResponseSpecification successfulResponse = new ResponseSpecBuilder()
            .expectStatusCode(200)
            .log(ALL)
            .build();

    public static ResponseSpecification createdResponse = new ResponseSpecBuilder()
            .expectStatusCode(201)
            .log(ALL)
            .build();
    public static ResponseSpecification successfulResponse204 = new ResponseSpecBuilder()
            .expectStatusCode(204)
            .log(ALL)
            .build();

    public static ResponseSpecification notFoundResponse = new ResponseSpecBuilder()
            .expectStatusCode(404)
            .log(ALL)
            .build();

    public static ResponseSpecification badResponse = new ResponseSpecBuilder()
            .expectStatusCode(400)
            .log(ALL)
            .build();
}