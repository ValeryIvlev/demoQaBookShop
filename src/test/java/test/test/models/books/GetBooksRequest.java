package test.test.models.books;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import test.test.models.Book;
@Getter
@Setter
@AllArgsConstructor

public class GetBooksRequest {
    private Book[] books;

    public GetBooksRequest() {
    }
}
