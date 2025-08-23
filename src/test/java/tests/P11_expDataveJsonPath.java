package tests;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class P11_expDataveJsonPath {
    /*

https://restful-booker.herokuapp.com/booking url’ine
asagidaki body’ye sahip bir POST request gonderdigimizde
donen response’un id haric asagidaki gibi oldugunu test edin.

Request body
      {
        "firstname": "Ahmet",
        "lastname": "Bulut",
        "totalprice": 500,
        "depositpaid": false,
        "bookingdates": {
            "checkin": "2021-06-01",
            "checkout": "2021-06-10"
        },
        "additionalneeds": "wi-fi"
    }

Response Body - Expected Data
 {
    “bookingid”: 24,
    “booking”: {
        "firstname": "Ahmet",
        "lastname": "Bulut",
        "totalprice": 500,
        "depositpaid": false,
        "bookingdates": {
            "checkin": "2021-06-01",
            "checkout": "2021-06-10"
        },
        additionalneeds": "wi-fi"
    }
}

 */
    @Test
    public void test(){
        String url="https://restful-booker.herokuapp.com/booking";
        JSONObject bookindates=new JSONObject();
        bookindates.put("checkin", "2025-08-25");
        bookindates.put("checkout", "2025-08-29");

        JSONObject reqData=new JSONObject();
        reqData.put("firstname","Murat");
        reqData.put("lastname","Babayiğit");
        reqData.put("totalprice",255);
        reqData.put("depositpaid",true);
        reqData.put("bookingdates",bookindates);
        reqData.put("additionalneeds","wifi");

        JSONObject expData=new JSONObject();
        expData.put("bookingid",786);
        expData.put("booking",reqData);

        Response response=given().contentType(ContentType.JSON).when().body(reqData.toString()).post(url);


/*
        {
    “bookingid”: 24,
    “booking”: {
        "firstname": "Ahmet",
        "lastname": "Bulut",
        "totalprice": 500,
        "depositpaid": false,
        "bookingdates": {
            "checkin": "2021-06-01",
            "checkout": "2021-06-10"
        },
        additionalneeds": "wi-fi"
    }

 */

        JsonPath resJP=response.jsonPath();
        assertEquals(expData.getJSONObject("booking").get("firstname"),resJP.get("booking.firstname"));
        System.out.println("Beklenen İsim: "+expData.getJSONObject("booking").get("firstname")+"  -  Gelen Response'daki İsim: "+resJP.get("booking.firstname")+"         Doğrulama gerçekleşti");
        assertEquals(expData.getJSONObject("booking").get("lastname"),resJP.get("booking.lastname"));
        System.out.println("Beklenen Soyisim: "+expData.getJSONObject("booking").get("lastname")+"  -  Gelen Response'daki Soyisim: "+resJP.get("booking.lastname")+"         Doğrulama gerçekleşti");
        assertEquals(expData.getJSONObject("booking").get("totalprice"),resJP.get("booking.totalprice"));
        System.out.println("Beklenen Ücret Bilgisi: "+expData.getJSONObject("booking").get("totalprice")+"  -  Gelen Response'daki Ücret Bilgisi: "+resJP.get("booking.totalprice")+"         Doğrulama gerçekleşti");
        assertEquals(expData.getJSONObject("booking").get("depositpaid"),resJP.get("booking.depositpaid"));
        System.out.println("Beklenen Depoizto Bilgisi: "+expData.getJSONObject("booking").get("depositpaid")+"  -  Gelen Response'daki Depozito Bilgisi: "+resJP.get("booking.depositpaid")+"         Doğrulama gerçekleşti");
        assertEquals(expData.getJSONObject("booking").get("additionalneeds"),resJP.get("booking.additionalneeds"));
        System.out.println("Beklenen Ek Talep Bilgisi: "+expData.getJSONObject("booking").get("additionalneeds")+"  -  Gelen Response'daki Ek Talep Bilgisi: "+resJP.get("booking.additionalneeds")+"         Doğrulama gerçekleşti");

        assertEquals(expData.getJSONObject("booking").getJSONObject("bookingdates").get("checkin"),resJP.get("booking.bookingdates.checkin"));
        System.out.println("Beklenen Giriş Tarihi: "+expData.getJSONObject("booking").getJSONObject("bookingdates").get("checkin")+"  -  Gelen Response'daki Giriş Tarihi: "+resJP.get("booking.bookingdates.checkin")+"         Doğrulama gerçekleşti");
        assertEquals(expData.getJSONObject("booking").getJSONObject("bookingdates").get("checkout"),resJP.get("booking.bookingdates.checkout"));
        System.out.println("Beklenen Çıkış Tarihi: "+expData.getJSONObject("booking").getJSONObject("bookingdates").get("checkout")+"  -  Gelen Response'daki Çıkış Tarihi: "+resJP.get("booking.bookingdates.checkout")+"         Doğrulama gerçekleşti");

        System.out.println("All Tests PASSED");










    }



}
