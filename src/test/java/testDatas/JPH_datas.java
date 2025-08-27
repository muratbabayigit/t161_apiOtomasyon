package testDatas;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class JPH_datas {
        public static int basariliDurumKodu=200;
        public static String contentType="application/json; charset=utf-8";
        public static String header="keep-alive";



        public static JSONObject expDataOlustur(){
            JSONObject expData=new JSONObject();
            expData.put("id",22);
            expData.put("userId",3);
            expData.put("title","dolor sint quo a velit explicabo quia nam");
            expData.put("body","eos qui et ipsum ipsam suscipit aut\nsed omnis non odio\nexpedita earum mollitia molestiae aut atque rem suscipit\nnam impedit esse");

            return expData;
        }

        public static JSONObject expDataolustur2(int id, int userId, String title, String body){
            JSONObject expData=new JSONObject();
                expData.put("id",id);
                expData.put("userId",userId);
                expData.put("title",title);
                expData.put("body",body);

            return expData;
        }





        public static JSONObject dataCreate(String title,String body, int userId,int id){

            JSONObject data=new JSONObject();
            data.put("title",title);
            data.put("body",body);
            data.put("userId",userId);
            data.put("id",id);



            return data;
        }

        public static Map<String,Object> MAPdataOlustur(String title, String body, double userId, double id){
            Map<String,Object> mapData=new HashMap<>();
            mapData.put("title",title);
            mapData.put("body",body);
            mapData.put("userId",userId);
            mapData.put("id",id);

            return mapData;
        }
















}
