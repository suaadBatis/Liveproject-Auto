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
                        .withLogFile(new File (System.getProperty("user.dir")+"/src/test/resources/Logs/HistoryList.log")));
        service.start (); // check the logs folder

        File app = new File(System.getProperty ("user.dir") + "/app/app-release.apk");

        DesiredCapabilities desiredCapabilities = new DesiredCapabilities ();
        desiredCapabilities.setCapability ("platformName", "android");
        desiredCapabilities.setCapability ("platformVersion", "8.0");
        desiredCapabilities.setCapability ("deviceName", "Huaweip10lite");
        desiredCapabilities.setCapability ("app", app.getAbsolutePath ());

        URL remoteUrl = new URL ("http://localhost:4723/wd/hub");

        driver = new AndroidDriver (remoteUrl, desiredCapabilities);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    }

    @Test
    public void sampleTest() {
        MobileElement el1 = (MobileElement) driver.findElementById("com.moviedb.android.moviedb:id/year_spinner_menu_item");
        el1.click();
        MobileElement el2 = (MobileElement) driver.findElementById("android:id/text1");
        el2.click();
        MobileElement el3 = (MobileElement) driver.findElementById ("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.CheckedTextView[7]");
        el3.click();
    }


    @After
    public void tearDown() {

        driver.quit();
        service.stop ();
    }

}