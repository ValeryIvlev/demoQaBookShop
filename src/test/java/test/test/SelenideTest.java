package test.test;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import test.test.helpers.WithLogin;
import test.test.pages.ProfilePage;
import test.test.steps.OrderSteps;

import static test.test.data.UserData.*;
import static test.test.helpers.LoginExtension.TOKEN;

public class SelenideTest extends TestBase{
    @WithLogin
    @Test
    @Tag("DemoQa")
    void deleteBook(){
        OrderSteps orderSteps = new OrderSteps();
        ProfilePage profilePage = new ProfilePage();

        orderSteps.addRandomBook(TOKEN, USER_ID);

        profilePage.openProfile()
                .deleteNumberBook(0)
                .confirmDelete()
                .countBooksOnBasket(0);
    }
}
