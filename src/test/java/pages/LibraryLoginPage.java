package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LibraryLoginPage extends BasePage {

    @FindBy(id="inputEmail")
    public WebElement email; //WebElement email = driver.findElement(By.id("inputEmail"))

    @FindBy(id="inputPassword")
    public WebElement password;

    @FindBy(xpath="//button[.='Sign in']")
    public WebElement signInBtn;

    @FindBy(xpath="//div[.='Sorry, Wrong Email or Password']")
    public WebElement errorMsg;


}
