package utilities;

import browserfactory.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Random;

public class Utility extends BaseTest {
    // this method will click on element
    public void clickOnElement(By by) {
        driver.findElement(by).click();
    }
    // this method will get text from element
    public String getTextFromElement(By by) {
        return driver.findElement(by).getText();
    }
    // this method will send text on element
    public void sendTextToElement(By by, String text) {
        driver.findElement(by).sendKeys(text);
    }

    // ---------------------------Alert method-------------------------
    //this method will switch to alert
    public void switchToAlert() {
        driver.switchTo().alert();
    }
    // this method will accept alert
    public void acceptAlert() {
        driver.switchTo().alert().accept();
    }
    // this method will dismiss alert
    public void dismissAlert() {
        driver.switchTo().alert().dismiss();
    }
    // this method will get text from alert
    public String getTextFromAlert() {
        return driver.switchTo().alert().getText();
    }
    // this method will send text from alert
    public void sendTextToAlert(String text) {
        driver.switchTo().alert().sendKeys(text);
    }

    //---------------------------Select Class Methods -------------------------------------

    //This method will select the option by visible text
    public void selectByVisibleTextFromDropDown(By by, String text) {
        WebElement dropDown = driver.findElement(by);
        Select select = new Select(dropDown);
        select.selectByVisibleText(text);
    }
    //  This method will select the option by index
    public void selectByValueFromDropDown(By by, String value) {
        new Select(driver.findElement(by)).selectByValue(value);
    }
    //This method will select the option by index
    public void selectByIndexFromDropDown(By by, int index) {
        new Select(driver.findElement(by)).selectByIndex(index);
    }
    //This method will select the option by contains text
    public void selectByContainsTextFromDropDown(By by, String text) {
        List<WebElement> allOptions = new Select(driver.findElement(by)).getOptions();
        for (WebElement options : allOptions) {
            if (options.getText().contains(text)) {
                options.click();
            }
        }
    }
    //--------------------------------- Action Method -----------------------------------------

    /*
    This method will mouse hover over any element
     */
    public void mouseHoverOnElement(By by) {
        Actions actions = new Actions(driver);
        WebElement xyz = driver.findElement(by);
        actions.moveToElement(xyz).build().perform();
    }

    /**
     * This method will use to hover mouse on element and click
     */
    public void mouseHoverToElementAndClick(By by) {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(by)).click().build().perform();
    }
    //-------------------------------- Window Handle Methods --------------------------
    /**
     * This method will close all windows
     */
    public void closeAllWindows(List<String> hList, String parentWindow) {
        for (String str : hList) {
            if (!str.equals(parentWindow)) {
                driver.switchTo().window(str).close();
            }
        }
    }

    /**
     * This method will switch to parent window
     */
    public void switchToParentWindow(String parentWindowId) {
        driver.switchTo().window(parentWindowId);
    }

    /**
     * This method will find that we switch to right window
     */
    public boolean switchToRightWindow(String windowTitle, List<String> hList) {
        for (String str : hList) {
            String title = driver.switchTo().window(str).getTitle();
            if (title.contains(windowTitle)) {
                System.out.println("Found the right window....");
                return true;
            }
        }
        return false;
    }
  //  ---------------------------- Assert Method -----------------------------------
    /**
     * This method will get text from element and check whether it is displayed or not.
     */
    public boolean isTextDisplayed(By by, String expectedText){
        boolean actualText = (driver.findElement(by).getText()).contains(expectedText); // Find and get actual text on page and check whether it contains expected text or not?
        assert actualText : "Text is not found" + expectedText;
        return true;
    }
    /**
     * This method will get number from element and check
     * whether it is displayed or not.
     */
    public boolean getNumberFromElement(By by,int expectedNumber) {
        int actualNumber = driver.findElements(by).size();
        assert actualNumber == expectedNumber : "Expected Number is not found" + expectedNumber;
        return true;
    }


    public static String getRandomEmail() { // Method generating Random email everytime
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder random = new StringBuilder();
        Random rnd = new Random();
        while (random.length() < 10) { // length of the random string.
            int index = (int) (rnd.nextFloat() * chars.length());
            random.append(chars.charAt(index));
        }
        String email = random.toString() + "@gmail.com";
        return email;
    }

}
