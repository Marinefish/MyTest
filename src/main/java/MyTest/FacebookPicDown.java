package MyTest;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.squareup.okhttp.*;
import org.springframework.util.StringUtils;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Author: fangxueshun
 * Description:
 * Date: 2017/5/18
 * Time: 15:27
 */
public class FacebookPicDown {
    private final static OkHttpClient client = new OkHttpClient();
    private final static JsonParser jsonParser = new JsonParser();
    public static void main(String[] args) throws Exception{
        String nodeId = "428766210492456";
        String cursor = "";
        List<String> urls = new ArrayList<>();
        //.sizing(cover-fill-cropped).height(400).width(400)
        Map<String,Object> map = getPics(nodeId,cursor);
        cursor = (String)map.get("nextCur");
        int count = (int)map.get("count");
        boolean hasNext = (boolean)map.get("hasNextPage");
        int currentDownNum = (int)map.get("size");
        urls.addAll((List<String>)map.get("urls"));
        while (hasNext){
            try {
                map = getPics(nodeId,cursor);
                currentDownNum = currentDownNum +(int)map.get("size");
                hasNext = (boolean)map.get("hasNextPage");
                cursor = (String)map.get("nextCur");
                urls.addAll((List<String>)map.get("urls"));
                System.out.println("当前下载数量："+currentDownNum+",全部数量："+count);
                if(urls.size()>999){
                    //写入文档
                    saveFile(urls,nodeId+"_"+cursor);
                    urls.clear();
                }
            }catch (Exception e){
                System.out.println("===========>下载出错，cursor = "+cursor);
            }
        }


    }

    private static Map<String,Object> getPics(String nodeId, String cursor)throws Exception{
        Map<String,Object> targetMap = new HashMap<>();
        List<String> urls = new ArrayList<>();
        String nextCur = "";
        String afterInfo = "";
        if(!StringUtils.isEmpty(cursor))
            afterInfo = ".after("+cursor+")";
        MediaType mediaType = MediaType.parse("multipart/form-data; boundary=----WebKitFormBoundary7MA4YWxkTrZu0gW");
        String queries = "{\"q1\":{\"priority\":0,\"q\":\"Query MediaPageRoute {node("+nodeId+") {id,__typename,@F7}} QueryFragment F0 : Page {id,name,page_albums.first(4) as _page_albumsEdocB {edges {node {can_upload,id},cursor},page_info {has_next_page,has_previous_page}}} QueryFragment F1 : Photo {album {album_type,id},can_viewer_edit,id,owner {id,__typename}} QueryFragment F2 : Photo {can_viewer_delete,id} QueryFragment F3 : Photo {id,album {id,name},feedback {id,can_viewer_comment,can_viewer_like,does_viewer_like.use_default_actor(false) as _does_viewer_likeSEwHo,likers {count},comments {count}}} QueryFragment F4 : Photo {can_viewer_edit,id,image as _image3VZWQ1 {uri},url,@F1,@F2,@F3} QueryFragment F5 : Photo {album {id},id} QueryFragment F6 : Page {id,posted_photos"+afterInfo+".first(100) as _posted_photos2TVj5F {count,edges {node {id,@F4,@F5},cursor},page_info {has_next_page,has_previous_page}}} QueryFragment F7 : Page {viewer_profile_permissions,posted_photos {count},id,@F0,@F6}\",\"query_params\":{}}}";
        String content = "------WebKitFormBoundary7MA4YWxkTrZu0gW\r\nContent-Disposition: form-data; name=\"__user\"\r\n\r\n0\r\n------WebKitFormBoundary7MA4YWxkTrZu0gW\r\nContent-Disposition: form-data; name=\"__a\"\r\n\r\n1\r\n------WebKitFormBoundary7MA4YWxkTrZu0gW\r\nContent-Disposition: form-data; name=\"__dyn\"\r\n\r\n5V8WXxaAcomgDxKS5u2iq2WiWGey8jrWo466EeVE98nyUdUb8aUgxebmbxK5WyoScDKaxeUW2y5pQ12VVojxCaCzLypUkxu7EO2S1iyECQu2K4o4O68mCyEgyk3Gu64i4eexW1hCwDAwGxedzS4EpKHxii6ElzECfAxu12y9E9oKfU\r\n------WebKitFormBoundary7MA4YWxkTrZu0gW\r\nContent-Disposition: form-data; name=\"__af\"\r\n\r\niw\r\n------WebKitFormBoundary7MA4YWxkTrZu0gW\r\nContent-Disposition: form-data; name=\"__req\"\r\n\r\n8\r\n------WebKitFormBoundary7MA4YWxkTrZu0gW\r\nContent-Disposition: form-data; name=\"__be\"\r\n\r\n-1\r\n------WebKitFormBoundary7MA4YWxkTrZu0gW\r\nContent-Disposition: form-data; name=\"__pc\"\r\n\r\nPHASED:DEFAULT\r\n------WebKitFormBoundary7MA4YWxkTrZu0gW\r\nContent-Disposition: form-data; name=\"__rev\"\r\n\r\n3026667\r\n------WebKitFormBoundary7MA4YWxkTrZu0gW\r\nContent-Disposition: form-data; name=\"lsd\"\r\n\r\nAVon86cA\r\n------WebKitFormBoundary7MA4YWxkTrZu0gW\r\nContent-Disposition: form-data; name=\"av\"\r\n\r\n0\r\n------WebKitFormBoundary7MA4YWxkTrZu0gW\r\nContent-Disposition: form-data; name=\"batch_name\"\r\n\r\nPagePhotosTabAllPhotosGrid_react_PageRelayQL\r\n------WebKitFormBoundary7MA4YWxkTrZu0gW\r\nContent-Disposition: form-data; name=\"method\"\r\n\r\nGET\r\n------WebKitFormBoundary7MA4YWxkTrZu0gW\r\nContent-Disposition: form-data; name=\"queries\"\r\n\r\n" +queries+"\r\n------WebKitFormBoundary7MA4YWxkTrZu0gW \r\nContent-Disposition: form-data ; name=\"response_format\"\r\n\r\njson\r\n------WebKitFormBoundary7MA4YWxkTrZu0gW\r\nContent-Disposition: form-data; name=\"scheduler\"\r\n\r\nphased\r\n------WebKitFormBoundary7MA4YWxkTrZu0gW--";
        RequestBody body = RequestBody.create(mediaType, content);
        Request request = new Request.Builder()
                .url("https://m.facebook.com/api/graphqlbatch/")
                .post(body)
                .addHeader("content-type", "multipart/form-data; boundary=----WebKitFormBoundary7MA4YWxkTrZu0gW")
                .addHeader("cache-control", "no-cache")
                .addHeader("postman-token", "20fa228a-c003-5636-b566-e3ef408ee223")
                .build();

        Response response = client.newCall(request).execute();
        String jsonStr = response.body().string();

        JsonElement jsonElement = jsonParser.parse(jsonStr);
        JsonObject albumsObj = jsonElement.getAsJsonObject().get("q1").getAsJsonObject().get("response").getAsJsonObject().get(nodeId).getAsJsonObject()
                .get("_posted_photos2TVj5F").getAsJsonObject();
        int albumsTotalCount = albumsObj.get("count").getAsInt();
        JsonArray albums = albumsObj.get("edges").getAsJsonArray();
        boolean hasNextPage = albumsObj.get("page_info").getAsJsonObject().get("has_next_page").getAsBoolean();

        for(JsonElement album:albums){
            String picUri = album.getAsJsonObject().get("node").getAsJsonObject().get("_image3VZWQ1").getAsJsonObject()
                    .get("uri").getAsString();
            urls.add(picUri);
            nextCur = album.getAsJsonObject().get("cursor").getAsString();
        }

        targetMap.put("urls",urls);
        targetMap.put("nextCur",nextCur);
        targetMap.put("hasNextPage",hasNextPage);
        targetMap.put("count",albumsTotalCount);
        targetMap.put("size",albums.size());
        return targetMap;
    }

    private static void saveFile(List<String> urls,String name){
        String filePath = "C:\\Temp\\"+name+".txt";
        //追加文件
        try {
            File f = new File(filePath);
            if (f.exists()) {
                ;
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
}
