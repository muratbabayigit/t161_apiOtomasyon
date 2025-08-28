package tests;

import BaseUrl.JPH_BaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.testng.annotations.Test;
import pojos.JPHPojo;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class P20_PUT_POJOKullanimi extends JPH_BaseUrl {
    /*

https://jsonplaceholder.typicode.com/posts/70 url’ine
asagidaki body’e sahip bir PUT request yolladigimizda
donen response’in response body’sinin
asagida verilen ile ayni oldugunu test ediniz

Request Body
{
    “title”: “Ahmet”,
    “body”: “Merhaba”,
    “userId”: 10,
    “id”: 70
}

Expected Data :
{
    “title”: “Ahmet”,
    “body”: “Merhaba”,
    “userId”: 10,
    “id”: 70
}

 */

    @Test
    public void test01(){
        specJPH.pathParams("pp1","posts","pp2","70");
        JPHPojo reqPOJO=new JPHPojo("Ahmet","Merhaba",7,70);

        JPHPojo expPOJO=new JPHPojo("Ahmet","Merhaba",7,70);

        Response response=given().contentType(ContentType.JSON).spec(specJPH).when().body(reqPOJO).put("/{pp1}/{pp2}");

        JPHPojo resPOJO=response.as(JPHPojo.class);

       assertEquals(expPOJO.getTitle(),resPOJO.getTitle());
       assertEquals(expPOJO.getBody(),resPOJO.getBody());
       assertEquals(expPOJO.getUserId(),resPOJO.getUserId());
       assertEquals(expPOJO.getId(),resPOJO.getId());

    }


}
