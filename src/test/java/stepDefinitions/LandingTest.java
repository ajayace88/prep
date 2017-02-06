package stepDefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import prep.Browser;

import java.util.concurrent.TimeUnit;

/**
 * Created by Aj on 19-01-2017.
 */
public class LandingTest {
    WebDriver driver;
    WebDriverWait wait;


    @Given("^User open \"([^\"]*)\" in \"([^\"]*)\"$")
    public void user_open_in(String url, String browser) throws Throwable {
        driver = Browser.startBrowser(browser);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(url);
        wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("html/body/div[5]/div[2]/span/a[1]"))));
        driver.findElement(By.xpath("html/body/div[5]/div[2]/span/a[1]")).click();
        System.out.println(driver.getTitle());

    }

    @Then("^Redirects to page with title \"([^\"]*)\"$")
    public void redirects_to_page_with_title(String title) throws Throwable {

        System.out.println(driver.getTitle());
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("html/body/div[5]/div[2]/span/a[1]")));
        System.out.println(driver.getTitle());
        Assert.assertTrue("Not matched", title.equalsIgnoreCase(driver.getTitle()));

    }

    @Then("^Close browser$")
    public void close_browser() throws Throwable {
        Browser.quitBrowser(driver);
    }

}
