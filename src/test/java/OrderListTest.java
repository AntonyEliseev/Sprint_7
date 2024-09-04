import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.ValidatableResponse;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import static java.net.HttpURLConnection.HTTP_OK;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class OrderListTest {
    private OrderSteps orderSteps;
    private Order order;
    private int track;

    @Before
    public void setUp() {
        orderSteps = new OrderSteps();
        order = OrderData.getDefault();
    }

    @After
    public void cleanUp() {
        ValidatableResponse responseDelete = orderSteps.cancel(track);
        int actualStatusCode = responseDelete.extract().statusCode();
        assertEquals(HTTP_OK,actualStatusCode);
    }

    @Test
    @DisplayName("Получение списка заказов")
    public void checkOrderListGet() {
        ValidatableResponse create = orderSteps.create(order);
        track = create.extract().path("track");
        ValidatableResponse getOrders = orderSteps.orderList();
        int statusCodeGetList = getOrders.extract().statusCode();
        assertEquals(HTTP_OK,statusCodeGetList);
        ArrayList<String> listOrders = getOrders.extract().path("orders");
        assertNotNull(listOrders);
    }
}