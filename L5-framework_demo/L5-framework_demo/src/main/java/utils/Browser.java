package utils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Browser {

	public static WebDriver driver;
	public final static String DRIVERS_PATH = "D:\\selenium_drvers\\";

	public static void init(String browser) {
		if (browser.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", DRIVERS_PATH + "geckodriver.exe");
			driver = new FirefoxDriver();
		} else if (browser.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", DRIVERS_PATH + "chromedriver.exe");
			driver = new ChromeDriver();
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	public static void close() {
		driver.quit();
	}
}
