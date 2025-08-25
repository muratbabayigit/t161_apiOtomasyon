package tests;

import BaseUrl.RestFullBaseUrl;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Assertions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

import static io.restassured.RestAssured.given;

public class P13_RestfullBaseUrl extends RestFullBaseUrl {
     /*

       https://restful-booker.herokuapp.com/booking endpointine
       bir GET request gonderdigimizde donen response’un
       status code’unun 200 oldugunu ve
       Response’ta en az 12 booking oldugunu test edin

  */

    @Test
    public void test01(){
        specJPH.pathParam("ilk","booking");

        Response response=given().spec(specJPH).when().get("/{ilk}");


        List<Integer> bookingIdList = response.jsonPath().getList("bookingid");
        int size=bookingIdList.size();
        response.then().assertThat().statusCode(200);
        Assert.assertTrue(size>=12);
        System.out.println("All Test PASSED");


        //2.Çözüm
        response.then().assertThat().statusCode(200).body("size()",Matchers.greaterThanOrEqualTo(12));




    }

}
