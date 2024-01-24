package test.test.models.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import test.test.models.Book;

@Data
public class ApiUserResponse {
    @JsonProperty("userID")
    String userId;
    String username;
    Book[] books;
}
