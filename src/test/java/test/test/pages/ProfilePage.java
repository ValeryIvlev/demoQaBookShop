package test.test.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import test.test.pages.component.DeleteComponent;

import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProfilePage {
    ElementsCollection deleteButton = $$("#delete-record-undefined");
    ElementsCollection booksOnBasket = $$("[id*=see-book]");

    @Step("Открываем профиль")
    public ProfilePage openProfile(){
        open("https://demoqa.com/profile");
        return this;
    }

    @Step("Удаляем книгу")
    public DeleteComponent deleteNumberBook(int number) {
        deleteButton.get(number).shouldBe(Condition.visible);
        deleteButton.get(number).click();
        return Selenide.page(DeleteComponent.class);
    }

    @Step("Проверяем что удалили книгу из корзины")
    public ProfilePage countBooksOnBasket(int countBooksBasket) {
        assertEquals(countBooksBasket, booksOnBasket.size());
        return this;
    }
}
