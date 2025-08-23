package tests;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class P09_POST_JsonPathileTest {
    /*
        https://restful-booker.herokuapp.com/booking url’ine asagidaki body’ye sahip
        bir POST request gonderdigimizde
      {
           “firstname” : “Ahmet”,
           “lastname” : “Bulut”,
           “totalprice” : 500,
           “depositpaid” : false,
           “bookingdates” : {
               "checkin" : "2021-06-01",
               "checkout" : "2021-06-10"
                            },
           “additionalneeds” : “wi-fi”
       }
donen Response’un,
status code’unun 200,
 ve content type’inin application/json,
 ve response body’sindeki
       “firstname”in,“Ahmet”,
       ve “lastname”in, “Bulut”,
   ve “totalprice”in,500,
   ve “depositpaid”in,false,
   ve “checkin” tarihinin 2021-06-01
   ve “checkout” tarihinin 2021-06-10
   ve “additionalneeds”in,“wi-fi”
   oldugunu test edin
  */

    @Test
    public void test(){
        String url="https://restful-booker.herokuapp.com/booking";
        JSONObject bookingdates=new JSONObject();
        bookingdates.put("checkin" , "2025-08-25");
        bookingdates.put("checkout" , "2025-08-29");

        JSONObject reqData=new JSONObject();
        reqData.put("firstname","Murat");
        reqData.put("lastname","Babayiğit");
        reqData.put("totalprice",3355);
        reqData.put("depositpaid",false);
        reqData.put("bookingdates",bookingdates);
        reqData.put("additionalneeds","wifi,midnigth snack");

        Response response=given().contentType(ContentType.JSON).when().body(reqData.toString()).post(url);
        //response.prettyPrint();


        //Assertion İşlemi


        response.then().assertThat().statusCode(200).contentType("application/json")
                .body("booking.firstname", equalTo("Murat"),
                        "booking.lastname",equalTo("Babayiğit"),
                        "booking.totalprice",equalTo(3355),
                        "booking.depositpaid",equalTo(false),
                        "booking.bookingdates.checkin",equalTo("2025-08-25"),
                        "booking.bookingdates.checkout",equalTo("2025-08-29"));


        System.out.println("All Tests PASSED");
    }


}
