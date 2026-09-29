package MobileTests;

import InitDrivers.Base;
import MobilePages.MobileCategoriesPage;
import MobilePages.MobileLandingPage;
import MobilePages.MobileLoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MobileCategoriesPageTest extends Base {

    @Test
    public void getPageTitle(){
        MobileLoginPage mobileloginpage = new MobileLoginPage(driver);
        mobileloginpage.clickSkipBtnOnLanguageScreen();
        MobileLandingPage landingPage = new MobileLandingPage(driver);
        MobileCategoriesPage categoriesPage = landingPage.clickOnCategoriesFromMenu();
        String title = categoriesPage.getPageTitle();
        Assert.assertEquals(title,"All Categories");

    }
}
