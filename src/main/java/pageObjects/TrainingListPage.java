package pageObjects;

import consts.BusinessConfigs;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;

public class TrainingListPage extends AbstractPage{

    private static final Logger LOG = Logger.getLogger(TrainingListPage.class);

    private final String skillTag = "SKILL_TAG";
    private final String skillCheckBoxXpathLocator =
            "//input[@class='our-skills']/parent::label[normalize-space()='" + skillTag + "']";

    private final String countryTag = "COUNTRY_TAG";
    private final String countrySelectXpathLocator =
            "//div[contains(@class, 'location__not-active-label city-name ng-binding') and normalize-space(text())='" + countryTag + "']";

    private final String cityTag = "CITY_TAG";
    private final String cityCheckBoxXpathLocator =
            "//div[@class='location__cities']//label[@class='location__not-active-label ng-binding' and normalize-space()='" + cityTag + "']";


    private final By searchElement = By.xpath("//input[@class='input-field-search ng-pristine ng-untouched ng-valid']");

    private final By bySkillsTab = By.xpath("//div[@class='navigation-item ng-binding' and normalize-space(text())='By skills']");

    private final By clearSelectedLocationButton =
            By.xpath("//span[@class='filter-field__input-item-close-icon filter-field__input-item-close-icon--common']");

    private final By listOfActiveCourses =
            By.xpath("//div[@class='training-list__container training-list__desktop']//div[@class='training-item__title ng-binding']");

    private final By listOfActiveCoursesLocation =
            By.xpath("//div[@class='training-list__container training-list__desktop']//span[@class='training-item__location--text ng-binding ng-scope']");


    public TrainingListPage moveToSearchElement() {
        moveToElement(searchElement);
        LOG.info("Move to 'Search' element");
        return this;
    }

    public void proceedToTrainingListPage() {
        proceedToPage(BusinessConfigs.TRAINING_LIST_PAGE_URL.getValue());
        LOG.info(String.format("Proceeded to '%s' URL.", BusinessConfigs.HOME_PAGE_URL.getValue()));
    }

    public TrainingListPage clickOnSearchElement() {
        getElement(searchElement).click();
        LOG.info("'Search' input clicked");
        return this;
    }

    public void clickOnClearSelectedLocationButton() {
        getElement(clearSelectedLocationButton).click();
        LOG.info("'Clear Selected Location' button clicked");
    }

    public void clickOnBySkillsTab() {
        getElement(bySkillsTab).click();
        LOG.info("'By Skills' tab clicked");
    }

    public void clickOnSkillCheckBox(String skill) {
        getElement(getLocatorBySkill(skill)).click();
        LOG.info(String.format("CheckBox '%s' clicked", skill));
    }

    private By getLocatorBySkill(String skill) {
        return By.xpath(skillCheckBoxXpathLocator.replace(skillTag, skill));
    }

    public void clickOnCountryMenu(String country) {
        getElement(getLocatorByCountry(country)).click();
        LOG.info(String.format("Country '%s' selector clicked", country));
    }

    private By getLocatorByCountry(String country) {
        return By.xpath(countrySelectXpathLocator.replace(countryTag, country));
    }

    public boolean isAllActiveCoursesContainsSkill(String skill) {
        List<WebElement> elements = getElements(listOfActiveCourses);
        List<String> elementsTitles = elements.stream().map(WebElement::getText).collect(Collectors.toList());
        long count = elementsTitles.stream().filter(s -> s.toLowerCase().contains(skill.toLowerCase())).count();
        boolean isPresent = count == elements.size();
        LOG.info(String.format("Is 'Skill' '%s' present in all active courses': '%s'", skill, isPresent));
        return isPresent;
    }

    public void clickOnCityCheckBox(String city) {
        getElement(getLocatorByCity(city)).click();
        LOG.info(String.format("CheckBox '%s' clicked", city));
    }

    private By getLocatorByCity(String city) {
        return By.xpath(cityCheckBoxXpathLocator.replace(cityTag, city));
    }

    public boolean isAllActiveCoursesContainsCountry(String country) {
        List<WebElement> elements = getElements(listOfActiveCoursesLocation);
        List<String> elementsTitles = elements.stream().map(WebElement::getText).collect(Collectors.toList());
        long count = elementsTitles.stream().filter(s -> s.toLowerCase().contains(country.toLowerCase())).count();
        boolean isPresent = count == elements.size();
        LOG.info(String.format("Is 'Country' '%s' or Multi-location present in all active courses': '%s'", country, isPresent));
        return isPresent;
    }
}
