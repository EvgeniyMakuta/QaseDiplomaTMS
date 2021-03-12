package pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Log4j2
public class LoginPage extends BasePage {
    @FindBy(id = "btnLogin")
    WebElement loginBtnLocator;
    @FindBy(id = "inputEmail")
    WebElement emailInputLocator;
    @FindBy(id = "inputPassword")
    WebElement passwordInputLocator;
    @FindBy(xpath = "//*[@class='form-control-feedback']")
    WebElement errorMsgLocator;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage openPage() {
        openPage(LOGIN_PAGE_URL);
        return this;
    }

    @Override
    public LoginPage waitForPageOpened() {
        wait.explicitWait(LOGIN_PAGE, loginBtnLocator);
        return this;
    }

    public ProjectsPage login(String email, String password) {
        log.debug(String.format("Login with email: %s. password: %s", email, password));
        emailInputLocator.sendKeys(email);
        passwordInputLocator.sendKeys(password);
        loginBtnLocator.click();
        return new ProjectsPage(driver);
    }

    public String getErrorMessage() {
        String message = errorMsgLocator.getText();
        log.debug(String.format("Getting error message '%s' for locator '%s'", message, errorMsgLocator));
        return message;
    }

    public boolean isPageOpened() {
        return loginBtnLocator.isDisplayed();
    }
}
