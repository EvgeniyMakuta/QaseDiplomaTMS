package pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@Log4j2
public class ProjectsPage extends BasePage {
    @FindBy(id = "createButton")
    WebElement createNewProjectBtnLocator;
    @FindBy(xpath = "//*[@name='title']")
    WebElement searchProjectInputLocator;
    @FindBy(xpath = "//*[contains(@class, 'btn-dropdown')]")
    WebElement menuLocator;
    @FindBy(xpath = "//*[contains(@class, 'text-danger')]")
    WebElement deleteFromMenuLocator;
    @FindBy(xpath = "//*[contains(@class, 'btn-cancel')]")
    WebElement deleteConfirmBtnLocator;
    @FindBy(xpath = "//*[contains(@class, 'project-row')]")
    List<WebElement> projectsListLocator;

   private static final String SELECTED_PROJECT_LOCATOR = "//*[contains(text(), '%s')]";

    public ProjectsPage(WebDriver driver) {
        super(driver);
    }

    public ProjectsPage openPage() {
        openPage(PROJECTS_PAGE_URL);
        return this;
    }

    @Override
    public ProjectsPage waitForPageOpened() {
        wait.explicitWait(PROJECTS_PAGE, createNewProjectBtnLocator);
        return this;
    }

    public boolean isPageOpened() {
        return createNewProjectBtnLocator.isDisplayed();
    }

    public ProjectPage openProject(String name) {
        log.info("Opening project with name" + name);
        searchProjectInputLocator.sendKeys(name);
        driver.findElement(By.xpath(String.format(SELECTED_PROJECT_LOCATOR, name))).click();
        return new ProjectPage(driver);
    }

// TODO метод на доработке!
    public void deleteAllProjects(String name) {
        searchProjectInputLocator.sendKeys(name);
        List<WebElement> projectsRow = projectsListLocator;
        if (projectsRow.size() != 0) {
            try {
                for (WebElement element : projectsRow
                ) {
                    log.debug("Deleting project: " + element);
                    menuLocator.click();
                    deleteFromMenuLocator.click();
                    deleteConfirmBtnLocator.click();
                }
            } catch (Exception e) {
                log.debug("Projects list is empty");
            }
        }
    }
}