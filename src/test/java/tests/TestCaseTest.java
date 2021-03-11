package tests;

import adapters.ProjectsAdapter;
import builders.ProjectBuilder;
import builders.TestCaseBuilder;
import objects.Project;
import objects.TestCase;
import org.testng.annotations.Test;

public class TestCaseTest extends BaseTest {

    @Test
    public void firstTestCaseShouldBeCreated() {
        Project project = ProjectBuilder.getProjectByAPI();
        String projectCode = new ProjectsAdapter().create(project);
        TestCase testCase = TestCaseBuilder.getTestCase();
        loginStep
                .login(validUser);
        projectPage
                .openProject(projectCode);
        createTestCasePage
                .createFirstTestCase(testCase);
    }

    @Test
    public void OneMoreTestCaseShouldBeCreated() {
       Project project = ProjectBuilder.getProjectByAPI();
        String projectCode = new ProjectsAdapter().create(project);
        TestCase testCase = TestCaseBuilder.getTestCase();
        loginStep.login(validUser );
        projectPage.openProject(projectCode);
        createTestCasePage.createFirstTestCase(testCase);
        TestCase testCase2 = TestCaseBuilder.getTestCase();
        createTestCasePage.createMoreTestCases(testCase2);
    }
}
