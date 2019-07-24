package pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.PageObject;
import org.junit.Assert;

public class LoginPage extends PageObject {

    @FindBy(css=".nav__button-secondary")
    public WebElementFacade buttonEnterInLoginPage;

    @FindBy(id="username")
    public WebElementFacade fieldUserName;

    @FindBy(id="password")
    public WebElementFacade fieldPassword;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElementFacade buttonEnter;

    @Step
    public void checkWelcomeTitle() {
        Assert.assertTrue(getDriver()
                .getTitle()
                .equals("LinkedIn: Войти или зарегистрироваться"));
    }

    @Step
    public void checkTitleLoginPage() {
        Assert.assertTrue(getDriver()
                .getTitle()
                .equals("Вход в LinkedIn, регистрация в LinkedIn | LinkedIn"));
    }

}
