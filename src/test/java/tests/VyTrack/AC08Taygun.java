package tests.VyTrack;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.WebDriverFactory;

import java.util.concurrent.TimeUnit;

public class AC08Taygun {

    WebDriver driver = WebDriverFactory.getDriver("chrome");
    String url = "https://qa2.vytrack.com/user/login";
    String userName = "user24";
    String password = "UserUser123";

    @BeforeMethod
    public void setUp(){
    driver.get(url);
    driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
        WebElement usernameField = driver.findElement(By.cssSelector("input[name='_username']"));
        usernameField.sendKeys(userName);
        WebElement passwordField = driver.findElement(By.cssSelector("input[name='_password']"));
        passwordField.sendKeys(password);
        WebElement loginBtn = driver.findElement(By.cssSelector("button[id='_submit']"));
        loginBtn.click();
    }

    @Test
    public void GridSettingBtnLocation(){
        String fleetTabLocator ="//a/span[contains(text(),' Fleet')]";
        String vehiclesTabLocator = "//a/span[text()='Vehicles']";

        WebElement fleetTab= driver.findElement(By.xpath(fleetTabLocator));
        WebElement vehiclesTab = driver.findElement(By.xpath(vehiclesTabLocator));
        fleetTab.click();
        vehiclesTab.click();

        WebElement settingSectionOnTheRight = driver.findElement(By.cssSelector("div[class='pull-right grid-toolbar-tools']"));

        Assert.assertNotNull(settingSectionOnTheRight.findElement(By.cssSelector("a[title='Grid Settings']")),"iT IS NOT ON THE RIGHT");

    }
}
