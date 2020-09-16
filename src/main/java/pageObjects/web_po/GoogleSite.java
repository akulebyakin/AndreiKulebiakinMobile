package pageObjects.web_po;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.stream.Collectors;

import static utils.GetTestProperties.GOOGLE_PAGE;

public class GoogleSite {

    private AppiumDriver appiumDriver;

    @FindBy(xpath = "//input[@name='q']")
    public WebElement searchInput;

    @FindBy(xpath = "//*[@id='rso']//div[@role='heading']")
    List<WebElement> searchResults;

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
        searchInput.sendKeys(Keys.ENTER);
        return this;
    }

    public List<String> getListResults() {
        return searchResults.stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }

}
