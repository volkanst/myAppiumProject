package com.appium.nesine.screens;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class KupondasScreen extends BaseScreen {

    public KupondasScreen(AndroidDriver driver) {
        super(driver);
    }

    String tumPay = "Tüm Paylaşımlar";
    private static final String GENERAL_ID = "com.pordiva.nesine.android:id/";
    private static final By HEMEN_OYNA_BTN_ID = By.id(GENERAL_ID + "status_btn");
    private static final By TUM_PAYLASIMLAR_FILTER_BTN_ID = By.className("android.widget.TextView");


    public void clickKupondasPageTumPaylasimlarFilterButton() {
        List<WebElement> elements = waitAndFindElements(TUM_PAYLASIMLAR_FILTER_BTN_ID);
        for (int i = 0; i < elements.size(); i++) {
            if (tumPay.equals(elements.get(i).getText())) {
                elements.get(i).click();
            }
        }
    }

    public void clickKupondasPageTumPaylasimlarFirstHemenOynaButton() {
        List<WebElement> elements = waitAndFindElements(HEMEN_OYNA_BTN_ID);
        elements.get(0).click();
    }
}
