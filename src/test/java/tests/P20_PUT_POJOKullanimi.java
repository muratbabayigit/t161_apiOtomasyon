package tests;

import BaseUrl.JPH_BaseUrl;
import org.testng.annotations.Test;
import pojos.JPHPojo;

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



    }


}
