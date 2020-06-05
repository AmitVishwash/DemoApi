package steps;

import com.jayway.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import utility.ConfigReader;
import static com.jayway.restassured.RestAssured.given;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

public class PutSteps {
    Response response;
    public static String apiUrl=null;
    ConfigReader configReader = new ConfigReader();
    public static int idToBeUpdated;
    JSONObject updateContentJson = new JSONObject();

    public PutSteps() throws FileNotFoundException {
    }


    public void callUpdateApiWithBody() {
        apiUrl=ConfigReader.putUrl;
        idToBeUpdated=11;
        setUpdateContent();
        System.out.println(apiUrl+idToBeUpdated);
        response=given().contentType("application/json").body(updateContentJson.toString()).when().put(apiUrl+idToBeUpdated);
        GetSteps.statusCode= response.getStatusCode();
    }

    private void setUpdateContent() {
        updateContentJson.put("name","test1");
        updateContentJson.put("salary","1123");
        updateContentJson.put("age","28");

    }

    public void validateUpdatedRecords() {
        HashMap responseMap = response.jsonPath().getJsonObject("data");
        System.out.println(response.print());
        Assert.assertEquals(idToBeUpdated,Integer.parseInt((String) responseMap.get("id")));
        Assert.assertEquals(updateContentJson.get("name"),responseMap.get("employee_name"));
        Assert.assertEquals(updateContentJson.get("salary"),responseMap.get("employee_salary"));
        Assert.assertEquals(updateContentJson.get("age"),responseMap.get("employee_age"));

    }

    public void callUpdateApiForRecordNotFound() {
        apiUrl=ConfigReader.putUrl;
        idToBeUpdated=110;
        setUpdateContent();
        System.out.println("Id to be updated is "+idToBeUpdated);
        System.out.println(apiUrl+idToBeUpdated);
        response=given().contentType("application/json").body(updateContentJson.toString()).when().put(apiUrl+idToBeUpdated);
        GetSteps.statusCode= response.getStatusCode();
        GetSteps.message=response.print();
    }

    public void callUpdateApiWithIncorrectUrl() {
        apiUrl=ConfigReader.incorrectPutUrl;
        setUpdateContent();
        response=given().contentType("application/json").body(updateContentJson.toString()).when().put(apiUrl+idToBeUpdated);
        GetSteps.statusCode= response.getStatusCode();
    }

    public void callUpdateApiWithIncorrectMethodType() {
        apiUrl=ConfigReader.putUrl;
        setUpdateContent();
        response=given().contentType("application/json").body(updateContentJson.toString()).when().get(apiUrl+idToBeUpdated);
        GetSteps.statusCode= response.getStatusCode();
    }
}
