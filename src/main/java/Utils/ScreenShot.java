package Utils;

import InitDrivers.Base;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class ScreenShot {

    static WebDriver driver;

  public static String captureScreenShot(String testCaseName, WebDriver driver) throws IOException {

      TakesScreenshot screenShot = (TakesScreenshot)driver;
      File source = screenShot.getScreenshotAs(OutputType.FILE);
      File destination = new File(System.getProperty("user.dir")+"//screenShots//"+testCaseName+".png");
      String filepaths = destination.getAbsolutePath();
      FileUtils.copyFile(source, destination);
      return filepaths;
  }

}
