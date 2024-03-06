package test.test.data;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import test.test.models.user.ApiUserRequest;
import test.test.models.user.ApiUserResponse;

@Getter
@Setter
@AllArgsConstructor
public class RegistrationData {
    private ApiUserRequest userRequest;
    private ApiUserResponse userResponse;
}
