package test;

import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import page.LandingPage;
import step.UserSteps;

import java.net.MalformedURLException;

public class BaseTest {

    protected LandingPage landingPage;

    @Steps
    protected UserSteps userSteps;

    @Managed(uniqueSession = true)
    WebDriver driver;
//    RemoteWebDriver  driver;

    @Before
    public void setupDriver() throws MalformedURLException {
//        WebDriverManager.chromedriver().setup();
//        DesiredCapabilities capabilities = new DesiredCapabilities();
//        capabilities.setBrowserName("chrome");
//        capabilities.setVersion("76.0");
//        capabilities.setCapability("enableVNC", true);
//        capabilities.setCapability("enableVideo", false);

//        driver = new RemoteWebDriver(
//                URI.create("http://localhost:4444/wd/hub").toURL(),
//                capabilities
//        );

//        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }
}
