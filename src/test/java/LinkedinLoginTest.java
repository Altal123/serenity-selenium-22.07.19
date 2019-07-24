import pages.Config;
import pages.LoginPage;
import pages.MainPage;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(SerenityRunner.class)
public class LinkedinLoginTest extends BaseTest{

    @Steps
    private LoginPage loginPage;

    @Steps
    private MainPage MainPage;

    @Test
    public void sucessfulLoginTest(){
        driver.get(Config.URL);

        //Welcome Page
        loginPage.checkWelcomeTitle();
        loginPage.buttonEnterInLoginPage.click();

        //Login Page
        loginPage.checkTitleLoginPage();
        loginPage.enter(Config.LOGIN).into(loginPage.fieldUserName);
        loginPage.enter(Config.PASSWORD).into(loginPage.fieldPassword);
        loginPage.buttonEnter.click();

        //Main Page
        MainPage.checkMainPageTitle();
    }
}
