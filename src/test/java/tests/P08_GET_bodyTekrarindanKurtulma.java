package tests;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import static org.hamcrest.Matchers.*;


public class P08_GET_bodyTekrarindanKurtulma {
    /*
https://restful-booker.herokuapp.com/booking/11 url'ine bir GET request gonderdigimizde donen Response'un,
        status code'unun 200,
        ve content type'inin application/json,
        ve response body'sindeki
        "firstname"in, "Jane",
        ve "lastname"in, "Doe",
        ve "totalprice"in, 111,
        ve "depositpaid"in, true,
     ve "additionalneeds"in, "Extra pillows please" oldugunu test edin
     NOT: Veriler değişiyor Postman'de dataları kontrol ediniz
 */

    @Test
    public void test01(){
        String url="https://restful-booker.herokuapp.com/booking/11";


        Response response= RestAssured.get(url);

        response.then().assertThat().statusCode(200).contentType(ContentType.JSON)
                .body("firstname", equalTo("Josh"),
                "lastname",equalTo("Allen"),
                         "totalprice",equalTo(111),
                         "depositpaid",equalTo(true),
                         "additionalneeds",equalTo("midnight snack"));

        System.out.println("All Tests PASSED");

    }

}
