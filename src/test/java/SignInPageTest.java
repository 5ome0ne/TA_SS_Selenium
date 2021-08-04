import consts.BusinessConfigs;
import dataProviders.MailsProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pageObjects.businessObjects.HomeBO;
import pageObjects.businessObjects.SignInBO;


//            1:  2.  1 negative scenario test with verifying all the criteria using soft asserts
//                    "and compare the difference with previous"    ???????
//
//            2: що краще? data-provider або перебір (foreach) коли можливо
//
//            3: чого працює label[normalize-space()='???']
//            а label[normalize-space(text())='???'] ні?


public class SignInPageTest extends BaseTest {

    @Test(description = "Verify user is successfully logged in with appropriate credentials")
    public void verifyUserSuccessfullyLoggedInWithAppropriateCredentials() {
        HomeBO homeBO = new HomeBO();
        homeBO
                .loginWithAppropriateCredentials()
                .verifyUserNameDisplayed();
    }

    @Test(description = "Verify error message appears when user logging in with inappropriate credentials")
    public void verifyErrorMessageAppearsForIncorrectUser() {
        new HomeBO()
                .proceedToHomePage()
                .clickSignInButton()
                .login("incorrectmail@gmail.com", "incorrectPassword");
        new SignInBO()
                .verifyFailedLoginErrorMessageDisplayed();
    }

    @Test(dataProvider = "invalid-mails",
            dataProviderClass = MailsProvider.class,
            description = "Verify continue button on ‘Sign In’ window shouldn't become enabled with incorrect mail format")
    public void verifyContinueButtonShouldNotBecomeEnabledWithIncorrectMail(String email) {
        new HomeBO()
                .proceedToHomePage()
                .clickSignInButton()
                .enterEmail(email)
                .verifyContinueButtonIsNotActive();
    }

    @Test(description = "[Hard assert]: Verify continue button on ‘Sign In’ window shouldn't become enabled with incorrect mail format")
    public void verifyContinueButtonShouldNotBecomeEnabledWithIncorrectMailHardAssert() {

        Object[][] invalidMails = MailsProvider.invalidMails();
        SignInBO signInBO = new HomeBO()
                .proceedToHomePage()
                .clickSignInButton();
        for (Object[] mail : invalidMails) {
            signInBO
                    .clearEmailField()
                    .enterEmail((String) mail[0])
                    .verifyContinueButtonIsNotActive();
        }
    }

    @Test(description = "[Soft assert]: Verify continue button on ‘Sign In’ window shouldn't become enabled with incorrect mail format")
    public void verifyContinueButtonShouldNotBecomeEnabledWithIncorrectMailSoftAssert() {

        SignInBO signInBO = new HomeBO()
                .proceedToHomePage()
                .clickSignInButton();

        SoftAssert softAssert = new SoftAssert();
        Object[][] invalidMails = MailsProvider.invalidMails();
        for (Object[] mail : invalidMails) {
            signInBO
                    .clearEmailField()
                    .enterEmail((String) mail[0])
                    .verifyContinueButtonIsNotActive(softAssert);
        }

        softAssert.assertAll();
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
                .enterEmail(BusinessConfigs.CORRECT_MAIL.getValue())
                .clickContinueButton()
                .verifyPasswordInputAppears();
    }
}
