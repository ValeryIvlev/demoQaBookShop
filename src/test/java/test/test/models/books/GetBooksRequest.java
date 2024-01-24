package test.test.models.books;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import test.test.models.Books;
@Data
public class GetBooksRequest {

    Books[] books;
}
