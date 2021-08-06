package pageObjects.businessObjects;

import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import pageObjects.SignInPage;

public class SignInBO {

    private static final String MSG_ERROR_CONTINUE_BTN_ACTIVE = "'Check incorrect mail format failed' continue button is active";
    private final SignInPage signInPage;

    public SignInBO() {
        this.signInPage = new SignInPage();
    }

    public SignInBO login(String email, String password) {
        signInPage
                .enterEmail(email)
                .clickContinueButton()
                .enterPassword(password)
                .clickSignInButton();
        return this;
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
        Assert.assertFalse(signInPage.isContinueButtonEnabled(), MSG_ERROR_CONTINUE_BTN_ACTIVE);
    }

    public void verifyContinueButtonIsNotActiveHardAssert(String[] invalidMailsArray) {
        for (String mail : invalidMailsArray) {
            this
                    .clearEmailField()
                    .enterEmail(mail)
                    .verifyContinueButtonIsNotActive();
        }
    }

    public void verifyContinueButtonIsNotActiveSoftAssert(String[] invalidMailsArray) {
        SoftAssert softAssert = new SoftAssert();
        for (String mail : invalidMailsArray) {
            this
                    .clearEmailField()
                    .enterEmail(mail);
            softAssert.assertFalse(signInPage.isContinueButtonEnabled(), MSG_ERROR_CONTINUE_BTN_ACTIVE);
        }
        softAssert.assertAll();
    }

    public void verifyContinueButtonIsActive() {
        Assert.assertTrue(signInPage.isContinueButtonEnabled(), "'Check correct mail format failed' continue button isn't enabled");
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
        Assert.assertTrue(signInPage.isPasswordInputClickable(), "'Password input' is not enabled");
    }
}
