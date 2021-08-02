package driver;

import consts.DriverConfigs;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public abstract class DriverFactory {

    private WebDriver webDriver;

    protected void initDriver(final String browserName) {
        if (DriverConfigs.CHROME_NAME.equalsIgnoreCase(browserName)) {
            System.setProperty(DriverConfigs.CHROME_NAME, DriverConfigs.CHROME_DRIVER_LOCATION);
            webDriver = new ChromeDriver();
        } else if (DriverConfigs.FIREFOX_NAME.equalsIgnoreCase(browserName)) {
            System.setProperty(DriverConfigs.FIREFOX_NAME, DriverConfigs.FIREFOX_DRIVER_LOCATION);
            webDriver = new FirefoxDriver();
        } else if (DriverConfigs.EDGE_NAME.equalsIgnoreCase(browserName)) {
            System.setProperty(DriverConfigs.EDGE_NAME, DriverConfigs.EDGE_DRIVER_LOCATION);
            webDriver = new EdgeDriver();
        }
        assert webDriver != null;
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts()
                .implicitlyWait(Duration.ofSeconds(Long.parseLong(DriverConfigs.IMPLICITLY_WAIT_TIME)));
    }

    public WebDriver getDriver() {
        return webDriver;
    }

    protected void quitDriver() {
        if (webDriver != null) {
            webDriver.quit();
            webDriver = null;
        }
    }
}
