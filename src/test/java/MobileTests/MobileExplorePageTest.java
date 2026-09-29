package MobileTests;

import InitDrivers.Base;
import MobilePages.MobileExplorePage;
import MobilePages.MobileLandingPage;
import MobilePages.MobileLoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MobileExplorePageTest extends Base {

    @Test
    public void getPageTtile(){
        MobileLoginPage mobileloginpage = new MobileLoginPage(driver);
        mobileloginpage.clickSkipBtnOnLanguageScreen();
        MobileLandingPage landingPage = new MobileLandingPage(driver);
        MobileExplorePage explorePage = landingPage.clickOnExploreFromMenu();
        String title = explorePage.getPageTitle();
        Assert.assertEquals(title,"Explore");
    }


}
