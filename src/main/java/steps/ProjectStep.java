package steps;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import objects.User;
import org.openqa.selenium.WebDriver;
import pages.ProjectPage;
import pages.ProjectsPage;

@Log4j2
public class ProjectStep extends BaseSteps {
    ProjectPage projectPage;
    ProjectsPage projectsPage;
    LoginStep loginStep;

    public ProjectStep(WebDriver driver, ProjectPage projectPage, LoginStep loginStep) {
        super(driver);
        this.projectPage = projectPage;
        this.loginStep = loginStep;
    }

    @Step("Opening project")
    public ProjectStep openProject(String code, User user) {
        log.debug(String.format("Opening project with code %s", code));
        loginStep
                .login(user);
        projectPage
                .openProject(code)
                .waitForPageOpened();
        return this;
    }

    @Step("Deleting project with code {projectCode}")
    public ProjectsStep deleteProject(String projectCode) {
        log.debug(String.format("Deleting project with code %s", projectCode));
        projectPage
                .deleteProject(projectCode)
                .waitForPageOpened();
        return new ProjectsStep(driver, projectsPage);
    }

    @Step("Deleting test case {title}")
    public ProjectStep deleteTestCase(String title) {
        projectPage.deleteTestCase(title);
        return this;
    }
}
