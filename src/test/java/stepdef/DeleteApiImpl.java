package stepdef;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.junit.Assert;
import steps.DeleteSteps;
import steps.GetSteps;

import java.io.FileNotFoundException;

public class DeleteApiImpl {
    DeleteSteps deleteSteps = new DeleteSteps();

    public DeleteApiImpl() throws FileNotFoundException {
    }

    @Given("^user calls the delete api by passing correct url and the specific index$")
    public void userCallsTheDeleteApiByPassingCorrectUrlAndTheSpecificIndex() {
        deleteSteps.callDeleteApiByPassingSpecificId();
    }

    @And("^user should see message as \"([^\"]*)\"$")
    public void userShouldSeeMessageAs(String expectedMessage) throws Throwable {
        Assert.assertEquals(expectedMessage, GetSteps.message);

    }

    @Then("^the deleted id should not be in the list$")
    public void theDeletedIdShouldNotBeInTheList() {
        deleteSteps.validateDeletedItems();
    }

    @Given("^user calls the delete api by passing incorrect url$")
    public void userCallsTheDeleteApiByPassingIncorrectUrl() {
        deleteSteps.callDeleteApiWithIncorrectEndpoint();
    }

    @Given("^user calls the get api by passing correct url and incorrect method$")
    public void userCallsTheGetApiByPassingCorrectUrlAndIncorrectMethod() {
        deleteSteps.callDeleteApiWithIncorrectMethod();
    }

}
