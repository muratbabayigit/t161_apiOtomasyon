package tests;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class P04_PUT_apiTest {
        /*
            https://jsonplaceholder.typicode.com/posts/70 url’ine
             asagidaki Json formatindaki body ile bir PUT request gonderdigimizde
            {
                "title": "Ahmet",
                "body": "Merhaba",
                "userId": 10,
                "id": 70
            }
            donen Response’un,
             status code’unun 200,
             ve content type’inin application/json; charset=utf-8,
             ve Server isimli Header’in degerinin cloudflare,
             ve status Line’in HTTP/1.1 200 OK
   */

    /*
        Tüm API testlerinde 4 aşamada işlem yapacağız
            1- Endpoint ve Gerekiyorsa requestData hazırlanır
            2- Eğer verilmiş ise ExpectedData hazırlanır
            3- Dönen Response kullanılmak için bir obje içine kaydedilir
            4- Assertion işlemleri yapılır
 */
    @Test
    public void test01() {

        //1- Endpoint ve Gerekiyorsa(POST-PUT-PATCH) requestData hazırlanır
        String url = "https://jsonplaceholder.typicode.com/posts/70";
        JSONObject reqData=new JSONObject();
        reqData.put("title", "Ahmet");
        reqData.put("body", "Merhaba");
        reqData.put("userId",10);
        reqData.put("id",70);

        // 2- Eğer verilmiş ise ExpectedData hazırlanır
                    // soruda verilmemiş

        // 3- Dönen Response kullanılmak için bir obje içine kaydedilir
        Response response=given().contentType(ContentType.JSON).when().body(reqData.toString()).put(url);

        // 4-Assertion İşlemleri yapılır
        response.then().assertThat().statusCode(200)
                                    .contentType("application/json; charset=utf-8")
                                    .statusLine("HTTP/1.1 200 OK")
                                    .header("Server","cloudflare");

        System.out.println("All Tests Passed");
    }
}
