package api_http_get_request;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.*;

public class Get02 {

    /*
            Given https://restful-booker.herokuapp.com/booking/1001
            When user sends a GET request to the url
            Then HTTP status code should be 404
            And   response body contains "Not Found"
            And status line should be HTTP/1.1 404 Not Found
            And body does not contain "techproed"
            And Server is "Cowboy"
             */
    //Set the url
    //String url = "https://restful-booker.herokuapp.com/booking/1001"

    @Test
    public void get02(){

        //Set the base url
        RequestSpecification spec = new RequestSpecBuilder().setBaseUri("https://restful-booker.herokuapp.com").build();

        //set the url
        spec.pathParams("first", "booking", "second", 101);

        //Set the expected data


        // Send the request and get the response
        Response response = given().spec(spec).when().get("/{first}/{second}");

        response.prettyPrint();


//        //validate the result and do assertions
//        response.then().statusCode(404).statusLine("HTTP/1.1 404 Not Found");
//
//        System.out.println("this is headers:");
//        System.out.println(response.getHeaders());
//
//        System.out.println(response.getHeader("server"));
//        assertEquals("Cowboy", response.getHeader("server"));
//        assertEquals("Not Found",response.asString());
//        assertFalse(response.asString().contains("techproed"));
//        assertTrue(response.asString().contains("Not Found"));
//
//        // assertEquals : compare 2 values and they should be same
//        //assertTrue : one condition expected and it should be tru
//        //assertFalse: one condition checked and it should be false

    }

}
