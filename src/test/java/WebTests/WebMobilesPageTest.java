package WebTests;

import InitDrivers.Base;
import Utils.RetryTheTestCaase;
import WebPages.WebMobilePage;
import WebPages.WebLandingPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;


public class WebMobilesPageTest extends Base {

	public static Logger log = LogManager.getLogger(WebMobilesPageTest.class.getName());

	@Test(groups= {"Smoke,Sanity"})
	public void selectMobileFromDefaultList() throws InterruptedException {
		log.info("Trying to select a mobile from the default list");
		WebLandingPage flipkartlandingpage = new WebLandingPage(driver);
		flipkartlandingpage.closeLoginWindow();
		Object pageobj  = flipkartlandingpage.selectCategoryBasedOnInput(prop.getProperty("selectmobilesCategory"));
		  ((WebMobilePage)pageobj).selectMobile(prop.getProperty("selectMobileBasedOnInput"));
		log.info("Mobile is selected based on user input");
		
		
/*
 * below code is called from a individual methods created in landing page--------but the above code is with single method,
   that select based on user input like whether to go for grocery or mobiles or travel or ....etc
 * 
 * 
 * FlipkartMobilePage flipkartmobilepage = flipkartlandingpage.selectMobiles();
		flipkartmobilepage.selectMobile("APPLE iPhone 15 Pro Max (Natural Titanium, 256 GB)");
	}
 * 		
 */
	
	}
	
	@Test(groups= {"Smoke,Sanity"},retryAnalyzer = RetryTheTestCaase.class)
	public void searchSpecificMobile() throws InterruptedException {
		log.info("Trying to search a mobile based on user input");
		WebLandingPage flipkartlandingpage = new WebLandingPage(driver);
		flipkartlandingpage.closeLoginWindow();
		WebMobilePage flipkartmobilepage = flipkartlandingpage.selectMobiles();
		flipkartmobilepage.searchSpecificMobile(prop.getProperty("selectSpecificMobile"));
		log.info("Mobile is selected based on user input");
	}

}
