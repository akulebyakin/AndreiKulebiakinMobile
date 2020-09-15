package pageObjects.native_po;

import entities.User;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class RegistrationActivity {

    @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/register_button")
    public WebElement registerBtn;

    @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/registration_email")
    public WebElement registerEmailInput;

    @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/registration_username")
    public WebElement registerUsernameInput;

    @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/registration_password")
    public WebElement registerPasswordInput;

    @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/registration_confirm_password")
    public WebElement registerConfirmPasswordInput;

    @AndroidFindBy(className = "android.widget.CheckedTextView")
    public WebElement registerAgreementCheckbox;

    @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/register_new_account_button")
    public WebElement registerNewAccountBtn;

    public RegistrationActivity(AppiumDriver appiumDriver) {
        PageFactory.initElements(new AppiumFieldDecorator(appiumDriver), this);
    }

    public RegistrationActivity registerWithUser(User user) {
        registerEmailInput.sendKeys(user.getEmail());
        registerUsernameInput.sendKeys(user.getUsername());
        registerPasswordInput.sendKeys(user.getPassword());
        registerConfirmPasswordInput.sendKeys(user.getPassword());
        registerAgreementCheckbox.click(); // seems that the element is not selectable
        registerNewAccountBtn.click();
        return this;
    }
}
