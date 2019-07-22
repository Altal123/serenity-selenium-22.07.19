import io.github.bonigarcia.wdm.WebDriverManager;
import net.thucydides.core.annotations.Managed;
import org.junit.Before;
import org.openqa.selenium.WebDriver;

public class BaseTest {

    @Managed(driver = "chrome")
    WebDriver driver;

    @Before
    public void setupDriver(){
        WebDriverManager.chromedriver().setup();
    }
}
