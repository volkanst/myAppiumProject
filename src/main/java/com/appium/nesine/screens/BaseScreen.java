package com.appium.nesine.screens;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Sleeper;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;
import java.util.Random;


public class BaseScreen {

    protected AndroidDriver driver;
    protected WebDriverWait wait;

    public BaseScreen (AndroidDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, 15);
    }

    protected void waitAndClick (By by) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(by)).click();
    }
    
    protected boolean checkElementIsEnabled(By by) {
       Boolean bool = driver.findElement(by).isEnabled();
       return bool;
    }

    protected void click(By by) {
        waitVisibility(by);
        driver.findElement(by).click();
    }
    
    public WebElement getElementBy(By by) {
		//WebElement element = 
		return driver.findElement(by);
	}
    
    protected Object getRandomContent(List<?> contentList) {
		Random rand = new Random();
		int n = rand.nextInt(contentList.size());
		return contentList.get(n);
	}

    protected void hideKeyboard(){
        driver.navigate().back();
    }

    protected boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    protected void notFoundElement(By by) {
        Assert.fail("Element Bulunumadı:" + by);
    }

    protected List<WebElement> waitAndFindElements (By by) {
        return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
    }
    
    protected List<WebElement> FindElements (By by) {
        return driver.findElements(by);
    }
    
    protected int countElements (By by) {
        return driver.findElements(by).size();
    }
    
    protected WebElement waitAndFindElement (By by) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }    
    
    protected String getText(By by) {
        return waitAndFindElement(by).getText();
    }

    protected void sendText (By by, String text) {
         waitAndFindElement(by).sendKeys(text);
    }

    protected void assertEquals (String actual, String expected) {
        Assert.assertEquals(actual,expected, "Two texts are not equal!" + "Actual: " + actual + " Expected: " + expected);
    }
    
    protected void assertTrue (Boolean condition , String message) {
        Assert.assertTrue(condition, message);
    }
    
    protected void waitVisibility (By by) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }


    protected boolean acceptAlert(int waitTimeInSec) {
        System.out.println("   wait to dismiss dialog");
        WebDriverWait wait = new WebDriverWait(driver, waitTimeInSec);
        try {
            wait.until(ExpectedConditions.alertIsPresent());
            driver.switchTo().alert().accept();
            return true;
        } catch (Exception e) {
            System.err.println("   no alert visible after "+waitTimeInSec+" sec.");
            return false;
        }
    }
    
    protected boolean checkElementIsEnabledByLocator(By locator) {
		boolean bool = driver.findElement(locator).isEnabled();
		return bool;
	}
    
    public void sleep(int second) {

		try {

			System.out.println("SLEEP...");
			long duration = new Long(second).longValue();
			Sleeper.SYSTEM_SLEEPER.sleep(
					new org.openqa.selenium.support.ui.Duration(duration, java.util.concurrent.TimeUnit.SECONDS));
			System.out.println("Time to wake up!");

		} catch (Exception e) {
			System.out.println(e);
		}
		
	}
}
