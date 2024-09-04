import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.ValidatableResponse;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import static java.net.HttpURLConnection.HTTP_BAD_REQUEST;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class CreateCourierParamTest {

    private CourierSteps courierSteps;
    private Courier courier;
    private int statusCode;
    private String message;
    private final static String ERROR_MESSAGE_BAD_REQUEST = "Недостаточно данных для создания учетной записи";

    @Before
    public void setUp() {
        courierSteps = new CourierSteps();
    }

    public CreateCourierParamTest(Courier courier, int statusCode, String message) {
        this.courier = courier;
        this.statusCode = statusCode;
        this.message = message;
    }

    @Parameterized.Parameters
    public static Object[][] getTestData() {
        return new Object[][] {
                {CourierData.getName(), HTTP_BAD_REQUEST, ERROR_MESSAGE_BAD_REQUEST},
                {CourierData.getLogin(), HTTP_BAD_REQUEST, ERROR_MESSAGE_BAD_REQUEST},
                {CourierData.getPassword(), HTTP_BAD_REQUEST, ERROR_MESSAGE_BAD_REQUEST}
        };
    }

    @Test
    @DisplayName("Создание курьера (негативные сценарии, обязательные поля)")
    public void checkNegativeCourierCreate() {
        ValidatableResponse response = courierSteps.create(courier);
        int actualStatusCode = response.extract().statusCode();
        String actualMessage = response.extract().path("message");
        assertEquals(statusCode,actualStatusCode);
        assertEquals(message,actualMessage);
    }
}