package prep;

import org.openqa.selenium.WebDriver;

import java.util.Set;

/**
 * Created by Aj on 18-01-2017.
 */
public class Utility {
    public static WebDriver driver = null;

    public static String getMainWindowHandle(WebDriver driver) {

        return driver.getWindowHandle();
    }

    public static boolean closeAllOtherWindows(String openWindowHandle, WebDriver driver) {
        Set<String> allWindowHandles = driver.getWindowHandles();
        for (String currentWindowHandle : allWindowHandles) {
            if (!currentWindowHandle.equals(openWindowHandle)) {
                driver.switchTo().window(currentWindowHandle);
                driver.close();
            }
        }

        driver.switchTo().window(openWindowHandle);
        if (driver.getWindowHandles().size() == 1)
            return true;
        else
            return false;
    }
}
