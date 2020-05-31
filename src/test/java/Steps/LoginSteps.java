package Steps;

import Base.BaseUtil;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.datatable.DataTable;

import java.util.List;

public class LoginSteps extends BaseUtil{

    private BaseUtil base;

    public LoginSteps(BaseUtil base) {
        this.base = base;
    }

    @Given("App is open")
    public void appIsOpen() {
        System.out.println("App Is Open");
    }

    @When("User Clicks on {string}")
    public void userCLicksOnString(String touch) throws InterruptedException {
        base.tap(touch);
    }

    @Then("User Navigated to Homescreen")
    public void userNavigatedToHomescreen() {
        String activity = base.androidDriver.currentActivity();
        System.out.println(activity);
        Thread.sleep(5000);
    }

    @And("User enters following fields")
    public void userEntersFollowingFields(DataTable dataTable) throws InterruptedException {
        List<List<String>> data = dataTable.asLists(String.class);
        System.out.println(data.get(0).get(0));
        base.sendkeys(data.get(0).get(0),data.get(0).get(1));
      }
}
