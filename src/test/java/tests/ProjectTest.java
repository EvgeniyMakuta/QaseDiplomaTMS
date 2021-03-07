package tests;

import adapters.ProjectsAdapter;
import builders.ProjectBuilder;
import objects.Project;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class ProjectTest extends BaseTest {

    @Test
    public void newProjectShouldBeCreated() {
        Project project = ProjectBuilder.getProject();
        loginSteps
                .login(EMAIL, PASSWORD);
        createProjectPage
                .createNewProject(project)
                .waitForPageOpened();
        assertTrue(projectPage.isPageOpened());
    }

    @Test
    public void searchedProjectShouldBeFindAndOpened() {
        Project project = ProjectBuilder.getProjectByAPI();
        new ProjectsAdapter().create(project);
        loginSteps
                .login(EMAIL, PASSWORD)
                .openProject(project.getTitle())
                .waitForPageOpened();
        assertTrue(projectPage.isPageOpened());
    }

    @Test
    public void projectShouldBeDeleted() {
        Project project = ProjectBuilder.getProjectByAPI();
        String projectCode = new ProjectsAdapter().create(project);
        loginSteps
                .login(EMAIL, PASSWORD);
        projectPage
                .deleteProject(projectCode)
                .waitForPageOpened();
        int statusCode = new ProjectsAdapter().getProject(projectCode).statusCode();
        assertEquals(statusCode, 404, "Status code should be 404 instead of " + statusCode);
    }
}
