package com.appium.nesine.cucumber.steps;

import com.appium.nesine.ThreadLocalDriver;
import com.appium.nesine.screens.*;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;

public class BaseSteps {
    protected BaseScreen baseScreen = null;
    protected LoginPageScreen loginPageScreen = null;
    protected CouponDetailScreen couponDetailScreen = null;
    protected BasePageScreen basePageScreen = null;
    protected KupondasScreen kupondasScreen = null;
    protected HomePageScreen homePageScreen = null;

    protected WebDriverWait wait;

    protected void setupCucumber() {
        wait = new WebDriverWait(ThreadLocalDriver.getTLDriver(), 20);

        baseScreen = new BaseScreen(ThreadLocalDriver.getTLDriver());
        loginPageScreen = new LoginPageScreen(ThreadLocalDriver.getTLDriver());
        couponDetailScreen = new CouponDetailScreen(ThreadLocalDriver.getTLDriver());
        basePageScreen = new BasePageScreen(ThreadLocalDriver.getTLDriver());
        kupondasScreen = new KupondasScreen(ThreadLocalDriver.getTLDriver());
        homePageScreen = new HomePageScreen(ThreadLocalDriver.getTLDriver());

        final Runtime rt = Runtime.getRuntime();
        try {
            rt.exec("adb shell input keyevent 224");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected void teardown() {
        ThreadLocalDriver.getTLDriver().quit();
    }
}
