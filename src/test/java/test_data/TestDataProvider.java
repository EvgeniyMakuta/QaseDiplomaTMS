package test_data;

import org.testng.annotations.DataProvider;

public class TestDataProvider implements TestConstants {
    @DataProvider(name = "InvalidTestDataFotLogin")
    public static Object[][] testDataForLogin() {
        return new Object[][] {
                {INVALID_EMAIL, PASSWORD, "These credentials do not match our records."},
                {EMAIL, INVALID_PASSWORD, "These credentials do not match our records."}
        };
    }
}
