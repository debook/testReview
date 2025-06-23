import com.simbirsoft.api.ApiSteps;
import org.junit.jupiter.api.Test;
import org.testng.Assert;

import java.io.IOException;

public class ApiTest {

    @Test
    public void apiTest1() throws IOException {
        ApiSteps apiSteps = new ApiSteps();

        String token = apiSteps.authRequest().jsonPath().getString("token");
        String id = apiSteps.create(token, "Latin check name");
        Assert.assertNotNull(id);
    }

    @Test
    public void apiTest2() throws IOException {
        ApiSteps apiSteps = new ApiSteps();

        String token = apiSteps.authRequest().jsonPath().getString("token");
        String id = apiSteps.create(token, "Проверка кирилицы");
        Assert.assertNotNull(id);
    }

    @Test
    public void apiTest3() throws IOException {
        ApiSteps apiSteps = new ApiSteps();

        String token = apiSteps.authRequest().jsonPath().getString("token");
        String id = apiSteps.create(token, "Проверка спец-символов %;№.");
        Assert.assertNotNull(id);
    }
}
