package tests;

import BaseUrl.RestFullBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.annotations.Test;
import testDatas.RestFull_datas;

import static io.restassured.RestAssured.given;

public class P22_TokenKullanarakApiRequest extends RestFullBaseUrl {

    /*
    https://restful-booker.herokuapp.com/booking/282 (id güncellenmeli)
    adresindeki rezervasyon bilgilerini
        -H 'Content-Type: application/json' \
        -H 'Accept: application/json' \
        -H 'Cookie: token=abc123' \ veya -H 'Authorization:Basic YWRtaW46cGFzc3dvcmQxMjM=' \
        header değerleriyle PUT request göndererek update ediniz.


        Token Oluşturma
        Content-Type: application/json header derğeriyle aşağıdaki body ile
        {
                "username" : "admin",
                "password" : "password123"
        }


        https://restful-booker.herokuapp.com/auth adresine Post Request yapınız

 */

    static String token;
    static String authCode="YWRtaW46cGFzc3dvcmQxMjM=";

    @Test
    public void test01(){
        specJPH.pathParam("pp1","auth");

        JSONObject data=new JSONObject();;
        data.put("username","admin");
        data.put("password","password123");

        Response response =given().contentType(ContentType.JSON).spec(specJPH).when().body(data.toString()).post("/{pp1}");

       // response.prettyPrint();

        JsonPath resJP=response.jsonPath();

        token=resJP.get("token");
        System.out.println("token:"+token);

    }

  @Test (dependsOnMethods = "test01")
  public void test02(){
      specJPH.pathParams("pp1","booking","pp2","282");
      JSONObject reqBody = RestFull_datas.reqDataOlustur();

      Response response=given().contentType(ContentType.JSON).spec(specJPH).when().body(reqBody.toString())
              .header("Content-Type","application/json")
              .header("Accept","application/json")
              .header("Cookie","token="+token)
              .put("/{pp1}/{pp2}");

      response.prettyPrint();

  }


    @Test
    public void test03(){
        specJPH.pathParams("pp1","booking","pp2","282");
        JSONObject reqBody = RestFull_datas.reqDataOlustur();

        Response response=given().contentType(ContentType.JSON).spec(specJPH).when().body(reqBody.toString())
                .header("Content-Type","application/json")
                .header("Accept","application/json")
                .header("Authorization","Basic "+authCode)
                .put("/{pp1}/{pp2}");

        response.prettyPrint();

    }




}
