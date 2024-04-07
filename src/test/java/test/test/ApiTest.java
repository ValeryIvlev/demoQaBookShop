package test.test;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


public class ApiTest extends TestBase{

    @Test
    @Tag("DemoQa")
    void test(){
        open("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/manager/openAccount");
        $("#userSelect").selectOption("Hermoine Granger");
        $("#currency").selectOption("Rupee");
        $(byText("Process")).click();
        String alert = switchTo().alert().getText();
        HashMap<String, String> map = new HashMap<>();
        map.put("accountNumber",alert.substring(alert.indexOf(":")+1, alert.length()));
        $(byText("Customers")).click();
        $$("tr.ng-scope").findBy(text("Hermoine")).$("td").sibling(2)
                .shouldHave(text(map.get("accountNumber")));

    }
    @Test
    @Tag("DemoQa")
    void test2(){
        open("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/manager/list");
        System.out.println($$("tr.ng-scope").findBy(text("Hermoine")).$("td").sibling(2).getText());
        sleep(5000);
    }
}
