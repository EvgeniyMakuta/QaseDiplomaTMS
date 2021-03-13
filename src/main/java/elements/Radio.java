package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Radio extends BaseElement {

   private static final String ACCESS_TYPE_LOCATOR = "//*[@id='%s-access-type']";

    public Radio(String stringLocator, String label, WebDriver driver) {
        super(stringLocator, label);
        this.driver = driver;
    }

    @Override
    public void select(String option) {
        super.select(option);
        driver.findElement(By.xpath(String.format(ACCESS_TYPE_LOCATOR, option))).click();
    }
}
