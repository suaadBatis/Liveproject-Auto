package HomeScreen;


import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class HistoryList {
    public  static AppiumDriverLocalService service;
    private AndroidDriver driver;

    @Before
    public void setUp () throws MalformedURLException {
        service = AppiumDriverLocalService.buildService (
                new AppiumServiceBuilder ().usingDriverExecutable(new File ("/usr/local/bin/node"))
                        .withAppiumJS(new File("/Applications/Appium.app/Contents/Resources/app/node_modules/appium/build/lib/main.js"))
                        .withArgument(GeneralServerFlag.LOCAL_TIMEZONE)
                        .withLogFile(new File (System.getProperty("user.dir")+"/src/test/resources/Lsogs/Appium1.log")));
        service.start (); // check the logs folder
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities ();
        desiredCapabilities.setCapability ("platformName", "android");
        desiredCapabilities.setCapability ("platformVersion", "8.0");
        desiredCapabilities.setCapability ("deviceName", "Huaweip10lite");
        desiredCapabilities.setCapability ("app", "/Users/suaadbatis/Desktop/app.apk");

        URL remoteUrl = new URL ("http://localhost:4723/wd/hub");

        driver = new AndroidDriver (remoteUrl, desiredCapabilities);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        if (driver.findElementById("com.android.packageinstaller:id/permission_allow_button").isDisplayed()) {
            driver.findElementById ("com.android.packageinstaller:id/permission_allow_button").click ();
        }
    }
    @Test
    public void sampleTest() {
        MobileElement el1 = (MobileElement) driver.findElementByXPath("(//android.widget.ImageView[@content-desc=\"Banner\"])[1]");
        el1.click();
    }

    @After
    public void tearDown() {

        driver.quit();
        service.stop ();
    }

}