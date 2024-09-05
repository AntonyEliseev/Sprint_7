import com.github.javafaker.Faker;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class OrderData {

    private static final Faker faker = new Faker();

    public static Order getDefault() {
        List<String> color = List.of("BLACK,GREY");
        return new Order(faker.name().firstName(),
                faker.name().lastName(),
                faker.address().streetAddress(),
                Integer.toString(faker.number().numberBetween(1,237)),
                "+7 800 555 35 35",
                faker.number().numberBetween(1,7),
                faker.backToTheFuture().date(),
                faker.lebowski().quote(),
                color);
    }

    public static Order getColor(List<String> color) {
        return new Order(faker.name().firstName(),
                faker.name().lastName(),
                faker.address().streetAddress(),
                Integer.toString(faker.number().numberBetween(1,237)),
                "89999998888",
                faker.number().numberBetween(1,7),
                faker.backToTheFuture().date(),
                faker.lebowski().quote(),
                color);
    }
}