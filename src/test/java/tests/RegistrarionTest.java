package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrarionTest {

    @Test
    public void inputeValuesAndChekThem () {
        Configuration.pageLoadTimeout = 1000000;
        Configuration.holdBrowserOpen = true;

        open("https://demoqa.com/automation-practice-form");

        $("#firstName").setValue("Egor");
        $("#lastName").setValue("Tellin");
        $("#userEmail").setValue("egor21chuv@yandex.ru");
        $("#userNumber").setValue("123456789");
        $("#currentAddress").setValue("Some address");
        $("#genterWrapper").$(byText("Male")).click();

        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("April");
        $(".react-datepicker__year-select").selectOption("1999");
        $(".react-datepicker__day--019").click();

        $("#subjectsInput").setValue("Math").pressEnter();
        $("#hobbiesWrapper").$(byText("Sports")).click();
        $("#hobbiesWrapper").$(byText("Reading")).click();
//        $("#uploadPicture").uploadFromClasspath("img/1.png");
        $("#state").click();
        $("#stateCity-wrapper").$(byText("NCR")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Delhi")).click();
        $("#submit").click();


    }
}
