package testsuite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class LoginTest extends Utility {
    String baseUrl = "https://www.saucedemo.com";

    @Before
    public void setup() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {
        sendTextToElement(By.id("user-name"), "standard_user");
        sendTextToElement(By.name("password"), "secret_sauce");
        clickOnElement(By.id("login-button"));
        String expectedText = "Products";

        String actualText = getTextFromElement(By.xpath("//span[contains(text(),'Products')]"));
        Assert.assertEquals(expectedText, actualText);
    }

    @Test
    public void verifyThatSixProductsAreDisplayedOnPage() {
        sendTextToElement(By.id("user-name"), "standard_user");
        sendTextToElement(By.name("password"), "secret_sauce");
        clickOnElement(By.id("login-button"));

        int actualText1 = productsDisplayed(By.className("inventory_item"));
        int expectedText1 = 6;
           Assert.assertEquals(actualText1,expectedText1);
    }

    @After
    public void testDown() {
        closeBrowser();
    }


}
