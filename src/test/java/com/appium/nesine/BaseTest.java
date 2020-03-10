package com.appium.nesine;

import com.appium.nesine.screens.*;
import io.appium.java_client.android.AndroidDriver;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.appium.nesine.utilities.DriverFactory;

import java.io.IOException;
import java.net.URL;

public class BaseTest {

    public WebDriverWait wait;
    DriverFactory driverFactory = new DriverFactory();  
    public String platformName = "Android";
    public String platformVersion = "9.0";
    public String appPackage = "com.pordiva.nesine.android"; 
    public String appActivity = "com.nesine.ui.taboutside.splash.MainActivityDefault";
    public String deviceName = "Pixel 2 Android 9.0";
    public String hubURL = "http://127.0.0.1:4723/wd/hub";
    public String udid = "emulator-5554";

    protected BaseScreen baseScreen = null;
    protected LoginPageScreen loginPageScreen = null;
    protected CouponDetailScreen couponDetailScreen = null;
    protected BasePageScreen basePageScreen = null;
    protected KupondasScreen kupondasScreen = null;
    protected HomePageScreen homePageScreen = null;

    @BeforeMethod
    @Parameters({"deviceName", "platformVersion"})
    public void setup (String deviceName, String platformVersion) throws IOException {
        
    	System.out.println("TestNG Before");
           
        final Runtime rt = Runtime.getRuntime();
        rt.exec("adb shell input keyevent 224");

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", deviceName);
        caps.setCapability("platformVersion", platformVersion);
        caps.setCapability("udid", udid);
        caps.setCapability("platformName", platformName);
        caps.setCapability("appPackage", appPackage);
        caps.setCapability("appActivity", appActivity);
        caps.setCapability("noReset","false");
        caps.setCapability("autoGrantPermissions", "true");
        
        ThreadLocalDriver.setTLDriver(new AndroidDriver(new URL(hubURL),caps));
        wait = new WebDriverWait(ThreadLocalDriver.getTLDriver(), 10);

        baseScreen = new BaseScreen(ThreadLocalDriver.getTLDriver());
        loginPageScreen = new LoginPageScreen(ThreadLocalDriver.getTLDriver());
        couponDetailScreen = new CouponDetailScreen(ThreadLocalDriver.getTLDriver());
        basePageScreen = new BasePageScreen(ThreadLocalDriver.getTLDriver());
        kupondasScreen = new KupondasScreen(ThreadLocalDriver.getTLDriver());
        homePageScreen = new HomePageScreen(ThreadLocalDriver.getTLDriver());

    }

    @AfterMethod
    public synchronized void teardown(){
        ThreadLocalDriver.getTLDriver().quit();
    }

}
