package tests;

import builders.UserBuilder;
import objects.User;
import org.testng.annotations.Test;
import test_data.TestDataProvider;
import utils.Retry;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class LoginTest extends BaseTest {

    @Test(description = "Verify that user is logged in", retryAnalyzer = Retry.class)
    public void userShouldBeLoggedIn() {
        loginStep
                .login(validUser);
        assertTrue(projectsStep.isPageOpened(), "Projects page is not opened");
    }

    @Test(description = "Verify that login form is opened from main page")
    public void loginFormShouldBeOpened() {
        startStep
                .openLoginForm();
        assertTrue(loginStep.isPageOpened(), "Login form is not displayed");
    }

    @Test(description = "Verify that error message appears on attempt to login with invalid credentials",
            dataProvider = "InvalidTestDataFotLogin", dataProviderClass = TestDataProvider.class)
    public void errorMsgShouldAppearWithInvalidCredentials(String email, String password, String errorMsg) {
        User user = UserBuilder.getUser(email, password);
       loginStep
               .attemptToLogin(user);
       String errorMessage = loginStep.getErrorMessage();
       assertEquals(errorMessage, errorMsg, "Wrong error message is displayed: " + errorMessage);
    }
}
