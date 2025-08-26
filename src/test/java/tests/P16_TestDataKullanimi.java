package tests;

import BaseUrl.RestFullBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import testDatas.RestFull_datas;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class P16_TestDataKullanimi extends RestFullBaseUrl {
    /*
       https://restful-booker.herokuapp.com/booking url’ine asagidaki body’ye sahip
        bir POST request gonderdigimizde donen response’un
        id haric asagidaki gibi oldugunu test edin.

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
        Response Body(expData)
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
    public void test02(){
        specJPH.pathParam("pp1","booking");
        JSONObject reqBody= RestFull_datas.reqDataOlustur();

        JSONObject expBody=RestFull_datas.expDataOlustur(1224,reqBody);

        Response response=given().contentType(ContentType.JSON).spec(specJPH).when().body(reqBody.toString()).post("/{pp1}");

        //response.prettyPrint();
        JsonPath resJP=response.jsonPath();

        assertEquals(resJP.get("booking.firstname"),expBody.getJSONObject("booking").getString("firstname"));
        assertEquals(resJP.get("booking.lastname"),expBody.getJSONObject("booking").getString("lastname"));
        assertEquals(resJP.get("booking.totalprice"),expBody.getJSONObject("booking").get("totalprice"));
        assertEquals(resJP.get("booking.depositpaid"),expBody.getJSONObject("booking").get("depositpaid"));
        assertEquals(resJP.get("booking.additionalneeds"),expBody.getJSONObject("booking").getString("additionalneeds"));
        assertEquals(resJP.get("booking.bookingdates.checkin"),expBody.getJSONObject("booking").getJSONObject("bookingdates").getString("checkin"));
        assertEquals(resJP.get("booking.bookingdates.checkout"),expBody.getJSONObject("booking").getJSONObject("bookingdates").getString("checkout"));



    }
}
