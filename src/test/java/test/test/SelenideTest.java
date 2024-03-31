package test.test;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import test.test.models.user.RegistrationData;
import test.test.data.TestData;
import test.test.helpers.ManualLoginExtension;
import test.test.helpers.WithLogin;
import test.test.models.user.ApiUserResponse;
import test.test.pages.BookStorePage;
import test.test.pages.LoginPage;
import test.test.pages.ProfilePage;
import test.test.steps.OrderSteps;
import test.test.steps.RegistrationSteps;

import java.util.ArrayList;


//@ExtendWith(CreateUser.class)
public class SelenideTest extends TestBase{
    OrderSteps orderSteps = new OrderSteps();
    ProfilePage profilePage = new ProfilePage();
    RegistrationSteps registrationSteps = new RegistrationSteps();
    LoginPage loginPage = new LoginPage();
    TestData testData = new TestData();
    BookStorePage bookStorePage = new BookStorePage();

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
        ApiUserResponse userData = registrationSteps.createUserRandom().getUserResponse();

        loginPage.openLoginPage()
                .enterUserName(userData.getUserName())
                .enterPassword(userData.getPassword())
                .clickOnLoginButton()
                .checkUserNameInProfile(userData.getUserName());
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
    @WithLogin
    @ValueSource(ints = {
            1,2,3,4,5
    })

    @ParameterizedTest(name = "Проверка отображения {0} книг в корзине")
    void checkBooksInCart(int countBooks){
        orderSteps.deleteAllBooks()
                .addBookToCartCount(countBooks);
        ArrayList<String> booksList = orderSteps.nameBooksInUserBasket();
        profilePage.openProfile()
                .checkBooksInBasket(booksList);
    }
    @Test
    @Tag("DemoQa")
    @DisplayName("Проверка отображения всех доступных книг в магазине")
    void checkBooksInStore(){
        bookStorePage.openStorePage()
                .checkBooksInStore(OrderSteps.getAllParamValues("title"));
    }
    @Test
    @Tag("DemoQa")
    @DisplayName("Проверка удаления пользователя")
    void checkDeleteAccountUser(){
        RegistrationData registrationData = registrationSteps.createUserRandom();

        String userName = registrationData.getUserRequest().getUserName();
        String password = registrationData.getUserResponse().getPassword();
        String userId = registrationData.getUserRequest().getUserId();
        ManualLoginExtension.manualLogin(userName, userId, password);

        profilePage.openProfile()
                .deleteAccount();
        loginPage.enterUserName(userName)
                .enterPassword(password)
                .clickOnLoginButton();
        loginPage.checkAlertInfoInvalidAuthorization();

    }
}
