import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pages.AdminLoginPage;
import pages.DashboardPage;
import utils.Browser;

public class DashboardPageTests {
	@Before
	public void setUp() throws InterruptedException{
		AdminLoginPage.login(AdminLoginPage.user, AdminLoginPage.pass);
		Browser.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		DashboardPage.Init();
	}
	@After
	public void tearDown() throws InterruptedException{
		Browser.close();
	}
	
	@Test
	public void DashboardPageSuccesfulLogOut() throws Throwable{
		DashboardPage.Logout();
	}
	
	@Test
	public void DashboardPageTableheadContentTest(){
		List<String> actualText = DashboardPage.GetTableheadContent();
		List<String> expectedText = Arrays.asList(new String[] {"Order ID", "Customer", "Status", "Date Addd", "Total", "Action"});
		Assert.assertArrayEquals(expectedText.toArray(), actualText.toArray());
	}
	
	@Test
	public void DashboardPageTableContentIsLastColumnClickable() throws Throwable{
		WebElement element = DashboardPage.GetWebElementOfLastColOftable();
		WebDriverWait wait = new WebDriverWait(Browser.driver, 10); 
		WebElement elementToClick = wait.until(ExpectedConditions.elementToBeClickable(element));
		elementToClick.click();
		Thread.sleep(2000);
		assertEquals("Orders", Browser.driver.getTitle());
	}
	@Test
	public void DashboardPageHasNOTSelectRangeOptionHour(){
		List<String> option_values = DashboardPage.SelectRange();
		String hour = "hour";
		for (String option_value : option_values) {
		Assert.assertNotEquals(hour, option_value);
		}
	}
}























