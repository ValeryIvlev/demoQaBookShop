package test.test;

import org.junit.jupiter.api.Test;
import test.test.steps.OrderSteps;

public class ApiTest {

    @Test
    void test(){
        OrderSteps orderSteps = new OrderSteps();
        orderSteps.deleteAllBooks()
        .addRandomBook();
        orderSteps.nameBooksInUserBasket();


    }
}
