package pageObjects.businessObjects;

import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import pageObjects.TrainingListPage;

public class TrainingListBO {
    private final TrainingListPage trainingListPage;

    public TrainingListBO() {
        trainingListPage = new TrainingListPage();
    }

    public TrainingListBO proceedToTrainingListPage() {
        trainingListPage.proceedToTrainingListPage();
        return this;
    }

    public TrainingListBO scrollToSearchElement() {
        trainingListPage.moveToSearchElement();
        return this;
    }

    public TrainingListBO clickOnSearchElement() {
        trainingListPage.clickOnSearchElement();
        return this;
    }

    public TrainingListBO openSearchBySkills() {
        trainingListPage
                .moveToSearchElement()
                .clickOnSearchElement().
                clickOnBySkillsTab();
        return this;
    }

    public TrainingListBO openClearedSearchMenu() {
        return scrollToSearchElement()
                .clearSelectedLocation()
                .clickOnSearchElement();
    }

    public TrainingListBO clickOnSkillCheckBox(String skill) {
        trainingListPage.clickOnSkillCheckBox(skill);
        return this;
    }

    public void verifyAllActiveCoursesContainsSkill(String skill) {
        verifyAllActiveCoursesContainsSkill(skill, null);
    }

    public void verifyAllActiveCoursesContainsSkill(String skill, SoftAssert softAssert) {
        String message = "Check 'Skill present' failed - at least one of course without skill:" + skill;
        boolean result = trainingListPage.isAllActiveCoursesContainsSkill(skill);
        if (softAssert != null) {
            softAssert.assertTrue(result, message);
        } else Assert.assertTrue(result, message);
    }

    public TrainingListBO clearSelectedLocation() {
        trainingListPage.clickOnClearSelectedLocationButton();
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
