package test.test.helpers;

import io.qameta.allure.Step;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.openqa.selenium.Cookie;
import test.test.models.token.GenerateTokenResponse;
import test.test.steps.AuthorizationSteps;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static test.test.data.UserData.USER_ID;
import static test.test.data.UserData.USER_NAME;

public class LoginExtension implements BeforeEachCallback {
    private static final GenerateTokenResponse cookies = AuthorizationSteps.generateAuth();
    public static final String TOKEN = cookies.getToken();
    public static final String EXPIRES = cookies.getExpires();
    @Override
    @Step("Устанавливаем авторизационные куки")
    public void beforeEach(ExtensionContext context) {

        open("/images/Toolsqa.jpg");
        getWebDriver().manage().addCookie(new Cookie("userID", USER_ID));
        getWebDriver().manage().addCookie(new Cookie("userName", USER_NAME));
        getWebDriver().manage().addCookie(new Cookie("token", TOKEN));
        getWebDriver().manage().addCookie(new Cookie("expires", EXPIRES));
    }

}