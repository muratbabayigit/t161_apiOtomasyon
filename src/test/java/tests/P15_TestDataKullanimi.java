package tests;

import BaseUrl.JPH_BaseUrl;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import testDatas.JPH_datas;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class P15_TestDataKullanimi extends JPH_BaseUrl {
    /*
    https://jsonplaceholder.typicode.com/posts/70 url’ine asagidaki body’e sahip
    bir PUT request yolladigimizda donen response’in
    status kodunun 200, content type’inin “application/json; charset=utf-8”,
    Connection header degerinin “keep-alive”
    ve response body’sinin asagida verilen ile ayni oldugunu test ediniz
    Request Body
        {
            “title”: “Ahmet”,
            “body”: “Merhaba”,
            “userId”: 7,
            “id”: 70
        }
   Response Body
              {
            “title”: “Ahmet”,
            “body”: “Merhaba”,
            “userId”: 7,
            “id”: 70
        }
 */
    @Test
    public void test01(){
       // 1- Endpoint oluşturma ve Gerekiyorsa(3P) request body oluşturma
        specJPH.pathParams("pp1","posts","pp2","70");
        JSONObject reqBody= JPH_datas.dataCreate("Ahmet","Merhaba",7,70);
       // 2- ExpBody oluşturma
       JSONObject expBody=JPH_datas.dataCreate("Ahmet","Merhaba",7,70);

       // 3-Response değerini kaydetmek
        Response response=given().contentType(ContentType.JSON).spec(specJPH).when().body(reqBody.toString()).put("/{pp1}/{pp2}");;

       // 4-Assertion işlemleri yapılır
       JsonPath resJP= response.jsonPath();

        assertEquals(response.getStatusCode(),JPH_datas.basariliDurumKodu);
        assertEquals(resJP.getString("title"),expBody.getString("title"));
        assertEquals(resJP.getString("body"),expBody.getString("body"));
        assertEquals(resJP.getInt("id"),expBody.getInt("id"));
        assertEquals(resJP.getInt("userId"),expBody.getInt("userId"));

        System.out.println("All tests PASSED");


    }

}
