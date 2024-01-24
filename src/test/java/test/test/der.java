package test.test;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import test.test.data.TestData;
import test.test.models.Books;
import test.test.models.books.GetBooksRequest;
import test.test.steps.OrderSteps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

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
