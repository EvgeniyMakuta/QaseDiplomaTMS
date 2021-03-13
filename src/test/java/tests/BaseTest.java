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
    ProjectPage projectPage;
    StartPage startPage;
    SettingsPage settingsPage;
    ProjectsPage projectsPage;
    LoginPage loginPage;
    CreateTestCasePage createTestCasePage;
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
        pageInit();
        stepInit();
    }

    private void pageInit() {
        loginPage = new LoginPage(driver);
        startPage = new StartPage(driver);
        settingsPage = new SettingsPage(driver);
        projectsPage = new ProjectsPage(driver);
        createProjectPage = new CreateProjectPage(driver);
        createTestCasePage = new CreateTestCasePage(driver);
        projectPage = new ProjectPage(driver);
    }

    private void stepInit() {
        loginStep = new LoginStep(driver, loginPage, projectsPage);
        startStep = new StartStep(driver, startPage);
        projectStep = new ProjectStep(driver, projectPage);
        createProjectStep = new CreateProjectStep(driver, createProjectPage, projectPage);
        settingsStep = new SettingsStep(driver, settingsPage);
        createTestCaseStep = new CreateTestCaseStep(driver, projectPage, createTestCasePage);
        projectsStep = new ProjectsStep(driver, projectsPage);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
