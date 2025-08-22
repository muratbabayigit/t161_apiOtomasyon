package tests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

public class P02_GET_apiOtomasyon {
/*
    https://restful-booker.herokuapp.com/booking/10 url’ine
    bir GET request gonderdigimizde donen Response’un,
 	status code’unun 200,
	ve content type’inin application/json; charset=utf-8,
	ve Server isimli Header’in degerinin Cowboy,
	ve status Line’in HTTP/1.1 200 OK
	oldugunu otomasyonla assert ediniz.
*/
    /*
        Tüm API testlerinde 4 aşamada işlem yapacağız
            1- Endpoint ve Gerekiyorsa requestData hazırlanır
            2- Eğer verilmiş ise ExpectedData hazırlanır
            3- Dönen Response kullanılmak için bir obje içine kaydedilir
            4- Assertion işlemleri yapılır
 */

    @Test
    public void test01(){
        //1-
        String url="https://restful-booker.herokuapp.com/booking/10";

        //2-

        //3-
        Response response= RestAssured.get(url);

        //4-

        response.then().assertThat().statusCode(200)
                                    .contentType("application/json; charset=utf-8")
                                    .statusLine("HTTP/1.1 200 OK");

        System.out.println("All Tests PASSED");


    }
}
