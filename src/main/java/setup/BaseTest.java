package setup;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import page_objects.PageObject;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import static utils.GetTestProperties.*;

public class BaseTest implements IDriver {

    private static AppiumDriver appiumDriver; // singleton

    protected IPageObject po;

    @Override
    public AppiumDriver getDriver() {
        return appiumDriver;
    }

    @Parameters({"platformName", "appType", "deviceName", "udid", "browserName", "app",
            "appPackage", "appActivity", "bundleId"})
    @BeforeSuite(alwaysRun = true)
    public void setUp(String platformName,
                      String appType,
                      @Optional("") String deviceName,
                      @Optional("") String udid,
                      @Optional("") String browserName,
                      @Optional("") String app,
                      @Optional("") String appPackage,
                      @Optional("") String appActivity,
                      @Optional("") String bundleId) throws Exception {
        System.out.println(">>> SET UP >>>");
        System.out.println("App type - " + appType);

        // set capabilities from .propetries file
        if (platformName.equals("Android")) {
            if (udid.isEmpty()) udid = ANDROID_DEVICE_UDID;
            if (app.isEmpty()) app = ANDROID_APP;
            if (appPackage.isEmpty()) appPackage = ANDROID_APP_PACKAGE;
            if (appActivity.isEmpty()) appActivity = ANDROID_APP_ACTIVITY;
        } else if (platformName.equals("iOS")) {
            if (udid.isEmpty()) udid = IOS_DEVICE_UDID;
            if (app.isEmpty()) app = IOS_APP;
            if (bundleId.isEmpty()) bundleId = IOS_APP_BUNDLEID;
        }

        setAppiumDriver(platformName, deviceName, udid, browserName, app, appPackage, appActivity,
                bundleId);
        setPageObject(appType, appiumDriver);
    }

    @AfterSuite(alwaysRun = true)
    public void tearDown() {
        System.out.println("<<< TEAR DOWN <<<");
        appiumDriver.closeApp();
    }

    private void setAppiumDriver(String platformName, String deviceName, String udid,
                                 String browserName, String app, String appPackage,
                                 String appActivity, String bundleId) {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("platformName", platformName);
        capabilities.setCapability("deviceName", deviceName);
        capabilities.setCapability("udid", udid);

        if (app.endsWith(".apk")) {
            capabilities.setCapability("app", new File(app).getAbsolutePath());
        }

        capabilities.setCapability("browserName", browserName);
        capabilities.setCapability("chromedriverDisableBuildCheck", "true");

        // Capabilities for iOS and Android Native tests on EPAM Mobile Cloud
        if (platformName.equals("Android")) {
            capabilities.setCapability("appPackage", appPackage);
            capabilities.setCapability("appActivity", appActivity);
        } else if (platformName.equals("iOS")) {
            capabilities.setCapability("bundleId", bundleId);
            capabilities.setCapability("automationName", "XCUITest");
        }

        try {
            URL url = new URL(String.format(TS_APPIUM, EMC_API_KEY));
            appiumDriver = new AppiumDriver(url, capabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        // Timeouts tuning
        appiumDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public IPageObject getPageObject() {
        return this.po;
    }

    private void setPageObject(String appType, AppiumDriver appiumDriver) throws Exception {
        this.po = new PageObject(appType, appiumDriver);
    }

}
