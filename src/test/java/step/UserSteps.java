package step;

import net.thucydides.core.annotations.Step;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import page.Config;
import page.LandingPage;
import page.MainPage;

import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;

public class UserSteps {

    LandingPage landingPage;
    MainPage mainPage;
    Logger logger = LoggerFactory.getLogger(this.getClass().getName()); //org.slf4j.Logger;

    @Step
    public void openLandingPage(){
        landingPage.open();
    }

    @Step
    public UserSteps checkWelcomeTitle() {
        Assert.assertTrue("Title not matching",
                landingPage.matchTitle("LinkedIn: Войти или зарегистрироваться", "LinkedIn: Log In or Sign Up"));
        return this;
    }
    @Step
    public UserSteps openLoginPage() {
        landingPage.buttonEnterInLoginPage.click();
        logger.info("Open login page");
        return this;
    }


    @Step
    public UserSteps checkTitleLoginPage() {
        Assert.assertTrue("Title not matching",
                landingPage.matchTitle("Вход в LinkedIn, регистрация в LinkedIn | LinkedIn", "LinkedIn Login, LinkedIn Sign in | LinkedIn"));
        logger.info("Login Page (version 1) was loaded");
        return this;
    }
    @Step
    public UserSteps enterLoginPassword() {
        landingPage.enter(Config.LOGIN).into(landingPage.fieldUserName);
        landingPage.enter(Config.PASSWORD).into(landingPage.fieldPassword);
        landingPage.buttonEnter.click();
        logger.info("Login and password were entered");
        return this;
    }

    @Step
    public UserSteps enterLoginPassword2variant() {
        landingPage.fieldEmail2variant.clear();
        landingPage.enter(Config.LOGIN).into(landingPage.fieldEmail2variant);
        landingPage.fieldPassword2variant.clear();
        landingPage.enter(Config.PASSWORD).into(landingPage.fieldPassword2variant);
        landingPage.buttonEnter2variant.click();
        logger.info("Login and password were entered (2nd variant of Login Page)");
        return this;
    }

    @Step
    public UserSteps checkMainPageTitle() {
        Assert.assertTrue("Main page title is not matching expected!", mainPage.getTitle().equals("Linkedin"));
        return this;
    }
}
