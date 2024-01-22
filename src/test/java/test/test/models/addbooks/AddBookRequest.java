package test.test.models.addbooks;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import test.test.models.Books;
@Data
public class AddBookRequest {
    @JsonProperty("books")
    Books[] books;
}
