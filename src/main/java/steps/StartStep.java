package steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pages.StartPage;

public class StartStep extends BaseSteps {
    StartPage startPage;

    public StartStep(WebDriver driver) {
        super(driver);
        startPage = new StartPage(driver);
    }

    @Step("Open Main page")
    public StartStep openPage() {
        startPage
                .openPage()
                .waitForPageOpened();
        return this;
    }

    @Step("Open Login form")
    public LoginStep openLoginForm() {
        startPage
                .clickOnLoginBtn();
        return new LoginStep(driver);
    }
}
