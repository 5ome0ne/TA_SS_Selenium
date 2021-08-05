package driver;

import consts.Constants;
import consts.DriverConfigs;
import consts.properties.ConfigProperties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.security.InvalidParameterException;
import java.time.Duration;

public abstract class DriverFactory {

    private static WebDriver webDriver;

    public static void initDriver(final String browserName) {
        if (DriverConfigs.CHROME.getName().equalsIgnoreCase(browserName)) {
            System.setProperty(DriverConfigs.CHROME.getName(), DriverConfigs.CHROME.getPath());
            webDriver = new ChromeDriver();
        } else if (DriverConfigs.FIREFOX.getName().equalsIgnoreCase(browserName)) {
            System.setProperty(DriverConfigs.FIREFOX.getName(), DriverConfigs.FIREFOX.getName());
            webDriver = new FirefoxDriver();
        } else if (DriverConfigs.EDGE.getName().equalsIgnoreCase(browserName)) {
            System.setProperty(DriverConfigs.EDGE.getName(), DriverConfigs.EDGE.getPath());
            webDriver = new EdgeDriver();
        } else {
            throw new InvalidParameterException("\tERROR: Unknown browser name=" + browserName);
        }
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts()
                .implicitlyWait(Duration.ofSeconds(Long.parseLong(ConfigProperties.getValue(
                        Constants.DRIVER_PROP_TAG.getValue(), "IMPLICITLY_WAIT_TIME"))));
    }

    public static WebDriver getDriver() {
        if (webDriver == null){
            throw new NullPointerException("\tERROR: WebDriver isn't initialized");
        }
        return webDriver;
    }

    public static void quitDriver() {
        if (webDriver != null) {
            webDriver.quit();
            webDriver = null;
        }
    }
}
