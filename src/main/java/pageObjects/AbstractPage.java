package pageObjects;

import consts.Constants;
import consts.properties.ConfigProperties;
import driver.DriverFactory;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class AbstractPage {

    private final WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(),
            Duration.ofSeconds(Long.parseLong(ConfigProperties.getValue(Constants.DRIVER_PROP_TAG.getValue(), "DIVER_WAIT_TIME"))));

    private final Wait<WebDriver> waitFluent = new FluentWait<>(DriverFactory.getDriver())
            .withTimeout(Duration.ofSeconds(Long.parseLong(ConfigProperties.getValue(
                    Constants.DRIVER_PROP_TAG.getValue(), "DIVER_FLUENT_WAIT_TIME"))))
            .pollingEvery(Duration.ofSeconds(Long.parseLong(ConfigProperties.getValue(
                    Constants.DRIVER_PROP_TAG.getValue(), "DIVER_FLUENT_POLL_TIME"))))
            .ignoring(NoSuchElementException.class);


    void proceedToPage(final String url) {
        DriverFactory.getDriver().get(url);
    }

    protected WebElement getElement(By locator) {
        return wait.until(driver -> driver.findElement(locator));
    }

    protected List<WebElement> getElements(By locator) {
        return wait.until(driver -> driver.findElements(locator));
    }

    protected WebElement getElementFluentWait(By locator) {
        return waitFluent.until(driver -> driver.findElement(locator));
    }

    protected List<WebElement> getElementsFluentWait(By locator) {
        return waitFluent.until(driver -> driver.findElements(locator));
    }

    protected WebElement getElementWaitToBeClickable(By locator) {
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    protected boolean isExist(By locator){
        return !DriverFactory.getDriver().findElements(locator).isEmpty();
    }

    protected boolean isEnabled(By locator){
        WebElement element = getElement(locator);
        if (element != null) {
            return element.isEnabled();
        } else
            return false;
    }

    protected boolean isClickable(By locator) {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
        if (element != null) {
            return element.isDisplayed();
        } else
            return false;
    }

    protected boolean isDisplayed(By locator) {
        WebElement element = getElement(locator);
        if (element != null) {
            return element.isDisplayed();
        } else
            return false;
    }

    protected boolean isDisplayedExpectVisibility(By locator) {
        WebElement element = wait.until(ExpectedConditions.visibilityOf(DriverFactory.getDriver().findElement(locator)));
        if (element != null) {
            return element.isDisplayed();
        } else
            return false;
    }
}
