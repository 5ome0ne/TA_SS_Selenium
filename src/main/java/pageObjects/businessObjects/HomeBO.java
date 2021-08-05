package pageObjects.businessObjects;

import consts.Constants;
import org.testng.Assert;
import pageObjects.HomePage;

public class HomeBO {
    private final HomePage homePage;

    public HomeBO() {
        homePage = new HomePage();
    }

    public HomeBO proceedToHomePage() {
        homePage.proceedToHomePage();
        return this;
    }

    public SignInBO clickSignInButton() {
        homePage.clickSignInButton();
        return new SignInBO();
    }

    public void verifyUserNameDisplayed() {
        Assert.assertTrue(homePage.isUserNameDisplayed(),
                "'Login failed' user name isn't displayed");
    }

    public void verifyUserIsLoggedIn() {
        Assert.assertTrue(homePage.isUserNameDisplayed(), "User is not logged in");
    }

    public HomeBO loginWithAppropriateCredentials() {
        proceedToHomePage()
        .clickSignInButton()
        .login(Constants.CORRECT_MAIL.getValue(), Constants.CORRECT_PASSWORD.getValue());
        return this;
    }

    public BlogBO openBlogPage() {
        return homePage.openBlogPage();
    }

    public TrainingListBO openTrainingListPage() {
        return homePage.openTrainingListPage();
    }
}
