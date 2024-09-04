import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class Configuration {

    private static final String BASE_URL= "http://qa-scooter.praktikum-services.ru/";

    protected static RequestSpecification getConfiguration() {
        return new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .setBaseUri(BASE_URL)
                .build();
    }
}