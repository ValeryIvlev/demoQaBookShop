package test.test.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class RegistrationPage {
    LoginPage loginPage = new LoginPage();
    private final SelenideElement enterFirstName = $("#firstname");
    private final SelenideElement enterLastName = $("#lastname");
    private final SelenideElement registerButton = $("#register");
    private final SelenideElement exceptionText = $("#name");

    public RegistrationPage enterFirstName(String firstName){
        enterFirstName.sendKeys(firstName);
        return this;
    }
    public RegistrationPage enterLastName(String lastName){
        enterLastName.sendKeys(lastName);
        return this;
    }
    public RegistrationPage enterUserName(String userName){
        loginPage.enterUserName(userName);
        return this;
    }
    public RegistrationPage enterPassword(String password){
        loginPage.enterPassword(password);
        return this;
    }
    public RegistrationPage clickOnRegisterButton(){
        registerButton.click();
        return this;
    }
    public RegistrationPage checkTextException(){
        exceptionText.shouldHave(text("Please verify reCaptcha to register!"));
        return this;
    }
}
