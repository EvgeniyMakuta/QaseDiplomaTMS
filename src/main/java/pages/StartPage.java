package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class StartPage extends BasePage {
    @FindBy(id = "signin")
    WebElement loginBtnLocator;

    public StartPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public StartPage waitForPageOpened() {
        wait.explicitWait(MAIN_PAGE, loginBtnLocator);
        return this;
    }

    public StartPage openPage() {
        openPage(MAIN_PAGE_URL);
        return this;
    }

    public LoginPage clickOnLoginBtn() {
        loginBtnLocator.click();
        return new LoginPage(driver);
    }
}
