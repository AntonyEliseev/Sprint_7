import io.qameta.allure.Step;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.response.ValidatableResponse;
import static io.restassured.RestAssured.given;

public class CourierSteps extends Configuration {
    private static final String PATH = "api/v1/courier";
    private static final String PATH_LOGIN = "api/v1/courier/login";

    @Step ("Создание курьера")
    public ValidatableResponse createCourier(Courier courier) {
        return given()
                .spec(getConfiguration())
                .log()
                .all()
                .body(courier)
                .filter(new AllureRestAssured())
                .when()
                .post(PATH)
                .then();
    }

    @Step ("Логин курьера в системе")
    public ValidatableResponse loginCourier(Credentials credentials) {
        return given()
                .spec(getConfiguration())
                .log()
                .all()
                .body(credentials)
                .filter(new AllureRestAssured())
                .when()
                .post(PATH_LOGIN)
                .then();
    }

    @Step ("Удаление курьера")
    public ValidatableResponse deleteCourier(int id) {
        return given()
                .spec(getConfiguration())
                .log()
                .all()
                .filter(new AllureRestAssured())
                .when()
                .delete(PATH+"/"+id)
                .then();
    }
}