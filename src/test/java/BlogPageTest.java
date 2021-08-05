import consts.values.LinksTitlesValues;
import org.testng.annotations.Test;
import pageObjects.businessObjects.HomeBO;

import java.util.Arrays;

public class BlogPageTest extends BaseTest {

    @Test(description = "[Soft assert]: Verify All links on ‘Blog’ Page are displayed")
    public void verifyLinksAreDisplayed() {

        String[] linksTitlesArray = Arrays.stream(LinksTitlesValues.values())
                .map(LinksTitlesValues::getLinkTitle)
                .toArray(String[]::new);

        new HomeBO()
                .loginWithAppropriateCredentials()
                .openBlogPage()
                .verifyLinkIsDisplayedSoftAssert(linksTitlesArray);
    }
}
