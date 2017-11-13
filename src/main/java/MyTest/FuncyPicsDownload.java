package myTest;


import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.squareup.okhttp.*;
import org.springframework.util.StringUtils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

/**
 * Author: fangxueshun
 * Description:下载funcy网站图片，运营使用
 * Date: 2017/5/11
 * Time: 16:28
 */
public class FuncyPicsDownload {
    static JsonParser jsonParser = new JsonParser();
    public static void main(String[] args) throws Exception{
        String filePath = "C:\\Temp\\urls.txt";
        Map<String,Object> map = getPicUrls(-1);
        List<String> urls = (List<String>)map.get("urls");
        int id = (int)map.get("id");
        while (id>1){
            Map<String,Object> mapTmep = getPicUrls(id);
            try {
                urls.addAll((List<String>)mapTmep.get("urls"));
            }catch (Exception e){
                e.printStackTrace();
               continue;
            }

            id = (int)mapTmep.get("id");
            Thread.sleep(1000);
            System.out.println("已经抓取到"+id);
        }
        //追加文件
        try {
            File f = new File(filePath);
            if (f.exists()) {
                System.out.print("文件存在");
            } else {
                System.out.print("文件不存在");
                f.createNewFile();// 不存在则创建
            }
            //打开一个写文件器，构造函数中的第二个参数true表示以追加形式写文件
            FileWriter writer = new FileWriter(f, true);
            for(String url:urls){
                writer.write(url+"\r\n");
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*获取100张图片的url和当前最后一个id*/
    private static Map<String,Object> getPicUrls(int id) throws Exception{
        Map<String,Object> map = new HashMap<>();
        List<String> urls = new ArrayList<>();
        int postId = 100000000;
        String idPara = "";
        if(id>0)
            idPara="id="+id+"&";
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("https://api.uwinnh.com/posts.json?"+idPara+"count=100&exclude_content_types%5B%5D=video&exclude_content_types%5B%5D=gif&exclude_content_types%5B%5D=text")
                .get()
                .addHeader("content-type", "application/json;charset=UTF-8")
                .addHeader("authorization", "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHAiOjE0OTQ1NjE0NjEsInN1YiI6NDg4OTMsInNlc3Npb25pZCI6IjU0MmU0ZDdhN2E3NWE1NzAzNjJiYjIxY2Y0OTE5Y2RjIn0.Qj8gDi0STY-fnEay1_AyA60LRO6vbYz3GBw0s8cU5FU")
                .addHeader("cache-control", "no-cache")
                .build();

        Response response = client.newCall(request).execute();
        String jsonStr = response.body().string();
        JsonArray posts = jsonParser.parse(jsonStr).getAsJsonObject().get("posts").getAsJsonArray();
        for(JsonElement jsonElement:posts){
            String url = jsonElement.getAsJsonObject().get("display_src").getAsString();
            int tempId = jsonElement.getAsJsonObject().get("id").getAsInt();
            if(tempId<postId)
                postId = tempId;
            if(!StringUtils.isEmpty(url))
                urls.add(url);
            System.out.println(url);
        }
        map.put("urls",urls);
        map.put("id",postId);
        return map;
    }

    /*获取用户auth*/
    private static String getAuth() throws Exception{
        String authJson = "{\"auth\":{\"udid\":\"0811a53b-eee1-4868-9cad-395032867119\"}}";
        OkHttpClient client = new OkHttpClient();

        MediaType mediaType = MediaType.parse("application/json;charset=UTF-8");
        RequestBody body = RequestBody.create(mediaType, authJson);
        Request request = new Request.Builder()
                .url("https://api.uwinnh.com/user_token.json")
                .post(body)
                .addHeader("content-type", "application/json;charset=UTF-8")
                .build();

        Response response = client.newCall(request).execute();
        String respJsonStr = response.body().string();
        String authorization = jsonParser.parse(respJsonStr).getAsJsonObject().get("jwt").getAsString();
        return authorization;
    }


}
