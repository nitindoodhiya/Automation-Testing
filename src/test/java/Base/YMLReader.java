package Base;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.offset.PointOption;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.LogManager;


public class BaseUtil {

    static {

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy-hh-mm-ss");
        System.setProperty("current.date.time", dateFormat.format(new Date()));
    }

    public static AndroidDriver<AndroidElement> androidDriver;
    public static WebDriverWait wait;
    public final static String objectRepo = Constants.objectRepo;
    public final static String dataSet = Constants.dataSet;
    public static YMLReader reader = new YMLReader();
    public static boolean newlog = true;
    public static Logger logger = LogManager.getLogger(BaseUtil.class);

    public void scrollDown() {

        int pressX = androidDriver.manage().window().getSize().width * 9/10;
        // 4/5 of the screen as the bottom finger-press point
        int bottomY = androidDriver.manage().window().getSize().height * 5/8;
        // just non zero point, as it didn't scroll to zero normally
        int topY = androidDriver.manage().window().getSize().height / 8;
        //scroll with TouchAction by itself
        logger.info("scrolling down into view");
        TouchAction touchAction = new TouchAction(androidDriver);
        touchAction.press(PointOption.point(pressX, bottomY)).moveTo(PointOption.point(pressX, topY)).release().perform();

    }

    public void scrolldowntofind(String arg0) {
        logger.info("Element to be tapped :" + arg0);
        String xpath = reader.getXPath(arg0, objectRepo);
        logger.info("Xpath Received is :" + xpath);
        while (true) {
            scrollDown();
            try {
                MobileElement el = androidDriver.findElement(By.xpath(xpath));
                el.click();
                return;
            } catch (Exception e) {
                logger.info("Unable to Tap, Cause : Element not visible yet");

            }
        }
    }

    public void userPressEnterKeyforaplphakeys() throws InterruptedException {
        Dimension screenSize = androidDriver.manage().window().getSize();
        //getting bottom right corner coordinates for pressing Enter Key
        PointOption pointStart = PointOption.point(screenSize.getWidth() - 80, screenSize.getHeight() - 80);
        (new TouchAction(androidDriver)).tap(pointStart).perform();
    }
    public void userPressEnterKeyfornumerickeys() throws InterruptedException {
        Dimension screenSize = androidDriver.manage().window().getSize();
        //getting bottom right corner coordinates for pressing Enter Key
        PointOption pointStart = PointOption.point(screenSize.getWidth() - 120, screenSize.getHeight() - 100);
        (new TouchAction(androidDriver)).tap(pointStart).perform();
    }

    public boolean tap(String obj) {
        //get xpath of element from object_Repository
        logger.info("Element to be tapped :" + obj);
        String xpath = reader.getXPath(obj, objectRepo);

        logger.info("Xpath Received is :" + xpath);
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath))).click();    //wait until element appears on screen and then click

        } catch (Exception e) {
            logger.error("Unable to Tap, Cause :" + e);
            return false;
        }
        return true;
    }

    public boolean sendkeys(String obj, String input) {

        logger.info("Entering :" + input + " in Field: " + obj);
        String xpath = reader.getXPath(obj, objectRepo);                          //get xpath of element from object_Repository
        logger.info("Xpath received for " + obj + " Field : " + xpath);
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
            MobileElement el = androidDriver.findElementByXPath(xpath);             //get element using xpath
            el.sendKeys(input);                                                      //set the element with given input
        } catch (Exception e) {
            logger.error("Unable to input, Cause :" + e);
            return false;
        }

        return true;
    }

}
