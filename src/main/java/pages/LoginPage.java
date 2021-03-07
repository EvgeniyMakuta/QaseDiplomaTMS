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

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Override
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
        emailInputLocator.sendKeys(email);
        passwordInputLocator.sendKeys(password);
        loginBtnLocator.click();
        return new ProjectsPage(driver);
    }
}
