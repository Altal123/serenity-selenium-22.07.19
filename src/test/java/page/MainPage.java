package page;

import net.bytebuddy.asm.Advice;
import net.thucydides.core.annotations.At;
import net.thucydides.core.annotations.WhenPageOpens;
import net.thucydides.core.pages.PageObject;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.security.Key;
import java.util.List;

import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getPages;

@At("https://www.linkedin.com/feed")
public class MainPage extends PageObject {

    @FindBy(xpath = "//li[@id='profile-nav-item']")
    private WebElement profileNavItem;

    @FindBy(className = "search-global-typeahead__input")
    private WebElement fieldSearch;

    @FindBy(className = "search-result")
    private List<WebElement> searchResult;

    @WhenPageOpens
    public void waitUntilTitleAppears() {
        element(profileNavItem).waitUntilVisible();
    }

    public String getTitle(){
        return  getDriver().getTitle();
    }

    public boolean isPageLoaded() {
        return getPages().isCurrentPageAt(MainPage.class);
    }

    public void searchByKeyword(String keyword){
        fieldSearch.clear();
        fieldSearch.sendKeys(keyword + Keys.ENTER);
    }

    public void checkThatSearchResultIsMoreThanOne(){
        Assert.assertTrue("Search result size is less than 1", searchResult.size() > 1);
    }

    public void checkThatEachSearchResultContainsKeyword(String keyword){
        for (WebElement element: searchResult){
            jsScrollPageToElement(element);
            Assert.assertTrue(element.getText().contains(keyword));
        }
    }

    public void jsScrollPageToElement (WebElement element){
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);",element);
    }

}
