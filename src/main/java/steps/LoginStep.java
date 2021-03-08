package steps;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import objects.User;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import pages.ProjectsPage;

@Log4j2
public class LoginStep {
    private final LoginPage loginPage;
    private final WebDriver driver;

    public LoginStep(WebDriver driver) {
        this.driver = driver;
        this.loginPage = new LoginPage(driver);
    }

    @Step("Login by {user}")
    public ProjectsPage login(User user) {
        log.info(String.format("Logging by %s", user));
        attemptToLogin(user)
                .waitForPageOpened();
        return new ProjectsPage(driver);
    }

    @Step("Attempt to login by {user}")
    public ProjectsPage attemptToLogin(User user) {
        log.info(String.format("Logging by %s", user));
        loginPage
                .openPage()
                .waitForPageOpened()
                .login(user.getEmail(), user.getPassword());
        return new ProjectsPage(driver);
    }
}
