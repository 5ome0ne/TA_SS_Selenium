package pageObjects;

import consts.Constants;
import consts.properties.ConfigProperties;
import driver.DriverFactory;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class AbstractPage {

    private final WebDriverWait wait =
            new WebDriverWait(DriverFactory.getDriver(), Duration.ofSeconds(Long.parseLong(ConfigProperties.getValue(
                    Constants.DRIVER_PROP_TAG.getValue(), "DIVER_WAIT_TIME"))));

    private static final Logger LOG = Logger.getLogger(AbstractPage.class);

    void proceedToPage(final String url) {
        DriverFactory.getDriver().get(url);
    }

    WebElement getElement(By locator) {
        WebElement result = null;
        try {
            result = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        } catch (NoSuchElementException | TimeoutException e) {
            LOG.error(String.format("\t--->Can't find element by locator '%s'", locator));
        }
        return result;
    }

    List<WebElement> getElements(By locator) {
        List<WebElement> elementsList = null;
        try {
            elementsList = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
        } catch (StaleElementReferenceException ex) {
            elementsList = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
        } catch (NoSuchElementException | TimeoutException e) {
            LOG.error(String.format("\t--->Can't find elements List by locator '%s'", locator));
        }
        return elementsList;
    }

    public boolean isDisplayed(By locator) {
        WebElement element = getElement(locator);
        if (element != null) {
            return getElement(locator).isDisplayed();
        } else
            return false;
    }
}
