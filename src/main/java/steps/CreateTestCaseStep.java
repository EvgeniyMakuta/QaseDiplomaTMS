package steps;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import objects.TestCase;
import org.openqa.selenium.WebDriver;
import pages.CreateTestCasePage;
import pages.ProjectPage;

@Log4j2
public class CreateTestCaseStep extends BaseSteps {
    ProjectPage projectPage;
    CreateTestCasePage createTestCasePage;
    LoginStep loginStep;

    public CreateTestCaseStep(WebDriver driver, ProjectPage projectPage, CreateTestCasePage createTestCasePage) {
        super(driver);
        this.projectPage = projectPage;
        this.createTestCasePage = createTestCasePage;
    }

    public String getTestCaseTitleByIndex(int i) {
        log.debug(String.format("Getting test case with index %s and name %s ", i, createTestCasePage.getTestCaseTitle(i)));
        return createTestCasePage.getTestCaseTitle(i);
    }

    @Step("Creating test case {testCase.title}")
    public ProjectStep createTestCase(TestCase testCase) {
        createTestCasePage.createTestCase(testCase);
        return new ProjectStep(driver, projectPage, loginStep);
    }
}
