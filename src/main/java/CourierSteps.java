import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;
import static io.restassured.RestAssured.given;

public class CourierSteps extends Configuration {
    private static final String PATH = "api/v1/courier";
    private static final String PATH_LOGIN = "api/v1/courier/login";

    @Step ("Создание курьера")
    public ValidatableResponse create(Courier courier) {
        return given()
                .spec(getConfiguration())
                .log()
                .all()
                .body(courier)
                .when()
                .post(PATH)
                .then();
    }

    @Step ("Логин курьера в системе")
    public ValidatableResponse login(Credentials credentials) {
        return given()
                .spec(getConfiguration())
                .log()
                .all()
                .body(credentials)
                .when()
                .post(PATH_LOGIN)
                .then();
    }

    @Step ("Удаление курьера")
    public ValidatableResponse delete(int id) {
        return given()
                .spec(getConfiguration())
                .log()
                .all()
                .when()
                .delete(PATH+"/"+id)
                .then();
    }
}