package dataProviders;

import org.testng.annotations.DataProvider;

public class SkillsProvider {

    @DataProvider(name = "valid-skills")
    public static Object[][] validSkills() {
        return new Object[][]{
                {"Java"},
                {"Ruby"}
        };
    }
}
