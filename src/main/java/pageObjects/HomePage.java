package pageObjects;

import consts.BusinessConfigs;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;

public class HomePage extends AbstractPage {

    private static final Logger LOG = Logger.getLogger(HomePage.class);

    private final By signInButton = By.xpath("//a[@class='header-auth__signin']//span");

    private final By topRightCornerUserNameElement = By.xpath("//div[@class='user-navigation-container']//div[@class='user-info__name']");

    private final By trainingListPageButton = By.xpath("//ul[@class='main-nav__list']//a[contains(@class,'training')]");

    private final By newsPageButton = By.xpath("//ul[@class='main-nav__list']//a[contains(@class,'news')]");

    private final By aboutPageButton = By.xpath("//ul[@class='main-nav__list']//a[contains(@class,'about')]");

    private final By FAQPageButton = By.xpath("//ul[@class='main-nav__list']//a[contains(@class,'faq')]");

    public void clickSignInButton() {
        getElement(signInButton).click();
        LOG.info("'Sign in' button clicked");
    }

    public void proceedToHomePage() {
        proceedToPage(BusinessConfigs.HOME_PAGE_URL.getValue());
        LOG.info(String.format("Proceeded to '%s' URL.", BusinessConfigs.HOME_PAGE_URL));
    }

    public boolean isUserNameDisplayed() {
        boolean isDisplayed = isDisplayed(topRightCornerUserNameElement);
        LOG.info(String.format("User is logged in: '%s'", isDisplayed));
        return isDisplayed;
    }

    public String getLoggedInUserName() {
        return getElement(topRightCornerUserNameElement).getText();
    }

    public AboutPage openAboutPage() {
        getElement(aboutPageButton).click();
        LOG.info("Open 'About' page.");
        return new AboutPage();
    }

    public FAQPage openFAQPage() {
        getElement(FAQPageButton).click();
        LOG.info("Open 'FAQ' page.");
        return new FAQPage();
    }
}
