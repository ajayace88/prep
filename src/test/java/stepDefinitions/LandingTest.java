package stepDefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import prep.Browser;

import java.util.concurrent.TimeUnit;

/**
 * Created by Aj on 19-01-2017.
 */
public class LandingTest {
    WebDriver driver = null;

    @Given("^User open \"([^\"]*)\" in \"([^\"]*)\"$")
    public void user_open_in(String url, String browser) throws Throwable {
        driver = Browser.startBrowser(browser);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(url);
        
    }

    @Then("^Redirects to page with title \"([^\"]*)\"$")
    public void redirects_to_page_with_title(String title) throws Throwable {
        System.out.println(driver.getTitle());
        Assert.assertTrue("Not matched", title.equalsIgnoreCase(driver.getTitle()));

    }

    @When("^User performs search with \"([^\"]*)\"$")
    public void user_performs_search_with(String sSearchTerm) throws Throwable {
        driver.findElement(By.id("lst-ib")).sendKeys(sSearchTerm);
        driver.findElement(By.id("lst-ib")).sendKeys(Keys.ENTER);
    }

    @Then("^Search results displayed for \"([^\"]*)\"$")
    public void search_results_displayed_for(String sToMatch) throws Throwable {
        WebElement ele = driver.findElement(By.xpath("//div[@class=\"kp-hc\"]//following::div[contains(text(), 'Shah Rukh Khan')]"));
        Browser.waitFor(driver, ele);
        Assert.assertTrue("Not found", sToMatch.equalsIgnoreCase(ele.getText()));

    }

    @Then("^Close browser$")
    public void close_browser() throws Throwable {
        Browser.quitBrowser();
    }

}
