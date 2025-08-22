package tests;

import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import javax.swing.*;

public class P05_NestedJsonDataCreated {
/*
  {
  "firstname": "Jim",
  "additionalneeds": "Breakfast",
  "bookingdates": {
    "checkin": "2018-01-01",
    "checkout": "2019-01-01"
                  },
  "totalprice": 111,
  "depositpaid": true,
  "lastname": "Brown"
}

datasını oluşturup yazdırın

 */
    @Test
    public void nestedJSONCreate(){

        JSONObject innerData=new JSONObject();
        innerData.put("checkin","2018-01-01");;
        innerData.put( "checkout","2019-01-01");;

        JSONObject jsonData=new JSONObject();
        jsonData.put("firstname","Jim");
        jsonData.put("lastname","Brown");
        jsonData.put( "bookingdates",innerData);
        jsonData.put("totalprice",111);
        jsonData.put("depositpaid",true);
        jsonData.put("additionalneeds","Breakfast");


        System.out.println(jsonData.toString(2));



    }
}
