package com.appium.nesine.cucumber.steps;

import com.appium.nesine.ThreadLocalDriver;
import com.appium.nesine.screens.*;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

public class CouponDetailStepDef extends BaseSteps {

    BaseScreen baseScreen;
    LoginPageScreen loginPageScreen;
    BasePageScreen basePageScreen;
    KupondasScreen kupondasScreen;
    CouponDetailScreen couponDetailScreen;
    HomePageScreen homePageScreen;


    @Before
    public void setupLoginSteps() {
        setupCucumber();
        baseScreen = new BaseScreen(ThreadLocalDriver.getTLDriver());
        basePageScreen = new BasePageScreen(ThreadLocalDriver.getTLDriver());
        kupondasScreen = new KupondasScreen(ThreadLocalDriver.getTLDriver());
        couponDetailScreen = new CouponDetailScreen(ThreadLocalDriver.getTLDriver());
        loginPageScreen = new LoginPageScreen(ThreadLocalDriver.getTLDriver());
        homePageScreen = new HomePageScreen(ThreadLocalDriver.getTLDriver());
    }

    @Then("^Get : Coupon Detail : Coupon Info$")
    public void getCouponDetailCouponInfo() {
        couponDetailScreen.getCouponDetailCouponInfo();
    }

    @And("^Click : Coupon Detail : Hemen Oyna Button$")
    public void clickCouponDetailHemenOynaButton() {
        couponDetailScreen.clickCouponDetailHemenOynaButton();
    }

    @Then("^Verify : Basket : Coupon Info Control$")
    public void verifyBasketCouponInfoControl() {
        couponDetailScreen.verifyBasketCouponInfoControl();
    }
}
