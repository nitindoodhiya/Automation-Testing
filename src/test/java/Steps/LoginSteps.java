package Steps;

import Base.BaseUtil;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.datatable.DataTable;
import org.testng.Assert;

import java.util.List;

public class LoginSteps extends BaseUtil {

    private BaseUtil base;

    public LoginSteps(BaseUtil base) {
        this.base = base;
    }

    @Given("App is open")
    public void appIsOpen() {
        System.out.println("App Is Open");
    }

    @When("User Clicks on {string}")
    public void userCLicksOnString(String touch) {
        base.tap(touch);
    }

    @Then("User Navigated to Homescreen")
    public void userNavigatedToHomescreen() {
        Assert.assertTrue(base.tap("SEARCH_INPUT_FIELD_BUTTON"));    //we have a successful login or not
    }

    @And("User enters following fields")
    public void userEntersFollowingFields(DataTable dataTable) {
        List<List<String>> data = dataTable.asLists(String.class);
        base.sendkeys(data.get(0).get(0), data.get(0).get(1));          //first argument - element name
                                                                        //second argument - value to be set
    }
}
