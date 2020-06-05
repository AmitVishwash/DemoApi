package steps;

import com.jayway.restassured.response.Response;
import gherkin.deps.com.google.gson.JsonObject;
import org.json.JSONObject;
import org.junit.Assert;
import utility.ConfigReader;

import java.io.FileNotFoundException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import static com.jayway.restassured.RestAssured.given;

public class PostSteps {
    Response response;
    JSONObject json = new JSONObject();

    public  static  String apiUrl=null;
    ConfigReader configReader = new ConfigReader();

    public PostSteps() throws FileNotFoundException {
    }

    public void callPostApi() {
        apiUrl=ConfigReader.postApiUrl;
        setBody();
        response = given().contentType("application/json").body(json.toString()).when().post(apiUrl);
        GetSteps.statusCode= response.getStatusCode();
    }

    private void setBody() {

        json.put("name","Amit");
        json.put("salary","123456");
        json.put("age","28");

    }

    public void validateResponseBody() {
        HashMap map = response.jsonPath().getJsonObject("data");

        System.out.println("Employee Data created with the id:"+map.get("id")+ " and details are: "+map);
        map.remove("id");
        Assert.assertEquals(json.toMap(),map);

    }

    public void callPostApiWithOutBody() {
        apiUrl=ConfigReader.postApiUrl;
        response = given().contentType("application/json").body(json.toString()).when().post(apiUrl);
        GetSteps.statusCode= response.getStatusCode();
    }



    public void validateNullResponseBody() {
        HashMap map = response.jsonPath().getJsonObject("data");
        Assert.assertEquals(null,map.get("name"));
        Assert.assertEquals(null,map.get("salary"));
        Assert.assertEquals(null,map.get("age"));
        System.out.println("Employee Data created with the id:"+map.get("id")+ " and details are: "+map);
    }

    public void callPostApiWithIncorrectMethod() {
        apiUrl=ConfigReader.postApiUrl;
        setBody();
        response = given().contentType("application/json").body(json.toString()).when().get(apiUrl);
        GetSteps.statusCode= response.getStatusCode();
    }

    public void callPostApiToIncorrectUrl() {
        apiUrl=ConfigReader.incorrectPostApiUrl;
        response = given().contentType("application/json").body(json.toString()).when().post(apiUrl);
        GetSteps.statusCode= response.getStatusCode();
    }
}
