package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import utils.Driver;

public class BookManagementPage extends BasePage {

    @FindBy(xpath="//h3[.='Book Management']")
    public WebElement bookMangtHeader;

    //method to verify if we are on correct page
    public void isCurrentPage() {
        // actual versus expected title
        Assert.assertEquals(Driver.getDriver().getTitle(),"Library");
    }


}
