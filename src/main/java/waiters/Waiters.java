package waiters;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static constants.Constants.IMPLICIT_WAIT;
import static org.testng.Assert.fail;

@Log4j2
public class Waiters {
    WebDriverWait wait;
    WebDriver driver;

    public Waiters(WebDriver driver) {
        this.driver = driver;
    }

    public void explicitWait(String page, WebElement element) {
        try {
            wait = new WebDriverWait(driver, IMPLICIT_WAIT);
            wait.until(ExpectedConditions.visibilityOf(element));
        } catch (TimeoutException e) {
            log.error(String.format("%s page is not opened. Locator %s is not found", page, element));
            fail("Page is not loaded. Not found locator: " + element);
        }
    }

    public void explicitWait(String page, WebElement element, int time) {
        try {
            wait = new WebDriverWait(driver, time);
            wait.until(ExpectedConditions.visibilityOf(element));
        } catch (TimeoutException e) {
            log.error(String.format("%s page is not opened. Locator %s is not found", page, element));
            fail("Page is not loaded. Not found locator: " + element);
        }
    }

    public void implicitWait(int time, TimeUnit timeUnit) {
        log.debug(String.format("Implicit wait timeout: %s %s", time, timeUnit));
        try {
            driver.manage().timeouts().implicitlyWait(time, timeUnit);
        } catch (TimeoutException e) {
            log.error(String.format("Implicit wait time is out: %s %s", time, timeUnit));
        }
    }
}
