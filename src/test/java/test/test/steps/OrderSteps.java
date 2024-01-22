package test.test.steps;

import io.qameta.allure.Step;
import test.test.models.addbooks.AddBookRequest;
import test.test.models.addbooks.AddBookResponse;
import test.test.models.addbooks.CollectionOfIsbns;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static test.test.specs.BaseSpecs.createdResponse;
import static test.test.specs.BaseSpecs.successfulRequests;

public class OrderSteps {

    @Step("Добавляем книгу в корзину")
    public String addBook(String token, String userId){
        CollectionOfIsbns collectionOfIsbns = CollectionOfIsbns.builder()
                .isbn("9781449325862")
                .build();
        AddBookResponse addBookResponse = AddBookResponse.builder()
                .userId(userId)
                .collectionOfIsbns(new CollectionOfIsbns[]{collectionOfIsbns})
                .build();
        AddBookRequest addOneBook = given()
                .spec(successfulRequests)
                .when()
                .header("Authorization", "Bearer "+token)
                .body(addBookResponse)
                .post("/BookStore/v1/Books")
                .then()
                .spec(createdResponse)
                .extract()
                .as(AddBookRequest.class);
        assertNotNull(addOneBook.getBooks()[0].getIsbn());
        return addOneBook.getBooks()[0].getIsbn();
    }
}
