import com.simbirsoft.utils.DriverInstance;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.chrome.ChromeOptions;


public class BaseTest {

    private static final boolean LOCAL = true;

    @BeforeAll
    public static void init() {

        if(LOCAL) {
            ChromeOptions localOptions = new ChromeOptions();
            localOptions.addArguments("--start-maximized");
            DriverInstance.createLocalDriver("chrome");
        } else {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--remote-allow-origins=*");
            DriverInstance.createRemoteDriver("http://localhost:4444/", options);
        }
    }

    @AfterAll
    public static void tearDown() {
        DriverInstance.closeWebDriver();
    }
}
