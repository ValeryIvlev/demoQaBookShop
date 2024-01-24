package test.test.models.addbooks;

import lombok.*;
import test.test.models.Book;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class AddBookRequest {
    private String userId;
    private Book[] collectionOfIsbns;
}
