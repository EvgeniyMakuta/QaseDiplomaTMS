package steps;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import objects.Project;
import org.openqa.selenium.WebDriver;
import pages.SettingsPage;

@Log4j2
public class SettingsStep extends BaseSteps {
    SettingsPage settingsPage = new SettingsPage(driver);

    public SettingsStep(WebDriver driver) {
        super(driver);
    }

    @Step("Updating project {project}")
    public SettingsStep updateProject(Project project) {
    log.debug(String.format("Updating project", project));
        settingsPage
                .updateProject(project)
                .waitForPageOpened();
                return this;
    }

    public String getErrorMessage() {
       return settingsPage.getAlertMsg();
    }
}
