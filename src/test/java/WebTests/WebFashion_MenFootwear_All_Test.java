package WebTests;

import InitDrivers.Base;
import WebPages.WebLandingPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;



public class WebFashion_MenFootwear_All_Test extends Base {

	public static Logger log = LogManager.getLogger(WebFashion_MenFootwear_All_Test.class.getName());
	
	@Test
	public void selectFashionMensFootwearAll() throws InterruptedException {
		log.info("Trying to select Fashion | MensFootWear | All");
		WebLandingPage flipkartlandingpage = new WebLandingPage(driver);
		flipkartlandingpage.closeLoginWindow();	
		flipkartlandingpage. hoverCategories(prop.getProperty("selectCategoryToHover"));
		log.info("Mouse hover on Fashion");
		flipkartlandingpage.hoveredSubMenu(prop.getProperty("selectSubMenuToHover"));
		log.info("Mouse hover on Fashion | MensFootWear");
		flipkartlandingpage.subMenuLists(prop.getProperty("selectSubMenuCategory"));
		log.info("Mouse hover on Fashion | MensFootWear | All");
	}

}
