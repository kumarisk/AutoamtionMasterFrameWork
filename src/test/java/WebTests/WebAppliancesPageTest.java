package WebTests;

import InitDrivers.Base;
import WebPages.WebAppliancesPage;
import WebPages.WebLandingPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;



public class WebAppliancesPageTest extends Base {

	public static Logger log = LogManager.getLogger(WebAppliancesPageTest.class.getName());
	
	@Test
	public void openEveryImageAndNavigateBack() throws InterruptedException {
		log.info("Trying to open each link that is present on the Appliances page");
		WebLandingPage flipkartlandingpage = new WebLandingPage(driver);
		flipkartlandingpage.closeLoginWindow();
		Object applianceses  = flipkartlandingpage.selectCategoryBasedOnInput(prop.getProperty("selectAppliancesCategory"));
		WebAppliancesPage appliance = (WebAppliancesPage)applianceses;
		appliance.openeachlinkInNewTab();
		log.info("Opened Each link that is present on the Appliances page");
	}

}
