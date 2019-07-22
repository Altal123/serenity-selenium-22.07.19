import io.github.bonigarcia.wdm.WebDriverManager;
import net.serenitybdd.junit.runners.SerenityRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(SerenityRunner.class)
public class LinkedinLoginTest extends BaseTest{

    @Test
    public void sucessfulLoginTest(){
        driver.navigate().to("https://www.linkedin.com/");

    }
}
