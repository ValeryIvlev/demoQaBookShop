package test.test.models.user;

import lombok.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import test.test.models.Book;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class ApiUserRequest {
    @JsonProperty("userID")
    String userId;
    String username;
    Book[] books;
    public ApiUserRequest(){}
}