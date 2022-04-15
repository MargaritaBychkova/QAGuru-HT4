package guru.qa;

import com.codeborne.selenide.Configuration;
import com.github.javafaker.Faker;
import guru.qa.pages.RegistrationFormPage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


import java.util.Locale;


public class RegistrationFormTestsWithFakerdata {

    RegistrationFormPage registrationFormPage = new RegistrationFormPage();


    @BeforeAll
    static void setUp() {
        Configuration.baseUrl = "https://demoqa.com";


    }

    @Test
    void fillFormTest() {
        Faker faker = new Faker(new Locale("in-ID"));

        String firstname = faker.name().firstName();
        String lastname = faker.name().lastName();
        String useremail = faker.internet().emailAddress();
        String gender = "Female";
        String usermobile = faker.phoneNumber().subscriberNumber(10);
        String dateofbirth = "07 March,1990";
        String subject = "Maths";
        String hobby = "Music";
        String currentaddress = faker.address().streetAddress();
        String state = "Uttar Pradesh";
        String city = "Agra";


        //Fill the form

        registrationFormPage.openPage()
        .setFirstName(firstname)
        .setLastName(lastname)
        .setUserEmail(useremail)
        .setGender(gender)
        .setUserMobile(usermobile)
        .setBirthDate("7", "March", "1990")
        .setSubject(subject)
        .setHobby(hobby)
        .uploadPicture("img.png")
        .setCurrentAddress(currentaddress)
        .setState(state)
        .setCity(city)
        .clickSubmit();


        //Asserts

registrationFormPage.checkResultHeader()
        .checkTableResults("Student Name", firstname + " " + lastname)
        .checkTableResults("Student Email", useremail)
        .checkTableResults("Gender", gender)
        .checkTableResults("Mobile", usermobile)
        .checkTableResults("Date of Birth", dateofbirth)
        .checkTableResults("Subjects", subject)
        .checkTableResults("Hobbies", hobby)
        .checkTableResults("Picture", "img.png")
        .checkTableResults("Address", currentaddress)
        .checkTableResults("State and City", state + " " + city);


    }
}
