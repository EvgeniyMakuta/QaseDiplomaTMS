package steps;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import pages.ProjectsPage;

@Log4j2
public class ProjectsStep extends BaseSteps {
    ProjectsPage projectsPage;

    public ProjectsStep(WebDriver driver) {
        super(driver);
        this.projectsPage = new ProjectsPage(driver);
    }

    public boolean isPageOpened() {
       return projectsPage.isPageOpened();
    }

    @Step("Deleting all projects with prefix {prefix}")
    public void deleteAllProjectsWithPrefix(String prefix) {
        log.debug(String.format("Deleting project with prefix %s", prefix));
        projectsPage.deleteAllProjects(prefix);
    }

}
