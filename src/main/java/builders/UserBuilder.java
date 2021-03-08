package builders;

import constants.Constants;
import lombok.extern.log4j.Log4j2;
import objects.User;

@Log4j2
public class UserBuilder implements Constants {

    public static User getUser(String email, String password) {
        User user = User.builder()
                .email(email)
                .password(password)
                .build();
        log.debug(String.format("Getting user %s", user.toString()));
        return user;
    }

    // TODO Get proterties!!!
    public static User getValidUser() {
        return getUser(EMAIL, PASSWORD);

    }
}
