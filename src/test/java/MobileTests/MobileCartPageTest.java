package MobileTests;

import InitDrivers.Base;
import MobilePages.MobileCartPage;
import MobilePages.MobileLandingPage;
import MobilePages.MobileLoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MobileCartPageTest extends Base {

    @Test
    public void getPageTitle(){
        MobileLoginPage mobileloginpage = new MobileLoginPage(driver);
        mobileloginpage.clickSkipBtnOnLanguageScreen();
        MobileLandingPage landingPage = new MobileLandingPage(driver);
        MobileCartPage cartPage = landingPage.clickOnCartFromMenu();
        String title = cartPage.getPageTitle();
        Assert.assertEquals(title,"My Cart");
    }
}
