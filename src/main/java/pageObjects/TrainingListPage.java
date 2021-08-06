package pageObjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class TrainingListPage extends AbstractPage {

    private static final Logger LOG = Logger.getLogger(TrainingListPage.class);

    private final String skillCheckBoxXpathLocator =
            "//input[@class='our-skills']/parent::label[normalize-space()='%s']";

    private final String countrySelectXpathLocator =
            "//div[contains(@class, 'location__not-active-label city-name ng-binding') and normalize-space(text())='%s']";

    private final String cityCheckBoxXpathLocator =
            "//div[@class='location__cities']//label[@class='location__not-active-label ng-binding' and normalize-space()='%s']";

    private final By searchElement = By.xpath("//input[@class='input-field-search ng-pristine ng-untouched ng-valid']");

    private final By bySkillsTab = By.xpath("//div[@class='navigation-item ng-binding' and normalize-space(text())='By skills']");

    private final By clearAllFiltersButton =
            By.xpath("//span[@class='filter-field__input-item-close-icon filter-field__input-item-close-icon--common']");

    private final By listOfActiveCourses =
            By.xpath("//div[@class='training-list__container training-list__desktop']//div[@class='training-item ng-isolate-scope']");

    private final String listOfActiveCoursesWithSkill =
            "//div[@class='training-list__container training-list__desktop']//img[@src='/Content/images/BigLogo/%s_Icon.png']";

    private final By listOfActiveCoursesLocation =
            By.xpath("//div[@class='training-list__container training-list__desktop']//span[@class='training-item__location--text ng-binding ng-scope']");

    public TrainingListPage clickOnSearchElement() {
        getElement(searchElement).click();
        LOG.info("'Search' input clicked");
        return this;
    }

    public void clickOnClearAllFiltersButton() {
        boolean isExist = isExist(clearAllFiltersButton);
        if (isExist){
            getElementWaitToBeClickable(clearAllFiltersButton).click();
        }
        LOG.info(String.format("'Clear Selected filters' button: %s", (isExist ? "clicked" : "absent")));
    }

    public void clickOnBySkillsTab() {
        getElement(bySkillsTab).click();
        LOG.info("'By Skills' tab clicked");
    }

    public void clickOnSkillCheckBox(String skill) {
        getElement(By.xpath(
                String.format(skillCheckBoxXpathLocator, skill))).click();
        LOG.info(String.format("CheckBox '%s' clicked", skill));
    }

    public void clickOnCountryMenu(String country) {
        getElement(By.xpath(
                String.format(countrySelectXpathLocator, country))).click();
        LOG.info(String.format("Country '%s' selector clicked", country));
    }

    public boolean isAllActiveCoursesContainsSkill(String skill) {
        List<WebElement> coursesList = getElementsFluentWait(listOfActiveCourses);
        if (coursesList.isEmpty()) {
            LOG.info(String.format("Is 'Skill' '%s' present in all active courses': '%s'", skill, true));
            return true;
        }
        List<WebElement> coursesWithSkillList = getElementsFluentWait(By.xpath(String.format(listOfActiveCoursesWithSkill, skill)));

        boolean isAllContains = coursesList.size() == coursesWithSkillList.size();
        LOG.info(String.format("Is 'Skill' '%s' present in all active courses': '%s'", skill, isAllContains));
        LOG.info(String.format("All courses = '%s', with skill '%s' = '%s'", coursesList.size(), skill, coursesWithSkillList.size()));
        return isAllContains;
    }

    public void clickOnCityCheckBox(String city) {
        getElement(getLocatorByCity(city)).click();
        LOG.info(String.format("CheckBox '%s' clicked", city));
    }

    private By getLocatorByCity(String city) {
        return By.xpath(String.format(cityCheckBoxXpathLocator, city));
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
