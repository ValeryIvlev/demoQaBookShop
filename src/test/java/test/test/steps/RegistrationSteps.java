package test.test.steps;

import io.qameta.allure.Step;
import test.test.data.RegistrationData;
import test.test.data.TestData;
import test.test.models.user.ApiUserRequest;
import test.test.models.user.ApiUserResponse;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static test.test.data.CookiesData.TOKEN;
import static test.test.specs.BaseSpecs.createdResponse;
import static test.test.specs.BaseSpecs.successfulRequests;

public class RegistrationSteps {

    @Step("Создаем нового пользователя случайного")
    public RegistrationData createUserRandom(){
        TestData testData = new TestData();
        ApiUserResponse userRequest = test.test.models.user.ApiUserResponse
                .builder()
                .userName(testData.getUserName())
                .password(testData.getPassword())
                .build();
        ApiUserRequest userResponse = given()
                .spec(successfulRequests)
                .when()
                .body(userRequest)
                .post("/Account/v1/User")
                .then()
                .spec(createdResponse)
                .extract()
                .as(ApiUserRequest.class);

        assertNotNull(userResponse.getUserId());
        assertEquals(userRequest.getUserName(), userResponse.getUserName());
        return new RegistrationData(userResponse, userRequest);
    }
}
