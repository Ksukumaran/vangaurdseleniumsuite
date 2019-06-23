package pages;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;


public class BaseClass {

	private static final Logger log = LogManager.getLogger(BaseClass.class.getName());
	public static WebDriver driver;
	public Properties properties;


	public WebDriver initializeChromeDriver() throws IOException {
		chromeInitializer();
		driver = new ChromeDriver();
		return driver;
	}

	public WebDriver initializeFireFoxDriver() throws IOException {
		firefoxInitializer();
		driver = new FirefoxDriver();
		return driver;
	}


	public void chromeInitializer() throws IOException {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\src\\main\\resources\\chromedriver.exe");

	}


	public void firefoxInitializer() throws IOException {
		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "\\src\\main\\resources\\geckodriver.exe");

	}

	public void browserPrep() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
	}

	//To Kill the geckodriver process after execution completion
	public void processKillGecko() throws IOException {
		Runtime.getRuntime().exec("TASKKILL /F /IM geckodriver.exe");
	}

	//To Kill the Chromedriver process after execution completion
	public void processKillChrome() throws IOException {
		Runtime.getRuntime().exec("TASKKILL /F /IM chromedriver.exe");
	}

	public void propertyFileLoader() throws IOException {
		properties = new Properties();
		InputStream is = getClass().getResourceAsStream("/data.properties");
		properties.load(is);
	}

	//Screenshots on successful completion of test
	public void screenShotCaptureSuccess(String result) throws IOException {
		String dateFileName = new SimpleDateFormat("yyyy-MM-dd hh.mm.ss").format(new Date());
		Screenshot fpScreenshot = new AShot().shootingStrategy(ShootingStrategies.viewportRetina(100, 0, 0, 2)).takeScreenshot(driver);
		new File("C://Screenshots").mkdirs();
		ImageIO.write(fpScreenshot.getImage(), "PNG", new File("C://Screenshots/" + result + "-" + dateFileName + ".png"));
	}

	//Screenshots on test failure 
	public void screenShotCaptureFailure(String result) throws IOException {
		String dateFileName = new SimpleDateFormat("yyyy-MM-dd HH.mm.ss").format(new Date());
		Screenshot fpScreenshot = new AShot().shootingStrategy(ShootingStrategies.viewportRetina(100, 0, 0, 2)).takeScreenshot(driver);
		new File("C://Screenshots/Failures").mkdirs();
		ImageIO.write(fpScreenshot.getImage(), "PNG", new File("C://Screenshots/Failures/Failures" + result + "-" + dateFileName + ".png"));


	}

}
