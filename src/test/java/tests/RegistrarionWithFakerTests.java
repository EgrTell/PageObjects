package tests;

import com.codeborne.selenide.Configuration;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;

import java.util.Locale;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static utils.RandomUtils.*;

public class RegistrarionWithFakerTests extends TestBase {

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




    @Test
    public void inputeValuesAndChekThemWithPageObject () {

        String [] genders = {"Male", "Female", "Other"};
        String [] months = {"January", "February", "March", "April", "May", "June", "July",
                "August", "September", "October", "November", "December"};
        String [] subjects = {"English", "Chemistry", "Computer Science", "Commerce", "Economics",
                "Social Studies", "Maths", "Hindi", "Physics", "History", "Arts", "Civics", "Accounting", "Biology"};
        String [] Hobbies = {"Sports", "Reading", "Music"};
        String [] states = {"NCR", "Uttar Pradesh", "Haryana", "Rajasthan"};
        String [] cityesOfNCR = {"Delhi", "Gurgaon", "Noida"};
        String [] cityesOfUttarPradesh = {"Agra", "Lucknow", "Merrut"};
        String [] cityesOfHaryana = {"Karnal", "Panipat"};
        String [] cityesOfRajasthan = {"Jaipur", "Jaiselmer"};



        Faker kek = new Faker();
        String day, city;


                String firstName = kek.name().firstName(),
                        lastName = kek.name().lastName(),
                        email = kek.internet().emailAddress(),
                        currentAddress = kek.address().fullAddress(),
                        phoneNumber = "7" + kek.number().numberBetween(100000000, 999999999),
                        gender = getRandomItemFromArray(genders),
                        year = String.valueOf(kek.number().numberBetween(1950, 2023)),
                        month = getRandomItemFromArray(months),
//                        day = String.valueOf(faker.number().numberBetween(1,30)),
                        subject = getRandomItemFromArray(subjects),
                        hobbi = getRandomItemFromArray(Hobbies),
                        state = getRandomItemFromArray(states);

                int dayInt = kek.number().numberBetween(1,9);

                if (dayInt < 10) {
                    day = "0" + String.valueOf(dayInt);
                } else {
                    day = String.valueOf(dayInt);
                }

                if (state.equals("NCR")) {
                    city = getRandomItemFromArray(cityesOfNCR);
                }if (state.equals("Uttar Pradesh")) {
                    city = getRandomItemFromArray(cityesOfUttarPradesh);
        }       if (state.equals("Haryana")){
                    city = getRandomItemFromArray(cityesOfHaryana);
        }else {
                    city = getRandomItemFromArray(cityesOfRajasthan);
        }





        registrarionPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .setPhoneNumber(phoneNumber)
                .setAddress(currentAddress)
                .setGender(gender)
                .setDateOfBirth(year, month, day)
                .setSubject(subject)
                .setHobbies(hobbi)
                .setImg()
                .setState(state)
                .setCity(city)
                .verifyResultsModalAppears()
                .verifyResult("Student Name", firstName + " " + lastName)
                .verifyResult("Student Email", email)
                .verifyResult("Gender", gender)
                .verifyResult("Mobile", phoneNumber)
                .verifyResult("Date of Birth", day +" " + month + "," + year)
                .verifyResult("Address", currentAddress);













    }
}
