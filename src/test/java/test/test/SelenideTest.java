package test.test;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import test.test.data.TestData;
import test.test.helpers.WithLogin;
import test.test.models.user.ApiUserResponse;
import test.test.pages.LoginPage;
import test.test.pages.ProfilePage;
import test.test.steps.OrderSteps;
import test.test.steps.RegistrationSteps;


public class SelenideTest extends TestBase{
    OrderSteps orderSteps = new OrderSteps();
    ProfilePage profilePage = new ProfilePage();
    RegistrationSteps registrationSteps = new RegistrationSteps();
    LoginPage loginPage = new LoginPage();
    TestData testData = new TestData();

    @WithLogin
    @Test
    @Tag("DemoQa")
    @DisplayName("Проверка удаление книги")
    void deleteBook(){
        orderSteps.deleteAllBooks()
                .addRandomBook();

        profilePage.openProfile()
                .deleteNumberBook(0)
                .confirmDelete()
                .countBooksOnBasket(0);
    }

    @Test
    @Tag("DemoQa")
    @DisplayName("Проверка авторизации нового пользователя")
    void authorizationNewUserFirstTime(){
        ApiUserResponse userData = registrationSteps.createUserRandom();

        loginPage.openLoginPage()
                .enterUserName(userData.userName)
                .enterPassword(userData.password)
                .clickOnLoginButton()
                .checkUserNameInProfile(userData.userName);
    }

    @Test
    @Tag("DemoQa")
    @DisplayName("Проверка регистрации нового пользователя UI без ввода капчи")
    void registrationNewUserUINotEnterCaptcha(){
        loginPage.openLoginPage()
                .clickOnRegistrationButton()
                .enterFirstName(testData.getFirstName())
                .enterLastName(testData.getLastName())
                .enterUserName(testData.getUserName())
                .enterPassword(testData.getPassword())
                .clickOnRegisterButton()
                .checkTextException();
    }
}
