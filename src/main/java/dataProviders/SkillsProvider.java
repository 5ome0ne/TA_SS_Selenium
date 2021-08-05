package dataProviders;

import consts.values.SkillsValues;
import org.testng.annotations.DataProvider;

import java.util.Arrays;

public class SkillsProvider {

    @DataProvider(name = "valid-skills")
    public static Object[][] validSkills() {
        return Arrays.stream(SkillsValues.values())
                .map(v->new Object[]{v.getSkill()})
                .toArray(Object[][]::new);
    }
}
