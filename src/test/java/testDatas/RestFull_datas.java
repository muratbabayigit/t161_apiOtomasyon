package testDatas;

import org.json.JSONObject;

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
}
