package pages;

import lombok.extern.log4j.Log4j2;
import objects.enums.AccessType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Locale;

@Log4j2
public class ProjectPage extends BasePage {
    @FindBy(xpath = "//*[contains(text(), 'Test repository')]")
    WebElement projectHeaderLocator;
    @FindBy(xpath = "//*[@class='submenu-item-text'] [contains(text(), 'Settings')]")
    WebElement settingsMenuLocator;
    @FindBy(xpath = "//*[contains(@class, 'btn-cancel')]")
    WebElement deleteProjectBrnLocator;
    @FindBy(xpath = "//*[@type = 'submit']")
    WebElement deleteProjectConfirmationBtnLocator;
    @FindBy(xpath = "//*[@class = 'subheader']")
    WebElement projectCodeLocator;
    @FindBy(xpath = "//*[contains(@class, 'sub-menu-header')]/child::*/*[@class='header']")
    WebElement projectTitleLocator;

    private static final String PROJECT_ACCESS_TYPE_LOCATOR = "//*[@id='%s-access-type']";

    public ProjectPage(WebDriver driver) {
        super(driver);

    }

    public ProjectPage openProject(String code) {
        openPage(String.format(PROJECT_PAGE_URL, code.toUpperCase(Locale.ROOT)));
        return this;
    }

    @Override
    public ProjectPage waitForPageOpened() {
        wait.explicitWait(PROJECT_PAGE, projectHeaderLocator);
        return this;
    }

    public boolean isPageOpened() {
        return projectHeaderLocator.isDisplayed();
    }

    public ProjectsPage deleteProject(String code) {
        log.debug(String.format("Deleting project with code %s", code));
        openProject(code);
        openProjectSettings();
        deleteProjectBrnLocator.click();
        deleteProjectConfirmationBtnLocator.click();
        return new ProjectsPage(driver);
    }

    public void openProjectSettings() {
        settingsMenuLocator.click();
    }

    public String getProjectTitle() {
       return projectTitleLocator.getText();
    }

    public String getProjectCode() {
        return projectCodeLocator.getText();
    }

    public boolean isAccessTypeSelected(AccessType type) {
        openProjectSettings();
        return driver.findElement(By.xpath(String.format(PROJECT_ACCESS_TYPE_LOCATOR, type.toString().toLowerCase(Locale.ROOT)))).isSelected();
    }

}
