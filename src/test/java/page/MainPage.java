package page;

import net.thucydides.core.annotations.WhenPageOpens;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getPages;

public class MainPage extends PageObject {

    @FindBy(xpath = "//li[@id='profile-nav-item']")
    private WebElement profileNavItem;

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

}
