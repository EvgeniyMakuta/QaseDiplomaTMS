package pages;

import elements.Input;
import elements.Select;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;
import objects.TestCase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@Log4j2
public class CreateTestCasePage extends BasePage {
    @FindBy(id = "save-case")
    WebElement saveTestCaseBtnLocator;
    @FindBy(id = "title")
    WebElement titleTestCaseLocator;
    @FindBy(xpath = "//*[contains(text(), 'Create new case')]")
    WebElement createNewTestCaseBrnLocator;
    @FindBy(id = "create-case-button")
    WebElement createOneMoreTestCaseBtnLocator;
    @FindBy(xpath = "//*[contains(@class, 'case-row-title')]")
    List<WebElement> testCasesListLocator;

    public CreateTestCasePage(WebDriver driver) {
        super(driver);
    }

    public CreateTestCasePage openPage(String code) {
        super.openPage(String.format(CREATE_NEW_TEST_CASE_URL, code));
        return this;
    }

    @Override
    public CreateTestCasePage waitForPageOpened() {
        wait.explicitWait(NEW_TEST_CASE_PAGE, saveTestCaseBtnLocator);
        return this;
    }

    @SneakyThrows
    private void fillInTestCaseFields(TestCase testCase) {
        log.debug("Creating test case: " + testCase);
        new Input(titleTestCaseLocator, TEST_CASE_TITLE_INPUT_LABEL).write(testCase.getTitle());
        new Select(TEST_CASE_PRIORITY_LABEL, driver).select(testCase.getPriority().getField());
        new Input(TEST_CASE_DESCRIPTION_LABEL, driver).writeProseMirror(testCase.getDescription());
        new Select(TEST_CASE_STATUS_LABEL, driver).select(testCase.getStatus().getField());
        new Select(TEST_CASE_SUITE_LABEL, driver).select(testCase.getSuite().getField());
        new Select(TEST_CASE_SEVERITY_LABEL, driver).select(testCase.getSeverity().getField());
        new Select(TEST_CASE_TYPE_LABEL, driver).select(testCase.getType().getField());
        new Select(TEST_CASE_BEHAVIOR_LABEL, driver).select(testCase.getBehavior().getField());
        new Select(TEST_CASE_AUTO_STATUS_LABEL, driver).select(testCase.getAutomationStatus().getField());
        new Input(TEST_CASE_PRECONDITIONS_LABEL, driver).writeProseMirror(testCase.getPreConditions());
        new Input(TEST_CASE_POSTCONDITIONS_LABEL, driver).writeProseMirror(testCase.getPostConditions());
        Thread.sleep(500);
    }

    public ProjectPage createFirstTestCase(TestCase testCase) {
        clickOnCreateNewCase();
        fillInTestCaseFields(testCase);
        clickOnSaveTestCase();
        return new ProjectPage(driver);
    }

    public ProjectPage createMoreTestCases(TestCase testCase) {
        clickOnPlusCase();
        fillInTestCaseFields(testCase);
        clickOnSaveTestCase();
        return new ProjectPage(driver);
    }

    private void clickOnCreateNewCase() {
        createNewTestCaseBrnLocator.click();
    }

    private void clickOnPlusCase() {
        createOneMoreTestCaseBtnLocator.click();
    }

    private void clickOnSaveTestCase() {
        saveTestCaseBtnLocator.click();
    }

    public String getTestCaseTitle(int i) {
       return testCasesListLocator.get(i).getText();
    }
}
