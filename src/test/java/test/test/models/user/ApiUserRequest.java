package test.test.models.user;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ApiUserRequest {
    public String userName;
    public String password;

    public ApiUserRequest() {}

    public ApiUserRequest(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }
}
