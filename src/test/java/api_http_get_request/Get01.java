package api_http_get_request;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class Get01 {

    /*
        Given https://restful-booker.herokuapp.com/booking/3 endpoint
        When user sends a GET request to the url
        Then HTTP status code should be 200
        And   content type should be Json
        And status line should be HTTP/1.1 200 OK
 */

    // the primitive way/ not recommended

    @Test
    public void get01(){

        //Set the base url
        // the primitive way/ not recommended
        String url = "https://restful-booker.herokuapp.com/booking/4";

        //Set the expected data


        //Send the request and get the response
        Response response = given().when().get(url);

        response.prettyPrint();


        //do the validation
        response.then().statusCode(200).contentType("application/json");




    }


}
