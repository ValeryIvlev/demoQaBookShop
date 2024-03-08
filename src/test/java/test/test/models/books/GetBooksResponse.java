package test.test.models.books;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import test.test.models.Book;

import java.util.ArrayList;

@Getter
@Setter
@AllArgsConstructor
public class GetBooksResponse {
    private ArrayList<Book> books;

    public GetBooksResponse() {
    }
}
