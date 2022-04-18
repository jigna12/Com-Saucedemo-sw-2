/*3. Write down the following test into ‘LoginTest’ class
1. userShuoldLoginSuccessfullyWithValid
 Credentials
* Enter “standard_user” username
* Enter “secret_sauce” password
* Click on ‘LOGIN’ button
* Verify the text “PRODUCTS”
2. verifyThatSixProductsAreDisplayedOnPage
* Enter “standard_user” username
* Enter “secret_sauce” password
* Click on ‘LOGIN’ button
* Verify that six products are displayed
 on page*/

package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class LoginTest extends BaseTest {
    String BaseUrl = "https://www.saucedemo.com/";
    @Before
    public void setUp()
    {
        openBrowser(BaseUrl);
    }

    /*
    1. userShuoldLoginSuccessfullyWithValidCredentials
          * Enter “standard_user” username
          * Enter “secret_sauce” password
          * Click on ‘LOGIN’ button
          * Verify the text “PRODUCTS”
     */
    @Test
    public void userSholdLoginSuccessfullyWithValidCredentials()
    {
        //Find the UserName and enter the UserName
        WebElement userName = driver.findElement(By.id("user-name"));
        userName.sendKeys("standard_user");

        //Find the password and enter the password
        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("secret_sauce");

        //Find the Login button and click on login button
        WebElement loginbtn =  driver.findElement(By.id("login-button"));
        loginbtn.click();

        //This requirement is from documents
        String ExpectedMsg = "PRODUCTS";
        //Find the Products area text element and get the text
        WebElement ActualMsgEl = driver.findElement(By.xpath("//span[contains(text(),'Products')]"));
        String ActMsg = ActualMsgEl.getText();
        System.out.println("Actual Message :");

        //Validate actual and expected message
        Assert.assertEquals("Message is not expected:",ExpectedMsg,ActMsg);
    }
    /*  verifyThatSixProductsAreDisplayedOnPage
             * Enter “standard_user” username
             * Enter “secret_sauce” password
             * Click on ‘LOGIN’ button
             * Verify that six products are displayed on page   */
    @Test
    public void verifyThatSixProductsAreDisplayedOnPage()
    {
        //Find the UserName and enter the UserName
        WebElement userName = driver.findElement(By.id("user-name"));
        userName.sendKeys("standard_user");

        //Find the password and enter the password
        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("secret_sauce");

        //Find the Login button and click on login button
        WebElement loginbtn = driver.findElement(By.id("login-button"));
        loginbtn.click();

        //This requirement is from document
        int ExpectedNoOfProducts=6;
        //find no of products and count in Array List
        List<WebElement> Products = driver.findElements(By.className("inventory_item"));
        int ActNumberOfProducts = Products.size();
        System.out.println("Actual No of Products on Display  = " +ActNumberOfProducts);

        //Validate actual and expected message
        Assert.assertEquals("No of products in display are not match with expected =",ExpectedNoOfProducts,ActNumberOfProducts);

    }
    @After
    public void teardown()
    {
        closeBrowser();
    }
}
