package steps;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import objects.TestCase;
import org.openqa.selenium.WebDriver;
import pages.CreateTestCasePage;

@Log4j2
public class CreateTestCaseStep extends BaseSteps {
    CreateTestCasePage createTestCasePage = new CreateTestCasePage(driver);

    public CreateTestCaseStep(WebDriver driver) {
        super(driver);
    }

    @Step("Creating first test case {testCase}")
    public ProjectsStep createFirstTestCase(TestCase testCase) {
        log.debug("Creating first test case: " + testCase);
        createTestCasePage
                .createFirstTestCase(testCase)
                .waitForPageOpened();
        return new ProjectsStep(driver);
    }
    @Step("Creating one more test case {testCase}")
    public ProjectsStep createSecondTestCase(TestCase testCase) {
        log.debug("Creating one more test case: " + testCase);
        createTestCasePage
                .createMoreTestCases(testCase)
                .waitForPageOpened();
        return new ProjectsStep(driver);
    }

    public String getTestCaseTitleByIndex(int i) {
        log.debug(String.format("Getting test case with index %s and name %s ", i, createTestCasePage.getTestCaseTitle(i)));
       return createTestCasePage.getTestCaseTitle(i);
    }
}
