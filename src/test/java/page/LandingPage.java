package page;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.PageObject;
import org.junit.Assert;

@DefaultUrl("https://www.linkedin.com")
public class LandingPage extends PageObject {

    @FindBy(css=".nav__button-secondary")
    public WebElementFacade buttonEnterInLoginPage;

    @FindBy(id="username")
    public WebElementFacade fieldUserName;

    @FindBy(id="password")
    public WebElementFacade fieldPassword;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElementFacade buttonEnter;


}
