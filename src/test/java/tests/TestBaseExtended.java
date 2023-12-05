package tests;

import Pages.RegistrarionPage;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Map;

public class TestBaseExtended {



//        String firstName = "Egor",
//                lastName = "Tellin",
//                email = "egor21chuv@yandex.ru";

    @BeforeAll
    static void beforeAll () {
        Configuration.pageLoadTimeout = 1000000;
        Configuration.browserSize = "1920x1080";
        Configuration.holdBrowserOpen = true;
        Configuration.browser = "chrome";
        Configuration.browserVersion = "100.0";
        Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub";

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                "enableVNC", true,
                "enableVideo", true
        ));

        Configuration.browserCapabilities = capabilities;
    }

    @BeforeEach
    void addListener () {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }
}
