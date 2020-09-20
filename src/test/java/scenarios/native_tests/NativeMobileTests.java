package scenarios.native_tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import page_objects.PageObject;
import page_objects.native_po.LoginActivity;
import page_objects.native_po.RegistrationActivity;
import setup.BaseTest;
import setup.DataProviders;
import utils.OCRSpaceImageAnalyzer;

import java.io.File;

import static utils.GetTestProperties.TEST_USER;
import static utils.Utils.takeScreenshot;

public class NativeMobileTests extends BaseTest {

    private final long WAIT_BEFORE_SCREENSHOT_MILLIS = 500;

//    @Test(groups = {"native"}, description = "This simple test just click on the Sign In button")
//    public void simpleNativeTest() throws IllegalAccessException, NoSuchFieldException, InstantiationException {
//        getPo().getWelement("signInBtn").click();
//        System.out.println("Simplest Android native test done");
//    }

    @Test(priority = 1, groups = {"native", "android"},
            description = "Check error message when we click on SIGN IN "
                    + "without providing correct login and password",
            dataProviderClass = DataProviders.class,
            dataProvider = "getIncorrectEmailOrPasswordText")
    public void testIncorrectLoginErrorMessage(String expected) {
        PageObject pageObject = (PageObject) getPageObject();
        LoginActivity loginActivity = (LoginActivity) pageObject.getSomePageObject();

        loginActivity.signInBtn.click();

        // 1. Capture screenshot
        // 2. Using external API convert to text (OCR)
        // 3. assert that imageText contains "Incorrect"
        String imageText = "";
        try {
            // I don't know how to do it without Thread.sleep
            Thread.sleep(WAIT_BEFORE_SCREENSHOT_MILLIS);

            File imageFile = takeScreenshot(getDriver());
            imageText = OCRSpaceImageAnalyzer.getTextFromScreenshot(imageFile);
        } catch (Exception e) {
            e.printStackTrace();
        }

        Assert.assertTrue(imageText.contains(expected),
                "There is no error message with expected text");
    }

    @Test(priority = 2, groups = {"native"}, description = "Register new account",
            dataProviderClass = DataProviders.class, dataProvider = "getBudgetActivityName")
    public void testRegisterNewAccount(String expected) {
        PageObject pageObject = (PageObject) getPageObject();
        LoginActivity loginActivity = (LoginActivity) pageObject.getSomePageObject();

        RegistrationActivity registrationActivity = loginActivity.openRegistration();
        registrationActivity.registerWithUser(TEST_USER);

        String activityName = loginActivity.loginWithUser(TEST_USER)
                .getActivityName();

        Assert.assertEquals(activityName, expected,
                "Activity name is not equal to expected");
    }

}
