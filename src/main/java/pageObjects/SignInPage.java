package pageObjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;

public class SignInPage extends AbstractPage {

    private static final Logger LOG = Logger.getLogger(SignInPage.class);

    private final By mailInput = By.id("username");

    private final By passwordInput = By.id("password");

    private final By continueButton = By.id("kc-login-next");

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
        boolean isDisplayed = false;
        if (isExist(loginFailedErrorMessage)) isDisplayed = isDisplayedExpectVisibility(loginFailedErrorMessage);
        LOG.info(String.format("Is 'Login Failed' error message displayed': '%s'", isDisplayed));
        return isDisplayed;
    }

    public boolean isContinueButtonEnabled() {
        boolean isEnabled = getElement(continueButton).isEnabled();
        LOG.info(String.format("Is 'Continue button' active': '%s'", isEnabled));
        return isEnabled;
    }

    public boolean isPasswordInputClickable() {
        boolean isClickable = isClickable(passwordInput);
        LOG.info(String.format("Is 'Enter Password Window' clickable': '%s'", isClickable));
        return isClickable;
    }
}
