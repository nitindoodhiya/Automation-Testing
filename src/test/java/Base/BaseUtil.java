package Base;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BaseUtil {

    public AndroidDriver<AndroidElement> androidDriver;
    public WebDriverWait wait;
    public final static String objectRepo = "Object_repository.yml";
    public YMLReader reader = new YMLReader();
    public boolean scroll(Integer pix) 
    {
        int startX = 550;
        int endX = 550;
        int startY = 1200;
        int endY = startY-pix;
        
        try {
        		Thread.sleep(8000);
                TouchAction touchAct = new TouchAction(this.androidDriver);
                PointOption pointStart = PointOption.point(startX, startY);
                PointOption pointEnd = PointOption.point(endX, endY);
                WaitOptions waitOption = WaitOptions.waitOptions(Duration.ofMillis(1000));
                touchAct.press(pointStart).waitAction(waitOption).moveTo(pointEnd).release().perform();
        }catch (Exception e)
        {
            e.printStackTrace();
            return false;
        }
        return true;
    }
    public boolean scrolldowntofind(String xpath)
    {
        int startX = 550;
        int endX = 550;
        int startY = 1000;
        int endY = 500;
        try {
            while (this.androidDriver.findElementsByXPath(xpath).size()==0) {
                TouchAction touchAction = new TouchAction(this.androidDriver);
                PointOption pointStart = PointOption.point(startX, startY);
                PointOption pointEnd = PointOption.point(endX, endY);
                WaitOptions waitOption = WaitOptions.waitOptions(Duration.ofMillis(1000));
                touchAction.press(pointStart).waitAction(waitOption).moveTo(pointEnd).release().perform();
                startX = 550;
                endX = 550;
                startY = 1000;
                endY = 500;
            }
            MobileElement el = this.androidDriver.findElementByXPath(xpath);
            el.click();
        }catch (Exception e)
        {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean tap(String obj )
    {
        String xpath = reader.getXPath(obj,objectRepo);
        try{
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath))).click();
        }
        catch (Exception e)
        {
            System.out.println(e);
            return false;
        }
        return true;
    }

    public boolean tapold(String id )
    {
        try{
        	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(id))).click();
        }
        catch (Exception e)
        {
            System.out.println(e);
            return false;
        }
        return true;
    }
    public boolean sendkeys(String obj, String key )
    {
        String xpath = reader.getXPath(obj,objectRepo);

        try{
        	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
            MobileElement el = (MobileElement) this.androidDriver.findElementByXPath(xpath);
            el.sendKeys(key);
        }
        catch (Exception e){
            System.out.println(e);
            return false;
        }

        return true;
    }
}
