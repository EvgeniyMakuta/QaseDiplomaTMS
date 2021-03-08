package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Radio extends BaseElement {

    String accessTypeLocator = "//*[@id='%s-access-type']";

    public Radio(String stringLocator, String label, WebDriver driver) {
        super(stringLocator, label);
        this.driver = driver;
    }

    @Override
    public void select(String option) {
        super.select(option);
        driver.findElement(By.xpath(String.format(accessTypeLocator, option))).click();
    }
}
