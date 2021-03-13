package steps;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import objects.TestCase;
import org.openqa.selenium.WebDriver;
import pages.CreateTestCasePage;
import pages.ProjectPage;
import pages.ProjectsPage;

@Log4j2
public class CreateTestCaseStep extends BaseSteps {
    CreateTestCasePage createTestCasePage;
    ProjectPage projectPage;
    ProjectsPage projectsPage;

    public CreateTestCaseStep(WebDriver driver, ProjectPage projectPage, CreateTestCasePage createTestCasePage) {
        super(driver);
        this.projectPage = projectPage;
        this.createTestCasePage = createTestCasePage;
    }

    @Step("Creating test case {testCase.title}")
    public ProjectsStep createNewTestCase(TestCase testCase, String state) {
        log.debug(String.format("Creating %s test case: %s", state, testCase));
        if (state.equals("NEW")) {
            createNewTestCase(testCase);
        } else if (state.equals("PLUS")) {
            createPlusTestCase(testCase);
        }
        projectPage.waitForPageOpened();
        return new ProjectsStep(driver, projectsPage);
    }

    private void createNewTestCase(TestCase testCase) {
        createTestCasePage.createFirstTestCase(testCase);
    }

    private void createPlusTestCase(TestCase testCase) {
        createTestCasePage.createMoreTestCases(testCase);
    }

    public String getTestCaseTitleByIndex(int i) {
        log.debug(String.format("Getting test case with index %s and name %s ", i, createTestCasePage.getTestCaseTitle(i)));
       return createTestCasePage.getTestCaseTitle(i);
    }
}
