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

    @Step("Open Login form from Main page")
    public LoginStep openLoginForm() {
        startPage
                .openPage()
                .waitForPageOpened()
                .clickOnLoginBtn();
        return new LoginStep(driver);
    }
}
