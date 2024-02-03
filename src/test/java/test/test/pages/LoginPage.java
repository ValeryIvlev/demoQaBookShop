package test.test.pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class LoginPage {
    private final SelenideElement userNameInput =  $("#userName");
    private final SelenideElement passwordInput =  $("#password");
    private final SelenideElement loginButton =  $("#login");

    public LoginPage openLoginPage(){
        open("/login");
        return this;
    }

    public LoginPage enterUserName(String userName){
        userNameInput.sendKeys(userName);
        return this;
    }
    public LoginPage enterPassword(String password){
        passwordInput.sendKeys(password);
        return this;
    }
    public ProfilePage clickOnLoginButton(){
        loginButton.click();
        return Selenide.page(ProfilePage.class);
    }
}
