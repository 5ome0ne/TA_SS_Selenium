package pageObjects.businessObjects;

import org.testng.Assert;
import pageObjects.TrainingListPage;

public class TrainingListBO {
    private final TrainingListPage trainingListPage;

    public TrainingListBO() {
        trainingListPage = new TrainingListPage();
    }

    public TrainingListBO clickOnSearchElement() {
        trainingListPage.clickOnSearchElement();
        return this;
    }

    public TrainingListBO openSearchBySkills() {
        trainingListPage
                .clickOnSearchElement()
                .clickOnBySkillsTab();
        return this;
    }

    public TrainingListBO openClearedSearchMenu() {
        return clearAllFilters()
                .clickOnSearchElement();
    }

    public TrainingListBO clickOnSkillCheckBox(String skill) {
        trainingListPage.clickOnSkillCheckBox(skill);
        return this;
    }

    public void verifyAllActiveCoursesContainsSkill(String skill) {
        Assert.assertTrue(
                trainingListPage.isAllActiveCoursesContainsSkill(skill),
                String.format("Check 'Skill present' failed - at least one of course without skill '%s'", skill));
    }

    public TrainingListBO clearAllFilters() {
        trainingListPage.clickOnClearAllFiltersButton();
        return this;
    }

    public TrainingListBO clickOnCountryMenu(String country) {
        trainingListPage.clickOnCountryMenu(country);
        return this;
    }

    public TrainingListBO clickOnCityCheckBox(String city) {
        trainingListPage.clickOnCityCheckBox(city);
        return this;
    }

    public void verifyAllActiveCoursesContainsCountryOrMultiLocation(String country) {
        boolean isAllContains = trainingListPage.isAllActiveCoursesContainsCountry(country);
        Assert.assertTrue(isAllContains, "Check 'Country present' failed - at least one course with a country other than the given one:" + country);
    }
}
