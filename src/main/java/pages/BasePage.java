package pages;

import constants.Constants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import waiters.Waiters;

public abstract class BasePage extends Waiters implements Constants {
    WebDriver driver;
    Waiters wait;

    public BasePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        this.wait = new Waiters(driver);
        PageFactory.initElements(driver, this);
    }

    public abstract BasePage openPage();

    public abstract BasePage waitForPageOpened();

    public BasePage openPage(String url) {
        driver.get(url);
        return this;
    }


}
