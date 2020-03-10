package com.appium.nesine.cucumber.steps;

import com.appium.nesine.ThreadLocalDriver;
import com.appium.nesine.screens.*;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

public class HomePageStepDef extends BaseSteps{

    BaseScreen baseScreen;
    LoginPageScreen loginPageScreen;
    BasePageScreen basePageScreen;
    KupondasScreen kupondasScreen;
    CouponDetailScreen couponDetailScreen;
    HomePageScreen homePageScreen;


    @Before
    public void setupLoginSteps () {
        setupCucumber();
        baseScreen = new BaseScreen(ThreadLocalDriver.getTLDriver());
        basePageScreen = new BasePageScreen(ThreadLocalDriver.getTLDriver());
        kupondasScreen = new KupondasScreen(ThreadLocalDriver.getTLDriver());
        couponDetailScreen = new CouponDetailScreen(ThreadLocalDriver.getTLDriver());
        loginPageScreen = new LoginPageScreen(ThreadLocalDriver.getTLDriver());
        homePageScreen = new HomePageScreen(ThreadLocalDriver.getTLDriver());
    }

    @Then("^Verify : Home Page : User Id control$")
    public void verifyHomePageUserIdControl() {
        String userId = loginPageScreen.getUserId();
        homePageScreen.verifyHomePageUserIdControl(userId);
    }

    @And("^Click : Home Page : Kupondas button$")
    public void clickHomePageKupondasButton() {
        homePageScreen.clickHomePageKupondasButton();

        }
}
