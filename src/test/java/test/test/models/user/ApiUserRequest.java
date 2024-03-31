package test.test.models.user;

import lombok.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import test.test.models.Book;

import java.util.ArrayList;
import java.util.List;

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