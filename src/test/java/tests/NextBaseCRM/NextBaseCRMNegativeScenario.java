package tests.NextBaseCRM;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class NextBaseCRMNegativeScenario {

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        String url = "https://login2.nextbasecrm.com/";
        driver.get(url);

        WebElement findEmail = driver.findElement(By.name("USER_LOGIN"));
        findEmail.sendKeys("helpdesk@cybertekschool.com");
        WebElement findPassword = driver.findElement(By.name("USER_PASSWORD"));
        findPassword.sendKeys("User" + Keys.ENTER);

        Thread.sleep(2000);


        String expectedMessage = "Incorrect login or password";
        System.out.println("Expected message: " + expectedMessage);

        WebElement actualMessage = driver.findElement(By.xpath("//div[@class='errortext']"));
        System.out.println("Actual message: " + actualMessage.getText());
        String error = actualMessage.getText();

        System.out.println(error.equals(expectedMessage) ? "PASS" : "FAIL");

        Thread.sleep(2000);

    }
}