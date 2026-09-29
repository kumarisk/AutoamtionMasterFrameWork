package MobileTests;

import InitDrivers.Base;
import MobilePages.MobileLandingPage;
import MobilePages.MobileLoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MobileLandingPageTest extends Base {

    @Test
    public void getLogo(){
        MobileLoginPage mobileloginpage = new MobileLoginPage(driver);
        mobileloginpage.clickSkipBtnOnLanguageScreen();
        MobileLandingPage landingPage = new MobileLandingPage(driver);
        boolean logoStatus = landingPage.getApplicationLogo();
        Assert.assertTrue(logoStatus);
    }
}
