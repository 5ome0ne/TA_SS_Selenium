package pageObjects.businessObjects;

import consts.BusinessConfigs;
import org.testng.Assert;
import pageObjects.HomePage;

public class HomeBO {
    private HomePage homePage;

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
        .login(BusinessConfigs.CORRECT_MAIL.getValue(), BusinessConfigs.CORRECT_PASSWORD.getValue());
        return this;
    }

//    ????????????????????????????????????????????????????????????????????????????????????????????????????????????????
//    public <T extends AbstractPage> T openPage(Class<T> page){
//        try {
//            Method method =
//        }
//    }
}
