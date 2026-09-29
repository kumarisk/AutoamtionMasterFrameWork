package WebTests;

import MobileTests.MobileLoginPageTest;
import WebPages.WebLoginPage;
import InitDrivers.Base;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WebLoginPageTest extends Base {

    public static Logger log = LogManager.getLogger(WebLoginPageTest.class.getName());

    @Test
    public void LoginToWebApplication(){
        WebLoginPage webloginpage = new WebLoginPage(driver);
        log.info("Launched Web Application");
        webloginpage.clickOnLandingPageLoginBtn();
        log.info("Clicked on Login button");
        webloginpage.enterMobileOrEmail("1234567890");
        log.info("Entered Email or Mobile Number");
        webloginpage.clickOnRequestOTPBtn();
        log.info("Clicked on Get OTP button");
    }

    @Test
    public void test1(){
        System.out.println("========web login page test 1==================");
        Assert.assertTrue(false);
    }

    @Test
    public void test2(){
        System.out.println("========web login page test 2==================");
    }
    @Test
    public void test3(){
        System.out.println("========web login page test 3==================");
    }

    @Test
    public void test4(){
        System.out.println("========web login page test 4==================");
    }


}
