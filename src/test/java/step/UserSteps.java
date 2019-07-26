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
        Assert.assertTrue(driver
                .getTitle()
                .equals("LinkedIn: Войти или зарегистрироваться"));
    }

    @Step
    public void checkTitleLoginPage(WebDriver driver) {
        Assert.assertTrue(driver
                .getTitle()
                .equals("Вход в LinkedIn, регистрация в LinkedIn | LinkedIn"));
    }

    @Step
    public void checkMainPageTitle(WebDriver driver) {
        Assert.assertTrue(driver
                .getTitle()
                .equals("LinkedIn"));
    }
}
