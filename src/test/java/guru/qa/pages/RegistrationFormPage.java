package guru.qa.pages;

import guru.qa.pages.components.CalendarComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class RegistrationFormPage {
    CalendarComponent calendar = new CalendarComponent();


    //actions
    public RegistrationFormPage openPage() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");

        return this;
    }

    public RegistrationFormPage setFirstName(String value){
        $("#firstName").setValue(value);

        return this;
    }

    public RegistrationFormPage setLastName(String value){
        $("#lastName").setValue(value);

        return this;
    }

    public RegistrationFormPage setUserEmail(String value){
        $("#userEmail").setValue(value);

        return this;
    }

    public RegistrationFormPage setGender(String gender){
        $("#genterWrapper").$(byText("Female")).click();

        return this;
    }

    public RegistrationFormPage setUserMobile(String value){
        $("#userNumber").setValue(value);

        return this;
    }

    public RegistrationFormPage setBirthDate (String day, String month,String year){
        $("#dateOfBirthInput").click();
        calendar.setDate(day, month, year);

         return this;
    }

    public RegistrationFormPage setSubject (String value){
        $("#subjectsInput").setValue(value).pressEnter();

        return this;
    }

    public RegistrationFormPage setHobby (String value){
        $("#hobbiesWrapper").$(byText("Music")).click();

        return this;
    }

    public RegistrationFormPage uploadPicture(String value) {
        $("#uploadPicture").uploadFromClasspath("img.png");

        return this;
    }

    public RegistrationFormPage setCurrentAddress (String value) {
        $("#currentAddress").setValue(value);

        return this;

    }

    public RegistrationFormPage setState (String value){
            $("#state").click();
            $("#stateCity-wrapper").$(byText("Uttar Pradesh")).click();

        return this;
    }



    public RegistrationFormPage setCity (String value){
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Agra")).click();

        return this;
    }



    public RegistrationFormPage clickSubmit (){
        $("#submit").scrollIntoView("false").click();

        return this;
    }


    public RegistrationFormPage checkResultHeader (){
        $("#example-modal-sizes-title-lg")
                .shouldHave(text("Thanks for submitting the form"));

        return this;
    }


    public RegistrationFormPage checkTableResults (String key, String value){
        $(".table-responsive").$(byText(key)).parent().shouldHave(text(value));

        return this;
    }


}
