package com.appium.nesine.screens;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.testng.Assert;

public class LoginPageScreen extends BaseScreen {

    public LoginPageScreen(AndroidDriver driver) {
        super(driver);
    }

    private String userId;
    private static final String GENERAL_ID = "com.pordiva.nesine.android:id/";
    private static final By USER_NAME_ID = By.id(GENERAL_ID + "username_edit");
    private static final By PASSWORD_ID = By.id(GENERAL_ID + "password_edit");
    private static final By LOGIN_BUTTON_ID = By.id(GENERAL_ID + "login_btn");


    public void setUserNameAndPassword(String userName, String password) {
        fillUserName(userName);
        setUserId(userName);
        fillPassWord(password);
    }

    public void fillUserName(String username) {
        Assert.assertTrue(isElementPresent(USER_NAME_ID), "Kullanıcı adı alanı bulunamadı.");
        sendText(USER_NAME_ID, username);
    }

    public void fillPassWord(String passWord) {
        Assert.assertTrue(isElementPresent(PASSWORD_ID), "Password alanı bulunamadı.");
        sendText(PASSWORD_ID, passWord);
    }


    public void clickLoginButton() {
        Assert.assertTrue(isElementPresent(LOGIN_BUTTON_ID), "Giriş Yap butonu bulunamadı.");
        waitAndClick(LOGIN_BUTTON_ID);
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

}
