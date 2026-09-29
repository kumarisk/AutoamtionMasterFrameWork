package MobilePages;

import Utils.CommonMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MobileLandingPage extends CommonMethods {

    public WebDriver driver;

    public MobileLandingPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath="//android.view.ViewGroup[@content-desc='Home']")
    WebElement homeMenuBtn;

    @FindBy(xpath="//*[@focusable='true")
    WebElement homeMenuIcon;

    @FindBy(xpath="//android.view.ViewGroup[@bounds='[56,126][473,224]']")
    WebElement flipkartLogo;

    

    @FindBy(xpath="//android.view.ViewGroup[@content-desc='Explore']")
    WebElement homeMenuExploreBtn;

    @FindBy(xpath="//android.view.ViewGroup[@content-desc='Categories']")
    WebElement homeMenuCategoriesBtn;

    @FindBy(xpath="//android.view.ViewGroup[@content-desc='Cart']")
    WebElement homeMenuCartBtn;

    public boolean getApplicationLogo(){
       return waitObject().until(ExpectedConditions.visibilityOf(flipkartLogo)).isDisplayed();
    }

    public MobileExplorePage clickOnExploreFromMenu(){
        waitObject().until(ExpectedConditions.visibilityOf(homeMenuExploreBtn)).click();
        return new MobileExplorePage(driver);
    }

    public MobileCategoriesPage clickOnCategoriesFromMenu(){
        waitObject().until(ExpectedConditions.visibilityOf(homeMenuCategoriesBtn)).click();
        return new MobileCategoriesPage(driver);
    }

    public MobileCartPage clickOnCartFromMenu(){
        waitObject().until(ExpectedConditions.visibilityOf(homeMenuCartBtn)).click();
        return new MobileCartPage(driver);
    }

}
