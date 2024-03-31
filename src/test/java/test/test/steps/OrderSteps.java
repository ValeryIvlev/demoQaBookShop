package test.test.steps;

import io.qameta.allure.Step;
import test.test.data.TestData;
import test.test.models.Book;
import test.test.models.addbooks.AddBookRequest;
import test.test.models.addbooks.AddBookResponse;

import test.test.models.books.GetBooksResponse;
import test.test.models.books.GetUserBooksResponse;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static test.test.data.CookiesData.TOKEN;
import static test.test.data.UserData.USER_ID;
import static test.test.data.UserData.USER_NAME;
import static test.test.specs.BaseSpecs.*;

public class OrderSteps {
    @Step("Получаем список книг из корзины пользователя со всеми параметрами книги")
    private ArrayList<Book> getBooksBasketUser(){
        GetUserBooksResponse getUserBooksResponse = given()
                .spec(successfulRequests)
                .when()
                .header("Authorization", "Bearer "+TOKEN)
                .get("https://demoqa.com/Account/v1/User/"+USER_ID)
                .then()
                .spec(successfulResponse)
                .extract()
                .as(GetUserBooksResponse.class);
        assertEquals(USER_ID, getUserBooksResponse.getUserId());
        assertEquals(USER_NAME, getUserBooksResponse.getUserName());
        return getUserBooksResponse.getBooks();
    }

    @Step("Получаем весь список книг")
    private static List<Book> getAllBooks(){
        GetBooksResponse getBooksRequest = given()
                .spec(successfulRequests)
                .when()
                .get("/BookStore/v1/Books")
                .then()
                .spec(successfulResponse)
                .extract()
                .as(GetBooksResponse.class);
        return getBooksRequest.getBooks();
    }

    @Step("Получаем список значений определенного поля из всех книг")
    public static ArrayList<String> getAllParamValues(String paramName){
        List<Book> books = getAllBooks();
        ArrayList<String> list = new ArrayList<>();
        for (Book book : books) {
            switch (paramName) {
                case "isbn":
                    list.add(book.getIsbn());
                    break;
                case "title":
                    list.add(book.getTitle());
                    break;
                default:
                    throw new IllegalArgumentException("Некорректное имя поля: " + paramName);
            }
        }
        return list;
    }

    @Step("Добавляем рандомную книгу в корзину")
    public void addBook(String isbn){
        Book isbns = Book.builder()
                .isbn(isbn).build();
        AddBookRequest addBookResponse = AddBookRequest.builder()
                .userId(USER_ID)
                .collectionOfIsbns(Collections.singletonList(isbns))
                .build();
        AddBookResponse addRandomBook = given()
                .spec(successfulRequests)
                .when()
                .header("Authorization", "Bearer "+TOKEN)
                .body(addBookResponse)
                .post("/BookStore/v1/Books")
                .then()
                .spec(createdResponse)
                .extract()
                .as(AddBookResponse.class);
        assertEquals(isbn, addRandomBook.getBooks().get(0).getIsbn());
    }

    @Step("Добавляем рандомную книгу в корзину")
    public String addRandomBook(){
        TestData testData = new TestData();
        String randomBook = testData.getRandomBook();
        addBook(randomBook);
        return randomBook;
    }
    @Step("Удаляем все книги")
    public OrderSteps deleteAllBooks(){
        given()
                .spec(successfulRequests)
                .when()
                .header("Authorization", "Bearer "+TOKEN)
                .delete("/BookStore/v1/Books?UserId="+USER_ID)
                .then()
                .spec(successfulResponse204);
        return this;
    }
    @Step("Добавляем книги в корзину")
    public OrderSteps addBookToCartCount(int countAddBook){
        ArrayList<String> list =  getAllParamValues("isbn");
        for (int i = 0; i < countAddBook; i++) {
            addBook(list.get(i));
        }
        return this;
    }
    @Step("Получаем названия книг из корзины пользователя")
    public ArrayList<String> nameBooksInUserBasket(){
        ArrayList<String> list = new ArrayList<>();
        ArrayList<Book> books = getBooksBasketUser();
        for (int i = 0; i < books.size(); i++) {
            list.add(books.get(i).getTitle());
        }
        System.out.println(list);
        return list;
    }

}
