import io.qameta.allure.Step;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.response.ValidatableResponse;
import static io.restassured.RestAssured.given;

public class OrderSteps extends Configuration {
    private static final String PATH = "/api/v1/orders";

    @Step("Создание заказа")
    public ValidatableResponse createOrder(Order order) {
        return given()
                .spec(getConfiguration())
                .log()
                .all()
                .body(order)
                .filter(new AllureRestAssured())
                .when()
                .post(PATH)
                .then();
    }

    @Step ("Получение списка заказов")
    public ValidatableResponse orderList() {
        return given()
                .spec(getConfiguration())
                .filter(new AllureRestAssured())
                .when()
                .get(PATH)
                .then();
    }

    @Step ("Отменить заказ")
    public ValidatableResponse cancelOrder(int track) {
        return given()
                .spec(getConfiguration())
                .filter(new AllureRestAssured())
                .when()
                .put(PATH+"/cancel?track="+track)
                .then();
    }
}