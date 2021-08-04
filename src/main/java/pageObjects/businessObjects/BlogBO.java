package pageObjects.businessObjects;

import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import pageObjects.BlogPage;

public class BlogBO {

    private final BlogPage blogPage;

    public BlogBO() {
        this.blogPage = new BlogPage();
    }

    public BlogBO proceedToBlogPage() {
        blogPage.proceedToTrainingListPage();
        return this;
    }

    public void verifyLinkIsPresent(String linkTitle) {
        verifyLinkIsPresent(linkTitle, null);
    }

    public void verifyLinkIsPresent(String linkTitle, SoftAssert softAssert) {
        String message = "'Check 'Link present' failed' - no one link with title:" + linkTitle;
        boolean result = blogPage.isLinkPresent(linkTitle);
        if (softAssert != null) {
            softAssert.assertTrue(result, message);
        } else Assert.assertTrue(result, message);
    }
}
