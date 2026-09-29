package WebPages;

import java.util.List;

import Utils.CommonMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class WebMobilePage extends CommonMethods {

	public WebDriver driver;

	public WebMobilePage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[@class='N27L5l'] //a[@class='wjcEIp']")
	List<WebElement> productNames;
	
	By by = By.xpath("//div[@class='_3YgSsQ'] //a[@class='s1Q9rs']");
	
	@FindBy(xpath="(//div[@class='Y77NLA'])[1]")
	WebElement bestSelling;
	

	@FindBy(xpath = "//input[@class='zDPmFV']")
	WebElement mobileSearchBlock;

	public void selectMobile(String enterProduct) throws InterruptedException {
		scrollDown();
		scrollIntoView(bestSelling);
		for (int i = 0; i < productNames.size(); i++) {
			String productsText = productNames.get(i).getText();
			System.out.println(productsText);
			if (productsText.contains(enterProduct)) {
				productNames.get(i).click();
				break;
			}
		}
	}

	public void searchSpecificMobile(String entermobileName) {
		mobileSearchBlock.sendKeys(entermobileName);
		mobileSearchBlock.sendKeys(keyboardEnter());
	}

}
