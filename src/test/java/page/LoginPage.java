package page;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.At;
import net.thucydides.core.annotations.WhenPageOpens;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getPages;

@At("https://www.linkedin.com/login")
public class LoginPage extends PageObject {

    Logger logger = LoggerFactory.getLogger(this.getClass().getName()); //org.slf4j.Logger;

    @FindBy(id = "username")
    private WebElement userEmailField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(id = "error-for-password")
    private WebElement errorWrongPassword;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElementFacade buttonEnter;

    @WhenPageOpens
    public void waitUntilTitleAppears() {
        element(userEmailField).waitUntilVisible();
    }

    public boolean isPageLoaded() {
        return getPages().isCurrentPageAt(LoginPage.class);
    }

    public void enterLoginPassword(String email, String password){
        enter(email).into(userEmailField);
        enter(password).into(passwordField);
        buttonEnter.click();
        logger.info("Login and password were entered");
    }

    public boolean isWrongPasswordErrorDisplayed() {
        return errorWrongPassword.isDisplayed();
    }
}
