package step;

import net.thucydides.core.annotations.Step;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import page.Config;
import page.LandingPage;

public class UserSteps {

    LandingPage landingPage;
    Logger logger = LoggerFactory.getLogger(this.getClass().getName()); //org.slf4j.Logger;

    @Step
    public void openLandingPage(){
        landingPage.open();
    }

    @Step
    public UserSteps checkWelcomeTitle(WebDriver driver) {
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
    public UserSteps checkTitleLoginPage(WebDriver driver) {
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
    public UserSteps checkMainPageTitle(WebDriver driver) {
        Assert.assertTrue("Main page title is not matching expected!", driver.getTitle().equals("LinkedIn"));
        return this;
    }
}
