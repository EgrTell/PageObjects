package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static tests.TestData.*;

public class RegistrarionWithTestDataTests extends TestBase {

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
        //...


    }

//    String firstName = "Egor",
//            lastName = "Tellin",
//            email = "egor21chuv@yandex.ru";

//    String firstName,
//            lastName,
//            email;
//
//    @BeforeEach
//    void prepareTestData () {
//        firstName = "Egor";
//        lastName = "Tellin";
//        email = "egor21chuv@yandex.ru";
//
//    }


    @Test
    public void inputeValuesAndChekThemWithPageObject () {

//        String firstName = "Egor",
//                lastName = "Tellin",
//                email = "egor21chuv@yandex.ru";


        registrarionPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .setPhoneNumber("1234567890")
                .setAddress("Some address")
                .setGender("Male")
                .setDateOfBirth("1999", "April", "19")
                .setSubject("Maths")
                .setHobbies("Reading")
                .setState("NCR")
                .setCity("Delhi")
                .verifyResultsModalAppears()
                .verifyResult("Student Name", firstName + " " + lastName)
                .verifyResult("Student Email", email)
                .verifyResult("Gender", "Male")
                .verifyResult("Mobile", "1234567890")
                .verifyResult("Date of Birth", "19 April,1999");








//        $("#uploadPicture").uploadFromClasspath("img/1.png");





    }
}
