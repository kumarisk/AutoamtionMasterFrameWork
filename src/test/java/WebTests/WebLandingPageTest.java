package WebTests;

import InitDrivers.Base;
import Utils.RetryTheTestCaase;
import WebPages.WebLandingPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;



public class WebLandingPageTest extends Base {

	public static Logger log = LogManager.getLogger(WebLandingPageTest.class.getName());

	@Test
	public void verifyFlipkartlogo() throws InterruptedException {
		log.info("Trying to verify Application logo");
		WebLandingPage flipkartlandingpage = new WebLandingPage(driver);
		flipkartlandingpage.closeLoginWindow();
		boolean logo = flipkartlandingpage.verifyLogo();
		Assert.assertTrue(logo);
		log.info("Application logo is displayed");
	}
	
	
	
	@Test(groups= {"Smoke"})
	public void ClickOnMobiles() throws InterruptedException {
		log.info("Trying to click on Mobiles menu from the row");
		String expectedtitle = "Mobiles- Buy Products Online at Best Price in India - All Categories | Flipkart.com";
		WebLandingPage flipkartlandingpage = new WebLandingPage(driver);
		flipkartlandingpage.closeLoginWindow();
		flipkartlandingpage.entertextInSearch("mobiles");
		log.info("Text has been entered in the search field");
		String currenttitle =flipkartlandingpage.grabTitle();
		Assert.assertEquals(currenttitle, expectedtitle);
	}
	
	@Test(groups= {"Smoke,Sanity"},retryAnalyzer = RetryTheTestCaase.class)
	public void selectMobileCategory() throws InterruptedException {
		log.info("Trying to click on Mobiles Category");
		String expectedtitle = "Mobile Phones Online at Best Prices in India";
		WebLandingPage flipkartlandingpage = new WebLandingPage(driver);
		flipkartlandingpage.closeLoginWindow();
		flipkartlandingpage.selectMobiles();
		log.info("Mobiles Category is selected");
		String currenttitle =flipkartlandingpage.grabTitle();
		Assert.assertEquals(currenttitle, expectedtitle);
		
	}
	
	@Test(groups= {"Smoke"},retryAnalyzer = RetryTheTestCaase.class)
	public void selectGroceryCategory() throws InterruptedException {
		log.info("Trying to click on Grocery category");
		String expectedtitle = "Flipkart Grocery Store - Buy Groceries Online & Get Rs.1 Deals at Flipkart.com";
		WebLandingPage flipkartlandingpage = new WebLandingPage(driver);
		flipkartlandingpage.closeLoginWindow();		
		flipkartlandingpage.selectGrocery();
		log.info("Grocery category is selected");
		String currenttitle =flipkartlandingpage.grabTitle();
		Assert.assertEquals(currenttitle, expectedtitle);
		
	}
	
	
	@Test
	public void gamingAllFromElectronicsCategory() throws InterruptedException {
		log.info("Trying to select Electronics | Gaming | All ");
		WebLandingPage flipkartlandingpage = new WebLandingPage(driver);
		flipkartlandingpage.closeLoginWindow();	
		flipkartlandingpage.hoverCategories("Electronics");
		flipkartlandingpage.hoveredSubMenu("Gaming");
		flipkartlandingpage.subMenuLists("All");
		Thread.sleep(5000);
		log.info("selected Electronics | Gaming | All");
	}
	
	@Test(groups= {"Smoke,Sanity"})
	public void selectTravelCategory() throws InterruptedException {
		log.info("Trying to click on Travel category");
		String expectedtitle = "Flight bookings, Cheap flights, Lowest Air tickets at Flipkart.com";
		WebLandingPage flipkartlandingpage = new WebLandingPage(driver);
		flipkartlandingpage.closeLoginWindow();		
		flipkartlandingpage.selectTravel();
		Thread.sleep(2000);
		log.info("Travel category is selected");
		String currenttitle =flipkartlandingpage.grabTitle();
		Assert.assertEquals(currenttitle, expectedtitle);
		
	}
	
	@Test(groups= {"Smoke"},retryAnalyzer = RetryTheTestCaase.class)
	public void selectAppliancesCategory() throws InterruptedException {
		log.info("Trying to click on Appliances category");
		String expectedtitle = "Tvs And Appliances New Clp Store Online - Buy Tvs And Appliances New Clp Online at Best Price in India | Flipkart.com";
		WebLandingPage flipkartlandingpage = new WebLandingPage(driver);
		flipkartlandingpage.closeLoginWindow();		
		flipkartlandingpage.selectAppliances();
		log.info("Appliances category is selected");
		String currenttitle =flipkartlandingpage.grabTitle();
		Assert.assertEquals(currenttitle, expectedtitle);
	
	}
	
	@Test(groups= {"Smoke,Sanity"},retryAnalyzer = RetryTheTestCaase.class)
	public void verifyribbonsIsDisplayed() throws InterruptedException {
		log.info("Trying to verify ribbons are displayed");
		String expectedtitle = "Mobiles- Buy Products Online at Best Price in India - All Categories | Flipkart.com";
		WebLandingPage flipkartlandingpage = new WebLandingPage(driver);
		flipkartlandingpage.closeLoginWindow();		
		flipkartlandingpage.ribbonsIsDisplayed();
		log.info("All the Ribbons are displayed");
	}
	
}
