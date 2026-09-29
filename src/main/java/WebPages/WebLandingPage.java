package WebPages;

import java.util.List;

import Utils.CommonMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;


public class WebLandingPage extends CommonMethods {

	public WebDriver driver;

	public WebLandingPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[@class='JFPqaw']")
	WebElement loginBlock;
	
	By loginwindow = By.xpath("//div[@class='_38VF5e'] //div[@class='_1Us3XD']");

	@FindBy(xpath = "//div[@class='JFPqaw'] //span[@class='_30XB9F']")
	WebElement closeLoginBlock;
	
	@FindBy(xpath = "//img[@src='https://static-assets-web.flixcart.com/batman-returns/batman-returns/p/images/fkheaderlogo_exploreplus-44005d.svg']")
	WebElement logo;
	
	@FindBy(xpath = "//*[@class='-dOa_b L_FVxe']/ancestor::div[@class='_1Us3XD']")
	WebElement loginbtn;

	@FindBy(css = "._1yQHx8 ._3sdu8W a ._1XjE3T")
	List<WebElement> categories;

	@FindBy(xpath = "//div[@class='_3NorZ0 _3jeYYh'] //input[@name='q']")
	WebElement searchBlock;

	@FindBy(xpath = "//div[@class='_1yQHx8 _2UnIQ_ _3ak8Rd _1kAmyc'] //div[@class='_25HC_u']")
	List<WebElement> electonicsRibbon;
	
	@FindBy(xpath = "//div[@class='_1yQHx8 _2UnIQ_ _3ak8Rd _2y8Yzt'][3] //div[@class='_25HC_u']")
	List<WebElement> foodToysBeautyRibbon;
	
	@FindBy(xpath = "//div[@class='_1yQHx8 _2UnIQ_ _3ak8Rd _2y8Yzt'][4] //div[@class='_25HC_u']")
	List<WebElement> sportsHealthcareRibbon;
	
	@FindBy(xpath = "//div[@class='_58bkzq62 _3n8fnaug _3n8fnamv _3n8fnaf9 _3n8fna1 _3n8fna7n _58bkzqh _1i2djtb9 _1i2djt0']")
	List<WebElement> ribbonTitleList;
	
	@FindBy(xpath="//*[contains(text(),'Flight Booking | Book Flight Tickets at Lowest Airfare on Flipkart.com')]")
	WebElement travelpage;
	
	@FindBy(xpath="//div[@class='YBLJE4'] //span[@class='_1XjE3T']")
	List<WebElement> hoverCategries;
	
	@FindBy(xpath="//div[@class='_16rZTH'] //a[@class='_1BJVlg']")
	List<WebElement> hoverSubCategries;
	

	@FindBy(xpath="//div[@class='_31z7R_'] //a[@class='_3490ry']")
	List<WebElement> hoverSubSubCategries;
	
	

	
	public boolean verifyLogo() {
		boolean flipkartLogo = logo.isDisplayed();
		return flipkartLogo;
	}
	
	public WebLoginPage clickLoginbtn() {
		mouseActions(driver).moveToElement(loginbtn).build().perform();
		loginbtn.click();
		
		WebLoginPage loginpage = new WebLoginPage(driver);
		return loginpage;
	}

	public void entertextInSearch(String search) {
		searchBlock.sendKeys(search);
		searchBlock.sendKeys(keyboardEnter());
	}

	public void closeLoginWindow() {
		try {
			if (loginBlock.isDisplayed()) {
				closeLoginBlock.click();
			}
		    } catch (Exception e) {
		    	
					Assert.assertTrue(true);
		    }
		
	}
	
	
	public Object selectCategoryBasedOnInput(String enterCategoryName) {
		for (int i = 0; i < categories.size(); i++) {
			String catrgoryName = categories.get(i).getText();
			if (catrgoryName.contains(enterCategoryName)) {
				categories.get(i).click();
				if(enterCategoryName.contains("Mobiles")) {	
					WebMobilePage mobilpage = new WebMobilePage(driver);
					return mobilpage;					 
					
				}else if(enterCategoryName.contains("Grocery")){
					WebGroceryPage grocery = new WebGroceryPage(driver);
					return grocery;
							
				}
				else if(enterCategoryName.contains("Travel")) {
					WebTravelPage travel = new WebTravelPage(driver);
					return travel;
					
				}else if(enterCategoryName.contains("Appliances")) {
					WebAppliancesPage appliances = new WebAppliancesPage(driver);
					return appliances;
				}
				break;
			}
		}
		return new Object[] {WebMobilePage.class, WebGroceryPage.class, WebTravelPage.class, WebAppliancesPage.class};
		
	}
	
	
	

	public WebMobilePage selectMobiles() {
		for (int i = 0; i < categories.size(); i++) {
			String catrgoryName = categories.get(i).getText();
			if (catrgoryName.contains("Mobiles")) {
				categories.get(i).click();
				break;
			}
		}
		
		WebMobilePage flipkartmobilepage = new WebMobilePage(driver);
		return flipkartmobilepage;
	}

	public WebGroceryPage selectGrocery() {
		for (int i = 0; i < categories.size(); i++) {
			String catrgoryName = categories.get(i).getText();
			if (catrgoryName.contains("Grocery")) {
				categories.get(i).click();
				break;
			}
		}
		
		WebGroceryPage flipkartgrocerypage = new WebGroceryPage(driver);
		return flipkartgrocerypage;
	}
	
	
	public void hoverCategories(String cat_name) {
		for(int m=0;m<hoverCategries.size();m++) {
			String categoryName = hoverCategries.get(m).getText();
			if(categoryName.contains(cat_name)) {
				mouseActions(driver).moveToElement(hoverCategries.get(m)).build().perform();
			
			}
		}
	}
	
	public void hoveredSubMenu(String name) {
		for(int l=0;l<hoverSubCategries.size();++l) {
			String subMenuNames = hoverSubCategries.get(l).getText();
			if(subMenuNames.contains(name)) {
				mouseActions(driver).moveToElement(hoverSubCategries.get(l)).build().perform();
			}
		}
	}
	
	public WebElectronics_GamingAll subMenuLists(String subname) {
		for(int k=0;k<hoverSubSubCategries.size();++k) {
			String subMenuNames = hoverSubSubCategries.get(k).getText();
			if(subMenuNames.contains(subname)) {
				mouseActions(driver).moveToElement(hoverSubSubCategries.get(k)).build().perform();
				 hoverSubSubCategries.get(k).click();
				 break;
				 
			}
		}
		
		WebElectronics_GamingAll gamingAl = new WebElectronics_GamingAll(driver);
		return gamingAl;
	}

	public void selectTravel() throws InterruptedException {
		for (int i = 0; i < categories.size(); i++) {
			String catrgoryName = categories.get(i).getText();
			if (catrgoryName.contains("Travel")) {
				categories.get(i).click();
				break;	
			}
		}
	}

	public void selectAppliances() {
		for (int i = 0; i < categories.size(); i++) {
			String catrgoryName = categories.get(i).getText();
			if (catrgoryName.contains("Appliances")) {
				categories.get(i).click();
				break;
			}
		}
	}
	
//below code will check if the ribbon name is matching with the given name if matched it will get the tile names of each ribbon	
	public void ribbonsIsDisplayed() {
		for(int k=0;k<ribbonTitleList.size();k++) {
			String ribbonTitleText = ribbonTitleList.get(k).getText();
			if(ribbonTitleText.equalsIgnoreCase("Best of Electronics")) {
				for(int j=0;j<electonicsRibbon.size();j++) {
					 String electronicsribbonProductsText = electonicsRibbon.get(j).getText().split("From")[0].trim();
						System.out.println(electronicsribbonProductsText);
					}
			}
			else if(ribbonTitleText.equalsIgnoreCase("Beauty, Food, Toys & more")) {
				for(int j=0;j<foodToysBeautyRibbon.size();j++) {
					 String foodribbonProductsText = foodToysBeautyRibbon.get(j).getText().split("From")[0].split("Upto")[0].split("Up")[0].trim();
						System.out.println(foodribbonProductsText);
					}
			}
			else if(ribbonTitleText.equalsIgnoreCase("Sports, Healthcare & more")) {
				for(int j=0;j<sportsHealthcareRibbon.size();j++) {
					 String sportsribbonProductsText = sportsHealthcareRibbon.get(j).getText().split("From")[0].split("Upto")[0].split("Up")[0].split("Under")[0].split("up")[0].trim();
						System.out.println(sportsribbonProductsText);
					}
			}
		}
	
	
	}

	public String grabTitle() {
		String title = getTitle();
		System.out.println(title);
		return title;
	}

}
