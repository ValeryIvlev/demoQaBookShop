package test.test.models.addbooks;

import lombok.*;
import test.test.models.Book;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class AddBookRequest {
    private String userId;
    private Book[] collectionOfIsbns;
}
