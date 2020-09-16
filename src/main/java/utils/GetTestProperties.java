package utils;

import entities.User;

import java.util.ResourceBundle;

public class GetTestProperties {

    public static final String GOOGLE_PAGE;

    public static final User TEST_USER;

    public static final String OCR_SPACE_API_KEY;

    public static final String TESSDATA_DIRECTORY_PATH;

    public static final String OCR_SPACE_ENDPOINT;

    static {
        ResourceBundle rb = ResourceBundle.getBundle("test");

        GOOGLE_PAGE = rb.getString("google.page.domain");

        TEST_USER = new User(rb.getString("user.email"),
                rb.getString("user.username"),
                rb.getString("user.password"));

        OCR_SPACE_API_KEY = rb.getString("OCR.space.api.key");

        TESSDATA_DIRECTORY_PATH = rb.getString("tessdata.directory.path");

        OCR_SPACE_ENDPOINT = rb.getString("ocr.space.endpoint");

    }

}
