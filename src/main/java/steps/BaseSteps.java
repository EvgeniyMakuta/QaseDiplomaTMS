package steps;

import constants.Constants;
import org.openqa.selenium.WebDriver;

public class BaseSteps implements Constants {
    WebDriver driver;

    public BaseSteps(WebDriver driver) {
        this.driver = driver;
    }
}
