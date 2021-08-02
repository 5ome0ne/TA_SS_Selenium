import consts.BusinessConfigs;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.SignInPage;

public class SignInPageTest extends BaseTest {


    @Test(description = "Verify user is successfully logged in with appropriate credentials.")
    public void verifyUserIsSuccessfullyLoggedInWithAppropriateCredentials() {
        new HomePage(getDriver())
                .proceedToHomePage()
                .clickSignInButton()
                .enterEmail(BusinessConfigs.CORRECT_MAIL)
                .clickContinueButton()
                .enterPassword(BusinessConfigs.CORRECT_PASSWORD)
                .clickSignInButton();
        new SignInPage(getDriver())
                .verifyUserNameDisplayed();

    }

//    @Ignore
    @Test(description = "Verify error message appears when user logging in with inappropriate credentials.")
    public void verifyErrorMessageAppearsForIncorrectUser() {
        new HomePage(getDriver())
              .proceedToHomePage()
              .clickSignInButton()
                .enterEmail("incorrectmail@gmail.com")
                .clickContinueButton()
                .enterPassword("incorrectPassword")
                .clickSignInButton();
        new SignInPage(getDriver())
              .verifyFailedLoginErrorMessageDisplayed();
    }
}
