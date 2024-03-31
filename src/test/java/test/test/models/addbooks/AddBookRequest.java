package test.test.models.addbooks;

import lombok.*;
import test.test.models.Book;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class AddBookRequest {
    private String userId;
    private List<Book> collectionOfIsbns;
}
