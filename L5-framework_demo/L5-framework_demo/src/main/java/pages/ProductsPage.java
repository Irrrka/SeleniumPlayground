package pages;

import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.Browser;

public class ProductsPage {

	public static String product = "Vespa Piaggio Rosa";
	public static String product_model = "Primavera";
	public static String product_price = "5500.00";
	public static String product_status = "Enabled";
	public static String product_image_name = "Piaggio-Vespa.jpg";
	
	@FindBy(id = "catalog")
	public static WebElement menu;
	@FindBy(name = "filter_name")
	public static WebElement filter_name;
	@FindBy(linkText = "Filter")
	public static WebElement filter_button;
	@FindBy(className = "filter")
	public static WebElement filter_result;
	@FindBy(linkText = "Insert")
	public static WebElement insert_button;
	@FindBy(name = "product_description[1][name]")
	public static WebElement product_name_description;
	@FindBy(xpath = "//div[@id='tabs']/a[2]")
	public static WebElement tab_data;
	@FindBy(name = "model")
	public static WebElement model;
	@FindBy(name = "price")
	public static WebElement price;
	@FindBy(partialLinkText = "image_upload")
	public static WebElement browse_button;
	@FindBy(xpath = "//img[contains(@src, 'product_image_name']")//как да въведа да ми е променлива?
	public static WebElement imageFile;
	@FindBy(xpath = "//a[contains(@onclick, 'submit()']")//?
	public static WebElement save_button;
	@FindBy(xpath = "/html/body/div[1]/div[2]/div[2]/div[1]/div/a[3]")//нещо по-добро
	public static WebElement delete_button;

	
	
	
	public static void Init(){
		PageFactory.initElements(Browser.driver, ProductsPage.class);
	}

	public static void Open() throws Throwable {
		WebElement submenu = menu.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/ul[1]/li[2]/ul/li[2]/a"));//relative path?!
		
		Actions action = new Actions(Browser.driver);
		action.moveToElement(menu).perform();
		Thread.sleep(1000);
		action.click(submenu).perform();
	}

	public static boolean isProductPresentInCatalog() {
		filter_name.sendKeys(product);
		filter_button.click();
		WebElement text_of_result = filter_result.findElement(By.tagName("td"));
		String result = text_of_result.getText();
		
		try{
			Assert.assertNotEquals("No results!", result);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	public static void AddProduct(String product) throws Throwable {
		WebDriverWait wait = new WebDriverWait(Browser.driver, 10); 
		WebElement insertButton = wait.until(ExpectedConditions.elementToBeClickable(insert_button));
		insertButton.click();
		Thread.sleep(2000);
		
		product_name_description.sendKeys(product);
		WebElement tabData = wait.until(ExpectedConditions.elementToBeClickable(tab_data));
		tabData.click();
		Thread.sleep(2000);
		
		model.sendKeys(product_model);
		price.sendKeys(product_price);
		
		WebElement browseImage = wait.until(ExpectedConditions.elementToBeClickable(browse_button));
		browseImage.click();
		Thread.sleep(2000);
		
		Actions actions = new Actions(Browser.driver);
		actions.doubleClick(imageFile);
		Thread.sleep(2000);
		
		WebElement save = wait.until(ExpectedConditions.elementToBeClickable(save_button));
		save.click();
		Thread.sleep(2000);
	}

	public static void DeleteProduct(String product) throws Throwable {
		if (product_name_description.getText()=="") {
			product_name_description.sendKeys(product);
		} else if(product_name_description.getText()==product){
			WebDriverWait wait = new WebDriverWait(Browser.driver, 10); 
			WebElement deleteButton = wait.until(ExpectedConditions.elementToBeClickable(delete_button));
			deleteButton.click();
			Thread.sleep(2000);
		}
	}

	
	
	
}
