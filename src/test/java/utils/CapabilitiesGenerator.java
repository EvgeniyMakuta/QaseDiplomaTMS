package utils;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.chrome.ChromeOptions;
@Log4j2
public class CapabilitiesGenerator {
    public static ChromeOptions getChromeOptions() {
        ChromeOptions options = new ChromeOptions();
        log.debug(" Used browser: " + options.getBrowserName());
        options.addArguments(
                "--ignore-certificate-errors",
                "--disable-popup-blocking",
                "--disable-notifications",
                "-incognito",
                "--disable-extensions"
        );
        options.setAcceptInsecureCerts(true);
        return options;
    }
}
