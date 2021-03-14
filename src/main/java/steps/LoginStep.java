package steps;

import io.qameta.allure.Step;
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

    public LoginStep(WebDriver driver, LoginPage loginPage, ProjectsPage projectsPage) {
        this.driver = driver;
        this.loginPage = loginPage;
        this.projectsPage = projectsPage;
    }

    @Step("Login with email {user.email}")
    public ProjectsStep login(User user) {
        attemptToLogin(user);
        projectsPage
                .waitForPageOpened();
        return new ProjectsStep(driver, projectsPage);
    }

    @Step("Attempt to login with email {user.email}")
    public ProjectsStep attemptToLogin(User user) {
        log.info(String.format("Logging by %s", user));
        loginPage
                .openPage()
                .waitForPageOpened()
                .login(user.getEmail(), user.getPassword());
        return new ProjectsStep(driver, projectsPage);
    }
}
