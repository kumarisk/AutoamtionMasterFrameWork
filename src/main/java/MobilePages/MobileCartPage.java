package MobilePages;

import Utils.CommonMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MobileCartPage extends CommonMethods {

    public WebDriver driver;

    public MobileCartPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath="//android.widget.TextView[@text='My Cart']")
    WebElement pageTitle;

    @FindBy(id="")
    WebElement pp;

    @FindBy(id="")
    WebElement ppp;

    @FindBy(id="")
    WebElement pppp;

    public String getPageTitle(){
        return waitObject().until(ExpectedConditions.visibilityOf(pageTitle)).getText();
    }
}
