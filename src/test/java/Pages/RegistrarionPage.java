package Pages;

import Pages.Components.RegistrarionResultModal;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrarionPage {

    RegistrarionResultModal  registrarionResultModal = new RegistrarionResultModal();

    public RegistrarionPage openPage () {
        open("https://demoqa.com/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        return this;
    }

    public RegistrarionPage setFirstName (String name) {
        $("#firstName").setValue(name);
        return this;
    }

    public RegistrarionPage setLastName (String name) {
        $("#lastName").setValue(name);
        return this;
    }

    public RegistrarionPage setEmail (String email) {
        $("#userEmail").setValue(email);
        return this;
    }

    public RegistrarionPage setPhoneNumber (String number) {
        $("#userNumber").setValue(number);
        return this;
    }

    public RegistrarionPage setAddress (String address) {
        $("#currentAddress").setValue(address);
        return this;
    }

    public RegistrarionPage setGender (String gender) {
        $("#genterWrapper").$(byText(gender)).click();
        return this;
    }

    public RegistrarionPage setDateOfBirth (String year, String month, String day) {
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption(month);
        $(".react-datepicker__year-select").selectOption(year);
        $(".react-datepicker__day--0" + day +
                ":not(.react-datepicker__day--outside-month)").click();
        return this;
    }

    public RegistrarionPage setSubject (String subject) {
        $("#subjectsInput").setValue(subject).pressEnter();
        return this;
    }

    public RegistrarionPage setHobbies (String hobbi) {
        $("#hobbiesWrapper").$(byText(hobbi)).click();
        return this;
    }

    public RegistrarionPage setState (String state) {
        $("#state").click();
        $("#stateCity-wrapper").$(byText(state)).click();
        return this;
    }

    public RegistrarionPage setCity (String city) {
        $("#city").click();
        $("#stateCity-wrapper").$(byText(city)).click();
        return this;
    }

    public RegistrarionPage verifyResultsModalAppears () {
        registrarionResultModal.verifyModalAppears();
        return this;
    }

    public RegistrarionPage verifyResult (String key, String value) {
        registrarionResultModal.verifyResult(key, value);
        return this;
    }

    public RegistrarionPage setImg () {
        $("#uploadPicture").uploadFromClasspath("img/1.png");
        return this;
    }







}
