package test.test.data;

import test.test.models.token.GenerateTokenResponse;
import test.test.steps.AuthorizationSteps;

public class CookiesData {
    private static final GenerateTokenResponse cookies = AuthorizationSteps.generateAuth();
    public static final String TOKEN = cookies.getToken();
    public static final String EXPIRES = cookies.getExpires();
}
