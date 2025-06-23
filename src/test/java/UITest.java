import com.simbirsoft.pages.Page1;
import com.simbirsoft.pages.Page2;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.Color;

import static com.simbirsoft.utils.DriverInstance.getDriver;

public class UITest extends BaseTest {

    @Test
    void testOne() throws InterruptedException {
        Page1 page1 = new Page1(getDriver());
        page1.selectCustomerUser("debook")
                .button1.click();
        Page2 page2 = new Page2(getDriver());
        page2.inputNumberToField(20)
                .clickButton1();
        Assertions.assertTrue(page2.checkResult("Ожидаемый результат"), "Результат не соответствует ожидаемому");
    }

    @Test
    void testTwo() throws InterruptedException {
        Page1 page1 = new Page1(getDriver());
        page1.selectCustomerUser("debook")
                .button1.click();

        Page2 page2 = new Page2(getDriver());
        page2.inputNumberToField(0)
                .clickButton1();
        Assertions.assertTrue(Color.fromString(page2.getResultField().getCssValue("color")).asHex().equals("#ff0000"), "Цвет элемента не красный");
    }
}
