package steps;
import com.jayway.restassured.response.Response;
import static com.jayway.restassured.RestAssured.given;
import org.junit.Assert;
import utility.ConfigReader;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GetSteps {

    Response response;
    public static int statusCode;
    public static List listOfIds = new ArrayList();
    String apiUrl=null;
    String route= null;
    ConfigReader configReader = new ConfigReader();
    public static String message=null;

    public GetSteps() throws FileNotFoundException {
    }

    public void callGetApi() throws FileNotFoundException {

        apiUrl= ConfigReader.getapiUrl;
        response = given().contentType("application/json").when().get(apiUrl);
        statusCode= response.getStatusCode();
    }

    public void getResponseBody() {

        Assert.assertEquals("success",response.jsonPath().get("status"));
        for (int i=0;i<response.jsonPath().getList("data").size();i++)
        {
            Map map = (HashMap) response.jsonPath().getList("data").get(i);
            String id= (String) map.get("id");
             listOfIds.add(id);
        }

        System.out.println("Employee Data are available for listed employee id: "+listOfIds);
    }

    public void getDetailsOfparticularEmployee(String indexValueOfEmployeeDetails) throws FileNotFoundException {
        route= indexValueOfEmployeeDetails;
        System.out.println("URL:"+ConfigReader.individualEmployeeGetapiUrl+route);
        response = given().contentType("application/json").when().get(ConfigReader.individualEmployeeGetapiUrl+route);
        System.out.println(response.print());
        statusCode = response.getStatusCode();
        if (listOfIds.contains(indexValueOfEmployeeDetails))
        {
             Assert.assertEquals(200,statusCode) ;
             Assert.assertEquals("success",response.jsonPath().get("status")); 
             Map employeeDetailsMap= response.jsonPath().get("data");
             Assert.assertTrue(employeeDetailsMap.get("id").equals(route));
             Assert.assertTrue(employeeDetailsMap.containsKey("employee_name"));
             Assert.assertTrue(employeeDetailsMap.containsKey("employee_salary"));
             Assert.assertTrue(employeeDetailsMap.containsKey("employee_age"));
             Assert.assertTrue(employeeDetailsMap.containsKey("profile_image"));
        }
        else
        {
           Assert.assertEquals("failed",response.jsonPath().get("status"));
           System.out.println(response.print());
        }

    }

    public void callGetApiWithIncorrectMethod() throws FileNotFoundException {
        apiUrl=ConfigReader.getapiUrl;
        response = given().contentType("application/json").when().post(apiUrl);
        statusCode= response.getStatusCode();
    }

    public void callGetApiWithIncorrectUrl() throws FileNotFoundException {
        apiUrl= ConfigReader.incorrectGetapiUrl;
        response = given().contentType("application/json").when().get(apiUrl);
        statusCode= response.getStatusCode();
    }
}
