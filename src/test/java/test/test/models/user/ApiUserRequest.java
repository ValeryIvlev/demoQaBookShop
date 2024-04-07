package test.test.models.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import test.test.models.Book;

import java.util.ArrayList;

@Getter
@Setter
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class ApiUserRequest {
    @JsonProperty("userID")
    private String userId;
    @JsonProperty("username")
    private String userName;
    private ArrayList<Book> books;
}