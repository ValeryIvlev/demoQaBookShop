package test.test;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import test.test.helpers.WithLogin;
import test.test.pages.ProfilePage;
import test.test.steps.OrderSteps;


public class SelenideTest extends TestBase{
    OrderSteps orderSteps = new OrderSteps();
    ProfilePage profilePage = new ProfilePage();
    @WithLogin
    @Test
    @Tag("DemoQa")
    void deleteBook(){

        orderSteps.deleteAllBooks()
                .addRandomBook();

        profilePage.openProfile()
                .deleteNumberBook(0)
                .confirmDelete()
                .countBooksOnBasket(0);
    }
}
