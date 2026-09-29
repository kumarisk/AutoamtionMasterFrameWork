package MobileTests;

import InitDrivers.Base;
import MobilePages.MobileLoginPage;
import Utils.RetryTheTestCaase;
import io.appium.java_client.android.nativekey.AndroidKey;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

public class MobileLoginPageTest extends Base {

    public static Logger log = LogManager.getLogger(MobileLoginPageTest.class.getName());

// retryAnalyzer is used RetryTheTestCase class to retry if test cases fails
    @Test(retryAnalyzer = RetryTheTestCaase.class)
    public void LoginToMobileApplication(){
        MobileLoginPage mobileloginpage = new MobileLoginPage(driver);
        log.info("Launched Mobile application");
        mobileloginpage.clickSkipBtnOnLanguageScreen();
        log.info("Clicked on skip button");
        mobileloginpage.clickOnAccountBtnFromMenu();
        log.info("Clicked on Login button from menu");
        mobileloginpage.clickOnLoginBtn();
        log.info("Clicked on Login button from login Screen");
        mobileloginpage.enterMobileNoOrEmail("9848012345");
        log.info("Email or Mobile Number has entered");
        mobileloginpage.keyPadEvents();
        mobileloginpage.clickOnSubmitBtn();
        log.info("Clicked Submit button");
    }

    //@Test
    public void test1(){
        System.out.println("========mobile login page test 1==================");
    }

    //@Test
    public void test2(){
        System.out.println("========mobile login page test 2==================");
    }
    //@Test
    public void test3(){
        System.out.println("========mobile login page test 3==================");
    }

    //@Test
    public void test4(){
        System.out.println("========mobile login page test 4==================");
    }
}
