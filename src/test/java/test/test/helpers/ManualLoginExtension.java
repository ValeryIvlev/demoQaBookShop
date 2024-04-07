package test.test.helpers;

import io.qameta.allure.Step;
import org.openqa.selenium.Cookie;
import test.test.models.token.GenerateTokenResponse;
import test.test.steps.AuthorizationSteps;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class ManualLoginExtension {
    @Step("Устанавливаем авторизационные куки")
    public static void manualLogin(String userName, String userId, String password) {
        GenerateTokenResponse cookies = AuthorizationSteps
                .generateAuthWithUserData(userName, password);

        open("/images/Toolsqa.jpg");
        getWebDriver().manage().addCookie(new Cookie("userID", userId));
        getWebDriver().manage().addCookie(new Cookie("userName", userName));
        getWebDriver().manage().addCookie(new Cookie("token", cookies.getToken()));
        getWebDriver().manage().addCookie(new Cookie("expires", cookies.getExpires()));
    }
}
