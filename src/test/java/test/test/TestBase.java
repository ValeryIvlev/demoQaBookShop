package test.test;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;
import test.test.config.BrowserDriverConfig;
import test.test.helpers.Attach;
import test.test.models.token.GenerateTokenResponse;
import test.test.steps.AuthorizationSteps;

import java.util.Map;

import static com.codeborne.selenide.Selenide.*;

public class TestBase {


    @BeforeAll
    static void beforeAll() {
        BrowserDriverConfig config = ConfigFactory.create(BrowserDriverConfig.class, System.getProperties());

        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = System.getProperty("size", "1920x1080");
        Configuration.pageLoadStrategy = "eager";
        Configuration.timeout = 20000;
        Configuration.browserVersion = config.getBrowserVersion();
        Configuration.headless = false;
        Configuration.webdriverLogsEnabled = true;
        Configuration.browser = config.getBrowserName();


        if (!config.getRemoteWebDriver().isEmpty()) {
            Configuration.remote
                    = config.getRemoteWebDriver();
        }
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                "enableVNC", true,
                "enableVideo", true
        ));
        Configuration.browserCapabilities = capabilities;

        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @AfterEach
    void setUp() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.addVideo();

        clearBrowserCookies();
        clearBrowserLocalStorage();
        closeWebDriver();
    }
}
