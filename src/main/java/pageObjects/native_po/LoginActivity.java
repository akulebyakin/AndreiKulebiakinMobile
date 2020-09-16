package pageObjects.native_po;

import entities.User;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class LoginActivity {

    private AppiumDriver appiumDriver;

    @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/email_sign_in_button")
    public WebElement signInBtn;

    @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/register_button")
    public WebElement registerBtn;

    @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/login_email")
    public WebElement emailInput;

    @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/login_pwd")
    public WebElement passwordInput;

    @AndroidFindBy(uiAutomator = "new UiSelector().textContains('incorrect')")
    public WebElement errorMessage;

    public LoginActivity(AppiumDriver appiumDriver) {
        this.appiumDriver = appiumDriver;
        PageFactory.initElements(new AppiumFieldDecorator(appiumDriver), this);
    }

    public RegistrationActivity openRegistration() {
        registerBtn.click();
        return new RegistrationActivity(appiumDriver);
    }

    public BudgetActivity loginWithUser(User user) {
        emailInput.sendKeys(user.getEmail());
        passwordInput.sendKeys(user.getPassword());
        signInBtn.click();
        return new BudgetActivity(appiumDriver);
    }
}
