package steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import pages.ProjectsPage;
import pages.StartPage;

public class StartStep extends BaseSteps {
    StartPage startPage;
    LoginPage loginPage;
    ProjectsPage projectsPage;

    public StartStep(WebDriver driver, StartPage startPage) {
        super(driver);
        this.startPage = startPage;
    }

    @Step("Open Login form from Main page")
    public LoginStep openLoginForm() {
        startPage
                .openPage()
                .waitForPageOpened()
                .clickOnLoginBtn();
        return new LoginStep(driver, loginPage, projectsPage);
    }
}
