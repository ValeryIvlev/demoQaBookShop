package test.test.models.token;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GenerateTokenResponse {
    private String token;
    private String expires;
    private String status;
    private String result;
}
