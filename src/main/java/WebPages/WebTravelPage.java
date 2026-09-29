package WebPages;

import java.util.List;

import Utils.CommonMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WebTravelPage extends CommonMethods {
	
	public WebDriver driver;

	public WebTravelPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	//label[contains(text(),'From')]/ancestor::div[@class='_3qBKP_ _1Jqgld']/input
	
	@FindBy(xpath="//input[@class='v2VFa- rLGgLC g9KxuM smJZop ZjUTQC z2D4XG']")
	WebElement enterFromAddress;
	
	//*[contains(text(),'To')]/ancestor::div[@class='_3qBKP_ _1Jqgld']/input
	@FindBy(xpath="//input[@name='0-arrivalcity']")
	WebElement enterToAddress;
	
	@FindBy(xpath="//div[@class='ecAhsD uzeEmI'] //div[@class='_98hP1j'] //span")
	List<WebElement> fromPartialList;
	
	@FindBy(xpath="//div[@class='_24hoQ2 _1EzOls'] //div[@class='_2B0KQx']")
	List<WebElement> toPartialList;
	
	@FindBy(xpath="//label[contains(text(),'Depart On')]/ancestor::div[@class='wN1kJt U1LCmH']")
	WebElement departOn;
	
	
	@FindBy(xpath="//div[@class='_5WWQqg'] /table[1] //td")
	List<WebElement> dayslist;
	
	@FindBy(xpath="//div[@class='_1w7bXX']")
	WebElement monthYearName;
	
	@FindBy(xpath="(//button[@class='R0r93E'])[2]")
	WebElement rightArrowbtn;
	
	@FindBy(xpath="//div[@class='_1Di8FC'] //div[@class='_2zLOdI']")
	List<WebElement> typeOftravellersList;
	
	@FindBy(xpath="(//div[@class='dxenpX'])[2]")
	WebElement adultIncrementbtn;
	
	@FindBy(xpath="(//button[@class='QqFHMw +qYPut vSNayu'])[2]")
	WebElement childrenIncrementbtn;
	
	@FindBy(xpath="(//button[@class='QqFHMw +qYPut vSNayu'])[3]")
	WebElement infantIncrementbtn;
	
//	@FindBy(xpath="(//div[contains(text(),'Adults')]/ancestor::div[@class='_1Di8FC']//button[@class='_2KpZ6l _34K0qG _37Ieie']")
//	WebElement adultsIncrementbtn;
//	
//	@FindBy(xpath="(//div[contains(text(),'Children')]/ancestor::div[@class='_1Di8FC'] //button[@class='_2KpZ6l _34K0qG _37Ieie']")
//	WebElement childrenIncrementbtn;
//	
//	@FindBy(xpath="(//div[contains(text(),'Infants')]/ancestor::div[@class='_1Di8FC'] //button[@class='_2KpZ6l _34K0qG _37Ieie']")
//	WebElement infantsIncrementbtn;
	
	@FindBy(xpath="//label[contains(@class,'_2Fn-Ln _2WzguY')] //div[@class='_2jIO64 _1NhOqr']")
	List<WebElement> cabinClasslist;
	
	@FindBy(xpath="//button[@class='QqFHMw sgUmTV M5XAsp']")
	WebElement searchbtn;
	
	
	public boolean fromAddressIsEnabled() {
		clickVisibilityOfWebElement(enterFromAddress);
		return enterFromAddress.isEnabled();
	}
	
	public boolean toAddressIsEnabled() {
		clickVisibilityOfWebElement(enterToAddress);
		return enterToAddress.isEnabled();
	}
	
	public boolean departureOnIsEnabled() {
		clickVisibilityOfWebElement(departOn);
		return departOn.isEnabled();
	}
	
	
	
	
	public void selectFromAddressPO(String enterfromaddress,String selectaddressfromlist) throws InterruptedException {
		clickVisibilityOfWebElement(enterFromAddress);
		enterFromAddress.sendKeys(enterfromaddress);
		Thread.sleep(3000);
		for(int i=0;i<fromPartialList.size();i++) {
			String frompartialtext = fromPartialList.get(i).getText();
			if(frompartialtext.equalsIgnoreCase(selectaddressfromlist)) {
				fromPartialList.get(i).click();
				break;
			}
		}
		
	}
	
	public void selectToAddressPO(String entertoaddress,String selecttoaddresslist) throws InterruptedException {
		clickVisibilityOfWebElement(enterToAddress);
		enterToAddress.sendKeys(entertoaddress);
		Thread.sleep(3000);
		for(int i=0;i<toPartialList.size();i++) {
			String frompartialtext = fromPartialList.get(i).getText();
			if(frompartialtext.equalsIgnoreCase(selecttoaddresslist)) {
				fromPartialList.get(i).click();
				break;
			}
		}
		
	}
	
	public void selectdate(String entermonthyear,String enterday) throws InterruptedException {
		clickVisibilityOfWebElement(departOn);
		Thread.sleep(2500);
		String monthyeartext = monthYearName.getText();
		System.out.println(monthyeartext);
		int k=0;
		while(!monthyeartext.equalsIgnoreCase(entermonthyear)) {
			rightArrowbtn.click();
			k++;
			String monthtext = monthYearName.getText();
			if(monthtext.equals(entermonthyear)) {
				for(int l=0;l<dayslist.size();l++) {
					String daystext = dayslist.get(l).getText();
					if(daystext.contains(enterday)) {
						dayslist.get(l).click();
						break;
					}
				}
				break;
			}
		}
	}
	
	public void selecttravellers(int adultcount,int childcount,int infantcount) {
		WebElement travellers = driver.findElement(By.xpath("//input[@name='0-travellerclasscount']"));
		clickVisibilityOfWebElement(travellers);
				int count = adultcount;
				for(int a=1;a<count;a++) {
					adultIncrementbtn.click();	
				}
				int childrencounts = childcount;
				for(int c=0;c<childrencounts;c++) {
					childrenIncrementbtn.click();	
				}
				int infants=infantcount	;
				for(int f=0;f<infants;f++) {
					infantIncrementbtn.click();	
				}
					
	}
	
	public void selectCabin(String enterCabin) {
		for(int m=0;m<cabinClasslist.size();m++) {
			String cabin = cabinClasslist.get(m).getText();
			if(cabin.contains(enterCabin)) {
				cabinClasslist.get(m).click();
			}
		}
	}
	
	
	public void clickSearchbtn() {
		searchbtn.click();
	}
	
	
	
	
	
	
	
	

}
