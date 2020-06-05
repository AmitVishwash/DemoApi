package stepdef;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import org.junit.Assert;
import steps.GetSteps;
import steps.PutSteps;

import java.io.FileNotFoundException;

public class PutApiImpl {
    PutSteps putSteps= new PutSteps();

    public PutApiImpl() throws FileNotFoundException {
    }

    @Given("^user calls the put api by passing correct url with the prerequisite body$")
    public void userCallsThePutApiByPassingCorrectUrlWithThePrerequisiteBody() {
        putSteps.callUpdateApiWithBody();
    }

    @And("^user should see updated employee details in the response$")
    public void userShouldSeeUpdatedEmployeeDetailsInTheResponse() {
        putSteps.validateUpdatedRecords();
    }

    @Given("^user calls the put api by passing correct url with the prerequisite body appending the id which is not in database$")
    public void userCallsThePutApiByPassingCorrectUrlWithThePrerequisiteBodyAppendingTheIdWhichIsNotInDatabase() {
        putSteps.callUpdateApiForRecordNotFound();
    }

    @And("^user should see message \"([^\"]*)\" in the response$")
    public void userShouldSeeMessageInTheResponse(String recordNotFoundMessage) throws Throwable {
        Assert.assertEquals(recordNotFoundMessage, GetSteps.message);

    }

    @Given("^user calls the put api by passing incorrect url with the prerequisite body$")
    public void userCallsThePutApiByPassingIncorrectUrlWithThePrerequisiteBody() {
        putSteps.callUpdateApiWithIncorrectUrl();

    }

    @Given("^user calls the put api by passing correct url with the prerequisite body but the wrong method type$")
    public void userCallsThePutApiByPassingCorrectUrlWithThePrerequisiteBodyButTheWrongMethodType() {
        putSteps.callUpdateApiWithIncorrectMethodType();
    }
}
