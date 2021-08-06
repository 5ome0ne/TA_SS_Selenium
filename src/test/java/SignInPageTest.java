import consts.Constants;
import consts.values.MailValues;
import dataProviders.MailsProvider;
import org.testng.annotations.Test;
import pageObjects.businessObjects.HomeBO;

public class SignInPageTest extends BaseTest {

    @Test(description = "Verify user is successfully logged in with appropriate credentials")
    public void verifyUserSuccessfullyLoggedInWithAppropriateCredentials() {
        new HomeBO()
                .loginWithAppropriateCredentials()
                .verifyUserNameDisplayed();
    }

    @Test(description = "Verify 'Error Message' appears when user logging in with inappropriate credentials")
    public void verifyErrorMessageAppearsForIncorrectUser() {
        new HomeBO()
                .proceedToHomePage()
                .clickSignInButton()
                .login(
                        MailValues.VALID.getMails()[0],
                        MailValues.VALID.getMails()[0])
                .verifyFailedLoginErrorMessageDisplayed();
    }

    @Test(dataProvider = "invalid-mails",
            dataProviderClass = MailsProvider.class,
            description = "[Provider]: Verify continue button on ‘Sign In’ window shouldn't become enabled with incorrect mail format")
    public void verifyContinueButtonShouldNotBecomeEnabledWithIncorrectMail(String email) {
        new HomeBO()
                .proceedToHomePage()
                .clickSignInButton()
                .enterEmail(email)
                .verifyContinueButtonIsNotActive();
    }

    @Test(description = "[Hard assert]: Verify continue button on ‘Sign In’ window shouldn't become enabled with incorrect mail format")
    public void verifyContinueButtonShouldNotBecomeEnabledWithIncorrectMailHardAssert() {
        new HomeBO()
                .proceedToHomePage()
                .clickSignInButton()
                .verifyContinueButtonIsNotActiveHardAssert(MailValues.INVALID.getMails());
    }

    @Test(description = "[Soft assert]: Verify continue button on ‘Sign In’ window shouldn't become enabled with incorrect mail format")
    public void verifyContinueButtonShouldNotBecomeEnabledWithIncorrectMailSoftAssert() {
        new HomeBO()
                .proceedToHomePage()
                .clickSignInButton()
                .verifyContinueButtonIsNotActiveSoftAssert(MailValues.INVALID.getMails());
    }

    @Test(dataProvider = "valid-mails",
            dataProviderClass = MailsProvider.class,
            description = "Verify continue button on ‘Sign In’ window should become enabled with correct mail format")
    public void verifyContinueButtonShouldBecomeEnabledWithCorrectMail(String email) {
        new HomeBO()
                .proceedToHomePage()
                .clickSignInButton()
                .enterEmail(email)
                .verifyContinueButtonIsActive();
    }

    @Test(description = "Verify ‘Enter your password’ window appears with correct mail input")
    public void verifyEnterPasswordInputAppearsWithCorrectMail() {
        new HomeBO()
                .proceedToHomePage()
                .clickSignInButton()
                .enterEmail(Constants.CORRECT_MAIL.getValue())
                .clickContinueButton()
                .verifyPasswordInputAppears();
    }
}
