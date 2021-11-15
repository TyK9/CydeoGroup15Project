package VyTrack;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class VyTrackLeo {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        String url = "https://qa2.vytrack.com/user/login";
        driver.get(url);

        WebElement findEmail = driver.findElement(By.name("_username"));
        findEmail.sendKeys("salesmanager144");
        WebElement findPassword = driver.findElement(By.name("_password"));
        findPassword.sendKeys("UserUser123" + Keys.ENTER);

        Thread.sleep(1234);

        String expectedMessage = "Dashboard";
        System.out.println("Expected message: " + expectedMessage);

        WebElement actualMessage = driver.findElement(By.xpath("//h1[@class='oro-subtitle']"));
        System.out.println("Actual message: " + actualMessage.getText());

        String message = actualMessage.getText();

        System.out.println(message.equals(expectedMessage) ? "Pass" : "Fail");


    }
}