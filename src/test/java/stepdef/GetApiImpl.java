package stepdef;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.junit.Assert;
import steps.GetSteps;

import java.io.FileNotFoundException;

public class GetApiImpl {
    GetSteps getSteps = new GetSteps();

    public GetApiImpl() throws FileNotFoundException {
    }

    @Then("^user should see the status code as \"([^\"]*)\"$")
    public void userShouldSeeTheStatusCodeAs(String statusCode) throws Throwable {
        Assert.assertEquals(Integer.parseInt(statusCode),GetSteps.statusCode);

    }

    @And("^user should see response body$")
    public void userShouldSeeResponseBody() {
        getSteps.getResponseBody();
    }

    @Given("^user calls the get api by passing correct url$")
    public void userCallsTheGetApiByPassingCorrectUrl() throws FileNotFoundException {
        getSteps.callGetApi();
    }

    @Given("^user calls the get api by passing correct url and a specific id \"([^\"]*)\"$")
    public void userCallsTheGetApiByPassingCorrectUrlAndASpecificId(String indexRoute) throws Throwable {
        getSteps.getDetailsOfparticularEmployee(indexRoute);
    }

    @Given("^user calls the get api by passing incorrect url$")
    public void userCallsTheGetApiByPassingIncorrectUrl() throws FileNotFoundException {
        getSteps.callGetApiWithIncorrectUrl();
    }

    @Given("^user calls the get api by passing url with the incorrect method$")
    public void userCallsTheGetApiByPassingUrlWithTheIncorrectMethod() throws FileNotFoundException {
        getSteps.callGetApiWithIncorrectMethod();
    }
}
