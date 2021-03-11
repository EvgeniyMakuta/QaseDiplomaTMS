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
import pages.*;
import steps.LoginStep;
import steps.StartStep;
import test_data.TestConstants;
import utils.CapabilitiesGenerator;
import waiters.Waiters;

import static java.util.concurrent.TimeUnit.SECONDS;
import static org.testng.Assert.fail;

@Log4j2
public class BaseTest implements TestConstants {
    WebDriver driver;
    LoginPage loginPage;
    ProjectsPage projectsPage;
    ProjectPage projectPage;
    CreateProjectPage createProjectPage;
    LoginStep loginStep;
    CreateTestCasePage createTestCasePage;
    StartPage startPage;
    StartStep startStep;
    SettingsPage settingsPage;
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
       // TODO выгести отдельно!
       loginPage = new LoginPage(driver);
       projectsPage = new ProjectsPage(driver);
       projectPage = new ProjectPage(driver);
       createProjectPage = new CreateProjectPage(driver);
       loginStep = new LoginStep(driver);
       createTestCasePage = new CreateTestCasePage(driver);
       startPage = new StartPage(driver);
       wait = new Waiters(driver);
       startStep = new StartStep(driver);
       settingsPage = new SettingsPage(driver);
       wait.implicitWait(IMPLICIT_WAIT, SECONDS);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
