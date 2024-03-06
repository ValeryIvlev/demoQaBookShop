package test.test.steps;

import io.qameta.allure.Step;
import test.test.models.token.GenerateTokenRequest;
import test.test.models.token.GenerateTokenResponse;

import static io.restassured.RestAssured.given;
import static test.test.data.UserData.*;
import static test.test.specs.BaseSpecs.*;

public class AuthorizationSteps {
    @Step("Получаем авторизационные данные")
    public static GenerateTokenResponse generateAuth(){
        GenerateTokenRequest tokenRequest = GenerateTokenRequest
                .builder()
                .userName(USER_NAME)
                .password(PASSWORD)
                .build();
        return given()
                .spec(successfulRequests)
                .when()
                .body(tokenRequest)
                .post("/Account/v1/GenerateToken")
                .then()
                .spec(successfulResponse)
                .extract()
                .as(GenerateTokenResponse.class);
    }
    @Step("Получаем авторизационные данные у конкретного юзера")
    public static GenerateTokenResponse generateAuthWithUserData(String userName, String password){
        GenerateTokenRequest tokenRequest = GenerateTokenRequest
                .builder()
                .userName(userName)
                .password(password)
                .build();
        return given()
                .spec(successfulRequests)
                .when()
                .body(tokenRequest)
                .post("/Account/v1/GenerateToken")
                .then()
                .spec(successfulResponse)
                .extract()
                .as(GenerateTokenResponse.class);
    }
}
