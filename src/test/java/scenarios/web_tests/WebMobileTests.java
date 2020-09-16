package scenarios.web_tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.PageObject;
import pageObjects.web_po.GoogleSite;
import setup.BaseTest;
import setup.DataProviders;

import java.util.List;

public class WebMobileTests extends BaseTest {

//    @Test(groups = {"web"}, description = "Make sure that we've opened IANA homepage")
//    public void simpleWebTest() throws InterruptedException {
//        getDriver().get("http://iana.org"); // open IANA homepage
//
//        // Make sure that page has been loaded completely
//        new WebDriverWait(getDriver(), 10).until(
//                wd -> ((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete")
//        );
//
//        // Check IANA homepage title
//        assert ((WebDriver) getDriver()).getTitle().equals("Internet Assigned Numbers Authority") : "This is not IANA homepage";
//
//        // Log that test finished
//        System.out.println("Site opening done");
//    }

    @Test(groups = {"web"},
            description = "Go to Google page, google 'Epam' and check values not empty",
            dataProviderClass = DataProviders.class,
            dataProvider = "getGoogleSearchText")
    public void testGoogleSearch(String searchText) {
        PageObject pageObject = (PageObject) getPageObject();
        GoogleSite googleSite = (GoogleSite) pageObject.getSomePageObject();

        googleSite.open();

        List<String> results = googleSite
                .searchText(searchText)
                .getListResults();

        Assert.assertFalse(results.isEmpty());

        System.out.println("RESULTS:");
        for (int i = 0; i < results.size(); i++) {
            System.out.println((i + 1) + ". " + results.get(i));
        }
    }

}
