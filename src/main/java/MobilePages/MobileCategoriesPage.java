package MobilePages;

import Utils.CommonMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MobileCategoriesPage extends CommonMethods {

    public WebDriver driver;

    public MobileCategoriesPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath="//android.widget.TextView[@text='All Categories']")
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


