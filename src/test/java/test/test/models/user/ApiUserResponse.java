package test.test.models.user;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class ApiUserResponse{
    public String userName;
    public String password;
}