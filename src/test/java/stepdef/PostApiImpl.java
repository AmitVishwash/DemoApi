package stepdef;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import steps.PostSteps;

import java.io.FileNotFoundException;

public class PostApiImpl {

    PostSteps postSteps = new PostSteps();

    public PostApiImpl() throws FileNotFoundException {
    }


    @And("^user should see posted employee details in the response$")
    public void userShouldSeePostedEmployeeDetailsInTheResponse() {
        postSteps.validateResponseBody();
    }

    @And("^user should see null values in the response$")
    public void userShouldSeeNullValuesInTheResponse() {
        postSteps.validateNullResponseBody();
    }


    @Given("^user calls the post api by passing correct url with the prerequisite body$")
    public void userCallsThePostApiByPassingCorrectUrlWithThePrerequisiteBody() {
        postSteps.callPostApi();
    }

    @Given("^user calls the post api by passing correct url and the body as null$")
    public void userCallsThePostApiByPassingCorrectUrlAndTheBodyAsNull() {
        postSteps.callPostApiWithOutBody();
    }

    @Given("^user calls the post api by passing incorrect url with the prerequisite body$")
    public void userCallsThePostApiByPassingIncorrectUrlWithThePrerequisiteBody() {
        postSteps.callPostApiToIncorrectUrl();
    }

    @Given("^user calls the post api by passing correct url and the prerequisite body but with incorrect method$")
    public void userCallsThePostApiByPassingCorrectUrlAndThePrerequisiteBodyButWithIncorrectMethod() {
        postSteps.callPostApiWithIncorrectMethod();
    }
}
