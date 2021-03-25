package tests;

import org.junit.jupiter.api.Test;
import pages.StudentRegistrationPage;

public class PracticeFormTestWithPageObjects {
    StudentRegistrationPage studentRegistrationPage;

    @Test
    void successfulFillFormTest() {
        studentRegistrationPage = new StudentRegistrationPage();
        studentRegistrationPage.openPage();
        studentRegistrationPage.fillForm();
        studentRegistrationPage.checkData();
    }
}
