package Utils;

import InitDrivers.Base;
import io.appium.java_client.android.nativekey.AndroidKey;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonMethods extends Base {

    public CommonMethods(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    WebDriverWait wait;

    public void visibilityOfElementLocated(By byElement){
        wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.visibilityOfElementLocated(byElement)).click();
    }

    public void clickVisibilityOfWebElement(WebElement webElement){
        wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.visibilityOf(webElement)).click();
    }

    public WebDriverWait waitObject(){
        wait = new WebDriverWait(driver, 15);
        return wait;
    }


    public Actions actionObject(){
        Actions action = new Actions(driver);
       return action;
    }

    public Keys keyboardEnter() {
        Keys enter = Keys.ENTER;
        return enter;
    }

    public Actions mouseActions(WebDriver driver) {
        Actions action = new Actions(driver);
        return action;
    }

    public String getTitle() {
        String title = driver.getTitle();
        return title;
    }

    public void scrollIntoView(WebElement element) throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
        Thread.sleep(500);
    }

    public void scrollDown() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scroll(0,3000)");
        Thread.sleep(2000);
    }

    public void keyPadEvents(){
        AndroidKey one  = AndroidKey.NUMPAD_1;
        AndroidKey two  = AndroidKey.NUMPAD_2;
        AndroidKey three  = AndroidKey.NUMPAD_3;
        AndroidKey four  = AndroidKey.NUMPAD_4;
        AndroidKey five  = AndroidKey.NUMPAD_5;
        AndroidKey six  = AndroidKey.NUMPAD_6;
        AndroidKey seven  = AndroidKey.NUMPAD_7;
        AndroidKey eight  = AndroidKey.NUMPAD_8;
        AndroidKey nine  = AndroidKey.NUMPAD_9;
        AndroidKey zero  = AndroidKey.NUMPAD_0;
    }


}
