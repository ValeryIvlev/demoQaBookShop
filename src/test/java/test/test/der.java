package test.test;

import org.junit.jupiter.api.Test;
import test.test.data.TestData;
import test.test.steps.OrderSteps;

import java.util.ArrayList;

public class der {
    @Test
    void test1(){

        ArrayList<String> a = OrderSteps.getAllIsbn();
        System.out.println("------------------------------------------------------------");
        System.out.println("------------------------------------------------------------");
        System.out.println("------------------------------------------------------------");
        TestData testData = new TestData();
        System.out.println(testData.getRandomBook());

    }
}
