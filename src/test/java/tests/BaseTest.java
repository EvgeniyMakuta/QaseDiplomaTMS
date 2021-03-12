package tests;

import builders.UserBuilder;
import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.extern.log4j.Log4j2;
import objects.User;
import org.openqa.selenium.SessionNotCreatedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import pages.*;
import steps.*;
import test_data.TestConstants;
import utils.CapabilitiesGenerator;
import utils.TestListener;
import waiters.Waiters;

import static java.util.concurrent.TimeUnit.SECONDS;
import static org.testng.Assert.fail;

@Log4j2
@Listeners(TestListener.class)
public class BaseTest implements TestConstants {
    WebDriver driver;
    LoginStep loginStep;
    StartStep startStep;
    ProjectStep projectStep;
    ProjectsStep projectsStep;
    CreateProjectStep createProjectStep;
    CreateTestCaseStep createTestCaseStep;
    SettingsStep settingsStep;
    ProjectsPage projectsPage;
    CreateProjectPage createProjectPage;
    Waiters wait;

    User validUser = UserBuilder.getValidUser();

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        try {
            driver = new ChromeDriver(CapabilitiesGenerator.getChromeOptions());
        } catch (SessionNotCreatedException e) {
            log.fatal(e.getLocalizedMessage());
            fail("Browser is not opened");
        }
        driver.manage().window().maximize();
        wait = new Waiters(driver);
        wait.implicitWait(IMPLICIT_WAIT, SECONDS);
        loginStep = new LoginStep(driver);
        startStep = new StartStep(driver);
        projectStep = new ProjectStep(driver);
        createProjectStep = new CreateProjectStep(driver);
        settingsStep = new SettingsStep(driver);
        createTestCaseStep = new CreateTestCaseStep(driver);
        projectsStep = new ProjectsStep(driver);
        projectsPage = new ProjectsPage(driver);
        createProjectPage = new CreateProjectPage(driver);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
