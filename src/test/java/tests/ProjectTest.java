package tests;

import builders.ProjectBuilder;
import objects.Project;
import org.testng.annotations.Test;

import java.util.Locale;

import static objects.enums.AccessType.PRIVATE;
import static objects.enums.AccessType.PUBLIC;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class ProjectTest extends BaseTest {

    @Test(description = "Verify that new private project is created")
    public void newPrivateProjectShouldBeCreated() {
        Project project = ProjectBuilder.getPrivateProject();
        createProjectStep.createProject(project, validUser);
        String actualProjectTitle = projectPage.getProjectTitle();
        String actualProjectCode = projectPage.getProjectCode();
        boolean isPrivateTypeSelected = projectPage.isAccessTypeSelected(PRIVATE);
        assertEquals(actualProjectTitle, project.getTitle(), "Project title is wrong: " + actualProjectTitle);
        assertEquals(actualProjectCode, project.getCode().toUpperCase(Locale.ROOT), "Project code is wrong: " + actualProjectCode);
        assertTrue(isPrivateTypeSelected, "Wrong access type selected for project");
    }

    @Test(description = "Verify that new public project is created")
    public void newPublicProjectShouldBeCreated() {
        Project project = ProjectBuilder.getPublicProject();
        createProjectStep.createProject(project, validUser);
        String actualProjectTitle = projectPage.getProjectTitle();
        String actualProjectCode = projectPage.getProjectCode();
        boolean isPublicTypeSelected = projectPage.isAccessTypeSelected(PUBLIC);
        assertEquals(actualProjectTitle, project.getTitle(), "Project title is wrong: " + actualProjectTitle);
        assertEquals(actualProjectCode, project.getCode().toUpperCase(Locale.ROOT), "Project code is wrong: " + actualProjectCode);
        assertTrue(isPublicTypeSelected, "Wrong access type selected for project");
        projectStep.deleteProject(actualProjectCode);
        assertTrue(projectsPage.isPageOpened(), "Project is not deleted " + project);
    }
}
