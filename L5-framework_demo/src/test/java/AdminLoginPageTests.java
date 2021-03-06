import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import pages.AdminLoginPage;
import pages.DashboardPage;
import utils.Browser;

public class AdminLoginPageTests {

	@Test
	public void successfulLogIn() throws InterruptedException {
		Browser.init();
		
		AdminLoginPage.open();
		AdminLoginPage.login("admin","parola");
		Thread.sleep(2000);
		assertEquals("Dashboard", Browser.driver.getTitle());		 
	}
	@After
	public void teardown(){
		Browser.close();
	}

}
