import consts.values.LinksTitlesValues;
import org.testng.annotations.Test;
import pageObjects.businessObjects.HomeBO;

public class BlogPageTest extends BaseTest {

    @Test(description = "[Soft assert]: Verify All links on ‘Blog’ Page are displayed")
    public void verifyLinksAreDisplayed() {
        new HomeBO()
                .loginWithAppropriateCredentials()
                .openBlogPage()
                .verifyLinkIsDisplayedSoftAssert(LinksTitlesValues.VALID.getLinksTitles());
    }
}
