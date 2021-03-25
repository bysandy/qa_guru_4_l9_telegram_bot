package tests;

import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static utils.RandomUtils.*;

public class PracticeFormTestsRandomUtils extends TestBase {
    // Variables
    String firstName = getRandomString(6);
    String lastName = getRandomString(8);
    String email = getRandomEmail();
    String phone = getRandomPhone();
    String gender = "Male";
    String month = "May";
    String year = "1977";
    String day = "13";
    String hobby1 = "Sports";
    String hobby2 = "Reading";
    String hobby3 = "Music";
    String currentAddress = getRandomMessage(25, 30);
    String picture = "1.png";
    String state = "NCR";
    String city = "Gurgaon";
    String subject = "Chemistry";

    @Test
    void dataAppearsInForm() {
        open("https://demoqa.com/automation-practice-form");
        $(".main-header").shouldHave(text("Practice Form"));
        // Set First name | Last name
        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        // Set Email | Gender | Phone number
        $("#userEmail").setValue(email);
        $("#genterWrapper").$(byText(gender)).click();
        $("#userNumber").setValue(phone);
        // Set Date of Birth
        $("#dateOfBirthInput").clear();
        $(".react-datepicker__year-select").selectOption(year);
        $(".react-datepicker__month-select").selectOption(month);
        $(".react-datepicker__day.react-datepicker__day--0" + day).click();
        // Set Subject
        $("#subjectsInput").val(subject);
        $(".subjects-auto-complete__menu-list").$(byText(subject)).click();
        // Set Hobbies
        $("#hobbiesWrapper").$(byText(hobby1)).click();
        $("#hobbiesWrapper").$(byText(hobby2)).click();
        $("#hobbiesWrapper").$(byText(hobby3)).click();
        // Image upload from local drive
        $("#uploadPicture").uploadFromClasspath("img/" + picture);
        // Set Address and State
        $("#currentAddress").setValue(currentAddress);
        $("#state").click();
        $("#stateCity-wrapper").$(byText(state)).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText(city)).click();
        // Submit form
        $("#submit").click();
        // Check that the form opened
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        // Verify results

        $x("//td[text()='Student Name']").parent().shouldHave(text(firstName + " " + lastName));
        $x("//td[text()='Student Email']").parent().shouldHave(text(email));
        $x("//td[text()='Gender']").parent().shouldHave(text(gender));
        $x("//td[text()='Mobile']").parent().shouldHave(text(phone));
        $x("//td[text()='Date of Birth']").parent().shouldHave(text(day + " " + month + "," + year));
        $x("//td[text()='Subjects']").parent().shouldHave(text(subject));
        $x("//td[text()='Hobbies']").parent().shouldHave(text(hobby1 + ", " + hobby2 + ", " + hobby3));
        $x("//td[text()='Picture']").parent().shouldHave(text(picture));
        $x("//td[text()='Address']").parent().shouldHave(text(currentAddress));
        $x("//td[text()='State and City']").parent().shouldHave(text(state + " " + city));

        // Close the form
        $("#closeLargeModal").click();
    }
}
