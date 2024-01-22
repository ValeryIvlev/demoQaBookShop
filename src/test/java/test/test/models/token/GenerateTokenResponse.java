package test.test.models.token;

import lombok.Data;

@Data
public class GenerateTokenResponse {
    String token;
    String expires;
    String status;
    String result;
    public GenerateTokenResponse() {}

    public GenerateTokenResponse(String token, String expires, String status, String result) {
        this.token = token;
        this.expires = expires;
        this.status = status;
        this.result = result;
    }
}
