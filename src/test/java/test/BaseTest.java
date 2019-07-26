package test;

import io.github.bonigarcia.wdm.WebDriverManager;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import page.LandingPage;
import step.UserSteps;

import java.util.concurrent.TimeUnit;

public class BaseTest {

    protected LandingPage landingPage;

    protected page.MainPage MainPage;

    @Steps
    protected UserSteps user;

    @Managed(driver = "chrome")
    WebDriver driver;

    @Before
    public void setupDriver(){
        WebDriverManager.chromedriver().setup();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }
}
