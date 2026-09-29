package WebTests;

import InitDrivers.Base;
import WebPages.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;


public class WebCartPageTest extends Base {

	public static Logger log = LogManager.getLogger(WebCartPageTest.class.getName());
	
	@Test
	public void verfiyProductAddedToCartPage() throws InterruptedException {
		log.info("Trying to verify that user is able to add a product to cart page");
		WebLandingPage flipkartlandingpage = new WebLandingPage(driver);
		flipkartlandingpage.closeLoginWindow();
		WebGroceryPage flipkartgrocerypage = flipkartlandingpage.selectGrocery();
		log.info("Grocery category is selected");
		flipkartgrocerypage.deliveryTo(prop.getProperty("cartpageDeliveryPincode"));
		log.info("Pincode is entered");
		flipkartgrocerypage.clickOnRandomGroceryImage();
		log.info("Selected a product category from grocery page");
		String product = "FORTUNE";
		WebCartPage cartpage = flipkartgrocerypage.addToCart(product) ;
		log.info("Product added to cart");
		flipkartgrocerypage.clickOnCart();
		log.info("Clicked on cart button");
		boolean  productName=cartpage.productName();
		Assert.assertTrue(productName);
		log.info("Product name that is added by the user is listed in cart page");
		boolean  totalPrice=cartpage.totalPrice();
		Assert.assertTrue(totalPrice);
		log.info("Price of the Product that is added by the user is listed in cart page");
		boolean  yourSavings=cartpage.yourSavings();
		Assert.assertTrue(yourSavings);
		log.info("Saving amount is displayed");
//		boolean  placeOrderBtn=cartpage.placeOrderBtn();
//		Assert.assertTrue(placeOrderBtn);
		
		
	}

}
