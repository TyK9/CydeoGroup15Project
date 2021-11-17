package VyTrack;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class VyTrackLeo {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        String url = "https://qa2.vytrack.com/user/login";
        driver.get(url);

        WebElement findEmail = driver.findElement(By.name("_username"));
        findEmail.sendKeys("user43");
        WebElement findPassword = driver.findElement(By.name("_password"));
        findPassword.sendKeys("UserUser123" + Keys.ENTER);

        WebElement fleet = driver.findElement(By.xpath("//span[@class='title title-level-1']"));
        fleet.click();
        Thread.sleep(4000);
        WebElement vehicles = driver.findElement(By.xpath("//span[@class='title title-level-2']"));
        vehicles.click();

        WebElement rightArrow = driver.findElement(By.xpath("//i[@class='fa-chevron-right hide-text']"));
        rightArrow.click();
        Thread.sleep(4000);
        WebElement leftArrow = driver.findElement(By.xpath("//i[@class='fa-chevron-left hide-text']"));
        leftArrow.click();

        Thread.sleep(1000);
        List<WebElement> links = driver.findElements(By.xpath("//td[@class='string-cell grid-cell grid-body-cell grid-body-cell-LicensePlate']"));
        System.out.println("Count = " + links.size());
        Thread.sleep(1000);

        WebElement random = links.get(new Random().nextInt(links.size()));
        random.click();

        Thread.sleep(1000);

        WebElement addEvent = driver.findElement(By.xpath("(//a[@href='javascript: void(0);'])[2]"));
        addEvent.click();
        Thread.sleep(2000);

        WebElement title = driver.findElement(By.xpath("//input[@name='oro_calendar_event_form[title]']"));
        title.sendKeys("Test");
        Thread.sleep(1234);

        WebElement buttonSave = driver.findElement(By.xpath("//button[@type='submit']"));
        buttonSave.click();

        Thread.sleep(2000);
        WebElement options = driver.findElement(By.xpath("(//a[@class='dropdown-toggle activity-item'])[1]"));
        Actions action = new Actions(driver);
        action.moveToElement(options).perform();
       // WebElement exit = driver.findElement(By.cssSelector("div[class='dropdown vertical-actions activity-actions']"));
       // WebElement exit = driver.findElement(By.xpath("/div/div[2]/div/div[2]/div[1]/div[1]/div/div[1]/div[3]/div/a"));
       // WebElement exit = driver.findElement(By.xpath("(//div[@class='dropdown vertical-actions activity-actions']"));
      // WebElement exit = driver.findElement(By.xpath("(//a[@class='dropdown-toggle activity-item'])[1]"));
       // exit.click();
        Thread.sleep(2000);
        //WebElement delete = driver.findElement(By.xpath("//a[@class='action item-remove-button']"));
        WebElement delete = driver.findElement(By.cssSelector("a[title='Delete Calendar event']"));
        delete.click();

        Thread.sleep(1000);
        WebElement yesDelete = driver.findElement(By.xpath("//a[@class='btn ok btn-danger']"));
        yesDelete.click();


    }
}
