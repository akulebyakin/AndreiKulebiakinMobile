package utils;

import entities.User;
import io.github.cdimascio.dotenv.Dotenv;

import java.util.ResourceBundle;

public class GetTestProperties {

    public static final String GOOGLE_PAGE;

    public static final User TEST_USER;

    public static final String OCR_SPACE_API_KEY;

    public static final String TESSDATA_DIRECTORY_PATH;

    public static final String OCR_SPACE_ENDPOINT;

    public static final String EMC_API_KEY;

    public static final String ANDROID_APP;

    public static final String ANDROID_APP_PACKAGE;

    public static final String ANDROID_APP_ACTIVITY;

    public static final String IOS_APP;

    public static final String IOS_APP_BUNDLEID;

    public static final String TS_APPIUM;

    public static final String IOS_DEVICE_UDID;

    public static final String ANDROID_DEVICE_UDID;

    static {
        ResourceBundle rb = ResourceBundle.getBundle("test");
        Dotenv dotenv = Dotenv.load();

        GOOGLE_PAGE = rb.getString("google.page.domain");

        TEST_USER = new User(rb.getString("user.email"),
                rb.getString("user.username"),
                rb.getString("user.password"));

        OCR_SPACE_API_KEY = rb.getString("OCR.space.api.key");

        TESSDATA_DIRECTORY_PATH = rb.getString("tessdata.directory.path");

        OCR_SPACE_ENDPOINT = rb.getString("ocr.space.endpoint");

        EMC_API_KEY = dotenv.get("emc.api.key");

        ANDROID_APP = rb.getString("android.app");

        ANDROID_APP_PACKAGE = rb.getString("android.app.package");

        ANDROID_APP_ACTIVITY = rb.getString("android.app.activity");

        IOS_APP = rb.getString("iOS.app");

        IOS_APP_BUNDLEID = rb.getString("iOS.app.bundleId");

        TS_APPIUM = rb.getString("ts.appium");

        IOS_DEVICE_UDID = rb.getString("ios.device.udid");

        ANDROID_DEVICE_UDID = rb.getString("android.device.udid");

    }

}
