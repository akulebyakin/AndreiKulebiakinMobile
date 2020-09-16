package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.ThreadLocalRandom;

public class Utils {

    private static final String SCREENSHOTS_PATH = "src/test/resources/screenshots/";

    public static File takeScreenshot(WebDriver driver) throws IOException {
        File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file, new File(SCREENSHOTS_PATH
                + "Screenshot-"
                + generateRandomInt()
                + ".png"));
        return file;
    }

    public static int generateRandomInt() {
        return ThreadLocalRandom.current().nextInt(1, 100000);
    }

}
