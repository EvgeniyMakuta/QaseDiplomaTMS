package builders;

import constants.Constants;
import lombok.extern.log4j.Log4j2;
import objects.User;
import utils.PropertyReader;

@Log4j2
public class UserBuilder implements Constants {

    private UserBuilder() {
    }

    public static User getUser(String email, String password) {
        User user = User.builder()
                .email(email)
                .password(password)
                .build();
        log.debug(String.format("Getting user %s", user.toString()));
        return user;
    }

    public static User getValidUser() {
        String email = System.getenv().getOrDefault("email", PropertyReader.getProperty("email"));
        String password = System.getenv().getOrDefault("password", PropertyReader.getProperty("password"));
        log.debug(String.format("Getting valid user email %s and password %s", email, password));
        return getUser(email, password);

    }
}
