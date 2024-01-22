package test.test.steps;

import io.qameta.allure.Step;
import test.test.data.TestData;
import test.test.models.user.ApiUserRequest;
import test.test.models.user.ApiUserResponse;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static test.test.specs.BaseSpecs.createdResponse;
import static test.test.specs.BaseSpecs.successfulRequests;

public class RegistrationSteps {

    @Step("Создаем нового пользователя случайного")
    public ApiUserRequest createUserRandom(){
        TestData testData = new TestData();
        ApiUserRequest userRequest = ApiUserRequest
                .builder()
                .userName(testData.getUserName())
                .password(testData.getPassword())
                .build();
        ApiUserResponse userResponse = given()
                .spec(successfulRequests)
                .when()
                .body(userRequest)
                .post("/Account/v1/User")
                .then()
                .spec(createdResponse)
                .extract()
                .as(ApiUserResponse.class);

        assertNotNull(userResponse.getUserId());
        assertEquals(userRequest.getUserName(), userResponse.getUsername());
        return userRequest;
    }
}
