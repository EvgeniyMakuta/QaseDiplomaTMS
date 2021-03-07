package steps;

import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import pages.ProjectsPage;

public class LoginSteps {
    private final LoginPage loginPage;
    private final WebDriver driver;

    public LoginSteps(WebDriver driver) {
        this.driver = driver;
        this.loginPage = new LoginPage(driver);
    }

    private void openPage() {
        loginPage
                .openPage()
                .waitForPageOpened();
    }

    public ProjectsPage login(String email, String password) {
        openPage();
        loginPage.login(email, password)
                .waitForPageOpened();
        return new ProjectsPage(driver);
    }
}
