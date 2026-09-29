package WebPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WebLoginPage {

    private WebDriver driver;

    public WebLoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath="//*[@class='-dOa_b L_FVxe']/ancestor::div[@class='_1Us3XD'] //a")
    WebElement landingPageLoginbtn;

    @FindBy(xpath="//div[@class='I-qZ4M vLRlQb']/input")
    WebElement mobileEmailEntry;

    @FindBy(xpath="//div[@class='LSOAQH']/button")
    WebElement requestOTPBtn;

    public void clickOnLandingPageLoginBtn(){
        landingPageLoginbtn.click();
    }

    public void enterMobileOrEmail(String mobileOrEmail){
        mobileEmailEntry.sendKeys(mobileOrEmail);
    }

    public void clickOnRequestOTPBtn(){
        requestOTPBtn.click();
    }

}
