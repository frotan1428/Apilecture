package api_http_get_request;

import base_urls.HerokuappBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class Get05 extends HerokuappBaseUrl {


    /*
            Given
                https://restful-booker.herokuapp.com/booking
            When
                User send a request to the URL
            Then
                Status code is 200
            And
               Among the data there should be someone whose firstname is "Jim" and last name is "Jackson"
 */


        @Test
        public void get05(){
            //Set the url
                spec.pathParam("first", "booking").queryParams("firstname", "Jik", "lastname", "Jol");

             //Set the expected data

            // Send the request and get the response
                Response response = given().spec(spec).when().get("/{first}");

                //validate and do assertion
                response.then().statusCode(200);

                response.prettyPrint();




        }










}
