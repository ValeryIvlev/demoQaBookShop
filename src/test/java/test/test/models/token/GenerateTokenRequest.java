package test.test.models.token;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GenerateTokenRequest {
    public String userName;
    public String password;

    public GenerateTokenRequest() {}

    public GenerateTokenRequest(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }
}
