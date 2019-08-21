package page;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.NoSuchElementException;

@DefaultUrl("https://www.linkedin.com")
public class LandingPage extends PageObject {

    @FindBy(css=".nav__button-secondary")
    public WebElementFacade buttonEnterInLoginPage;

    @FindBy(id="username")
    public WebElementFacade fieldUserName;

    @FindBy(id="login-email")
    public WebElementFacade fieldEmail2variant;

    @FindBy(id="password")
    public WebElementFacade fieldPassword;

    @FindBy(id="login-password")
    public WebElementFacade fieldPassword2variant;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElementFacade buttonEnter;

    @FindBy(id="login-submit")
    public WebElementFacade buttonEnter2variant;

    @FindBy(xpath = "//*[@id='regForm']/h2")
    private WebElementFacade welcomePage2variant;

    public boolean existsWelcomePage2variant() {
        try {
            return welcomePage2variant.getText().equals("Будьте профессионалом в своём деле") ||
                    welcomePage2variant.getText().equals("Be great at what you do");
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public boolean matchTitle(String titleRus, String titleEng){
        return (getDriver().getTitle().equals(titleRus) || getDriver().getTitle().equals(titleEng));
    }


}
