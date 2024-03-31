package test.test.models.addbooks;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import test.test.models.Book;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AddBookResponse {
    @JsonProperty("books")
    private Book[] books;
}
