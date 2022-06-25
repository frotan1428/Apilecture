package api_http_get_request;

import base_urls.DummyApiBaseUrl;
import io.restassured.response.Response;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Test;
import pojos.Employee;

import java.io.IOException;

import static io.restassured.RestAssured.given;

public class Get10 extends DummyApiBaseUrl {


    /*
      When
        I send a GET Request to the URL http://dummy.restapiexample.com/api/v1/employees
       Status code should be 200
       Use Gson and ObjectMapper
       make sure you have 24 records for data
  */


    @Test
    public void get10() throws IOException {
        //Set the url
        spec.pathParams("first", "api", "second", "v1", "third", "employees");


        //Send the request and get the response
        Response response = given().spec(spec).when().get("/{first}/{second}/{third}");


        //validate all
        ObjectMapper obj = new ObjectMapper();// translator

        Employee employee = obj.readValue(response.asString(),Employee.class );

        System.out.println(employee.getMessage());
        System.out.println(employee.getStatus());
        System.out.println(employee.getData().size());

        for (int i = 0; i <employee.getData().size() ; i++) {

            System.out.println("name " + (i + 1) +" : "+employee.getData().get(i).getEmployee_name());
            System.out.println("age " + (i + 1) +" : "+employee.getData().get(i).getEmployee_age());

        }

    }
}
