import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;
import static io.restassured.RestAssured.given;

public class OrderSteps extends Configuration {
    private static final String PATH = "/api/v1/orders";

    @Step("Создание заказа")
    public ValidatableResponse create(Order order) {
        return given()
                .spec(getConfiguration())
                .log()
                .all()
                .body(order)
                .when()
                .post(PATH)
                .then();
    }

    @Step ("Получение списка заказов")
    public ValidatableResponse orderList() {
        return given()
                .spec(getConfiguration())
                .when()
                .get(PATH)
                .then();
    }

    @Step ("Отменить заказ")
    public ValidatableResponse cancel(int track) {
        return given()
                .spec(getConfiguration())
                .when()
                .put(PATH+"/cancel?track="+track)
                .then();
    }
}