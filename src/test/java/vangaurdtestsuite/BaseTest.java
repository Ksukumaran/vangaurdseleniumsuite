package vangaurdtestsuite;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import pages.BaseClass;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

public class BaseTest extends BaseClass {

    Logger log = LogManager.getLogger(BaseTest.class.getName());

    @BeforeTest
    @Parameters("browser")
    public void setupBrowser(String browser) throws IOException {

        if (browser.equalsIgnoreCase("firefox")) {
            driver = initializeFireFoxDriver();
        } else if (browser.equalsIgnoreCase("chrome")) {
            driver = initializeChromeDriver();
        }
        browserPrep();
        propertyFileLoader();
    }

    @AfterTest
    public void tearDown() throws IOException, InterruptedException {

        driver.quit();
        driver = null;
        processKillChrome();
        processKillGecko();
        Thread.sleep(1500);
    }

    public void explicitWait(WebElement locator, int timeInSeconds) {
        WebDriverWait w = new WebDriverWait(driver, timeInSeconds);
        w.until(ExpectedConditions.visibilityOf(locator));
    }


    public void loadURL(WebDriver driver, String url) {
        driver.get(url);
    }

    //Use to switch to the first child window
    public void windowSwitcher() throws InterruptedException {
        Thread.sleep(2000);
        Set<String> ids = driver.getWindowHandles();
        Iterator<String> it = ids.iterator();
        it.next();
        String childId = it.next();
        driver.switchTo().window(childId);
    }

    public void closeCurrentTab(String windowHandle) {
        driver.close();
        driver.switchTo().window(windowHandle);
    }


}
