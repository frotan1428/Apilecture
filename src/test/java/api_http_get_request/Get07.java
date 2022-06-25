package api_http_get_request;

import base_urls.DummyApiBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;
import org.testng.asserts.SoftAssert;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertEquals;

public class Get07 extends DummyApiBaseUrl {

    /*
        Given
             http://dummy.restapiexample.com/api/v1/employee/7
        When
            I send a GET request to the Url
        Then
            HTTP Status Code should be 200
        And
            Response format should be "application/json"
        And
            Herrod Chandler should be the employee name
        And
            "employee_salary":137500 should be expected salary
        And
           "id":7 should be expected id
     */

    @Test
    public void get07(){

        //Set the url
        spec.pathParams("first","api","second","v1","third","employee", "fourth", 7);

        //Set the expected data

        //Send the request and get the response
        Response response = given().spec(spec).when().get("/{first}/{second}/{third}/{fourth}");


        //validate them
        //1.way of validation
        response.then().statusCode(200).contentType(ContentType.JSON).
                body("data.employee_name", equalTo("Herrod Chandler")).
                body("data.employee_salary", equalTo(137500)).
                body("data.id", equalTo(7));


        //JsonPath
        //2. way of validation

        JsonPath json = response.jsonPath();

        System.out.println(json.getString("data.employee_name"));

        int salary = json.getInt("data.employee_salary");
        System.out.println(salary);

        assertEquals("Herrod Chandler", json.getString("data.employee_name"));
        assertEquals(137500, json.getInt("data.employee_salary"));
        assertEquals(7, json.getInt("data.id"));


                            //Hard assertion  vs Soft assertion
        //Hard assertion: when there is a failure, it stops execution
        //Soft assertion: when there is a failure, it will execute all scenarios and show result of all passing and failing scenarios


        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals("ibrahim", json.getString("data.employee_name"), "This is name validation");
        softAssert.assertEquals(1000, json.getInt("data.employee_salary"), "This is salary validation");
        softAssert.assertEquals(3, json.getInt("data.id"), "This is id validation");


        softAssert.assertAll();

    }




}
