package WebTests;

import InitDrivers.Base;
import WebPages.WebTravelPage;
import WebPages.WebLandingPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;


public class WebTravelPageTest extends Base {

	public static Logger log = LogManager.getLogger(WebTravelPageTest.class.getName());

	@Test
	public void verifyFromAddressFieldIsEnabled() throws InterruptedException {
		log.info("Verifying From Address text box is enabled");
		WebLandingPage flipkartlandingpage = new WebLandingPage(driver);
		flipkartlandingpage.closeLoginWindow();
		Object travelpagemethods  = flipkartlandingpage.selectCategoryBasedOnInput(prop.getProperty("selectTravelCategory"));
		log.info("Selected Travel from Row menu and user is on Travel page");
		WebTravelPage travel = (WebTravelPage)travelpagemethods;
		Assert.assertTrue(travel.fromAddressIsEnabled());
		log.info("From Address text box is enabled");
	}
	
	
	@Test
	public void verifyToAddressFieldIsEnabled() throws InterruptedException {
		log.info("Verifying To Address text box is enabled");
		WebLandingPage flipkartlandingpage = new WebLandingPage(driver);
		flipkartlandingpage.closeLoginWindow();
		Object travelpagemethods  = flipkartlandingpage.selectCategoryBasedOnInput(prop.getProperty("selectTravelCategory"));
		log.info("Selected Travel from Row menu and user is on Travel page");
		WebTravelPage travel = (WebTravelPage)travelpagemethods;
		Assert.assertTrue(travel.toAddressIsEnabled());
		log.info("To Address text box is enabled");
	}
	
	@Test
	public void verifyDepartureIsEnabled() throws InterruptedException {
		log.info("Verifying Departure field is enabled");
		WebLandingPage flipkartlandingpage = new WebLandingPage(driver);
		flipkartlandingpage.closeLoginWindow();
		Object travelpagemethods  = flipkartlandingpage.selectCategoryBasedOnInput(prop.getProperty("selectTravelCategory"));
		log.info("Selected Travel from Row menu and user is on Travel page");
		WebTravelPage travel = (WebTravelPage)travelpagemethods;
		Assert.assertTrue(travel.departureOnIsEnabled());
		log.info("Departure field is enabled");
	}
	
	@Test
	public void searchBasedOnDate() throws InterruptedException {
		log.info("Verifying that user is able to search for bookings based date");
		WebLandingPage flipkartlandingpage = new WebLandingPage(driver);
		flipkartlandingpage.closeLoginWindow();
		Object travelpagemethods  = flipkartlandingpage.selectCategoryBasedOnInput(prop.getProperty("selectTravelCategory"));
		log.info("Selected Travel from Row menu and user is on Travel page");
		WebTravelPage travel = (WebTravelPage)travelpagemethods;
		travel.selectFromAddressPO("hyd", "HYD");
		log.info("Entered From Address");
		travel.selectToAddressPO("banga", "BLR");
		log.info("Entered To Address");
		travel.selectdate("December 2024","23");
		log.info("Entered Travel data Address");
		travel.selecttravellers(2, 1, 1);
		log.info("Selected 2 adults, 1 child, 1 infant");
		travel.selectCabin("Business");
		log.info("Selected Bussines cabin");
		travel.clickSearchbtn();
		log.info("Clicked on Search button");
		
		
	}
	

}
