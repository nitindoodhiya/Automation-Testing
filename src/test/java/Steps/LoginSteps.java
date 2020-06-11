package Steps;

import Base.BaseUtil;
import io.appium.java_client.touch.offset.PointOption;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.datatable.DataTable;
import org.apache.log4j.PropertyConfigurator;
import io.appium.java_client.TouchAction;
import org.junit.Assert;

import java.io.IOException;
import java.util.List;

public class LoginSteps  {

    private BaseUtil base;

    public LoginSteps(BaseUtil base) {

        this.base = base;
    }

    @Given("App is open")
    public void appIsOpen() {
        base.logger.info("App Should have opened");
    }

    @When("User Clicks on {string}")
    public void userCLicksOnString(String touch) {
        base.logger.info("User to click on: "+ touch);
        base.tap(touch);
    }

    @Then("User Navigated to Homescreen")
    public void userNavigatedToHomescreen() {

        base.logger.info("User navigated to HomeScreen ");
        base.tap("SEARCH_INPUT_FIELD_BUTTON");
    }

    @And("User enters following fields")
    public void userEntersFollowingFields(DataTable dataTable) {
        List<List<String>> data = dataTable.asLists(String.class);
        base.sendkeys(data.get(0).get(0), data.get(0).get(1));          //first argument - element name
                                                                        //second argument - value to be set
    }

    @And("User enters in {string} from {string}")
    public void userEntersInFrom(String field, String input) {

        base.sendkeys(field,base.reader.getInfo(input,field,base.dataSet));
    }


    @And("User search for another product")
    public void userSearchForAnotherProduct(DataTable dataTable) throws InterruptedException {
        List<List<String>>data=dataTable.asLists(String.class);
        for(int ind=0;ind<data.size();ind++)
        {
            base.tap(data.get(ind).get(0)); //user clicked on SEARCH_BAR
            base.tap(data.get(ind).get(1)); //user clicked on SEARCH_TAP
            base.sendkeys(data.get(ind).get(1),data.get(ind).get(2)); //user searched for product
            Thread.sleep(5000);

            PointOption pointStart = PointOption.point(984, 1992); //User pressed enter key
            (new TouchAction(base.androidDriver)).tap(pointStart).perform();
            Thread.sleep(5000);

            base.tap(data.get(ind).get(3)); // user taps on first element
            Thread.sleep(5000);
            base.scrolldowntofind(data.get(ind).get(4));//user adds to cart
            Thread.sleep(5000);
        }

    }

    @And("User enters {string} in {string}")
    public void userEntersIn(String item, String box) throws InterruptedException {
        base.sendkeys(box,item);
        Thread.sleep(500);

    }
}
