package steps;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import objects.Project;
import objects.User;
import org.openqa.selenium.WebDriver;
import pages.CreateProjectPage;
import pages.ProjectPage;

@Log4j2
public class CreateProjectStep extends BaseSteps {
    CreateProjectPage createProjectPage;
    ProjectPage projectPage;
    LoginStep loginStep;

    public CreateProjectStep(WebDriver driver, CreateProjectPage createProjectPage, ProjectPage projectPage, LoginStep loginStep) {
        super(driver);
        this.loginStep = loginStep;
        this.createProjectPage = createProjectPage;
        this.projectPage = projectPage;
    }

    @Step("Creating project {project.title} ")
    public ProjectStep createProject(Project project, User user) {
        log.debug("Creating project: " + project);
        loginStep.login(user);
        createProjectPage.createNewProject(project);
        projectPage.waitForPageOpened();
        return new ProjectStep(driver, projectPage, loginStep);
    }
}
