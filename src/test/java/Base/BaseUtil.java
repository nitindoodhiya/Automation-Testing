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

    public boolean scroll(Integer pix) {
        int startX = 550;
        int endX = 550;
        int startY = 1200;
        int endY = startY - pix;
        try {
            Thread.sleep(8000);
            TouchAction touchAct = new TouchAction(this.androidDriver);
            PointOption pointStart = PointOption.point(startX, startY);
            PointOption pointEnd = PointOption.point(endX, endY);
            WaitOptions waitOption = WaitOptions.waitOptions(Duration.ofMillis(1000));
            touchAct.press(pointStart).waitAction(waitOption).moveTo(pointEnd).release().perform();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean scrolldowntofind(String xpath) {
        int startX = 550;
        int endX = 550;
        int startY = 1000;
        int endY = 500;
        try {
            while (this.androidDriver.findElementsByXPath(xpath).size() == 0) {  //scroll until element appears
                TouchAction touchAction = new TouchAction(this.androidDriver);
                PointOption pointStart = PointOption.point(startX, startY);     //starting coordinates
                PointOption pointEnd = PointOption.point(endX, endY);           //ending coordinates
                WaitOptions waitOption = WaitOptions.waitOptions(Duration.ofMillis(500)); //wait for 0.5 seconds
                touchAction.press(pointStart).waitAction(waitOption).moveTo(pointEnd).release().perform();  //releasing after moving
            }
            MobileElement el = this.androidDriver.findElementByXPath(xpath);
            el.click();
        } catch (Exception e) {

            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean tap(String obj) {
        String xpath = reader.getXPath(obj, objectRepo);                                            //get xpath of element from object_Repository
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath))).click();    //wait until element appears on screen and then click

        } catch (Exception e) {
            System.out.println(obj);
            System.out.println(e);
            return false;
        }
        return true;
    }

    public boolean sendkeys(String obj, String input) {

        String xpath = reader.getXPath(obj, objectRepo);                          //get xpath of element from object_Repository
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
            MobileElement el = (MobileElement) this.androidDriver.findElementByXPath(xpath); //get element using xpath
            el.sendKeys(input);                                                      //set the element with given input
        } catch (Exception e) {
            System.out.println(obj);
            System.out.println(e);
            return false;
        }

        return true;
    }

}
