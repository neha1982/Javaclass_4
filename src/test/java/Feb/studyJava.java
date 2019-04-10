package Feb;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class studyJava {

  protected static WebDriver driver;
  @Before
          public void setup() {
      //driver syntax for chrome driver
      System.setProperty("webdriver.chrome.driver", "src\\test\\java\\BrowserDriver\\chromedriver.exe");
        driver=new ChromeDriver();
      //implicit wait applied to driver instance
    driver.manage().timeouts().pageLoadTimeout( 15, TimeUnit.SECONDS);
    //driver getting url
    driver.get("https://demo.nopcommerce.com/");}
    @Test
      public void RegisterSuccessfully(){
      //register new user
          driver.findElement(By.xpath("//a[@class='ico-register']")).click();
          //type the first name
          driver.findElement(By.xpath("//input[@name='FirstName']")).sendKeys("Sofia");
          //type the last name
          driver.findElement(By.xpath("//input[@name='LastName']")).sendKeys("Grande");
          String UserName = "" + (int) (Math.random() * Integer.MAX_VALUE);
        String EmailID = "nehshi" + UserName + "@hotmail.com";
        //type the email id
          driver.findElement(By.xpath("//input[@name='Email']")).sendKeys("nehshi85@hotmail.com");
          //type the password
          driver.findElement(By.xpath("//input[@name='Password']")).sendKeys("Test1test");
          //type the confirm password
          driver.findElement(By.xpath("//input[@name='ConfirmPassword']")).sendKeys("Test1test");
          //click the register button
          driver.findElement(By.xpath("//input[@id='register-button']")).click();
          //actual result massage
          String actualRegistrationSuccessMassage = driver.findElement(By.xpath("//div[@class=\'result\']")).getText();
          //match the expected ans actual result
            Assert.assertEquals("Your registration completed", actualRegistrationSuccessMassage);
  }

            @Test
                    public void Login(){
      //click on login for put your details
      driver.findElement(By.xpath("//a[@class='ico-login']")).click();
      //type your email
      driver.findElement(By.xpath("//input[@name='Email']")).sendKeys("nehshi82@hotmail.com");
      //type your password
      driver.findElement(By.xpath("//input[@name='Password']")).sendKeys("Test1test");
      //click on login button
      driver.findElement(By.xpath("//input[@class='button-1 login-button']")).click();
      //actual result log out
      String massege = driver.findElement(By.xpath("//a[@class='ico-logout']")).getText();
      Assert.assertEquals("Log out", massege);
      //match the results
      System.out.println("User should be Login successfully");
  }

    @Test
      public void computer(){
      driver.findElement(By.linkText("Computers")).click();
      driver.findElement(By.partialLinkText("Notebooks")).click();
      String actresult=driver.findElement(By.xpath("//div[@class='page-title']")).getText();
      Assert.assertEquals("Notebooks",actresult);
      System.out.println("User should be able to navigate to Nootbook category page");

    }
    @Test
      public void electronics(){
      driver.findElement(By.linkText("Electronics")).click();
      driver.findElement(By.partialLinkText("Cell phones")).click();
      String actresult=driver.findElement(By.xpath("//div[@class='page-title']")).getText();
      Assert.assertEquals("Cell phones",actresult);
      System.out.println("User should be able to navigate cell phone page via Electronics");
    }
    @Test
    public void shoppingCart(){
      driver.findElement(By.xpath("//a[@href=\"/books\"]")).click();
      driver.findElement(By.xpath("//a[@href=\"/pride-and-prejudice\"]")).click();
      driver.findElement(By.xpath("//input[@id=\"add-to-cart-button-39\"]")).click();
     String actualaddtocart = driver.findElement(By.xpath("//p[@class=\"content\"]")).getText();
     System.out.println("User should be able to add product into the shopping cart ");
     Assert.assertEquals("The product has been added to your shopping cart",actualaddtocart );



    }

}
   // @After
    //      public void tearDown()

         // driver.quit();





