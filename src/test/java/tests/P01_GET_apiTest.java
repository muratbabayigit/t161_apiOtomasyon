package tests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;


public class P01_GET_apiTest {
    /*
        https://restful-booker.herokuapp.com/booking/10 url’ine
       bir GET request gonderdigimizde donen Response’un,
         status code’unun 200,
        ve content type’inin application/json; charset=utf-8,
        ve Server isimli Header’in degerinin Heroku,
        ve status Line’in HTTP/1.1 200 OK
        ve response suresinin 5 sn’den kisa oldugunu manuel olarak test ediniz.

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
        // 1- Endpoint ve Gerekiyorsa(3P) requestData hazırlanır
        String url = "https://restful-booker.herokuapp.com/booking/10";

        // 2- Eğer verilmiş ise ExpectedData hazırlanır
        // Soruda verilmemiş

        // 3- Dönen Response kullanılmak için bir obje içine kaydedilir
            Response response = given().when().get(url);
        //  Response response= RestAssured.get(url);

         response.prettyPrint();
        // response.prettyPeek();

        System.out.println("Status Code: "+response.getStatusCode());
        System.out.println("Content-Type: "+response.getContentType());
        System.out.println("Server Header: "+response.getHeader("Server"));
        System.out.println("Status Line: "+response.getStatusLine());
        System.out.println("Proses Time (ms): "+response.getTime());



    }
}
