package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.junit.Assert;

import utils.Browser;

public class DashboardPage {
	@FindBy(how = How.XPATH, using = ".//a[@class='top']")
	public static WebElement logoutButton;
	@FindBy(how = How.XPATH, using = "html/head/title")
	public static WebElement title;
	@FindBy(how = How.ID, using = "range")
	public static WebElement selectButton;
	@FindBy(how = How.ID, using = "range")
	public static WebElement range;
	@FindBy(how = How.TAG_NAME, using = "table")
	public static WebElement table;
	@FindBy(how = How.TAG_NAME, using = "thead")
	public static WebElement thead;
	@FindBy(how = How.TAG_NAME, using = "tbody")
	public static WebElement tbody;

	
	
	public static boolean isAt() {
		try{
			Browser.driver.findElement(By.xpath("//h1"));
			assertEquals(Browser.driver.findElement(By.xpath("//h1")).getText(), "Dashboard");
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	
	
	
	public static void Logout() {
		PageFactory.initElements(Browser.driver, DashboardPage.logoutButton);
		logoutButton.click();
		}
	
	public static void Init(){
		PageFactory.initElements(Browser.driver, DashboardPage.class);
	}
	
	public static List<String> GetTableheadContent(){
		WebElement tablehead_row = thead.findElement(By.tagName("tr"));
		List<WebElement> tablehead_col = tablehead_row.findElements(By.tagName("td"));
		List<String> text_of_col = new ArrayList<String>();
		for (WebElement col : tablehead_col) {
			text_of_col.add(col.getText());
		}
		return text_of_col;
	}
	
	public static WebElement GetWebElementOfLastColOftable(){
		WebElement tablebody_row = tbody.findElement(By.tagName("tr"));
		List<WebElement> tablebody_col = tablebody_row.findElements(By.tagName("td"));
		WebElement lastCol_element = tablebody_col.get(5);
		return lastCol_element;
	}



	public static List<String> SelectRange() {		
 		Select range = new Select(DashboardPage.range);
    	//List<String> exp_options = Arrays.asList(new String[]{"day", "week", "month","year"});
    	List<String> act_options = new ArrayList<String>();
    	for(WebElement option : range.getOptions())
    		 act_options.add(option.getText());
    	return act_options;
	}
}
