package tests;

import BaseUrl.JPH_BaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import testDatas.JPH_datas;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class P17_PUT_deSerailizationKullanimi extends JPH_BaseUrl {
     /*
            https://jsonplaceholder.typicode.com/posts/70 url'ine
            asagidaki body’e sahip bir PUT request yolladigimizda
            donen response’in response body’sinin
            asagida verilen ile ayni oldugunu test ediniz
            Request Body
            {
                "title": "Ahmet",
                "body": "Merhaba",
                "userId": 10,
                "id": 70
            }

            Expected Data :
            {
                "title": "Ahmet",
                "body": "Merhaba",
                "userId": 10,
                "id": 70
            }

     */

    @Test
    public void test01(){

        // 1-Endpoint ve Gerekise(3P) request body hazırlanır
        specJPH.pathParams("pp1","70","pp2","posts");
        Map<String, Object> reqMAPBody= JPH_datas.MAPdataOlustur("Ahmet","Merhaba",10.0,70.0);

        // 2-ExpData oluşturulur
        Map<String, Object> expMAPBody=JPH_datas.MAPdataOlustur("Ahmet","Merhaba",10.0,70.0);

        // 3-Response bir obje içine kaydedilir
        Response response=given().contentType(ContentType.JSON).spec(specJPH).when().body(reqMAPBody).put("/{pp2}/{pp1}");
        // put("/{pp2}/{pp1}") içine yazılan değerler soruda verilen endpointteki sıraya göre sisimden bağımsız olarak yazılır

        // Assertion işlemleri yapılır
        Map<String, Object> resMAP=response.as(HashMap.class);

        Assert.assertEquals(resMAP.get("title"),expMAPBody.get("title"));
        Assert.assertEquals(resMAP.get("body"),expMAPBody.get("body"));
        Assert.assertEquals(resMAP.get("userId"),expMAPBody.get("userId"));
        Assert.assertEquals(resMAP.get("id"),expMAPBody.get("id"));

        System.out.println("All Test PASSED");

    }
}
