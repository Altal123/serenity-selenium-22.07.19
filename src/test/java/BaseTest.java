import io.github.bonigarcia.wdm.WebDriverManager;
import net.thucydides.core.annotations.Managed;
import org.junit.Before;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class BaseTest {

    @Managed(driver = "firefox")
    WebDriver driver;

    @Before
    public void setupDriver(){
        WebDriverManager.firefoxdriver().setup();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);


    }
}
