package com.appium.nesine.cucumber.steps;

import com.appium.nesine.ThreadLocalDriver;
import com.appium.nesine.screens.*;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;

public class LoginPageStepDef extends BaseSteps {
    BaseScreen baseScreen = null;
    LoginPageScreen loginPageScreen = null;
    BasePageScreen basePageScreen = null;
    KupondasScreen kupondasScreen = null;
    CouponDetailScreen couponDetailScreen = null;
    HomePageScreen homePageScreen = null;


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

    @And("^I set LoginPage : username \"([^\"]*)\"  and password \"([^\"]*)\"$")
    public void iSetLoginPageUsernameAndPassword(String userName, String password) {
        loginPageScreen.setUserNameAndPassword(userName, password);
    }

    @And("^Click : Login Page : Giris Yap button$")
    public void clickLoginPageGirisYapButton() {
        loginPageScreen.clickLoginButton();
    }
}
