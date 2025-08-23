package tests;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class P10_GET_expectedDataOlusturma {
    /*

        https://jsonplaceholder.typicode.com/posts/22 url’ine
        bir GET request yolladigimizda donen response body’sinin
         asagida verilen ile ayni oldugunu test ediniz

              Response body :(EXPECTED DATA)
            {
                “userId”: 3,
                “id”: 22,
                “title”: "dolor sint quo a velit explicabo quia nam",
                “body”: "eos qui et ipsum ipsam suscipit aut\nsed omnis non odio\nexpedita
                earum mollitia molestiae aut atque rem suscipit\nnam impedit esse"
            }

 */

    @Test
    public void test(){
        // 1- EndPoint ve gerekiyorsa(3P) reqData hazırlama
       String url="https://jsonplaceholder.typicode.com/posts/22";

        // 2-Soruda verilmişse expData Hazırlama
       JSONObject expData=new JSONObject();
       expData.put("userId",3);
       expData.put("id",22);
       expData.put("title","dolor sint quo a velit explicabo quia nam");
       expData.put("body","eos qui et ipsum ipsam suscipit aut\nsed omnis non odio\nexpedita ear" +
                "um mollitia molestiae aut atque rem suscipit\nnam impedit esse");

        // 3-Response kaydetme işlemi
       Response response= RestAssured.get(url);

        //4- Assertions işlemleri yapılır
        // bu gibi sorularda yani beklenen data ile gelen data assert edilecekse
        // gelen veri obje olduğundan dolayı jsonPath'e dönüştürülür
       JsonPath resJP=response.jsonPath();

       assertEquals(response.getStatusCode(),200);
       assertEquals(expData.get("userId"),resJP.get("userId"));
       assertEquals(expData.get("id"),resJP.get("id"));
       assertEquals(expData.get("title"),resJP.get("title"));
       assertEquals(expData.get("body"),resJP.get("body"));

        System.out.println("All Tests PASSED");

    }
}
