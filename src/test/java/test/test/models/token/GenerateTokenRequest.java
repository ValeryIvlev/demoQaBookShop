package test.test.models.token;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class GenerateTokenRequest {
    private String userName;
    private String password;
}
