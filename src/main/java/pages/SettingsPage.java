package pages;

import elements.Input;
import elements.Radio;
import elements.TextArea;
import lombok.extern.log4j.Log4j2;
import objects.Project;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Log4j2
public class SettingsPage extends BasePage {
    @FindBy(xpath = "//*[@type='submit']")
    WebElement updateSettingsBrnLocator;
    @FindBy(id = "inputTitle")
    WebElement projectNameInputLocator;
    @FindBy(id = "inputCode")
    WebElement projectCodeInputLocator;
    @FindBy(id = "inputDescription")
    WebElement projectDescriptionTextAreaLocator;
    @FindBy(id = "public-access-type")
    WebElement publicAccessTypeLocator;
    @FindBy(id = "private-access-type")
    WebElement privateAccessTypeLocator;
    @FindBy(id = "archive")
    WebElement archiveProjectBtnLocator;
    @FindBy(xpath = "//*[contains(@class, 'btn-cancel')]")
    WebElement deleteProjectBrnLocator;
    @FindBy(xpath = "//*[@class='alert-message']")
    WebElement alertMegLocator;
    @FindBy(xpath = "//*[@class='submenu-item-text'] [contains(text(), 'Settings')]")
    WebElement settingsMenuLocator;

   private static final String PROJECT_ACCESS_TYPE_LOCATOR = "//*[@id='%s-access-type']";

    public SettingsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public SettingsPage waitForPageOpened() {
        wait.explicitWait(SETTINGS_PAGE, updateSettingsBrnLocator);
        return this;
    }

    public SettingsPage openPage(String code) {
        super.openPage(String.format(SETTINGS_URL, code));
        return this;
    }

    private void fillInProjectFields(Project project) {
        log.debug(String.format("Filling in the project fields: ", project));
        new Input(projectNameInputLocator, PROJECT_NAME_INPUT_LABEL).write(project.getTitle());
        new Input(projectCodeInputLocator, PROJECT_CODE_INPUT_LABEL).write(project.getCode());
        new TextArea(projectDescriptionTextAreaLocator, PROJECT_DESCRIPTION_TEXT_AREA_LABEL).write(project.getDescription());
        new Radio(PROJECT_ACCESS_TYPE_LOCATOR, PROJECT_ACCESS_TYPE_RADIO_LABEL, driver).select(project.getAccessType().getField());
    }

    public SettingsPage updateProject(Project project) {
        settingsMenuLocator.click();
        fillInProjectFields(project);
        updateSettingsBrnLocator.click();
        return this;
    }

    public String getAlertMsg() {
        String alert = alertMegLocator.getText();
        log.debug("alert message is " + alert);
       return alert;
    }
}
