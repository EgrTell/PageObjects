package tests;

import Pages.RegistrarionPage;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;

public class TestBase {


    RegistrarionPage registrarionPage = new RegistrarionPage();

//        String firstName = "Egor",
//                lastName = "Tellin",
//                email = "egor21chuv@yandex.ru";

    @BeforeAll
    static void beforeAll () {
        Configuration.pageLoadTimeout = 1000000;
        Configuration.browserSize = "1920x1080";

    }
}
