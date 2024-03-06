package test.test.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import test.test.pages.component.DeleteComponent;

import java.util.ArrayList;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProfilePage {
    private final ElementsCollection deleteButton = $$("#delete-record-undefined");
    private final ElementsCollection booksOnBasket = $$("[id*=see-book]");
    private final SelenideElement userNameWindow = $("#userName-value");
    private final SelenideElement basketSections = $(".rt-tbody");
    private final SelenideElement deleteAccountButton = $(byText("Delete Account"));

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
    @Step("Проверяем юзер нейм в профиле")
    public ProfilePage checkUserNameInProfile(String userName){
        userNameWindow.shouldHave(text(userName));
        return this;
    }
    @Step("Проверяем отображение книг в корзине")
    public ProfilePage checkBooksInBasket(ArrayList<String> namesBooks){
        basketSections.shouldBe(visible);
        int count = namesBooks.size();
        countBooksOnBasket(count);
        for (int i = 0; i < count; i++) {
            booksOnBasket.get(i).shouldHave(text(namesBooks.get(i)));
        }
        return this;
    }
    @Step("Удаляем аккаунт UI")
    public ProfilePage deleteAccount(){
        deleteAccountButton.click();
        $("#closeSmallModal-ok").click();
        switchTo().alert().accept();
        return this;
    }
}
