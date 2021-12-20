package tests.NextBaseCRM;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HelpDeskLogin {

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        String url = "https://login2.nextbasecrm.com/";
        driver.get(url);

        WebElement findEmail = driver.findElement(By.name("USER_LOGIN"));
        findEmail.sendKeys("helpdesk29@cybertekschool.com");
        WebElement findPassword = driver.findElement(By.name("USER_PASSWORD"));
        findPassword.sendKeys("UserUser" + Keys.ENTER);

        Thread.sleep(2000);

        WebElement profileModule = driver.findElement(By.xpath("//span[@class='user-name']"));
        String expectedProfile = "helpdesk29@cybertekschool.com";
        String actualProfile = profileModule.getText();



        if (actualProfile.equals(expectedProfile)){
            System.out.println("Pass: Profile is logged in");
        }   else {
            System.out.println("Fail: Profile was not able to login");
        }






    }
}
