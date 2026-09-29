package InitDrivers;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeMethod;

import java.net.URL;

public class MobileBase {

    /*
            As of now this Class is not used any where
     */

    public static WebDriver driver;

    @BeforeMethod
    public static WebDriver initializeMobileDriver() throws Exception {

         /*
        String appPath = System.getProperty("user.dir")+prop.getProperty("androidApplicationPath");
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME,prop.getProperty("androidPlatformName"));
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, prop.getProperty("androidDeviceName"));
        caps.setCapability(MobileCapabilityType.APP, appPath);
        caps.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT,60);
        caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");

        //or instead of MobileCapabilityType we can use "platforName", "Android" or CapabilityType.platform.Name

        driver = new AndroidDriver<>(new URL(prop.getProperty("appiumServerURL")),caps);
*/

        String mobilePlatform = "android";
        DesiredCapabilities caps = new DesiredCapabilities();

        switch(mobilePlatform.toLowerCase()){
            case "android":
                String path = System.getProperty("user.dir")+"//Apps//com.flipkart.android-8.0.apk";
                caps.setCapability("platformName","Android");
                caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Y56D7PNZ75SK8S85");
                caps.setCapability(MobileCapabilityType.APP, path);
                caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
                driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"),caps);
            case "ios":
                caps.setCapability("platformName", "iOS");
                caps.setCapability("platformVersion", "15.5");
                caps.setCapability("deviceName", "deviceName");
                caps.setCapability("udid", "auto");
                caps.setCapability("bundleId", "<your bundle id>");
                caps.setCapability(MobileCapabilityType.APP, "[PATH_TO_YOUR_.IPA_FILE_COMPILED]");
                driver = new IOSDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), caps);
        }

        return driver;
    }
}
