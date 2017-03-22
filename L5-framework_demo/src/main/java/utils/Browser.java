package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Browser {

	public static WebDriver driver;
	final static String DRIVERS_PATH = "D:\\selenium_drvers\\";

	public static void init() {
		System.setProperty("webdriver.gecko.driver", DRIVERS_PATH + "geckodriver.exe");
		driver = new FirefoxDriver();
	}

	public static void close() {
		driver.quit();
	}
}
