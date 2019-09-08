package step;

import io.github.bonigarcia.wdm.WebDriverManager;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Step;

import net.thucydides.core.steps.ScenarioSteps;
import org.jbehave.core.annotations.BeforeStory;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import page.Config;
import page.LandingPage;
import page.LoginPage;
import page.MainPage;

import java.net.MalformedURLException;

public class UserSteps extends ScenarioSteps {

    LandingPage landingPage;
    MainPage mainPage;
    LoginPage loginPage;
    Logger logger = LoggerFactory.getLogger(this.getClass().getName()); //org.slf4j.Logger;

    @Managed(driver = "chrome")
    public WebDriver driver;

    @BeforeStory
    public void setupDriver() throws MalformedURLException {
        //эта строка нужна для локального запуска
        WebDriverManager.chromedriver().setup();
    }

    @Step
    public void openLandingPage(){
        landingPage.open();
    }

//    @Step
//    public UserSteps checkWelcomeTitle() {
//        Assert.assertTrue("Title not matching",
//                landingPage.matchTitle("LinkedIn: Войти или зарегистрироваться", "LinkedIn: Log In or Sign Up"));
//        return this;
//    }
    @Step
    public UserSteps openLoginPage() {
        landingPage.buttonEnterInLoginPage.click();
        logger.info("Open login page");
        return this;
    }

    @Step
    public UserSteps checkTitleLoginPage() {
        Assert.assertTrue("Title not matching",
                landingPage.matchTitle("Вход в LinkedIn, Войти | LinkedIn", "LinkedIn Login, LinkedIn Sign in | LinkedIn"));
        logger.info("Login Page (version 1) was loaded");
        return this;
    }
    @Step
    public UserSteps enterLoginPassword(String email, String password) {
        loginPage.enterLoginPassword(email, password);
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
        Assert.assertTrue("Main page title is not matching expected!", mainPage.getTitle().contains("LinkedIn"));
        return this;
    }

    @Step
    public void clickOnButton(String button){
        landingPage.clickOnButtonWithText(button);
    }

    @Step
    public boolean isLoginPageLoaded() {
        return loginPage.isPageLoaded();
    }

    @Step
    public boolean isWrongPasswordErrorDisplayed(){
        return loginPage.isWrongPasswordErrorDisplayed();
    }

    @Step
    public boolean isMainPageLoaded() {
        return mainPage.isPageLoaded();
    }

    @Step
    public void searchByKeyword(String keyword){
        mainPage.searchByKeyword(keyword);
    }

    @Step
    public void checkThatSearchResultIsMoreThanOne(){
        mainPage.checkThatSearchResultIsMoreThanOne();
    }

    @Step
    public void checkThatEachSearchResultContainsKeyword(String keyword){
        mainPage.checkThatEachSearchResultContainsKeyword(keyword);
    }

}
