package tests;

import builders.ProjectBuilder;
import objects.Project;
import org.testng.annotations.Test;

import static constants.Constants.PROJECT_UPDATE_ALERT_MSG;
import static org.testng.Assert.assertEquals;

public class SettingsTest extends BaseTest {

    @Test(description = "Verify that project is updated")
    public void projectShouldBeUpdated() {
        Project project = ProjectBuilder.getPublicProject();
        loginStep
                .login(validUser);
        createProjectPage
                 .createNewProject(project);
        Project updatedProject = ProjectBuilder.getPrivateProject();
        settingsPage
                .updateProject(updatedProject);
        String alert = settingsPage.getAlertMeg();
        assertEquals(alert, PROJECT_UPDATE_ALERT_MSG, "Fields are not updated or/and alert msg is invalid: " + alert);
    }

    @Test
    public void tes() {
        loginStep.login(validUser);
        settingsPage.openPage("XZKX");
    }
}
