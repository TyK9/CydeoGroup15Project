package VyTrack;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AdilyaTruckDriverNegativeTC14 {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        String url = "https://qa2.vytrack.com/user/login";
        driver.get(url);

        WebElement username = driver.findElement(By.cssSelector("input[type='text']"));
        username.sendKeys("User");
        WebElement password = driver.findElement(By.cssSelector("input[type='password']"));
        password.sendKeys("123");
        WebElement clickButton = driver.findElement(By.cssSelector("button[type='submit']"));
        clickButton.click();

        WebElement error = driver.findElement(By.xpath("//div[.='Invalid user name or password.']"));
        String actualMsg = error.getText();
        System.out.println("Actual error message: " + actualMsg);
        String expectedMsg = "Invalid user name or password.";
        System.out.println("Expected error message: " + expectedMsg);

        Thread.sleep(3000);

        System.out.println("LOGIN error message verification " + (actualMsg.equals(expectedMsg) ? "PASS" : "FAIL"));

        driver.quit();

    }
}