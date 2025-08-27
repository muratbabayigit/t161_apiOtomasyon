package tests;

import BaseUrl.RestFullBaseUrl;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class P19_QueryParametresiKullanimi extends RestFullBaseUrl {
    /*

    https://restful-booker.herokuapp.com/booking endpointine
    gerekli Query parametrelerini yazarak
    “firstname” degeri “Josh” olan rezervasyon oldugunu test edecek
    bir GET request gonderdigimizde, donen response’un status code’unun
    200 oldugunu ve “Josh” ismine sahip en az bir booking oldugunu test edin

 */

    @Test
    public void test01(){

        specJPH.pathParam("pp1","booking").queryParam("firstname","Josh");
                                                // Query parametresi eğer birden fazla ise queryParams() methodu kullanılır

        //  https://restful-booker.herokuapp.com/booking?firstname=Eric
        //  response kaydedilirken Response class'ı query parametrelerini
        //  get/post/put gibi methodların içine yazılmasını gerekli kılmamıştır
        Response response=given().spec(specJPH).when().get("/{pp1}");
        response.then().assertThat().statusCode(200).body("size()", Matchers.greaterThanOrEqualTo(1));

    }


}
