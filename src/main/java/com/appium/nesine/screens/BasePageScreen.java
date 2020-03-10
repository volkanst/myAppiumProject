package com.appium.nesine.screens;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.testng.Assert;

public class BasePageScreen extends BaseScreen {

    public BasePageScreen(AndroidDriver driver) {
        super(driver);
    }

    private static final String GENERAL_ID = "com.pordiva.nesine.android:id/";
    private static final By GIRIS_YAP_BTN_ID = By.id(GENERAL_ID + "btn_login");

    public void iClickBasePageLoginButton() {
        Assert.assertTrue(isElementPresent(GIRIS_YAP_BTN_ID),"Giriş Yap butonu bulunamadı.");
        waitAndClick(GIRIS_YAP_BTN_ID);
    }
}

