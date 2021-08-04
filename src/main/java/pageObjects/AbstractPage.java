package pageObjects;

import consts.DriverConfigs;
import driver.DriverFactory;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class AbstractPage {

    private final WebDriverWait wait =
            new WebDriverWait(DriverFactory.getDriver(), Duration.ofSeconds(DriverConfigs.DIVER_WAIT_TIME));

    void proceedToPage(final String url) {
        DriverFactory.getDriver().get(url);
    }

    WebElement getElement(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    List<WebElement> getElements(By locator) {
        return DriverFactory.getDriver().findElements(locator);
    }

    public boolean isDisplayed(By locator) {
        try {
            return getElement(locator).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

    public void moveToElement(By locator) {
        WebElement element = DriverFactory.getDriver().findElement(locator);
        Actions actions = new Actions(DriverFactory.getDriver());
        actions.moveToElement(element);
        actions.perform();

        JavascriptExecutor jse = (JavascriptExecutor) DriverFactory.getDriver();
        jse.executeScript("window.scrollBy(0, 500)");
    }
}
