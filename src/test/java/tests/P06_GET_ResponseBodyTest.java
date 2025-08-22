package tests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

public class P06_GET_ResponseBodyTest {
           /*
    https://jsonplaceholder.typicode.com/posts/44 url'ine bir GET request yolladigimizda
    donen Response’in
    status code'unun 200,
    ve content type'inin application/json; charset=utf-8,
    ve response body'sinde bulunan userId'nin 5,
     ve response body'sinde bulunan title'in "optio dolor molestias sit"
    oldugunu test edin.
     */

    @Test
    public void testGetResponseBody() {
        String url="https://jsonplaceholder.typicode.com/posts/44";


        Response response= RestAssured.get(url);

        response.then().assertThat().statusCode(200).contentType("application/json; charset=utf-8")
                                    .body("userId", Matchers.equalTo(5))
                                    .body("title",Matchers.equalTo("optio dolor molestias sit"));




        System.out.println("All Tests PASSED");
    }
}
