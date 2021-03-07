package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class LoginTest extends BaseTest {

    @Test
    public void userIsSuccessfullyLoggedIn() {
        loginSteps
                .login(EMAIL, PASSWORD);
        assertTrue(projectsPage.isPageOpened(), "Projects page is not opened");
    }
}
