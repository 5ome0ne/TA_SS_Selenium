import dataProviders.CountryCityProvider;
import dataProviders.SkillsProvider;
import org.testng.annotations.Test;
import pageObjects.businessObjects.HomeBO;

public class TrainingListPageTest extends BaseTest {

    @Test(dataProvider = "valid-skills",
            dataProviderClass = SkillsProvider.class,
            description = "[Provider]: Verify ‘Trainings’ search works properly with searching in ‘Skills’")
    public void verifyTrainingsSearchBySkillsWorksProperly(String skill) {
        new HomeBO()
                .loginWithAppropriateCredentials()
                .openTrainingListPage()
                .clearAllFilters()
                .openSearchBySkills()
                .clickOnSkillCheckBox(skill)
                .verifyAllActiveCoursesContainsSkill(skill);
    }

    @Test(dataProvider = "valid-Country-City",
            dataProviderClass = CountryCityProvider.class,
            description = "[Provider]: Verify ‘Trainings’ search works properly with searching in ‘Locations’")
    public void verifyTrainingsSearchByLocationWorksProperly(String country, String city) {
        new HomeBO()
                .loginWithAppropriateCredentials()
                .openTrainingListPage()
                .openClearedSearchMenu()
                .clickOnCountryMenu(country)
                .clickOnCityCheckBox(city)
                .verifyAllActiveCoursesContainsCountryOrMultiLocation(country);
    }
}
