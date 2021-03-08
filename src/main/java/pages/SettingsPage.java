package pages;

import elements.Input;
import elements.Radio;
import elements.TextArea;
import objects.Project;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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

    String projectAccessTypeLocator = "//*[@id='%s-access-type']";

    public SettingsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public SettingsPage waitForPageOpened() {
        wait.explicitWait(SETTINGS_PAGE, updateSettingsBrnLocator);
        return this;
    }

    // TODO ??? Почему не могу выбрать openPage из базового????
    public SettingsPage openPage(String code) {
        openPage(String.format(SETTINGS_URL, code));
        return this;
    }

    private void fillInProjectFields(Project project) {
        new Input(projectNameInputLocator, PROJECT_NAME_INPUT_LABEL).write(project.getTitle());
        new Input(projectCodeInputLocator, PROJECT_CODE_INPUT_LABEL).write(project.getCode());
        new TextArea(projectDescriptionTextAreaLocator, PROJECT_DESCRIPTION_TEXT_AREA_LABEL).write(project.getDescription());
        new Radio(projectAccessTypeLocator, PROJECT_ACCESS_TYPE_RADIO_LABEL, driver).select(project.getAccessType().getField());
    }

    public SettingsPage updateProject(Project project) {
        settingsMenuLocator.click();
        fillInProjectFields(project);
        updateSettingsBrnLocator.click();
        return this;
    }

    public String getAlertMeg() {
       return alertMegLocator.getText();
    }
}
