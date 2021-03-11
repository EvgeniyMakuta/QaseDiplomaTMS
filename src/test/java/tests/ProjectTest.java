package tests;

import adapters.ProjectsAdapter;
import builders.ProjectBuilder;
import objects.Project;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class ProjectTest extends BaseTest {

    @Test(description = "Verify that new public project is created")
    public void newPublicProjectShouldBeCreated() {
        Project project = ProjectBuilder.getPublicProject();
        loginStep
                .login(validUser);
        String projectCode = createProjectPage
                .createNewProject(project);
        projectPage
                .waitForPageOpened();
        assertTrue(projectPage.isPageOpened());
        int statusCode = new ProjectsAdapter().getProject(projectCode).statusCode();
        assertEquals(statusCode, 200, "Status code should be 200 instead of " + statusCode);
        // TODO дописать проверки полей + accessType
    }

    @Test(description = "Verify that new private project is created")
    public void newPrivateProjectShouldBeCreated() {
        Project project = ProjectBuilder.getPrivateProject();
        loginStep
                .login(validUser);
        String projectCode = createProjectPage
                .createNewProject(project);
        projectPage
                .waitForPageOpened();
        assertTrue(projectPage.isPageOpened());
        int statusCode = new ProjectsAdapter().getProject(projectCode).statusCode();
        assertEquals(statusCode, 200, "Status code should be 200 instead of " + statusCode);
        // TODO дописать проверки полей + accessType
    }

    @Test(description = "Verify that searched project exists and can be opened")
    public void searchedProjectShouldBeFindAndOpened() {
        Project project = ProjectBuilder.getProjectByAPI();
        new ProjectsAdapter().create(project);
        loginStep
                .login(validUser)
                .openProject(project.getTitle())
                .waitForPageOpened();
        assertTrue(projectPage.isPageOpened());
    }

    @Test(description = "Verify that project is deleted")
    public void projectShouldBeDeleted() {
        Project project = ProjectBuilder.getProjectByAPI();
        String projectCode = new ProjectsAdapter().create(project);
        loginStep
                .login(validUser);
        projectPage
                .deleteProject(projectCode)
                .waitForPageOpened();
        int statusCode = new ProjectsAdapter().getProject(projectCode).statusCode();
        assertEquals(statusCode, 404, "Status code should be 404 instead of " + statusCode);
    }
}
