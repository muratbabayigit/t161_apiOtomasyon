package tests;


import BaseUrl.JPH_BaseUrl;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;


public class P12_JPHBaseUrlKullanimi  extends JPH_BaseUrl {

    /*

        https://jsonplaceholder.typicode.com/posts endpointine
         bir GET request gonderdigimizde
         donen response'un status code'unun 200 oldugunu ve
         Response'ta 100 kayit oldugunu test edin


 */
    @Test
    public void test01(){

        // 1-Endpoint oluşturulması
        specJPH.pathParam("pp1","posts");   //specJPH: https://jsonplaceholder.typicode.com   pp1:posts

        //2-ExpData Hazırlama

        //3-Response degeri kayıt altına alınır
        Response response=given().spec(specJPH).when().get("/{pp1}");

       response.then().assertThat().statusCode(200).body("body",Matchers.hasSize(100));

        System.out.println("All Test PASSED");



    }

      /*
    2- https://jsonplaceholder.typicode.com/posts/44 endpointine
        bir GET request gonderdigimizde donen response’un
        status code’unun 200 oldugunu ve “title” degerinin
        "optio dolor molestias sit" oldugunu test edin

     */
    @Test
    public void test02(){
        specJPH.pathParams("pp1","posts","pp2","44");

        Response response=given().spec(specJPH).when().get("/{pp1}/{pp2}");
        response.then().assertThat().statusCode(200).body("title",Matchers.equalTo("optio dolor molestias sit"));

        System.out.println("All Test PASSED");
    }










}
