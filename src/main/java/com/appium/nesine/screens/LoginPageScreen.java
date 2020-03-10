package com.appium.nesine.screens;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class LoginPageScreen extends BaseScreen {

    public LoginPageScreen(AndroidDriver driver) {
        super(driver);
    }

    private String userId;
    private static final String GENERAL_ID = "com.pordiva.nesine.android:id/";
    private static final By USER_NAME_ID = By.id(GENERAL_ID + "username_edit");
    private static final By PASSWORD_ID = By.id(GENERAL_ID + "password_edit");
    private By loginButtonId = By.id(GENERAL_ID + "login_btn");


    public void setUserNameAndPassword(String userName, String password) {
        fillUserName(userName);
        setUserId(userName);
        fillPassWord(password);
    }

    public void fillUserName(String username) {
        sendText(USER_NAME_ID, username);
    }

    public void fillPassWord(String passWord) {
        sendText(PASSWORD_ID, passWord);
    }


    public void clickLoginButton() {
        waitAndClick(loginButtonId);

    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserIdFromLoginPage() {
        return getUserId();
    }
}
