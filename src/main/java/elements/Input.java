package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Input extends BaseElement {
    private static final String INPUT_XPATH = "//*[contains(text(), '%s')]/parent::*//*[@class='ProseMirror']";

    public Input(WebElement locator, String label) {
        super(locator, label);
    }

    public Input(String label, WebDriver driver) {
        super(label);
        this.driver = driver;
    }

    @Override
    public void write(String text) {
        super.write(text);
        locator.clear();
        locator.sendKeys(text);
    }

    @Override
    public void writeProseMirror(String text) {
        super.write(text);
        driver.findElement(By.xpath(String.format(INPUT_XPATH, label))).sendKeys(text);
    }
}