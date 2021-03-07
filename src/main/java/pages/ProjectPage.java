package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProjectPage extends BasePage {
    @FindBy(xpath = "//*[contains(text(), 'Test repository')]")
    WebElement projectHeaderLocator;
    @FindBy(xpath = "//*[@class='submenu-item-text'] [contains(text(), 'Settings')]")
    WebElement settingsMenuLocator;
    @FindBy(xpath = "//*[contains(@class, 'btn-cancel')]")
    WebElement deleteProjectBrnLocator;
    @FindBy(xpath = "//*[@type = 'submit']")
    WebElement deleteProjectConfirmationBtnLocator;

    public ProjectPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public BasePage openPage() {
        return null;
    }

    public ProjectPage openProject(String code) {
        openPage(String.format(PROJECT_PAGE_URL, code));
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
        openProject(code);
        openProjectSettings();
        deleteProjectBrnLocator.click();
        deleteProjectConfirmationBtnLocator.click();
        return new ProjectsPage(driver);
    }

    private void openProjectSettings() {
        settingsMenuLocator.click();
    }
}
