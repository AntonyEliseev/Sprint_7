import com.github.javafaker.Faker;

public class CourierData {

    private static final Faker faker = new Faker();

    public static Courier getDefault() {
        return new Courier(faker.name().username(), faker.internet().password(), faker.name().firstName());
    }

    public static Courier getPassword() {
        return new Courier(null, "no password", null);
    }

    public static Courier getLogin() {
        return new Courier(faker.name().username(), "", "");
    }

    public static Courier getName() {
        return new Courier("", "", faker.name().firstName());
    }
}