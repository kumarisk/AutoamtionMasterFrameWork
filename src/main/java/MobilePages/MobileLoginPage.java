package MobilePages;

import Utils.CommonMethods;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MobileLoginPage extends CommonMethods {

    public WebDriver driver;

    public MobileLoginPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id="com.flipkart.android:id/custom_back_icon")
    WebElement languageScreenSkipBtn;

    By languageScreenSkipBtn1 = By.id("com.flipkart.android:id/custom_back_icon");

    @FindBy(xpath="//android.view.ViewGroup[@content-desc=\"Account\"]")
    WebElement menuLoginBtn;

    By accountBtn = By.xpath("//android.view.ViewGroup[@content-desc=\"Account\"]");

    @FindBy(xpath="//android.widget.TextView[@text=\"Log In\"]")
    WebElement loginBtn;

    By loginBtn1 = By.xpath("//android.widget.TextView[@text=\"Log In\"]");

    @FindBy(id="com.flipkart.android:id/phone_input")
    WebElement mobileEmailEntry;

    By mobileEmailEntry1 = By.id("com.flipkart.android:id/phone_input");

    @FindBy(id="com.flipkart.android:id/button")
    WebElement submitBtn;

    By submitBtn1 = By.id("com.flipkart.android:id/button");

    public void clickSkipBtnOnLanguageScreen(){
        visibilityOfElementLocated(languageScreenSkipBtn1);
          }

    public void clickOnAccountBtnFromMenu(){
        visibilityOfElementLocated(accountBtn);
    }

    public void clickOnLoginBtn(){
        visibilityOfElementLocated(loginBtn1);
    }

    public void enterMobileNoOrEmail(String enterMobileNoOrEmail){
        visibilityOfElementLocated(mobileEmailEntry1);
        actionObject().sendKeys(enterMobileNoOrEmail).build().perform();
    }

    public void clickOnSubmitBtn(){
        visibilityOfElementLocated(submitBtn1);
    }
}
