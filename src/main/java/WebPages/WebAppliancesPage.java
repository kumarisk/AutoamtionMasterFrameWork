package WebPages;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import Utils.CommonMethods;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WebAppliancesPage extends CommonMethods {
	
	public WebDriver driver;

	public WebAppliancesPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//div[@class='_1bEAQy _2iN8uD']")
	List<WebElement> allImgLinks;
	
	@FindBy(xpath="//div[@class='cPHDOP col-12-12'] //a")
	List<WebElement> allproductLinks;
	
	
	
	public void openeachimg() throws InterruptedException {
		int size = allImgLinks.size();
		for(int i=0;i<size;i++) {
			allImgLinks.get(i).click();
			String title = driver.getCurrentUrl();
			System.out.println(title);
			Thread.sleep(1000);
			driver.navigate().back();
			Thread.sleep(1000);
			
		}
	}
	
	
	public void openeachlinkInNewTab() throws InterruptedException {
		int productssize = allproductLinks.size();
		for(int i=0;i<productssize;i++) {
			Thread.sleep(1000);
			allproductLinks.get(i).sendKeys(Keys.CONTROL,Keys.ENTER);
			Thread.sleep(1000);
			
		}
		
		Set<String> tabs = driver.getWindowHandles();
		Iterator<String> tab = tabs.iterator();
		while(tab.hasNext()) {
			driver.switchTo().window(tab.next());
			System.out.println(driver.getTitle());
		}
	}

}
