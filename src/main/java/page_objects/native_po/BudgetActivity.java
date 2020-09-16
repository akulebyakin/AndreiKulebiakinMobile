package page_objects.native_po;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BudgetActivity {

    private AppiumDriver appiumDriver;

    @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/action_bar")
    public WebElement actionBar;

    @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/add_new_expense")
    public WebElement addExpenseBtn;

    public BudgetActivity(AppiumDriver appiumDriver) {
        this.appiumDriver = appiumDriver;
        PageFactory.initElements(new AppiumFieldDecorator(appiumDriver), this);
    }

    public String getActivityName() {
        // I don't know why, but it doesn't want to wait until ActionBar to be visible.
        // But it works with another elements, for example - button
        // So when button is visible, we understand activity is loaded
        new WebDriverWait(appiumDriver, 60)
                .until(ExpectedConditions.visibilityOf(addExpenseBtn));
        return actionBar.findElement(By.className("android.widget.TextView")).getText();
    }

}
