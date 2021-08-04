package pageObjects;

import consts.BusinessConfigs;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class BlogPage extends AbstractPage {

    private static final Logger LOG = Logger.getLogger(BlogPage.class);

    private final By linksTitles = By.xpath("//div[@class='tab-nav__list separated-list']//span");

    public void proceedToTrainingListPage() {
        proceedToPage(BusinessConfigs.BLOG_PAGE_URL.getValue());
        LOG.info(String.format("Proceeded to '%s' URL.", BusinessConfigs.BLOG_PAGE_URL.getValue()));
    }

    public boolean isLinkPresent(String linkTitle) {
        List<WebElement> elements = getElements(linksTitles);
        List<String> elementsTitles = elements.stream().map(WebElement::getText).collect(Collectors.toList());
        Optional<String> result = elementsTitles.stream().filter(s -> s.equalsIgnoreCase(linkTitle)).findAny();
        boolean isPresent = result.isPresent();
        LOG.info(String.format("Is 'Link' with title '%s' displayed': '%s'", linkTitle, isPresent));
        return isPresent;
    }
}
