package test.test.pages;

import com.codeborne.selenide.ElementsCollection;
import io.qameta.allure.Step;

import java.util.ArrayList;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;

public class BookStorePage {
    private final ElementsCollection booksInStore = $$("[id*=see-book]");

    @Step("Открываем страницу магазина с товарами")
    public BookStorePage openStorePage(){
        open("/books");
        return this;
    }
    @Step("Проверяем отображение всег книг на странице магазина")
    public BookStorePage checkBooksInStore(ArrayList<String> namesBooks){
        //basketSections.shouldBe(visible);
        int count = namesBooks.size();
        for (int i = 0; i < count; i++) {
            booksInStore.get(i).shouldHave(text(namesBooks.get(i)));
        }
        return this;
    }
}
