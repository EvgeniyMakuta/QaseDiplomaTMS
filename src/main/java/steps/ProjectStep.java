package steps;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import objects.Project;
import org.openqa.selenium.WebDriver;
import pages.ProjectPage;

@Log4j2
public class ProjectStep extends BaseSteps {
    ProjectPage projectPage = new ProjectPage(driver);

    public ProjectStep(WebDriver driver) {
        super(driver);
    }

    @Step("Opening project {project}")
    public ProjectStep openProject(Project project) {
        log.debug(String.format("Opening project %s", project));
        projectPage
                .openProject(project.getCode())
                .waitForPageOpened();
        return this;
    }

    public boolean isPageOpened() {
       return projectPage.isPageOpened();
    }

    @Step("Deleting project with code {projectCode}")
    public ProjectsStep deleteProject(String projectCode) {
        log.debug(String.format("Deleting project with code %s", projectCode));
        projectPage
                .deleteProject(projectCode)
                .waitForPageOpened();
        return new ProjectsStep(driver);
    }

    public String getProjectTitle() {
        return projectPage.getProjectTitle();
    }

    public String getProjectCode() {
        return projectPage.getProjectCode();
    }
}
