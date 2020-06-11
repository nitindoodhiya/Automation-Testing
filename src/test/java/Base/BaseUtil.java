package Base;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.FileAppender;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;


public class BaseUtil {

    static{

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy-hh-mm-ss");
        System.setProperty("current.date.time", dateFormat.format(new Date()));
    }

    public AndroidDriver<AndroidElement> androidDriver;
    public WebDriverWait wait;
    public final static String objectRepo = Constants.objectRepo;
    public final static String dataSet = Constants.dataSet;
    public YMLReader reader = new YMLReader();
    public static boolean newlog = true;
    public  static Logger logger = LogManager.getLogger(BaseUtil.class);

    public boolean scroll(Integer pix) {
        this.logger.info("Inside Scroll Function: Scrolling by :" + pix.toString());
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
            this.logger.error("Scrolling Failed, Cause :" + e);
            return false;
        }
        return true;
    }

    public void scrollDown() {

        int pressX = androidDriver.manage().window().getSize().width / 2;
        // 4/5 of the screen as the bottom finger-press point
        int bottomY = androidDriver.manage().window().getSize().height * 4 / 5;
        // just non zero point, as it didn't scroll to zero normally
        int topY = androidDriver.manage().window().getSize().height / 8;
        //scroll with TouchAction by itself
        TouchAction touchAction = new TouchAction(androidDriver);
        touchAction.longPress(PointOption.point(pressX, bottomY)).moveTo(PointOption.point(pressX, topY)).release().perform();

    }
    public void scrolldowntofind(String arg0) {
        String xpath = reader.getXPath(arg0, objectRepo);
        while(true){
            scrollDown();
            try {
                MobileElement el = androidDriver.findElementByXPath(xpath);
                el.click();
                return;
            } catch (Exception e) {
                System.out.println("button not found yet");
            }
        }
    }

    public boolean scrolldowntofind_nitin(String xpat) {

        this.logger.info("Scrolling to Find:" + xpat);
        int startX = 550;
        int endX = 550;
        int startY = 1200;
        int endY = 500;
        String xpah = reader.getXPath(xpat, objectRepo);                                            //get xpath of element from object_Repository
        this.logger.info("Xpath Received is :" + xpah);
        try {
            while (this.androidDriver.findElements(By.xpath(xpah)).size()==0) {
                                                                                                   //scroll until element appears
                TouchAction touchAction = new TouchAction(this.androidDriver);
                PointOption pointStart = PointOption.point(startX, startY);                       //starting coordinates
                PointOption pointEnd = PointOption.point(endX, endY);                             //ending coordinates
                WaitOptions waitOption = WaitOptions.waitOptions(Duration.ofMillis(500));         //wait for 0.5 seconds
                touchAction.press(pointStart).waitAction(waitOption).moveTo(pointEnd).release().perform();  //releasing after moving

                Thread.sleep(5000);                                            //get xpath of element from object_Repository
                this.logger.info("Scrolling to get: " + xpah);

            }
            MobileElement el = this.androidDriver.findElementByXPath(xpah);
            el.click();
        } catch (Exception e) {
            this.logger.error("Cannot find Item, Cause :" + e);
            e.printStackTrace();
            return false;
        }
        return true;
    }

//    public boolean scrolldowntofind(String item) {
//
//        int startX = 550;
//        int endX = 550;
//        int startY = 1200;
//        int endY = 500;
//        String xpath = reader.getXPath(item,objectRepo);
//        try {
//            while (this.androidDriver.findElementsByXPath(xpath).size() == 0) {  //scroll until element appears
//                TouchAction touchAction = new TouchAction(this.androidDriver);
//                PointOption pointStart = PointOption.point(startX, startY);     //starting coordinates
//                PointOption pointEnd = PointOption.point(endX, endY);           //ending coordinates
//                WaitOptions waitOption = WaitOptions.waitOptions(Duration.ofMillis(500)); //wait for 0.5 seconds
//                touchAction.press(pointStart).waitAction(waitOption).moveTo(pointEnd).release().perform();  //releasing after moving
//            }
//            MobileElement el = this.androidDriver.findElementByXPath(xpath);
//            el.click();
//        } catch (Exception e) {
//
//            e.printStackTrace();
//            return false;
//        }
//        return true;
//    }

    public boolean tap(String obj) {
        //get xpath of element from object_Repository
        this.logger.info("Element to be tapped :" + obj);
        String xpath = reader.getXPath(obj, objectRepo);                                            //get xpath of element from object_Repository

        this.logger.info("Xpath Received is :" + xpath);
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath))).click();    //wait until element appears on screen and then click

        } catch (Exception e) {                                            //get xpath of element from object_Repository
            this.logger.error("Unable to Tap, Cause :" + e);
            return false;
        }
        return true;
    }

    public boolean sendkeys(String obj, String input) {

        this.logger.info("Entering :" + input + " in Field: "+obj);
        String xpath = reader.getXPath(obj, objectRepo);                          //get xpath of element from object_Repository
        this.logger.info("Xpath received for " + obj + " Field : " + xpath );
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
            MobileElement el = (MobileElement) this.androidDriver.findElementByXPath(xpath); //get element using xpath
            el.sendKeys(input);                                                      //set the element with given input
        } catch (Exception e) {
            this.logger.error("Unable to input, Cause :" + e);
            return false;
        }

        return true;
    }

}
