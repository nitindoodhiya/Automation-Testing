package Steps;

import Base.BaseUtil;
import Base.Constants;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.apache.log4j.*;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Timestamp;
import java.util.Date;
import java.util.logging.FileHandler;
import java.util.logging.SimpleFormatter;

public class Hook extends BaseUtil {

    private BaseUtil base;

    public Hook(BaseUtil base) throws IOException {

        this.base = base;
    }

    @Before
    public void InitializeTest() throws IOException {
        try {
            if(base.newlog)
            {
                System.out.println("Creating New Log");
                PropertyConfigurator.configure(Constants.log4jPropertyFile);
                base.logger.info("Logger Created");
                base.newlog = false;
            }
        }
        catch (Exception e)
        {
            System.out.println("Failed to create logger:" + e);
        }

        base.logger.info("opening the app");
        //setting up the properties of device - we are using
        try {

            DesiredCapabilities dc = new DesiredCapabilities();
            dc.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
            dc.setCapability("platformName", "android");
            dc.setCapability("appPackage", "in.amazon.mShop.android.shopping");
            dc.setCapability("appActivity", "com.amazon.micron.StartupActivity");
            base.androidDriver = new AndroidDriver<AndroidElement>(new URL("http://0.0.0.0:4723/wd/hub"), dc);
            base.wait = new WebDriverWait(base.androidDriver, 20);
        }
        catch (Exception e)
        {
            base.logger.error(e);
            base.logger.info("Failed to Open the App");
            return;
        }
        base.logger.info("App Opened");
    }

    @After
    public void TearDown() throws InterruptedException {
        Thread.sleep(5000);
        base.logger.info("Closing the app");
        base.androidDriver.quit();
    }


}
