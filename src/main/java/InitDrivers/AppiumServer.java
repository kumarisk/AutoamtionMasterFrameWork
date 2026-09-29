package InitDrivers;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

import java.io.File;

public class AppiumServer {

    private static AppiumDriverLocalService service;

    public static boolean isAppiumServeRunning(){
        try {
            Process process = Runtime.getRuntime().exec("curl -s http://localhost:4723/wd/hub/status");
            process.waitFor();
            return process.exitValue() == 0;
        } catch (Exception e) {
            return false;
        }
    }


    public static void startAppiumServer(){
        AppiumServiceBuilder builder = new AppiumServiceBuilder();
        builder
                .withAppiumJS(new File("C:\\Program Files\\Appium Server GUI\\resources\\app\\node_modules\\appium\\build\\lib\\main.js"))
                .usingPort(4723);
        // .withArgument(sessionOverride);// Adjust path as needed

        service = AppiumDriverLocalService.buildService(builder);
        service.start();
        System.out.println("Appium server started.");
    }


    public static void stopAppiumServer(){
        if (service != null && service.isRunning()) {
            service.stop();
            System.out.println("Appium server stopped.");
        }
    }
}
