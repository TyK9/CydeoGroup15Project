package VyTrack;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.WebDriverFactory;

import java.util.concurrent.TimeUnit;

public class IngaTruckDriverPositiveTC06 {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


        String url = "https://qa2.vytrack.com/user/login";
        driver.get(url);

        // GIVEN user successfully logged in -->

        //locate login field
        WebElement email = driver.findElement(By.name("_username"));
        //enter login data
        email.sendKeys("user42");
        //locate password field
        WebElement password = driver.findElement(By.name("_password"));
        // enter password data
        password.sendKeys("UserUser123" + Keys.ENTER);

        // WHEN user sees his account info ->

        WebElement accountHolderName = driver.findElement(By.xpath("(//a[contains(text(),'Josefa Larson')])[4]"));

       String actualAccountName = accountHolderName.getText();

       if(actualAccountName.equals("Josefa Larson")){
           System.out.println("Pass: correct account name is displayed.");
       }else{
           System.out.println("Fail: incorrect account name");
       }

        // AND user sees main menu
        // check if multi level main menu is displayed

        WebElement mainMenu = driver.findElement(By.xpath("//ul[@class='nav-multilevel main-menu']"));

      boolean isVisible =  mainMenu.isDisplayed();

      if(isVisible ){
          System.out.println("Success:  main menu is displayed.");
      }else{
          System.out.println("Fail: main menu is not displayed");
      }

      // THEN user sees Fleet Module

        // find fleet module
        WebElement fleetModule = driver.findElement(By.xpath("(//span[@class='title title-level-1'])[1]"));

        String expectedTitle = "Fleet";
         String actualTitle =  fleetModule.getText();

         if(expectedTitle.equals(actualTitle)){
             System.out.println("Pass: module title verification passed");
         }else {
             System.out.println("Fail: module title verification failed");
         }















    }
}
