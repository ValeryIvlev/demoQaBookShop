package test.test.models.books;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import test.test.models.Book;
@Getter
@Setter
@AllArgsConstructor
public class GetBooksResponse {
    private Book[] books;

    public GetBooksResponse() {
    }
}
