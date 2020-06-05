package steps;

import com.jayway.restassured.response.Headers;
import com.jayway.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import utility.ConfigReader;
import static  com.jayway.restassured.RestAssured.given;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

public class DeleteSteps {
    Response response;
    public  static  String apiUrl=null;
    public static int employeeIdToBeDeleted;
    Map map = new HashMap<>();
    ConfigReader configReader = new ConfigReader();


    public DeleteSteps() throws FileNotFoundException {
    }

    public void callDeleteApiByPassingSpecificId() {
        apiUrl= ConfigReader.correctDeleteApiUrl;
        employeeIdToBeDeleted=22;
        System.out.println("Employee id to be deleted: "+employeeIdToBeDeleted);
        System.out.println(apiUrl+employeeIdToBeDeleted);
        response= given().contentType("application/json").when().delete(apiUrl+employeeIdToBeDeleted);
        GetSteps.statusCode= response.getStatusCode();
        System.out.println(response.print());
    }



    public void validateDeletedItems() {
        Assert.assertTrue("Employee id deleted was "+employeeIdToBeDeleted+" and the list of ID's after delete operation are "+GetSteps.listOfIds,!GetSteps.listOfIds.contains(employeeIdToBeDeleted));
    }

    public void callDeleteApiWithIncorrectEndpoint() {
        apiUrl=ConfigReader.incorrectDeleteApiUrl;
        response=given().contentType("application/json").when().delete(apiUrl);
        GetSteps.statusCode=  response.getStatusCode();
    }

    public void callDeleteApiWithIncorrectMethod() {
        apiUrl= ConfigReader.correctDeleteApiUrl;
        employeeIdToBeDeleted=22;
        System.out.println("Employee id to be deleted: "+employeeIdToBeDeleted);
        response= given().contentType("application/json").when().post(apiUrl+employeeIdToBeDeleted);
        GetSteps.statusCode= response.getStatusCode();
        System.out.println(response.getStatusLine());
    }

    public void calldeleteApi() {
        response=given().when().contentType("application/json").delete("http://dummy.restapiexample.com/api/v1/delete/110");
        System.out.println(response.print());
    }
}
