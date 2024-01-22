package test.test.models.addbooks;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AddBookResponse {
    String userId;
    CollectionOfIsbns[] collectionOfIsbns;
}
