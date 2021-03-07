package elements;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebElement;

@Log4j2
public class BaseElement {
    public String label;
    public WebElement locator;
    public String stringLocator;

    public BaseElement(WebElement locator, String label) {
        this.label = label;
        this.locator = locator;
    }

    public BaseElement(String stringLocator, String label) {
        this.label = label;
        this.stringLocator = stringLocator;
    }

    private void writeActionMsg(String text) {
        log.info(String.format("Writing text '%s' into '%s' field", text, label));
    }

    private void selectActionMsg(String option) {
        log.info(String.format("Select option '%s' with label '%s'", option, label));
    }

    public void write(String text) {
        writeActionMsg(text);;
    }

    public void select(String option) {
        selectActionMsg(option);
    }
}
