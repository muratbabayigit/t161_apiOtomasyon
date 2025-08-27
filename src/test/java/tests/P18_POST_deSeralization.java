package tests;

import BaseUrl.RestFullBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.testng.annotations.Test;
import testDatas.RestFull_datas;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class P18_POST_deSeralization extends RestFullBaseUrl {


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
    public void test01(){
        specJPH.pathParam("pp1","booking");
        Map<String, Object> reqMapBody= RestFull_datas.reqMapDataOlustur();

        Map<String,Object> expMapBody=RestFull_datas.expMapDataOlustur();

        Response response=given().contentType(ContentType.JSON).spec(specJPH).when()
                .body(reqMapBody).post("/{pp1}");

        Map<String,Object> resMAP=response.as(HashMap.class);


        // expMapBody.get("booking") bir jsondata döndürecek onun içindeki firstname verisine ulaşmak için
        // dönen veriyi map'e cast etmemiz lazım (Map)expMapBody.get("booking")

       assertEquals(((Map)expMapBody.get("booking")).get("firstname"), ((Map)resMAP.get("booking")).get("firstname"));
       assertEquals(((Map)expMapBody.get("booking")).get("lastname"), ((Map)resMAP.get("booking")).get("lastname"));
       assertEquals(((Map)expMapBody.get("booking")).get("totalprice"), ((Map)resMAP.get("booking")).get("totalprice"));
       assertEquals(((Map)expMapBody.get("booking")).get("depositpaid"), ((Map)resMAP.get("booking")).get("depositpaid"));
       assertEquals(((Map)expMapBody.get("booking")).get("additionalneeds"), ((Map)resMAP.get("booking")).get("additionalneeds"));
       assertEquals(((Map)((Map)expMapBody.get("booking")).get("bookingdates")).get("checkin"),((Map)((Map)resMAP.get("booking")).get("bookingdates")).get("checkin"));
       assertEquals(((Map)((Map)expMapBody.get("booking")).get("bookingdates")).get("checkout"),((Map)((Map)resMAP.get("booking")).get("bookingdates")).get("checkout"));



    }
}
