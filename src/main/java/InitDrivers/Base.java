package InitDrivers;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;

import static InitDrivers.AppiumServer.*;

public class Base {

    public static WebDriver driver;
    public static Properties prop;

    @BeforeSuite
    public Properties getProperties()  {
        prop = new Properties();
            try{
                FileInputStream inputFile = new FileInputStream(
                        System.getProperty("user.dir") + "//src//main//resources//prop.properties");
                prop.load(inputFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
        return prop;
    }

       private static WebDriver initializeWebDriver(String browser) {

        switch (browser.toLowerCase()) {
            case "chrome":
                ChromeOptions options = new ChromeOptions();
                if (Boolean.parseBoolean(System.getProperty("headless", "false"))) {
                    options.addArguments("--headless=new", "--no-sandbox", "--disable-dev-shm-usage");
                }
                System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+ prop.getProperty("chromeDriverPath"));
                driver = new ChromeDriver();
                break;

            case "firefox":
               driver = new FirefoxDriver();
                break;

            case "safari":
              driver = new SafariDriver();
                break;

            case "microsoftedge":
                driver = new EdgeDriver();
                break;

            default:
                throw new IllegalArgumentException("Unsupported browser: " + browser);
        }
        driver.manage().window().maximize();
        return driver;
    }

    private static WebDriver initializeMobileDriver(String mobileType) throws Exception {

//        if (!isAppiumServeRunning()) {
//            startAppiumServer();
//        }

        String appPath = System.getProperty("user.dir")+prop.getProperty("androidApplicationPath");
        DesiredCapabilities caps = new DesiredCapabilities();

        switch(mobileType.toLowerCase()){
            case "android":
                caps.setCapability(MobileCapabilityType.PLATFORM_NAME,prop.getProperty("androidPlatformName"));
                caps.setCapability(MobileCapabilityType.DEVICE_NAME, prop.getProperty("androidDeviceName"));
                caps.setCapability(MobileCapabilityType.APP, appPath);
                caps.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT,60);
                caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
                driver = new AndroidDriver<>(new URL(prop.getProperty("appiumServerURL")),caps);
                break;

            case "ios":
                caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "ios");
                caps.setCapability(MobileCapabilityType.DEVICE_NAME, "deviceName");
                caps.setCapability(MobileCapabilityType.UDID, "auto");
                caps.setCapability(MobileCapabilityType.APP, "[PATH_TO_YOUR_.IPA_FILE_COMPILED]");
                driver = new IOSDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), caps);
                break;

            default:
                System.out.println("Unsupported browser: " + prop.getProperty("selectMobilePlatform"));
        }
        return driver;
    }

    @Parameters({"platform"})
    @BeforeMethod
    public static WebDriver startDriver(String platform) throws Exception {
       // String platform = prop.getProperty("selectPlatformName");
        switch (platform.toLowerCase()) {
            case "web":
                driver = initializeWebDriver(prop.getProperty("browserName"));
                driver.get(prop.getProperty("websiteUrl"));
                break;

            case "mobile":
                driver = initializeMobileDriver(prop.getProperty("selectMobilePlatform"));
                break;

            default:
                throw new IllegalArgumentException("Unsupported platform: " + platform);
        }

        return driver;
    }

    @AfterMethod
    public void closeBrowser() {
        driver.quit();
       // stopAppiumServer();
    }

    @AfterTest
    public void stopAppiumServers(){
        stopAppiumServer();
    }

    @BeforeTest
    public void startAppiumServers(){
        if (!isAppiumServeRunning()) {
            startAppiumServer();
        }
    }

}
