package utils;

import entities.User;

import java.util.ResourceBundle;

public class GetTestProperties {

    public static final String GOOGLE_PAGE;

    public static final User TEST_USER;

    static {
        ResourceBundle rb = ResourceBundle.getBundle("test");

        GOOGLE_PAGE = rb.getString("google.page.domain");
        TEST_USER = new User(rb.getString("user.email"),
                rb.getString("user.username"),
                rb.getString("user.password"));
    }

}
