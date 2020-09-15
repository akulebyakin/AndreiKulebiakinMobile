package scenarios.ex2;

import entities.User;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.PageObject;
import pageObjects.native_po.LoginActivity;
import pageObjects.native_po.RegistrationActivity;
import setup.BaseTest;

public class NativeMobileTests extends BaseTest {

//    @Test(groups = {"native"}, description = "This simple test just click on the Sign In button")
//    public void simpleNativeTest() throws IllegalAccessException, NoSuchFieldException, InstantiationException {
//        getPo().getWelement("signInBtn").click();
//        System.out.println("Simplest Android native test done");
//    }

    @Test(groups = {"native"}, description = "Register new account")
    public void testRegisterNewAccount() {
        PageObject pageObject = (PageObject) getPo();
        LoginActivity loginActivity = (LoginActivity) pageObject.getSomePageObject();

        RegistrationActivity registrationActivity = loginActivity.openRegistration();
        registrationActivity.registerWithUser(User.DEFAULT_USER);

        String activityName = loginActivity.loginWithUser(User.DEFAULT_USER)
                .getActivityName();

        Assert.assertEquals(activityName, "BudgetActivity",
                "Activity name is not equal to expected");

    }

}
