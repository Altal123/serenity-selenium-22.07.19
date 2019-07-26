package test;

import page.Config;
import net.serenitybdd.junit.runners.SerenityRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(SerenityRunner.class)
public class LinkedinLoginTest extends BaseTest {

    @Test
    public void sucessfulLoginTest(){
        user.openLandingPage();

        //Welcome Page
        user.checkWelcomeTitle(driver);
        landingPage.buttonEnterInLoginPage.click();

        //Login Page
        user.checkTitleLoginPage(driver);
        landingPage.enter(Config.LOGIN).into(landingPage.fieldUserName);
        landingPage.enter(Config.PASSWORD).into(landingPage.fieldPassword);
        landingPage.buttonEnter.click();

        //Main Page
        user.checkMainPageTitle(driver);
    }
}
