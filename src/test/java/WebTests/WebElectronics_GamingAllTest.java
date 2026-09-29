package WebTests;

import InitDrivers.Base;
import WebPages.WebElectronics_GamingAll;
import WebPages.WebLandingPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;



public class WebElectronics_GamingAllTest extends Base {

	public static Logger log = LogManager.getLogger(WebElectronics_GamingAllTest.class.getName());
	
	@Test
	public void verifyproductlistIsDisplayed() throws InterruptedException {
		log.info("Trying to verify list of products are displaying");
		WebLandingPage flipkartlandingpage = new WebLandingPage(driver);
		flipkartlandingpage.closeLoginWindow();	
		flipkartlandingpage. hoverCategories(prop.getProperty("HoverOnElectronics"));
		log.info("Mouse hove on Electronics");
		flipkartlandingpage.hoveredSubMenu(prop.getProperty("selectSubMenuFromElectronicsDropdown"));
		log.info("Mouse hove on Electronics sub menu");
		WebElectronics_GamingAll gamingAl = flipkartlandingpage.subMenuLists(prop.getProperty("selectCategoryFromElectronicsSubMenu"));
		boolean status =gamingAl.productList();
		Assert.assertTrue(status);
		log.info("List of products are displayed successfully");
		
	}
	
	@Test
	public void selectRadomProductFromList() throws InterruptedException {
		log.info("Trying to select any one product from the default list");
		WebLandingPage flipkartlandingpage = new WebLandingPage(driver);
		flipkartlandingpage.closeLoginWindow();	
		flipkartlandingpage. hoverCategories(prop.getProperty("HoverOnElectronics"));
		log.info("Mouse hove on Electronics");
		flipkartlandingpage.hoveredSubMenu(prop.getProperty("selectSubMenuFromElectronicsDropdown"));
		log.info("Mouse hove on Electronics sub menu");
		WebElectronics_GamingAll gamingAl = flipkartlandingpage.subMenuLists(prop.getProperty("selectCategoryFromElectronicsSubMenu"));
		gamingAl.productTitles("Gaming");
		log.info("User navigated to Gaming page");
	}

}
