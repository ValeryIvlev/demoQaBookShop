package test.test.models.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class RegistrationData {
    private ApiUserRequest userRequest;
    private ApiUserResponse userResponse;
}
