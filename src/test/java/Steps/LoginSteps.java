package Steps;

import Base.BaseUtil;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.datatable.DataTable;
import org.junit.Assert;

import java.util.List;

public class LoginSteps {

    private final BaseUtil base;

    public LoginSteps(BaseUtil base) {

        this.base = base;
    }

    @Given("App is open")
    public void appIsOpen() {

        BaseUtil.logger.info("App Should have opened");
    }

    @When("User Clicks on {string}")
    public void userCLicksOnString(String touch) {
        BaseUtil.logger.info("User to click on: " + touch);
        base.tap(touch);
    }

    @Then("User Navigated to Homescreen")
    public void userNavigatedToHomescreen() {

        BaseUtil.logger.info("User navigated to HomeScreen ");
        Assert.assertTrue(base.tap("SEARCH_INPUT_FIELD_BUTTON"));
    }

    @And("User enters following fields")
    public void userEntersFollowingFields(DataTable dataTable) {
        List<List<String>> data = dataTable.asLists(String.class);
        base.sendkeys(data.get(0).get(0), data.get(0).get(1));          //first argument - element name
                                                                        //second argument - value to be set
    }

    @And("User enters in {string} from {string}")
    public void userEntersInFrom(String field, String input) {

        base.sendkeys(field, BaseUtil.reader.getInfo(input, field, BaseUtil.dataSet));
    }


    @And("User search for these prime products and add them to cart")
    public void userSearchForAnotherProduct(DataTable dataTable) throws InterruptedException {

        List<List<String>> data = dataTable.asLists(String.class);
        for (int ind = 0; ind < data.size(); ind++) {

            base.tap(data.get(ind).get(1));                                 //user clicked on SEARCH_TAP
            base.sendkeys(data.get(ind).get(1), data.get(ind).get(2));       //user searched for product
            Thread.sleep(2000);                                        //waiting for keyboard to visible
            base.userPressEnterKeyforaplphakeys();                                       //user press enter key

            //selecting only prime products
            base.tap("PRIME_PRODUCT");
            Thread.sleep(3000);

            base.tap(data.get(ind).get(3));

                // user taps on first element
            Thread.sleep(4000);                                         //waiting for product page to visible
            base.scrolldowntofind(data.get(ind).get(4));                    //user adds to cart
            Thread.sleep(10000);
            if (ind != data.size() - 1)
                base.tap(data.get(ind).get(0));                             //user clicked on SEARCH_BAR
            else
                BaseUtil.logger.info("Done adding to cart");
        }

    }

    @And("User enters {string} in {string}")
    public void userEntersIn(String item, String box) throws InterruptedException {
        base.sendkeys(box, item);
        base.userPressEnterKeyfornumerickeys();
        Thread.sleep(500);

    }
}
