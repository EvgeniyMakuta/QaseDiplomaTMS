package steps;

import constants.IConstants;
import org.openqa.selenium.WebDriver;

public class BaseSteps implements IConstants {
    WebDriver driver;

    public BaseSteps(WebDriver driver) {
        this.driver = driver;
    }
}
