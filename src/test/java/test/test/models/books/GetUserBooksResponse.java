package test.test.models.books;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import test.test.models.Book;

@Getter
@Setter
@AllArgsConstructor
public class GetUserBooksResponse {
    private String userId;
    @JsonProperty("username")
    private String userName;
    private Book[] books;

    public GetUserBooksResponse() {
    }
}
