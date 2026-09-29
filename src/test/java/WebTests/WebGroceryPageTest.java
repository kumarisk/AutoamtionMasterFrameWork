package WebTests;

import InitDrivers.Base;
import Utils.RetryTheTestCaase;
import WebPages.WebGroceryPage;
import WebPages.WebLandingPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WebGroceryPageTest extends Base {

	public static Logger log = LogManager.getLogger(WebGroceryPageTest.class.getName());

	@Test
	public void addtoCartFromDefaultProducts() throws InterruptedException {
		log.info("From Grocery Trying to add a product to cart");
		WebLandingPage flipkartlandingpage = new WebLandingPage(driver);
		flipkartlandingpage.closeLoginWindow();
		Object grocerpagemethods  = flipkartlandingpage.selectCategoryBasedOnInput(prop.getProperty("selectGroceryCategory"));
		WebGroceryPage grocer = (WebGroceryPage)grocerpagemethods;
		grocer.deliveryTo(prop.getProperty("groceryDeliveryPinCode"));
		log.info("Entered pincode");
		grocer.clickOnRandomGroceryImage();
		log.info("Selected a product from grocery page");
		grocer.addToCart(prop.getProperty("groceryProduceName"));
		log.info("product added to cart");
		
		
/*
 * below code is called from a individual methods created in landing page--------but the above code is with single method,
   that select based on user input like whether to go for grocery or mobiles or travel or ....etc
 * 
 * FlipkartGroceryPage flipkartgrocerypage = flipkartlandingpage.selectGrocery();
		flipkartgrocerypage.deliveryTo("560037");
		flipkartgrocerypage.clickOnRandomGroceryImage();
		String product = "AASHIRVAAD Atta with Multigrains";
		FlipkartCartPage cartpage = flipkartgrocerypage.addToCart(product) ;
 * 		
 */
			
	
	}
	
	@Test(retryAnalyzer = RetryTheTestCaase.class)
	public void searchForSpecificProduct() throws InterruptedException {
		log.info("Trying to search a product based on user input");
		WebLandingPage flipkartlandingpage = new WebLandingPage(driver);
		flipkartlandingpage.closeLoginWindow();
		WebGroceryPage flipkartgrocerypage = flipkartlandingpage.selectGrocery();
		flipkartgrocerypage.deliveryTo(prop.getProperty("groceryDeliveryPinCode"));
		log.info("Entered pincode for searching specific product");
		flipkartgrocerypage.searchForProduct(prop.getProperty("searchSpecificGroceryProduce"));
		log.info("Search results are displayed based on user search");
	}

}
