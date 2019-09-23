import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.junit.After;
import java.net.MalformedURLException;
import java.net.URL;

public class HistoryList {

        private AndroidDriver driver;

        @Before
        public void setUp() throws MalformedURLException {
            DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
            desiredCapabilities.setCapability("platformName", "android");
            desiredCapabilities.setCapability("app", "/Users/suaadbatis/Desktop/Appiumpro/app-release.apk");
            desiredCapabilities.setCapability("deviceName", "Huaweip10lite");
            desiredCapabilities.setCapability("platformVersion", "8.0");

            URL remoteUrl = new URL("http://localhost:4723/wd/hub");

            driver = new AndroidDriver(remoteUrl, desiredCapabilities);
        }


        @Test
        public void sampleTest() {
            MobileElement el1 = (MobileElement) driver.findElementByXPath("(//android.widget.ImageView[@content-desc=\"Banner\"])[1]");
            el1.click();
        }


        @After
        public void tearDown() {
            driver.quit();
        }
    }

