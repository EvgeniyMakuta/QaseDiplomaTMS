package tests;

import builders.TestCaseBuilder;
import objects.TestCase;
import org.testng.annotations.Test;

import static constants.IConstants.PROJECT_CODE;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class TestCaseTest extends BaseTest {

    @Test(description = "Verify that test cases are created")
    public void testCasesShouldBeCreated() {
        TestCase firstTestCase = TestCaseBuilder.getTestCase();
        projectStep.openProject(PROJECT_CODE, validUser);
        String expectedFirstTCName = firstTestCase.getTitle();
        createTestCaseStep.createTestCase(firstTestCase);
        TestCase secondTestCase = TestCaseBuilder.getTestCase();
        String expectedSecondTCName = secondTestCase.getTitle();
        createTestCaseStep.createTestCase(secondTestCase);
        String actualFirstTCName = createTestCaseStep.getTestCaseTitleByIndex(0);
        String actualSecondTCName = createTestCaseStep.getTestCaseTitleByIndex(1);
        assertEquals(actualFirstTCName, expectedFirstTCName, "Test case title is not valid: " + actualFirstTCName);
        assertEquals(actualSecondTCName, expectedSecondTCName, "Test case title is not valid: " + actualSecondTCName);
    }

    @Test(description = "Verify that test case is deleted")
    public void testCaseShouldBeDeleted() {
        TestCase testCase = TestCaseBuilder.getTestCase();
        projectStep.openProject(PROJECT_CODE, validUser);
        String testCaseTitle = testCase.getTitle();
        createTestCaseStep.createTestCase(testCase);
        projectStep.deleteTestCase(testCaseTitle);
        boolean isTestCaseDisplayed = projectPage.isTestCaseDisplayed(testCaseTitle);
        assertTrue(isTestCaseDisplayed, "Test case is still displayed");
    }
}
