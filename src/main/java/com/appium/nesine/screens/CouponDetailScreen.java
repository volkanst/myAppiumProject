package com.appium.nesine.screens;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class CouponDetailScreen extends BaseScreen {

    public CouponDetailScreen(AndroidDriver driver) {
        super(driver);
    }

    private static final String GENERAL_ID = "com.pordiva.nesine.android:id/";
    private static final By MATCH_LIST_ID = By.id(GENERAL_ID + "tv_teams");
    private By DETAIL_HEMEN_OYNA_BTN_ID = By.id(GENERAL_ID + "status_btn");
    private static final By BASKET_LIST_ID = By.id(GENERAL_ID + "teamName");

    List<String> matchCode = new ArrayList<>();
    List<String> basketCode = new ArrayList<>();

    public void getCouponDetailCouponInfo() {
        List<WebElement> matchList = waitAndFindElements(MATCH_LIST_ID);
        for (int i = 0; i < matchList.size(); i++) {
            WebElement matchCodeArea = matchList.get(i);
            String matchCodetxt = matchCodeArea.getText().trim();
            matchCode.add(matchCodetxt);
        }
        System.out.println("Maç Listesi :" + matchCode);
    }

    public void clickCouponDetailHemenOynaButton() {
        Assert.assertTrue(isElementPresent(DETAIL_HEMEN_OYNA_BTN_ID),"Kupon Detay : Hemen Oyna butonu bulunamadı.");
        waitAndClick(DETAIL_HEMEN_OYNA_BTN_ID);
    }

    public void verifyBasketCouponInfoControl() {
        List<WebElement> basketList = waitAndFindElements(BASKET_LIST_ID);
        for (int i = 0; i < basketList.size(); i++) {
            WebElement matchCodeArea = basketList.get(i);
            String matchCodetxt = matchCodeArea.getText().trim();
            basketCode.add(matchCodetxt);
        }
        Assert.assertTrue(isTwoListEquals(basketCode, matchCode), "maç isim listesi hatalı.");
        System.out.println("Sepet Maç Listesi : " + basketCode);
    }
}
