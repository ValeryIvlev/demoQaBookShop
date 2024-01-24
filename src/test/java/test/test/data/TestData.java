package test.test.data;

import com.github.javafaker.Faker;
import test.test.models.addbooks.CollectionOfIsbns;
import test.test.steps.OrderSteps;

import java.util.List;

public class TestData {
    private static final Faker faker = new Faker();
    public String getPassword() {
        return faker.internet()
                .password(8, 10, true, true);
    }

    public String getUserName() {
        return faker.name().username();
    }
    public String getRandomBook(){
        List<String> list = OrderSteps.getAllIsbn();
        return list.get(faker.random().nextInt(list.size()));
    }
}
