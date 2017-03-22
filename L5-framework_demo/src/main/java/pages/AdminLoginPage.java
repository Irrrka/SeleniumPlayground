package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.*;

import utils.Browser;

public class AdminLoginPage {
	public static String initial_page = "http://shop.pragmatic.bg/admin/";
	
	@FindBy (how = How.NAME, using = "username")
	private static WebElement username;
	@FindBy (how = How.NAME, using = "password")
	private static WebElement password;
	@FindBy (how = How.XPATH, using = "/html/body/div[1]/div[2]/div/div[2]/form/table/tbody/tr[4]/td/a")
	private static WebElement loginButton;
	

	public static void open() {
		Browser.driver.get(initial_page);
		PageFactory.initElements(Browser.driver,AdminLoginPage.class);
		}

	/**
	 * This method populates username, password and clock on login button.
	 * @param userName The username to be populated.
	 * @param pass The password to be populated.
	 */
	public static void login(String userName, String pass) {
		username.sendKeys(userName);
		password.sendKeys(pass);
		loginButton.click();
	}	
}
