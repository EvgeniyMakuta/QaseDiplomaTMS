package elements;

import org.openqa.selenium.WebElement;

public class TextArea extends BaseElement {
    public TextArea(WebElement locator, String label) {
        super(locator, label);
    }

    @Override
    public void write(String text) {
        super.write(text);
        locator.clear();
        locator.sendKeys(text);
    }
}
