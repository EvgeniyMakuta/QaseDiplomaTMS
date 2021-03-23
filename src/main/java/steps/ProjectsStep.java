package steps;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import pages.ProjectsPage;

@Log4j2
public class ProjectsStep extends BaseSteps {
    ProjectsPage projectsPage;

    public ProjectsStep(WebDriver driver, ProjectsPage projectsPage) {
        super(driver);
        this.projectsPage = projectsPage;
    }
}
