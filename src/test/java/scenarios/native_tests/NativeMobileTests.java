package scenarios.native_tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import page_objects.PageObject;
import page_objects.native_po.LoginActivity;
import page_objects.native_po.RegistrationActivity;
import setup.BaseTest;
import setup.DataProviders;

import static utils.GetTestProperties.TEST_USER;

public class NativeMobileTests extends BaseTest {

//    @Test(groups = {"native"}, description = "This simple test just click on the Sign In button")
//    public void simpleNativeTest() throws IllegalAccessException, NoSuchFieldException, InstantiationException {
//        getPo().getWelement("signInBtn").click();
//        System.out.println("Simplest Android native test done");
//    }

    @Test(groups = {"native"}, description = "Register new account",
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

//    @Test(groups = {"native"}, description = "Check error message when we click on SIGN IN "
//            + "without providing corect login and password")
//    public void testIncorrectLoginErrorMessage() {
//        PageObject pageObject = (PageObject) getPo();
//        LoginActivity loginActivity = (LoginActivity) pageObject.getSomePageObject();
//
//        loginActivity.signInBtn.click();
//
//        System.out.println("Im here");
//
//        try {
//            Thread.sleep(10000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//    }

}
