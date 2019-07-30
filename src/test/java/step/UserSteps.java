package step;

import net.thucydides.core.annotations.Step;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import page.LandingPage;

public class UserSteps {

    LandingPage landingPage;

    @Step
    public void openLandingPage(){
        landingPage.open();
    }

    @Step
    public void checkWelcomeTitle(WebDriver driver) {
        Assert.assertTrue("Title not matching",
                landingPage.matchTitle("LinkedIn: Войти или зарегистрироваться", "LinkedIn: Log In or Sign Up"));
    }

    @Step
    public void checkTitleLoginPage(WebDriver driver) {
        Assert.assertTrue("Title not matching",
                landingPage.matchTitle("Вход в LinkedIn, регистрация в LinkedIn | LinkedIn", "LinkedIn Login, LinkedIn Sign in | LinkedIn"));
    }

    @Step
    public void checkMainPageTitle(WebDriver driver) {
        Assert.assertTrue("Main page title is not matching expected!", driver.getTitle().equals("LinkedIn"));
    }
}
