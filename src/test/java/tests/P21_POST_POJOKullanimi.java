package tests;

import BaseUrl.RestFullBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.testng.annotations.Test;
import pojos.Restfull_bookingdatesPojo;
import pojos.Restfull_expPojo;
import pojos.Restfull_reqPojo;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class P21_POST_POJOKullanimi extends RestFullBaseUrl {
    /*
https://restful-booker.herokuapp.com/booking url’ine
asagidaki body’ye sahip bir POST request gonderdigimizde
donen response’un id haric asagidaki gibi oldugunu test edin.
Request body
       {
           “firstname” : “Ahmet”,
           “lastname” : “Bulut”,
           “totalprice” : 500,
           “depositpaid” : false,
           “bookingdates” : {
               “checkin” : “2021-06-01”,
               “checkout” : “2021-06-10”
           },
           “additionalneeds” : “wi-fi”
       }
Response Body // expected data
 {
    “bookingid”: 24,
    “booking”: {
        “firstname”: “Ahmet”,
        “lastname”: “Bulut”,
        “totalprice”: 500,
        “depositpaid”: false,
        “bookingdates”: {
            “checkin”: “2021-06-01",
            “checkout”: “2021-06-10"
        },
        “additionalneeds”: “wi-fi”
    }
}

     */

    @Test
    public void Test01(){

        specJPH.pathParam("pp1","booking");
        Restfull_bookingdatesPojo bookingdatesPojo=new Restfull_bookingdatesPojo("2025-09-01","2025-09-10");
        Restfull_reqPojo reqPOJO=new Restfull_reqPojo("Murat","BABAYİĞİT",1000,true,bookingdatesPojo,"wi-fi");


        Restfull_expPojo expPojo=new Restfull_expPojo(24,reqPOJO);

        Response response =given().contentType(ContentType.JSON).spec(specJPH).when().body(reqPOJO).post("/{pp1}");

        Restfull_expPojo resPOJO=response.as(Restfull_expPojo.class);

        assertEquals(expPojo.getBooking().getFirstname(),resPOJO.getBooking().getFirstname());
        assertEquals(expPojo.getBooking().getLastname(),resPOJO.getBooking().getLastname());
        assertEquals(expPojo.getBooking().getTotalprice(),resPOJO.getBooking().getTotalprice());
        assertEquals(expPojo.getBooking().isDepositpaid(),resPOJO.getBooking().isDepositpaid());
        assertEquals(expPojo.getBooking().getBookingdates().getCheckin(),resPOJO.getBooking().getBookingdates().getCheckin());
        assertEquals(expPojo.getBooking().getBookingdates().getCheckout(),resPOJO.getBooking().getBookingdates().getCheckout());

    }

}
