package prep;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by Aj on 19-01-2017.
 */
public class Browser {
    public static WebDriver driver;

    public Browser(WebDriver driver) {

        this.driver = driver;
    }

    public static WebDriver startBrowser(String browserName) {
        if (browserName.equalsIgnoreCase("Chrome")) {
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\src\\main\\resources\\chromedriver.exe");
            driver = new ChromeDriver();
        } else if (browserName.equalsIgnoreCase("Mozilla")) {
            driver = new FirefoxDriver();
        }
        return driver;
    }

    public static void quitBrowser(WebDriver driver) {

        driver.quit();
    }

}
