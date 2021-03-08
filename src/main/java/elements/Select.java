package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Select extends BaseElement {
    String DROP_DOWN_XPATH = "//*[contains(text(), '%s')]/parent::*//input[@type='text']";
    String OPTION_XPATH = "//*[contains(text(), '%s')]/parent::*//*[contains(text(), '%s')]";

    public Select(String label, WebDriver driver) {
        super(label);
        this.driver = driver;
    }

    public void select(String option) {
        super.select(option);
        driver.findElement(By.xpath(String.format(DROP_DOWN_XPATH, label))).click();
        driver.findElement(By.xpath(String.format(OPTION_XPATH, label, option))).click();
    }
}