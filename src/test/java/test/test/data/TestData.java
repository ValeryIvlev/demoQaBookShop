package test.test.data;

import com.github.javafaker.Faker;

public class TestData {
    private static final Faker faker = new Faker();
    public String getPassword() {
        return faker.internet()
                .password(8, 10, true, true);
    }

    public String getUserName() {
        return faker.name().username();
    }
    public String getFirstName(){
        return faker.name().firstName();
    }
    public String getLastName(){
        return faker.name().lastName();
    }
}
