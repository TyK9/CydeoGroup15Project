package NextBaseCRM;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class IngaHr30LoginPositiveScenario {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        String appUrl = "https://login2.nextbasecrm.com/";

        String login = "hr30@cybertekschool.com";
        String password = "UserUser";

        driver.manage().window().maximize();


        driver.get(appUrl);

        Thread.sleep(2000);

        WebElement loginBox = driver.findElement(By.name("USER_LOGIN"));

        loginBox.sendKeys(login);

        WebElement passWordBox = driver.findElement(By.name("USER_PASSWORD"));

        Thread.sleep(2000);

        passWordBox.sendKeys(password);

        WebElement loginButton = driver.findElement(By.cssSelector("input[value='Log In']"));

        Thread.sleep(2000);

        loginButton.click();

        WebElement userBlock = driver.findElement(By.id("user-name"));

        String expectedUserName = userBlock.getText();


        if(expectedUserName.equals(login)){
            System.out.println("Pass: verification passed.");
        }else{
            System.out.println("Fail: verification failed.");
        }











    }

}
