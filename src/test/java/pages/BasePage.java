package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

public abstract class BasePage {

    protected WebDriver driver;

    public BasePage(){
        driver = Driver.getDriver();
        PageFactory.initElements(driver, this);

    }



}
