package laptopsandnotebooks;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class LaptopsAndNotebooksTest extends Utility {
    String baseUrl = "http://tutorialsninja.com/demo/index.php?";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void verifyProductsPriceDisplayHighToLowSuccessfully() {
        //hover over Laptops And Notebooks tab click on it
        mouseHoverOnElement(By.xpath("//body/div[1]/nav[1]/div[2]/ul[1]/li[2]/a[1]"));
        clickOnElement(By.xpath("//a[normalize-space()='Show AllLaptops & Notebooks']"));
        //once the page has loaded, select the option to order by price high to low
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='input-sort']"), "Price (High > Low)");
        //verify the ordering is priced high to low
        isTextDisplayed(By.xpath("//body[1]/div[2]/div[1]/div[1]/div[3]/div[3]/div[1]/select[1]/option[5]"), "Price (High > Low)");
    }
    @Test
    public void verifyThatUserPlaceOrderSuccessfully() {
        //hover over Laptops And Notebooks tab click on it
        mouseHoverOnElement(By.xpath("//body/div[1]/nav[1]/div[2]/ul[1]/li[2]/a[1]"));
        clickOnElement(By.xpath("//a[normalize-space()='Show AllLaptops & Notebooks']"));
        //once the page has loaded, select the option to order by price high to low
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='input-sort']"), "Price (High > Low)");
        //Select Product “MacBook”
        clickOnElement(By.xpath("//body[1]/div[2]/div[1]/div[1]/div[4]/div[4]/div[1]/div[2]/div[1]/h4[1]/a[1]"));
        // Verify the text “MacBook”
        isTextDisplayed(By.linkText("//body[1]/div[2]/div[1]/div[1]/div[1]/div[2]/h1[1]"),"MacBook");
        //Click on ‘Add To Cart’ button
        clickOnElement(By.xpath("//button[@id='button-cart']"));
        // Verify the message “Success: You have added MacBook to your shopping cart!”
        isTextDisplayed(By.xpath("//div[@class='alert alert-success alert-dismissible']"),"Success: You have added MacBook to your shopping cart!"+"\n×");
        //Click on link “shopping cart” display into success message
        clickOnElement(By.xpath("//body[1]/div[2]/div[1]/a[2]"));
        //Verify the text "Shopping Cart"
        isTextDisplayed(By.xpath("//body[1]/div[2]/div[1]/div[1]/h1[1]"),"Shopping Cart  (0.00kg)");
        //Verify the Product name "MacBook"
       isTextDisplayed(By.xpath("//div[@id='content']/form/div/table[1]/tbody[1]/tr[1]/td[2]/a[1]"),"MacBook");
        //clear 1 from textbox
        driver.findElement(By.xpath("//div[@class='input-group btn-block']/input")).clear();
        // Change Quantity "2"
        sendTextToElement(By.xpath("//div[@class='input-group btn-block']/input"),"2");
        // Click on “Update” Tab
        clickOnElement(By.xpath("//button[@type='submit']"));
        //Verify the message “Success: You have modified your shopping cart!”
        isTextDisplayed(By.xpath("//div[@class='alert alert-success alert-dismissible']"),"Success: You have modified your shopping cart!"+"\n×");
        //Verify the Total $1204.00
        isTextDisplayed(By.xpath("//body[1]/div[2]/div[2]/div[1]/div[2]/div[1]/table[1]/tbody[1]/tr[4]/td[2]"),"$1,204.00");
        //Click on “Checkout” button
        clickOnElement(By.xpath("//a[@class='btn btn-primary']"));
        //2.16 Verify the text “Checkout”
        isTextDisplayed(By.xpath("//div[@id='content']/h1"),"Checkout");
        // Verify the Text “New Customer”
        isTextDisplayed(By.xpath("//div[@class='col-sm-6']/h2[text()='New Customer']"),"New Customer");
        // Click on “Guest Checkout” radio button
        clickOnElement(By.xpath("//input[@value='guest']"));
        //Click on “Continue” tab
        mouseHoverToElementAndClick(By.id("button-account"));
        // Fill the mandatory fields
        //first name
        sendTextToElement(By.id("input-payment-firstname"),"Hi");
        //last name
        sendTextToElement(By.id("input-payment-lastname"),"Patel");
        //email
        sendTextToElement(By.id("input-payment-email"),getRandomEmail());
        //telephone
        sendTextToElement(By.id("input-payment-telephone"),"07654321234");
        //address
        sendTextToElement(By.id("input-payment-address-1"),"11 Pinner Road");
        //city
        sendTextToElement(By.id("input-payment-city"),"Harrow");
        //postcode
        sendTextToElement(By.id("input-payment-postcode"),"HA61SY");
        //Region
        selectByVisibleTextFromDropDown(By.xpath("//body[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[2]/fieldset[1]/div[6]/select[1]"),"United Kingdom");
        //city
        selectByVisibleTextFromDropDown(By.xpath("//body[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[2]/fieldset[1]/div[7]/select[1]"),"Aberdeen");
        //Click on “Continue” Button
        clickOnElement(By.xpath("//div[@class='buttons']/div[@class='pull-right']/input[@value='Continue']"));
        // Add Comments About your order into text area
        sendTextToElement(By.xpath("//div[@class='panel-body']/p[2]/textarea[@name='comment']"),"Comment XYZA");
        // Check the Terms & Conditions check box
        mouseHoverToElementAndClick(By.xpath("//input[@name='agree']"));
        //Click on “Continue” button
        clickOnElement(By.xpath("//input[@id='button-payment-method']"));
        // Verify the message “Warning: Payment method required!”
        isTextDisplayed(By.xpath("//div[@class='alert alert-danger alert-dismissible']"),"Warning: Payment method required!"+"\n×");


    }

    @After
    public void tearDown() {
        closeBrowser();
    }
}
