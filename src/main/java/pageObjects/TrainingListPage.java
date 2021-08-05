package pageObjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class TrainingListPage extends AbstractPage {

    private static final Logger LOG = Logger.getLogger(TrainingListPage.class);

    private final String skillTag = "SKILL_TAG";
    private final String countryTag = "COUNTRY_TAG";
    private final String cityTag = "CITY_TAG";

    private final String skillCheckBoxXpathLocator =
            "//input[@class='our-skills']/parent::label[normalize-space()='" + skillTag + "']";

    private final String countrySelectXpathLocator =
            "//div[contains(@class, 'location__not-active-label city-name ng-binding') and normalize-space(text())='" + countryTag + "']";

    private final String cityCheckBoxXpathLocator =
            "//div[@class='location__cities']//label[@class='location__not-active-label ng-binding' and normalize-space()='" + cityTag + "']";

    private final By searchElement = By.xpath("//input[@class='input-field-search ng-pristine ng-untouched ng-valid']");

    private final By bySkillsTab = By.xpath("//div[@class='navigation-item ng-binding' and normalize-space(text())='By skills']");

    private final By clearAllFiltersButton =
            By.xpath("//span[@class='filter-field__input-item-close-icon filter-field__input-item-close-icon--common']");

    private final By listOfActiveCourses =
            By.xpath("//div[@class='training-list__container training-list__desktop']//div[@class='training-item ng-isolate-scope']");

    private final String listOfActiveCoursesWithSkill =
            "//div[@class='training-list__container training-list__desktop']//img[@src='/Content/images/BigLogo/" + skillTag + "_Icon.png']";

    private final By listOfActiveCoursesLocation =
            By.xpath("//div[@class='training-list__container training-list__desktop']//span[@class='training-item__location--text ng-binding ng-scope']");

    public TrainingListPage clickOnSearchElement() {
        getElement(searchElement).click();
        LOG.info("'Search' input clicked");
        return this;
    }

    public void clickOnClearAllFiltersButton() {
        WebElement clearButton = getElement(clearAllFiltersButton);
        if (clearButton != null) {
            clearButton.click();
        }
        LOG.info(String.format("'Clear Selected filters' button: %s", (clearButton != null ? "clicked" : "absent")));
    }

    public void clickOnBySkillsTab() {
        getElement(bySkillsTab).click();
        LOG.info("'By Skills' tab clicked");
    }

    public void clickOnSkillCheckBox(String skill) {
        getElement(By.xpath(
                skillCheckBoxXpathLocator.replace(skillTag, skill))).click();
        LOG.info(String.format("CheckBox '%s' clicked", skill));
    }

    public void clickOnCountryMenu(String country) {
        getElement(By.xpath(
                countrySelectXpathLocator.replace(countryTag, country))).click();
        LOG.info(String.format("Country '%s' selector clicked", country));
    }

    public boolean isAllActiveCoursesContainsSkill(String skill) {
        List<WebElement> coursesList = getElements(listOfActiveCourses);
        if (coursesList == null || coursesList.size() == 0){
            LOG.info(String.format("Is 'Skill' '%s' present in all active courses': '%s'", skill, true));
            return true;
        }
        List<WebElement> coursesWithSkillList = getElements(By.xpath(
                listOfActiveCoursesWithSkill.replace(skillTag, skill)));
        if (coursesWithSkillList == null){
            LOG.info(String.format("Is 'Skill' '%s' present in all active courses': '%s'", skill, false));
            return false;
        }

        boolean isAllContains = coursesList.size() == coursesWithSkillList.size();
        LOG.info(String.format("Is 'Skill' '%s' present in all active courses': '%s'", skill, isAllContains));
        return isAllContains;
    }

    public void clickOnCityCheckBox(String city) {
        getElement(getLocatorByCity(city)).click();
        LOG.info(String.format("CheckBox '%s' clicked", city));
    }

    private By getLocatorByCity(String city) {
        return By.xpath(cityCheckBoxXpathLocator.replace(cityTag, city));
    }

    public boolean isAllActiveCoursesContainsCountry(String country) {
        List<WebElement> activeCoursesLocationList = getElements(listOfActiveCoursesLocation);

        String countryLowerCase = country.toLowerCase();
        boolean isAllContains = activeCoursesLocationList.stream()
                .map(WebElement::getText)
                .allMatch(s -> s.toLowerCase().contains(countryLowerCase));

        LOG.info(String.format("Is 'Country' '%s' or Multi-location present in all active courses': '%s'", country, isAllContains));
        return isAllContains;
    }
}
