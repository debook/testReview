import com.simbirsoft.pages.Page1;
import com.simbirsoft.pages.Page2;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.simbirsoft.utils.CalculateUtil.fibonacci;
import static com.simbirsoft.utils.DriverInstance.getDriver;

public class FirstTest extends BaseTest {
    @Test
    void testOne() {
        Page1 page1 = new Page1(getDriver());
        page1.selectCustomerUser("debook")
                .element1
                .click();
        Page2 page2 = new Page2(getDriver());
        page2.inputNumberToField(fibonacci(5))
                .clickButton1();
        Assertions.assertTrue(page2.checkResult("Ожидаемый результат"), "Результат не соответствует ожидаемому");
    }
}
