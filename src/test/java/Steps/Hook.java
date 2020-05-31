package Steps;

import Base.BaseUtil;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;

public class Hook extends BaseUtil {

    private BaseUtil base;

    public Hook(BaseUtil base) {
        this.base = base;
    }

    @Before
    public void InitializeTest() throws MalformedURLException {
        System.out.println("opening the app");
        DesiredCapabilities dc = new DesiredCapabilities();
        dc.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
        dc.setCapability("platformName", "android");
        dc.setCapability("appPackage", "in.amazon.mShop.android.shopping");
        dc.setCapability("appActivity", "com.amazon.micron.StartupActivity");
        base.androidDriver = new AndroidDriver<AndroidElement>(new URL("http://0.0.0.0:4723/wd/hub"), dc);
        base.wait = new WebDriverWait(base.androidDriver, 15);
        System.out.println("App Opened");
    }

    @After
    public void TearDown() throws InterruptedException {
        Thread.sleep(5000);
        System.out.println("Closing the app");
        base.androidDriver.quit();
    }
}
