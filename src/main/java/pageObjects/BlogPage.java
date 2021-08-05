package pageObjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class BlogPage extends AbstractPage {

    private static final Logger LOG = Logger.getLogger(BlogPage.class);

    private final By linksTitles = By.xpath("//div[@class='tab-nav__list separated-list']//span");

    public boolean isLinkDisplayed(String linkTitle) {
        boolean isPresent = false;
        List<WebElement> linksElementsList = getElements(linksTitles);

        if (linksElementsList != null && linksElementsList.size() > 0){
            isPresent = linksElementsList.stream()
                    .filter(e -> e.getText().equalsIgnoreCase(linkTitle))
                    .findFirst()
                    .map(WebElement::isDisplayed)
                    .orElse(false);
        }

        LOG.info(String.format("Is 'Link' with title '%s' displayed': '%s'", linkTitle, isPresent));
        return isPresent;
    }
}
