package test.test.models.user;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class ApiUserResponse{
    private String userName;
    private String password;
}