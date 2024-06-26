package test.test.pages.component;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import test.test.pages.ProfilePage;

import static com.codeborne.selenide.Selenide.$;

public class DeleteComponent {

    private final SelenideElement buttonOk = $("#closeSmallModal-ok");
    @Step("Подтверждаем удаление книги")
    public ProfilePage confirmDelete(){
        buttonOk.click();
        Selenide.confirm();
        return Selenide.page(ProfilePage.class);
    }

}
