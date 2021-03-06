package tests;

import builders.ProjectBuilder;
import objects.Project;
import org.testng.annotations.Test;

import static constants.IConstants.PROJECT_UPDATE_ALERT_MSG;
import static org.testng.Assert.assertEquals;

public class SettingsTest extends BaseTest {

    @Test(description = "Verify that project is updated")
    public void projectShouldBeUpdated() {
        Project project = ProjectBuilder.getPublicProject();
        loginStep
                .login(validUser);
        createProjectStep.createProject(project);
        Project updatedProject = ProjectBuilder.getPrivateProject();
        settingsStep.updateProject(updatedProject);
        String alert = settingsStep.getErrorMessage();
        assertEquals(alert, PROJECT_UPDATE_ALERT_MSG, "Fields are not updated or/and alert msg is invalid: " + alert);
    }
}
