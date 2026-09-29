package WebPages;

import Utils.CommonMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;


public class WebFashion_MenFootwear_All extends CommonMethods {
	
	public WebDriver driver;

	public WebFashion_MenFootwear_All(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	public String gettitle() {
		String title = driver.getTitle();
		return title;
	}

}
