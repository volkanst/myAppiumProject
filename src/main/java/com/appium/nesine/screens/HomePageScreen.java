package com.appium.nesine.screens;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class HomePageScreen extends BaseScreen {

    public HomePageScreen(AndroidDriver driver) {
        super(driver);
    }

    String kupondas = "Kupondaş";
    private static final String GENERAL_ID = "com.pordiva.nesine.android:id/";
    private static final By HOME_PAGE_USER_ID = By.id(GENERAL_ID + "memberidValue");

    public void verifyHomePageUserIdControl(String userId) {
        Assert.assertTrue(isElementPresent(HOME_PAGE_USER_ID),"userId texti bulunamadı.");
        String homePageUserId = getText(HOME_PAGE_USER_ID);
        Assert.assertEquals(userId, homePageUserId, "Ekranda Görünen UserId: " + homePageUserId + " iken olması gereken: " + userId);
    }

    public void clickHomePageKupondasButton() {
        List<WebElement> elements = waitAndFindElements(By.className("android.widget.TextView"));
        for (int i = 0; i < elements.size(); i++) {
            if (kupondas.equals(elements.get(i).getText())) {
                elements.get(i).click();
            }
        }
    }
}
