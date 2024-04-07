package test.test.models.addbooks;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import test.test.models.Book;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AddBookResponse {
    @JsonProperty("books")
    private List<Book> books;
}
