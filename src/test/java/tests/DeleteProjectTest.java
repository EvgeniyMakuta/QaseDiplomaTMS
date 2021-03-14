package tests;

import org.testng.annotations.Test;

import static constants.IConstants.PROJECT_CODE;
import static org.testng.Assert.assertTrue;

public class DeleteProjectTest extends BaseTest {

    @Test(description = "Verify that project is deleted")
    public void projectShouldBeDeleted() {
        projectStep
                .openProject(PROJECT_CODE, validUser)
                .deleteProject(PROJECT_CODE);
        assertTrue(projectsPage.isPageOpened(), "Project is not deleted with code " + PROJECT_CODE);
    }
}
