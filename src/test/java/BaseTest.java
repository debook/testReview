import com.simbirsoft.utils.DriverInstance;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.chrome.ChromeOptions;


public class BaseTest {

    @BeforeAll
    public static void init() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        DriverInstance.createRemoteDriver("http://localhost:4444/", options);
    }

    @AfterAll
    public static void tearDown() {
        DriverInstance.closeWebDriver();
    }
}
