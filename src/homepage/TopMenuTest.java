package homepage;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.List;

public class TopMenuTest extends Utility {

    String baseUrl = "http://tutorialsninja.com/demo/index.php?";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    public void selectMenu(String menu) {
        List<WebElement> topMenuList = driver.findElements(By.xpath("//nav[@id='menu']//ul/li[contains(@class, 'open')]/div/child::*"));
        try {
            for (WebElement element : topMenuList) {
                if (element.getText().equalsIgnoreCase(menu)) {
                    element.click();
                }
            }
        } catch (StaleElementReferenceException e) {
            topMenuList = driver.findElements(By.xpath("//nav[@id='menu']//ul/li[contains(@class, 'open')]/div/child::*"));
        }
    }

    @Test
    public void verifyUserShouldNavigateToDesktopsPageSuccessfully() {
        selectMenu("Desktops");
    }

    @Test
    public void verifyUserShouldNavigateToLaptopsAndNotebooksPageSuccessfully() {
        selectMenu("Laptops & Notebooks");
    }

    @Test
    public void verifyUserShouldNavigateToComponentsPageSuccessfully() {
        selectMenu("Components");
    }

    @After
    public void tearDown(){
        closeBrowser();
    }

}




