package pageObjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.asserts.SoftAssert;

public class SignInPage extends AbstractPage {

    private static final Logger LOG = Logger.getLogger(SignInPage.class);

    private final By mailInput = By.id("username");

    private final By passwordInput = By.id("password");

    private final By continueButton = By.id("kc-login-next");

    private final By continueButtonDisabled = By.xpath("//button[@id='kc-login-next' and @disabled]");

    private final By continueButtonEnabled = By.xpath("//button[@id='kc-login-next' and not(@disabled)]");

    private final By signInButton = By.id("kc-login");

    private final By loginFailedErrorMessage = By.xpath("//span[@class='error-text']");

    public SignInPage enterEmail(String email) {
        getElement(mailInput).sendKeys(email);
        LOG.info("Mail [" + email + "] was entered.");
        return this;
    }

    public void clearEmailField() {
        getElement(mailInput).clear();
        LOG.info("Mail field was cleared.");
    }

    public SignInPage enterPassword(String password) {
        getElement(passwordInput).sendKeys(password);
        LOG.info("Password was entered.");
        return this;
    }

    public SignInPage clickContinueButton() {
        getElement(continueButton).click();
        LOG.info("Continue button clicked.");
        return this;
    }

    public void clickSignInButton() {
        getElement(signInButton).click();
        LOG.info("Sign in button clicked.");
    }

    public boolean isLoginFailedErrorMessageDisplayed() {
        boolean isDisplayed = isDisplayed(loginFailedErrorMessage);
        LOG.info(String.format("Is 'Login Failed' error message displayed': '%s'", isDisplayed));
        return isDisplayed;
    }

    public boolean isContinueButtonNotActive() {
        boolean isDisplayed = isDisplayed(continueButtonDisabled);
        LOG.info(String.format("Is 'Continue button' inactive': '%s'", isDisplayed));
        return isDisplayed;
    }

    public boolean isContinueButtonActive() {
        boolean isDisplayed = isDisplayed(continueButtonEnabled);
        LOG.info(String.format("Is 'Continue button' active': '%s'", isDisplayed));
        return isDisplayed;
    }

    public boolean isPasswordInputDisplayed() {
        boolean isDisplayed = isDisplayed(passwordInput);
        LOG.info(String.format("Is 'Enter Password Window' displayed': '%s'", isDisplayed));
        return isDisplayed;
    }
}
