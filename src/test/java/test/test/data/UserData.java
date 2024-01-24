package test.test.data;

import org.aeonbits.owner.ConfigFactory;
import test.test.config.UserConfig;
import test.test.models.token.GenerateTokenResponse;
import test.test.steps.AuthorizationSteps;

public class UserData {
    private static final UserConfig config = ConfigFactory.create(UserConfig.class, System.getProperties());
    public static final String USER_NAME = config.getUserName();
    public static final String PASSWORD = config.getPassword();
    public static final String USER_ID = config.getUserId();
}
