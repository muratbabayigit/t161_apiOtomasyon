package testDatas;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class RestFull_datas {

    public static JSONObject reqDataOlustur(){
        JSONObject reqData=new JSONObject();
        JSONObject bookingdates=new JSONObject();
        bookingdates.put("checkin","2021-06-01");
        bookingdates.put("checkout","2021-06-10");

        reqData.put("firstname","Sena");
        reqData.put("lastname","Yiğit");
        reqData.put("totalprice",1000);
        reqData.put("depositpaid",false);
        reqData.put("bookingdates",bookingdates);
        reqData.put("additionalneeds","wi-fi");

        return reqData;
    }

    public static JSONObject expDataOlustur(int bookingid,JSONObject booking){
        JSONObject expData=new JSONObject();
        expData.put("bookingid",bookingid);
        expData.put("booking",booking);
        return expData;
    }


    public static Map<String,Object> reqMapDataOlustur(){
        Map<String,Object> bookingdatesMAP=new HashMap<>();
        bookingdatesMAP.put("checkin","2021-06-01");
        bookingdatesMAP.put("checkout","2021-06-10");

        Map<String,Object> reqMapData=new HashMap<>();
        reqMapData.put("firstname","Sena");
        reqMapData.put("lastname","Yiğit");
        reqMapData.put("totalprice",1000);
        reqMapData.put("depositpaid",false);
        reqMapData.put("bookingdates",bookingdatesMAP);
        reqMapData.put("additionalneeds","wi-fi");
        return reqMapData;
    }



    public static Map<String,Object> expMapDataOlustur(){
        Map<String,Object> expMapData=new HashMap<>();
        expMapData.put("bookingid",24);
        expMapData.put("booking",reqMapDataOlustur());



        return expMapData;

    }


}
