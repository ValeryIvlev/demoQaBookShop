package test.test.models.addbooks;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import test.test.models.Books;

@Data
@Builder
public class AddBookResponse {
    @JsonProperty("books")
    Books[] books;

    public AddBookResponse() {
    }

    public AddBookResponse(Books[] books) {
        this.books = books;
    }
}
