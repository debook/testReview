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
        page1.selectCustomerUser("debook").button1.click();
        Page2 page2 = new Page2(getDriver());
        page2.inputNumberToField(20).clickButton1();
        Assertions.assertTrue(page2.checkResult("Стих №20 - В тишине ночной, где звёзды мерцают, Луна серебрит нежным светом поля. Ветер шепчет сказки, что сердце ласкают, И тайны природы раскрываются для меня. Далёкий рассвет медленно пробуждается, Роса на траве сверкает, как жемчуг в лучах. Птицы песню новую в небо запускают, Наполняя мир светом и добротой в глазах. Жизнь — это путь, что ведёт нас сквозь мглы, Где каждый момент — как подарок судьбы. Пусть сердце хранит свет, что горит в глубине, И верит в мечты, что живут в тишине."), "Результат не соответствует ожидаемому");
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

    @Test
    void chekSettingsMenu() {
        Page1 page1 = new Page1(getDriver());
        page1.selectCustomerUser("debook").button1.click();
        Page2 page2 = new Page2(getDriver());
        page2.clickButton2();

        String allText = getDriver().getPageSource();
        String expectedText = "Настройки пользователя";

        Assertions.assertTrue(allText.contains(expectedText), "Настройки пользователя не отображаются на странице");
    }
}
