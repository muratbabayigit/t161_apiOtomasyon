package tests;

import BaseUrl.JPH_BaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import testDatas.JPH_datas;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class P14_TestDataKullanimi extends JPH_BaseUrl {
    /*

     https://jsonplaceholder.typicode.com/posts/22 url’ine bir
    GET request yolladigimizda donen response’in
    status kodunun 200 ve
    response body’sinin asagida verilen ile ayni oldugunu test ediniz
      Response body : (expected data)
    {
        “userId”: 3,
        “id”: 22,
        “title”: “dolor sint quo a velit explicabo quia nam”,
        “body”: “eos qui et ipsum ipsam suscipit aut\nsed omnis non odio\nexpedita earum mollitia molestiae aut atque rem suscipit\nnam impedit esse”
        }

 */
    @Test
    public void TestDataKullanimi(){

        specJPH.pathParams("pp1","posts","pp2","22");
        JSONObject expBody = JPH_datas.expDataOlustur();
        Response response=given().spec(specJPH).when().get("/{pp1}/{pp2}");

        // dönen cevabın body değerleri beklenen cevap değerleri ile karşılaştırılacaksa
        // gelen response muhakkak jSonPath haline çevrilir

        JsonPath resJP= response.jsonPath();
        response.prettyPrint();

        assertEquals(response.getStatusCode(),JPH_datas.basariliDurumKodu);
        assertEquals(resJP.getInt("id"),expBody.getInt("id"));
        assertEquals(resJP.getInt("userId"),expBody.getInt("userId"));
        assertEquals(resJP.getString("title"),expBody.getString("title"));
        assertEquals(resJP.getString("body"),expBody.getString("body"));

    }

    @Test
    public void TestDataKullanimi2(){

        specJPH.pathParams("pp1","posts","pp2","22");
        JSONObject expBody = JPH_datas.expDataolustur2(22,3,"dolor sint quo a velit explicabo quia nam","eos qui et ipsum ipsam suscipit aut\nsed omnis non odio\nexpedita earum mollitia molestiae aut atque rem suscipit\nnam impedit esse");
        Response response=given().spec(specJPH).when().get("/{pp1}/{pp2}");

        // dönen cevabın body değerleri beklenen cevap değerleri ile karşılaştırılacaksa
        // gelen response muhakkak jSonPath haline çevrilir

        JsonPath resJP= response.jsonPath();
        //response.prettyPrint();

        assertEquals(response.getStatusCode(),JPH_datas.basariliDurumKodu);
        assertEquals(resJP.getInt("id"),expBody.getInt("id"));
        assertEquals(resJP.getInt("userId"),expBody.getInt("userId"));
        assertEquals(resJP.getString("title"),expBody.getString("title"));
        assertEquals(resJP.getString("body"),expBody.getString("body"));

    }


}
