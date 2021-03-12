package steps;

import io.qameta.allure.Step;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;
import objects.User;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import pages.ProjectsPage;

@Log4j2
public class LoginStep {
    LoginPage loginPage;
    WebDriver driver;
    ProjectsPage projectsPage;

    public LoginStep(WebDriver driver) {
        this.driver = driver;
        this.loginPage = new LoginPage(driver);
        this.projectsPage = new ProjectsPage(driver);
    }

    @Step("Login by {user}")
    public ProjectsStep login(User user) {
        log.info(String.format("Logging by %s", user));
        attemptToLogin(user);
        projectsPage
                .waitForPageOpened();
        return new ProjectsStep(driver);
    }

    @Step("Attempt to login by {user}")
    public ProjectsStep attemptToLogin(User user) {
        log.info(String.format("Logging by %s", user));
        loginPage
                .openPage()
                .waitForPageOpened()
                .login(user.getEmail(), user.getPassword());
        return new ProjectsStep(driver);
    }

    public String getErrorMessage() {
       return loginPage.getErrorMessage();
    }

    public boolean isPageOpened() {
       return loginPage.isPageOpened();
    }
}
