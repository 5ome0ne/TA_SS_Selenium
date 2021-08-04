package dataProviders;

import org.testng.annotations.DataProvider;

public class LinksProvider {

    @DataProvider(name = "valid-mails")
    public static Object[][] validLinks() {
        return new Object[][]{
                {"NewsFAKE"},
                {"News"},
                {"Real Stories"},
                {"Materials"},
                {"Hard Skills"},
                {"Soft Skills"},
                {"Events"}
        };
    }
}
