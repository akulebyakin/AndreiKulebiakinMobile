package page_objects.web_po;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.stream.Collectors;

import static utils.GetTestProperties.GOOGLE_PAGE;

public class GoogleSite {

    private AppiumDriver appiumDriver;

    @FindBy(xpath = "//input[@name='q']")
    private WebElement searchInput;

    @FindBy(xpath = "//*[@id='rso']//div[@role='heading']")
    private List<WebElement> searchResults;

    @FindBy(className = "sbct")
    private List<WebElement> suggests;

    public GoogleSite(AppiumDriver appiumDriver) {
        this.appiumDriver = appiumDriver;
        PageFactory.initElements(appiumDriver, this);
    }

    public GoogleSite open() {
        appiumDriver.navigate().to(GOOGLE_PAGE);
        // Make sure that page has been loaded completely
        new WebDriverWait(appiumDriver, 10).until(
                wd -> ((JavascriptExecutor) wd)
                        .executeScript("return document.readyState")
                        .equals("complete")
        );
        return this;
    }

    public GoogleSite searchText(String searchText) {
        searchInput.sendKeys(searchText);
        suggests.get(0).click();

        // sendKeys doesn't work for iOs devices, at least in this way.
        // searchInput.sendKeys(Keys.ENTER);
        new WebDriverWait(appiumDriver, 10).until(
                ExpectedConditions.visibilityOfAllElements(searchResults)
        );
        return this;
    }

    public List<String> getListResults() {
        return searchResults.stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }

}
