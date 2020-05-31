import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;

import java.net.MalformedURLException;
import java.net.URL;

public class automation {

    public static  AndroidDriver<AndroidElement> getAndroidDriver(DesiredCapabilities dc) throws MalformedURLException
    {
        return new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"),dc);
    }

    public static boolean Tap(String id, AndroidDriver<AndroidElement> ad )
    {
        try{
            MobileElement el = (MobileElement) ad.findElementById( id);
            el.click();
        }
        catch (Exception e){
            System.out.println(e);
            return false;
        }
        System.out.println(id+ ": success");
        return true;
    }

    public static boolean Tap(String id, AndroidDriver<AndroidElement> ad, boolean symbol )
    {
        try{
            MobileElement el = (MobileElement) ad.findElementByAccessibilityId(id);
            el.click();
        }
        catch (Exception e){
            System.out.println(e);
            return false;
        }
        System.out.println(id+ ": success");
        return true;
    }
    public static String retrieve(String id,AndroidDriver<AndroidElement> ad)
    {
        MobileElement el = (MobileElement) ad.findElementById(id);
        return el.getText();
    }
    public static void main(String args[]) throws MalformedURLException {

        String action;
        DesiredCapabilities dc = new DesiredCapabilities();
        dc.setCapability(MobileCapabilityType.DEVICE_NAME,"emulator-5554");
        dc.setCapability("platformName","android");
        dc.setCapability("appPackage","com.android.calculator2");
        dc.setCapability("appActivity",".Calculator");

        AndroidDriver<AndroidElement> ad = getAndroidDriver(dc);

        action = "com.android.calculator2:id/digit_9";
        Tap(action,ad);

        action = "com.android.calculator2:id/digit_5";
        Tap(action,ad);

        action = "plus";
        Tap(action,ad,true);

        action = "com.android.calculator2:id/digit_5";
        Tap(action,ad);

        action = "com.android.calculator2:id/result";
        System.out.println( retrieve(action,ad) +  ": Is our result");

        try
        {
            Assert.assertEquals(retrieve(action,ad),"100");
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
        finally {
            System.out.println("Code Executed");
        }
    }
}
