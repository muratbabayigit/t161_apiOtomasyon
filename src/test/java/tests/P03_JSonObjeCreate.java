package tests;

import org.json.JSONObject;
import org.junit.jupiter.api.Test;

public class P03_JSonObjeCreate {
             /*
           Asagidaki JSON Objesini olusturup konsolda yazdirin.
                     {
                     "title":"Ahmet",
                     "body":"Merhaba",
                     "userId":1
                     }
      */
    @Test
    public void JsonDataCreate(){
        JSONObject jsonData= new JSONObject();

        jsonData.put("title","Ahmet");
        jsonData.put("body","Merhaba");
        jsonData.put("userId","1");

        System.out.println(jsonData.toString(2));






    }
}
