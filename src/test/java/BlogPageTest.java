import dataProviders.LinksProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pageObjects.businessObjects.BlogBO;
import pageObjects.businessObjects.HomeBO;

public class BlogPageTest extends BaseTest {

    @Test(description = "[Soft assert]: Verify All links on ‘Blog’ Page are displayed")
    public void verifyLinksAreDisplayed() {

        new HomeBO().loginWithAppropriateCredentials();
        BlogBO blogBO = new BlogBO();
        blogBO.proceedToBlogPage();

        SoftAssert softAssert = new SoftAssert();
        Object[][] links = LinksProvider.validLinks();
        for (Object[] linkTitle : links) {
            blogBO.verifyLinkIsPresent((String) linkTitle[0], softAssert);
        }

        softAssert.assertAll();
    }
}
