import dataProviders.CountryCityProvider;
import dataProviders.SkillsProvider;
import org.testng.annotations.Test;
import pageObjects.businessObjects.HomeBO;
import pageObjects.businessObjects.TrainingListBO;

public class TrainingListPageTest extends BaseTest {

    @Test(dataProvider = "valid-skills",
            dataProviderClass = SkillsProvider.class,
            description = "Verify ‘Trainings’ search works properly with searching in ‘Skills’")
    public void verifyTrainingsSearchBySkillsWorksProperly(String skill) {
        new HomeBO().loginWithAppropriateCredentials();
        new TrainingListBO()
                .proceedToTrainingListPage()
                .openSearchBySkills()
                .clickOnSkillCheckBox(skill)
                .verifyAllActiveCoursesContainsSkill(skill);
    }

    @Test(dataProvider = "valid-Country-City",
            dataProviderClass = CountryCityProvider.class,
            description = "Verify ‘Trainings’ search works properly with searching in ‘Locations’")
    public void verifyTrainingsSearchByLocationWorksProperly(String country, String city) {
        new HomeBO().loginWithAppropriateCredentials();
        new TrainingListBO()
                .proceedToTrainingListPage()
                .openClearedSearchMenu()
                .clickOnCountryMenu(country)
                .clickOnCityCheckBox(city)
                .verifyAllActiveCoursesContainsCountryOrMultiLocation(country);
    }
}
