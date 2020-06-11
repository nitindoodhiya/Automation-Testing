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

import java.io.IOException;
import java.net.URL;

public class Hook extends BaseUtil {

    private final BaseUtil base;
    private static boolean flag = true;

    public Hook(BaseUtil base) throws IOException {

        this.base = base;
    }

    @Before
    public void InitializeTest() throws IOException {
        try {
            if (newlog) {
                System.out.println("Creating New Log");
                PropertyConfigurator.configure(Constants.log4jPropertyFile);
                logger.info("Logger Created");
                newlog = false;
            }
        } catch (Exception e) {
            System.out.println("Failed to create logger:" + e);
        }
            // setting flag to initialise once the capabilities for scenario-outline
        if (flag) {
            logger.info("opening the app");
            //setting up the properties of device - we are using
            try {

                DesiredCapabilities dc = new DesiredCapabilities();
                dc.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
                dc.setCapability("platformName", "android");
                dc.setCapability("appPackage", "in.amazon.mShop.android.shopping");
                dc.setCapability("appActivity", "com.amazon.mShop.home.HomeActivity");
                androidDriver = new AndroidDriver<AndroidElement>(new URL("http://0.0.0.0:4723/wd/hub"), dc);
                wait = new WebDriverWait(androidDriver, 25);
            } catch (Exception e) {
                logger.error(e);
                logger.info("Failed to Open the App");
                return;
            }
            logger.info("App Opened");
            flag = false;
        }
        else {
            logger.info("App Already Opened");
        }

    }

    @After
    public void TearDown() throws InterruptedException {
        Thread.sleep(5000);
        logger.info("Closing the app");
    }


}
