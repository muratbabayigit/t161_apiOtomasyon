package BaseUrl;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeTest;

public class RestFullBaseUrl {
    protected RequestSpecification specJPH;

    @BeforeTest
    public void setup(){
        specJPH= new RequestSpecBuilder()
                .setBaseUri("https://restful-booker.herokuapp.com").build();
    }
}
