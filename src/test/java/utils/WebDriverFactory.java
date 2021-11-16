package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverFactory {


        /*

        Webdriver Factory class :
                is used to create Webdriver(Selenium) object and return it.
                It will open the browser and maximize it.
           method:
            getDriver(String browserType)

                It will check browser type and return object :
                    if browser type is "Chrome":
                        it will set up chrome driver, and return new Chrome browser
                    if Browser type is "firefox"
                        it will setup firefox driver , and return new FirefoxDriver

            EX:
                Webdriver driver = WebdriverFactory.getDriver("chrome);
                and use driver as normal

         */
        public static WebDriver getDriver(String browserType) {

            if (browserType.equalsIgnoreCase("chrome")) {

                WebDriverManager.chromedriver().setup();
                return new ChromeDriver();

            } else if (browserType.equalsIgnoreCase("firefox")) {
                WebDriverManager.firefoxdriver().setup();
                return new FirefoxDriver();
            } else {
                System.out.println("Invalid browserType = " + browserType);
                return null;
            }


        }

}
