package tests;

import adapters.ProjectsAdapter;
import builders.ProjectBuilder;
import builders.TestCaseBuilder;
import objects.Project;
import objects.TestCase;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class TestCaseTest extends BaseTest {

    @Test(description = "Verify that test cases are created")
    public void testCasesShouldBeCreated() {
        Project project = ProjectBuilder.getProjectForAPI();
        new ProjectsAdapter().create(project);
        TestCase firstTestCase = TestCaseBuilder.getTestCase();
        loginStep.login(validUser);
        projectStep.openProject(project);
        String expectedFirstTCName = firstTestCase.getTitle();
        createTestCaseStep.createFirstTestCase(firstTestCase);
        TestCase secondTestCase = TestCaseBuilder.getTestCase();
        createTestCaseStep.createSecondTestCase(secondTestCase);
        String expectedSecondTCName = secondTestCase.getTitle();
        String actualFirstTCName = createTestCaseStep.getTestCaseTitleByIndex(0);
        String actualSecondTCName = createTestCaseStep.getTestCaseTitleByIndex(1);
        assertEquals(actualFirstTCName, expectedFirstTCName, "Test case title is not valid: " + actualFirstTCName);
        assertEquals(actualSecondTCName, expectedSecondTCName, "Test case title is not valid: " + actualSecondTCName);
    }
}
