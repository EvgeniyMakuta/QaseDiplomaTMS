package pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Log4j2
public class ProjectsPage extends BasePage {
    @FindBy(id = "createButton")
    WebElement createNewProjectBtnLocator;
    @FindBy(xpath = "//*[@name='title']")
    WebElement searchProjectInputLocator;

    String selectedProjectLocator = "//*[contains(text(), '%s')]";

    public ProjectsPage(WebDriver driver) {
        super(driver);
    }

    @Override
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
        searchProjectInputLocator.sendKeys(name);
        driver.findElement(By.xpath(String.format(selectedProjectLocator, name))).click();
        return new ProjectPage(driver);
    }
}
