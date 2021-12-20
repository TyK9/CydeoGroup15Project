package tests.VyTrack;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class JaninaStoreManagerPositiveTC09 {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        String url = "https://qa2.vytrack.com/user/login";
        driver.get(url);


        WebElement username = driver.findElement(By.cssSelector("input[type='text']"));
        username.sendKeys("storemanager80");
        Thread.sleep(1234);

        WebElement password = driver.findElement(By.cssSelector("input[type='password']"));
        password.sendKeys("UserUser123");
        Thread.sleep(1234);

        WebElement clickButton = driver.findElement(By.cssSelector("button[type='submit']"));
        clickButton.click();

        Thread.sleep(3000);

        driver.findElement(By.linkText("Fleet")).click();

        Thread.sleep(3000);

        driver.findElement(By.linkText("Vehicles")).click();

        Thread.sleep(4000);

        driver.findElement(By.xpath("//div//table//tbody//tr[8]//td[4]")).click();

        Thread.sleep(4000);


        String expectedGeneralInfo = "General Information";
        WebElement actualGeneralInfo = driver.findElement(By.cssSelector("h5[class='user-fieldset']"));
        if (expectedGeneralInfo.equals(actualGeneralInfo.getText())) {
            System.out.println("PASS: Able to see the General Information");
        } else {
            System.out.println("FAIL: Not able to see the General Information");
        }

        Thread.sleep(2000);
        driver.findElement(By.partialLinkText("Add Event")).click();

        Thread.sleep(2000);
        driver.findElement(By.cssSelector("input[data-name='field__title']")).sendKeys("Stop drinking");

        Thread.sleep(2000);
        driver.findElement(By.cssSelector("button[type='submit']")).click();

        Thread.sleep(2000);
        driver.findElement(By.linkText("Activity")).click();

        Thread.sleep(2000);
        WebElement actualAddedBy = driver.findElement(By.linkText("Alden Goyette"));
        String expectedAddedBy = "Alden Goyette";
        if(expectedAddedBy.equals(actualAddedBy.getText())){
            System.out.println("PASS: Event displayed as expected");
        } else {
            System.out.println("FAIL: Event not displayed as expected");
        }

        Thread.sleep(2000);
        WebElement options = driver.findElement(By.linkText("..."));
        Actions action = new Actions(driver);
        action.moveToElement(options).perform();
    }
}
