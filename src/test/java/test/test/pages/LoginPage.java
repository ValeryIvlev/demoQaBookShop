package test.test.pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class LoginPage {
    private final SelenideElement userNameInput =  $("#userName");
    private final SelenideElement passwordInput =  $("#password");
    private final SelenideElement loginButton =  $("#login");

    @Step("Открытие страницы авторизации")
    public LoginPage openLoginPage(){
        open("/login");
        return this;
    }

    @Step("Вводим логин")
    public LoginPage enterUserName(String userName){
        userNameInput.sendKeys(userName);
        return this;
    }
    @Step("Вводим пароль")
    public LoginPage enterPassword(String password){
        passwordInput.sendKeys(password);
        return this;
    }
    @Step("Кликаем по кнопке авторизации")
    public ProfilePage clickOnLoginButton(){
        loginButton.click();
        return Selenide.page(ProfilePage.class);
    }
}
