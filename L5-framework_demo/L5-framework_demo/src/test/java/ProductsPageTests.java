import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pages.AdminLoginPage;
import pages.DashboardPage;
import pages.ProductsPage;
import utils.Browser;

public class ProductsPageTests {
	@Before
	public void setUp() throws InterruptedException{
		AdminLoginPage.login("user", "parola");
		Thread.sleep(2000);
		DashboardPage.Init();
		ProductsPage.Init();
	}
	@After
	public void tearDown(){
		Browser.driver.close();
	}
	
	@Test
	public void isProductsPageOpened() throws Throwable{

		ProductsPage.Open();
		Thread.sleep(2000);
		
		assertEquals("Products", Browser.driver.getTitle());
	}
	
	@Test
	public void isProductAddedSuccesful() throws Throwable{
		String product = ProductsPage.product;
		if (!ProductsPage.isProductPresentInCatalog()) {
			ProductsPage.AddProduct(product);
		} else {
			ProductsPage.DeleteProduct(product);
			ProductsPage.AddProduct(product);
		}
		Assert.assertTrue(ProductsPage.isProductPresentInCatalog());
	}
}
