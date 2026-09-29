package WebPages;

import java.util.List;

import Utils.CommonMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class WebGroceryPage extends CommonMethods {
	
	public WebDriver driver;

	public WebGroceryPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//div[@class='_2yTL60']")
	WebElement deliverTo;
	
	@FindBy(xpath="//input[@title='Enter pincode']")
	WebElement pincodeBlock;
	
	@FindBy(xpath="(//div[@class='_8z-Twi _4bzjfU'])[1]")
	WebElement landingPageproductslist;
	
	@FindBy(xpath="//div[@class='dSU+Ya']")
	List<WebElement> productTitleList;
	
	@FindBy(xpath="//button[@class='QqFHMw PxrzFS']")
	List<WebElement> addToCartbtn;
	
	@FindBy(xpath="//input[@placeholder='Search grocery products']")
	WebElement searchBlock;
	
	@FindBy(xpath="//a[@class='_9Wy27C']")
	WebElement headerCartbtn;
	
	
	
	public void deliveryTo(String pincode) throws InterruptedException {
		mouseActions(driver).moveToElement(deliverTo);
		pincodeBlock.sendKeys(pincode);
		pincodeBlock.sendKeys(keyboardEnter());;
	}
	
	public void clickOnRandomGroceryImage() {
		clickVisibilityOfWebElement(landingPageproductslist);
	}
	
	public WebCartPage addToCart(String productname) {
		try {
			Thread.sleep(2500);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}

		for(int i=0;i<productTitleList.size();i++) {
			String productName = productTitleList.get(i).getText();
			System.out.println(productName);
			if(productName.contains(productname)) {
				addToCartbtn.get(i).click();
				break;
			}
		}
		
		WebCartPage cartpage = new WebCartPage(driver);
		return cartpage;
	}
	
	public void searchForProduct(String enterproductName) {
		
		searchBlock.sendKeys(enterproductName);
		searchBlock.sendKeys(keyboardEnter());
	}
	
	public void clickOnCart() {
		headerCartbtn.click();
	}

}
