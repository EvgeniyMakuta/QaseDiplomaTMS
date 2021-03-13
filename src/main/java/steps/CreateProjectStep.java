package steps;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import objects.Project;
import org.openqa.selenium.WebDriver;
import pages.CreateProjectPage;
import pages.ProjectPage;

@Log4j2
public class CreateProjectStep extends BaseSteps {
    CreateProjectPage createProjectPage;
    ProjectPage projectPage;

    public CreateProjectStep(WebDriver driver, CreateProjectPage createProjectPage, ProjectPage projectPage) {
        super(driver);
        this.createProjectPage = createProjectPage;
        this.projectPage = projectPage;
    }

    @Step("Creating project {project.title} ")
    public ProjectStep createProject(Project project) {
        log.debug("Creating project: " + project);
        createProjectPage
                .createNewProject(project);
        projectPage
                .waitForPageOpened();
        return new ProjectStep(driver, projectPage);
    }
}
