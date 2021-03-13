package tests;

import adapters.ProjectsAdapter;
import builders.ProjectBuilder;
import objects.Project;
import org.testng.annotations.Test;

import java.util.Locale;

import static constants.IConstants.PROJECT_PREFIX_NAME;
import static objects.enums.AccessType.PUBLIC;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class ProjectTest extends BaseTest {

    @Test(description = "Verify that new public project is created")
    public void newPublicProjectShouldBeCreated() {
        Project project = ProjectBuilder.getPublicProject();
        loginStep
                .login(validUser);
        createProjectStep
                .createProject(project);
        String actualProjectTitle = projectStep.getProjectTitle();
        String actualProjectCode = projectStep.getProjectCode();
        boolean isRadioSelected = projectPage.isAccessTypeSelected(PUBLIC);
        assertEquals(actualProjectTitle, project.getTitle(),"Project title is wrong: " + actualProjectTitle);
        assertEquals(actualProjectCode, project.getCode().toUpperCase(Locale.ROOT), "Project code is wrong: " + actualProjectCode);
        assertTrue(isRadioSelected, "Selected wrong access type for project");
    }

    @Test(description = "Verify that new private project is created")
    public void newPrivateProjectShouldBeCreated() {
        Project project = ProjectBuilder.getPrivateProject();
        loginStep
                .login(validUser);
        createProjectStep
                .createProject(project);
        String actualProjectTitle = projectStep.getProjectTitle();
        String actualProjectCode = projectStep.getProjectCode();
        assertTrue(projectStep.isPageOpened(), "Created project page is not opened" + project);
        assertEquals(actualProjectTitle, project.getTitle(),"Project title is wrong: " + actualProjectTitle);
        assertEquals(actualProjectCode, project.getCode().toUpperCase(Locale.ROOT), "Project code is wrong: " + actualProjectCode);
    }

    @Test(description = "Verify that searched project exists and can be opened")
    public void searchedProjectShouldBeFindAndOpened() {
        Project project = ProjectBuilder.getProjectForAPI();
        new ProjectsAdapter().create(project);
        loginStep
                .login(validUser);
        projectStep
                .openProject(project);
        assertTrue(projectStep.isPageOpened(), "Searched project is not opened " + project);
    }

    @Test(description = "Verify that project is deleted")
    public void projectShouldBeDeleted() {
        Project project = ProjectBuilder.getProjectForAPI();
        String projectCode = new ProjectsAdapter().create(project);
        loginStep
                .login(validUser);
        projectStep
                .deleteProject(projectCode);
        assertTrue(projectsStep.isPageOpened(), "Project is not deleted " + project);
    }

    @Test(description = "Verify that all searched project are deleted")
    public void allProjectsShouldBeDeleted() {
        loginStep.login(validUser);
        projectsStep.deleteAllProjectsWithPrefix(PROJECT_PREFIX_NAME);
    }
}
