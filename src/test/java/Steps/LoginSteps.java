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
        Thread.sleep(2000);
        base.tap(touch);
    }

    @And("User Picks up from")
    public void userPicksUpDatasetFrom(DataTable dataTable) throws InterruptedException {
        Thread.sleep(2000);

        List<List<String>> list = dataTable.asLists(String.class);
        System.out.println(list.get(0).get(0));
        System.out.println(list.get(1).get(0));

    }

    @And("user enters {string} into {string}")
    public void userEntersInto(String arg0, String arg1) {

    }


    @Then("User Navigated to Homescreen")
    public void userNavigatedToHomescreen() {
    }

    @And("User enters following fields")
    public void userEntersFollowingFields(DataTable dataTable) throws InterruptedException {
        Thread.sleep(2000);

        List<List<String>> data = dataTable.asLists(String.class);
        System.out.println(data.get(0).get(0));
        base.sendkeys(data.get(0).get(0),data.get(0).get(1));
    }
}
