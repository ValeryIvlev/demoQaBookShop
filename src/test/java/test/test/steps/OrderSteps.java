package test.test.steps;

import io.qameta.allure.Step;
import io.restassured.http.ContentType;
import test.test.data.TestData;
import test.test.models.Books;
import test.test.models.addbooks.AddBookRequest;
import test.test.models.addbooks.AddBookResponse;
import test.test.models.addbooks.CollectionOfIsbns;
import test.test.models.books.GetBooksRequest;

import java.util.ArrayList;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static test.test.specs.BaseSpecs.*;

public class OrderSteps {
    @Step("Получаем весь список книг")
    public static Books[] getAllBooks(){
        GetBooksRequest getBooksRequest = given()
                .spec(successfulRequests)
                .when()
                .get("/BookStore/v1/Books")
                .then()
                .spec(successfulResponse)
                .extract()
                .as(GetBooksRequest.class);
        return getBooksRequest.getBooks();
    }
    @Step("Получаем isbn всех книг")
    public static ArrayList<String> getAllIsbn(){
        Books[] books = getAllBooks();
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < books.length; i++) {
            list.add(books[i].getIsbn());
        }
        return list;
    }

    @Step("Добавляем книгу в корзину")
    public String addRandomBook(String token, String userId){
        TestData testData = new TestData();
        CollectionOfIsbns collectionOfIsbns = CollectionOfIsbns.builder()
                .isbn(testData.getRandomBook())
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
