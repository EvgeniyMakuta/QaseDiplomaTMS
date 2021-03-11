package pages;

import elements.Input;
import elements.Radio;
import elements.TextArea;
import objects.Project;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Locale;

public class CreateProjectPage extends BasePage {
    @FindBy(id = "inputTitle")
    WebElement projectNameInputLocator;
    @FindBy(id = "inputCode")
    WebElement projectCodeInputLocator;
    @FindBy(id = "inputDescription")
    WebElement descriptionTextAreaLocator;
    @FindBy(xpath = "//*[@type = 'submit']")
    WebElement createProjectBtnLocator;
    @FindBy(id = "createButton")
    WebElement createNewProjectBtnLocator;

    String projectAccessTypeLocator = "//*[@id='%s-access-type']";

    public CreateProjectPage(WebDriver driver) {
        super(driver);
    }

    public CreateProjectPage openPage() {
        openPage(CREATE_NEW_PROJECT_PAGE_URL);
        return this;
    }

    @Override
    public CreateProjectPage waitForPageOpened() {
        wait.explicitWait(NEW_PROJECT_PAGE, createProjectBtnLocator);
        return this;
    }

    private String fillInNewProjectFields(Project project) {
        new Input(projectNameInputLocator, PROJECT_NAME_INPUT_LABEL).write(project.getTitle());
        new Input(projectCodeInputLocator, PROJECT_CODE_INPUT_LABEL).write(project.getCode());
        new TextArea(descriptionTextAreaLocator, PROJECT_DESCRIPTION_TEXT_AREA_LABEL).write(project.getDescription());
        new Radio(projectAccessTypeLocator, PROJECT_ACCESS_TYPE_RADIO_LABEL, driver).select(project.getAccessType().getField());
        return projectCodeInputLocator.getAttribute("value");
    }

    private void clickOnCreateProjectBtn() {
        createProjectBtnLocator.click();
    }

    private void clickOnCreateNewProjectBtnLocator() {
        createNewProjectBtnLocator.click();
    }

    public String createNewProject(Project project) {
        clickOnCreateNewProjectBtnLocator();
        String code = fillInNewProjectFields(project).toUpperCase(Locale.ROOT);
        clickOnCreateProjectBtn();
        return code;
    }
}
