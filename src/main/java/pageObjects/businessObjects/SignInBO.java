package pageObjects.businessObjects;

import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import pageObjects.SignInPage;

public class SignInBO {

    private SignInPage signInPage;

    public SignInBO() {
        this.signInPage = new SignInPage();
    }

    public void login(String email, String password) {
        signInPage
                .enterEmail(email)
                .clickContinueButton()
                .enterPassword(password)
                .clickSignInButton();
    }

    public SignInBO enterEmail(String email) {
        signInPage
                .enterEmail(email);
        return this;
    }

    public void verifyFailedLoginErrorMessageDisplayed() {
        Assert.assertTrue(signInPage.isLoginFailedErrorMessageDisplayed(),
                "'Login failed' error message is not displayed");
    }

    public void verifyContinueButtonIsNotActive() {
        verifyContinueButtonIsNotActive(null);
    }

    public void verifyContinueButtonIsNotActive(SoftAssert softAssert) {
        String message = "'Check incorrect mail format failed' continue button is enabled";
        boolean result = signInPage.isContinueButtonNotActive();
        if (softAssert != null) {
            softAssert.assertTrue(result, message);
        } else Assert.assertTrue(result, message);
    }

    public void verifyContinueButtonIsActive() {
        Assert.assertTrue(signInPage.isContinueButtonActive(), "'Check correct mail format failed' continue button isn't enabled");
    }

    public SignInBO clearEmailField() {
        signInPage.clearEmailField();
        return this;
    }

    public SignInBO clickContinueButton() {
        signInPage.clickContinueButton();
        return this;
    }

    public void verifyPasswordInputAppears() {
        Assert.assertTrue(signInPage.isPasswordInputDisplayed(), "'Password input' is not displayed");
    }
}
