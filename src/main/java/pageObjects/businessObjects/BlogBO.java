package pageObjects.businessObjects;

import org.testng.asserts.SoftAssert;
import pageObjects.BlogPage;

public class BlogBO {

    private final BlogPage blogPage;

    public BlogBO() {
        this.blogPage = new BlogPage();
    }

    public void verifyLinkIsDisplayedSoftAssert(String[] linksTitlesArray) {
        SoftAssert softAssert = new SoftAssert();
        for (String title : linksTitlesArray) {
            softAssert.assertTrue(
                    blogPage.isLinkDisplayed(title),
                    String.format("'Check 'Link present' failed' - no one link with title '%s'", title));
        }
        softAssert.assertAll();
    }
}
