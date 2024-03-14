package test.test.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class RegistrationPage {
    LoginPage loginPage = new LoginPage();
    private final SelenideElement enterFirstName = $("#firstname");
    private final SelenideElement enterLastName = $("#lastname");
    private final SelenideElement registerButton = $("#register");
    private final SelenideElement exceptionText = $("#name");
    @Step("Вводим firstName")
    public RegistrationPage enterFirstName(String firstName){
        enterFirstName.sendKeys(firstName);
        return this;
    }
    @Step("Вводим lastName")
    public RegistrationPage enterLastName(String lastName){
        enterLastName.sendKeys(lastName);
        return this;
    }
    @Step("Вводим userName")
    public RegistrationPage enterUserName(String userName){
        loginPage.enterUserName(userName);
        return this;
    }
    @Step("Вводим password")
    public RegistrationPage enterPassword(String password){
        loginPage.enterPassword(password);
        return this;
    }
    @Step("Кликаем по кнопке регистрации")
    public RegistrationPage clickOnRegisterButton(){
        registerButton.scrollTo();
        registerButton.click();
        return this;
    }
    @Step("Проверяем появление текста с требованием ввести капчу")
    public RegistrationPage checkTextException(){
        exceptionText.shouldHave(text("Please verify reCaptcha to register!"));
        return this;
    }
}
