package test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import page.Config;
import net.serenitybdd.junit.runners.SerenityRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(SerenityRunner.class)
public class LinkedinLoginTest extends BaseTest {
    Logger logger = LoggerFactory.getLogger(this.getClass().getName()); //org.slf4j.Logger;

    @Test
    public void sucessfulLoginTest(){
        user.openLandingPage();
        logger.info("We are on the Welcome Page");

        if (!landingPage.existsWelcomePage2variant()){
            logger.info("Welcome Page (version 1) was loaded");
            //Welcome Page 1 variant
            user.checkWelcomeTitle()
            .openLoginPage()
            //Login Page 1 variant
            .checkTitleLoginPage()
            .enterLoginPassword();
        }else{
            //Login Page 2 variant
            logger.info("Welcome Page with Login/Password fields (version 2) was loaded");
            user.enterLoginPassword2variant();
        }
        //Main Page
        user.checkMainPageTitle();
        logger.info("We are on the Main Page");

    }
}
