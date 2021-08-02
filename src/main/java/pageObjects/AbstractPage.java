package pageObjects;

import consts.DriverConfigs;
import driver.DriverFactory;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class AbstractPage {

    //    private static final WebDriverWait wait =  new WebDriverWait(webDriver, Duration.ofSeconds(DriverConfigs.DIVER_WAIT_TIME));
    private final WebDriverWait wait;
    private final WebDriver webDriver;

    AbstractPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        wait = new WebDriverWait(webDriver, Duration.ofSeconds(DriverConfigs.DIVER_WAIT_TIME));
    }

    void proceedToPage(final String url) {
        webDriver.get(url);
    }

    WebElement getElement(By locator) {
        WebElement webElement = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return webElement;
    }

    List<WebElement> getElements(By locator) {
        return webDriver.findElements(locator);
//        return DriverFactory.getDriver().findElements(locator);
    }


    public boolean isDisplayed(By locator) {
        try {
            WebElement result = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            return result.isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

    public WebDriver getWebDriver() {
        return webDriver;
    }
}
