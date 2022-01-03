package tests.library;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BookManagementPage;
import pages.LibraryLoginPage;
import tests.TestBase;
import utils.ConfigurationReader;

public class IngaLibrarianAddBook  extends TestBase {


    @Test
    public void librarianAddsBookTest() throws InterruptedException {


        driver.get(ConfigurationReader.getProperty("library.url"));

        LibraryLoginPage loginPage = new LibraryLoginPage();

        // here we are trying to sign in with correct credentials
        loginPage.email.sendKeys(ConfigurationReader.getProperty("library.username"));
        loginPage.password.sendKeys(ConfigurationReader.getProperty("library.password"));
        loginPage.signInBtn.click();



        //given librarian is on the  home page
//
//        WebElement homepageElem = driver.findElement(By.cssSelector("#user_count"));
//
//        Assert.assertTrue(homepageElem.isDisplayed(),"Not on homepage");

        // when librarian clicks Books module

        wait = new WebDriverWait(driver, 30);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a/span[@class='title'])[3]")));

        WebElement booksLink = driver.findElement(By.xpath("(//a/span[@class='title'])[3]"));

        booksLink.click();

        // verify we're on BookManagement Page

//        //Book management page steps: verify is correct page, verify label is displayed
//        BookManagementPage bookManagementPage = new BookManagementPage();
//        Assert.assertTrue(bookManagementPage.bookMangtHeader.isDisplayed());
//        bookManagementPage.isCurrentPage();

        // AND librarian click Add Book button

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Add Book")));

        WebElement addBookButton = driver.findElement(By.linkText("Add Book"));

        addBookButton.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='name']")));

        // When Librarian enters Book name, ISBN, year, author, and description

        WebElement bookNameInputBox = driver.findElement(By.xpath("//input[@name='name']"));

        String bookName = "You are a Badass";

        bookNameInputBox.sendKeys(bookName);

        WebElement isbnInputBox = driver.findElement(By.cssSelector("input[name='isbn']"));

        isbnInputBox.sendKeys("I-87465989");

        WebElement yearInputBox = driver.findElement(By.cssSelector("input[name='year']"));

        yearInputBox.sendKeys("2012");

        WebElement authorInputBox = driver.findElement(By.cssSelector("input[name='author']"));

        authorInputBox.sendKeys("Wicked Zed");

        // here we have to select

        WebElement bookCategoryDropDown = driver.findElement(By.cssSelector("#book_group_id"));

        Select dropDown = new Select(bookCategoryDropDown);

        dropDown.selectByVisibleText("Humor");


        WebElement descriptionInputBox = driver.findElement(By.cssSelector("#description"));

        descriptionInputBox.sendKeys("This book will encourage and motivate you to believe in yourself!");


        // AND Librarian click Save Changes

        WebElement saveChangesButton = driver.findElement(By.cssSelector("button[type='submit']"));

        saveChangesButton.click();

        // search for your book

        Thread.sleep(2000);

        WebElement searchForBooksField = driver.findElement(By.xpath("//input[@type='search']"));

        searchForBooksField.sendKeys(bookName+ Keys.ENTER);

        // verify bookName is found on page

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tbl_books_info")));

        WebElement results = driver.findElement(By.id("tbl_books_info"));

        String resultsText = results.getText();

        System.out.println(resultsText);

       Assert.assertTrue(resultsText.contains("1"), "No entries found");

    }



}
