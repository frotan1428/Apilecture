package api_http_get_request;

import base_urls.HerokuappBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;


public class Get09 extends HerokuappBaseUrl {


    /*
        When
            I send GET Request to https://restful-booker.herokuapp.com/booking/1
        Then
            Response body should be like that;
            {
                "firstname": "Susan", => String
                "lastname": "Ericsson", => String
                "totalprice": 564, => int
                "depositpaid": false, boolean
                "bookingdates": {
                    "checkin": "2018-08-19",
                    "checkout": "2021-06-20"
                 }
            }
     */
    @Test
    public void get09(){

        //Set the url
        spec.pathParams("first", "booking", "second", 100);

        //Set the expected data
        Map<String, Object> bookingdates = new HashMap<>();
        bookingdates.put("checkin", "2019-05-16");
        bookingdates.put("checkout", "2019-05-16");


        Map<String, Object> expectedData = new HashMap<>();
        expectedData.put("firstname", "Michael");
        expectedData.put("lastname", "%date:~4,2%%date:~7,2%%date:~10,4%_%time:~0,2%%time:~3,2%%time:~6,2%");
        expectedData.put("totalprice", 111);
        expectedData.put("depositpaid", true);
        expectedData.put("bookingdates", bookingdates);



        //Send the request and get the response
        Response response = given().spec(spec).when().get("/{first}/{second}");

        Map<String,Object> actualData = response.as(HashMap.class);




        //Validate all

        assertEquals(expectedData.get("firstname"), actualData.get("firstname"));
        assertEquals(expectedData.get("lastname"), actualData.get("lastname"));
        assertEquals(expectedData.get("totalprice"), actualData.get("totalprice"));
        assertEquals(expectedData.get("depositpaid"), actualData.get("depositpaid"));

        assertEquals(bookingdates.get("checkin"), ((Map)actualData.get("bookingdates")).get("checkin"));
        assertEquals(bookingdates.get("checkout"), ((Map)actualData.get("bookingdates")).get("checkout"));






    }


}
