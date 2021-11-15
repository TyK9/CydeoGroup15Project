package VyTrack;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AdilyaTruckDriverNegativeTC17 {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        String url = "https://qa2.vytrack.com/user/login";
        driver.get(url);

        WebElement clickButton = driver.findElement(By.cssSelector("button[type='submit']"));
        clickButton.click();

        String actualAlert = driver.findElement(By.id("prependedInput")).getAttribute("validationMessage");
        String expectedMsg = "Please fill out this field.";
        System.out.println(expectedMsg.equals(actualAlert)?
                "Please fill out Username and Password\nTest case PASSED" : "Unknown error\nTest case FAILED");

        Thread.sleep(3000);

        driver.quit();


    }
}