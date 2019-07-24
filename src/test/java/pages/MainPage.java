package pages;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.PageObject;
import org.junit.Assert;

public class MainPage extends PageObject {

    @Step
    public void checkMainPageTitle() {
        Assert.assertTrue(getDriver()
                .getTitle()
                .equals("LinkedIn"));
    }
}
