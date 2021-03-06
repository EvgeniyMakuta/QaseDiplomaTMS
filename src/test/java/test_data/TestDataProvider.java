package test_data;

import org.testng.annotations.DataProvider;
import utils.PropertyReader;

public class TestDataProvider implements ITestConstants {
    static String email = System.getenv().getOrDefault("email", PropertyReader.getProperty("email"));
    static String password = System.getenv().getOrDefault("password", PropertyReader.getProperty("password"));

    @DataProvider(name = "InvalidTestDataFotLogin")
    public static Object[][] testDataForLogin() {
        return new Object[][] {
                {INVALID_EMAIL, password, "These credentials do not match our records."},
                {email, INVALID_PASSWORD, "These credentials do not match our records."}
        };
    }
}
