package Nabd;
import Nabd.domain.Article;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import com.squareup.okhttp.*;
import net.sf.json.JSON;
import net.sf.json.xml.XMLSerializer;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Author: fangxueshun
 * Description:
 * Date: 2017/6/10
 * Time: 15:46
 */
public class GetArticle {
    public static void main(String[] args) throws Exception{
        String filePath = "C:\\learning\\labd\\android_cover_stories.xml";
        String encoding = "utf-8";
        String xmlStr = ReadWriteFileWithEncode.read(filePath,encoding);
        OkHttpClient client = new OkHttpClient();
        JsonParser jsonParser = new JsonParser();
        Gson gson = new Gson();
        List<Article> articles = new ArrayList<>();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        MediaType mediaType = MediaType.parse("application/json;charset=UTF-8");
        RequestBody body = RequestBody.create(mediaType, "{\"collectionName\":\"crawler_content_parser\"}");
        Request request = new Request.Builder()
            .url("https://3203498-appengine.com/app/v1.3/android_cover_stories.php?status=next&max_id=42692539&offset=30&first=0&feed_flag=FLAG&widgets_ids=-1%2C27%2C18&user_id=16367529")
            .get()
            .addHeader("content-type", "application/json;charset=UTF-8")
            .addHeader("cache-control", "no-cache")
            .addHeader("postman-token", "dc3b1dbe-6ff4-1cf0-1c6f-6d2e3e1c2559")
            .build();

        Response response = client.newCall(request).execute();
        String jsonStr = getJsonFromXml(response.body().string());
//        String jsonStr = getJsonFromXml(xmlStr);
        JsonElement eml = jsonParser.parse(jsonStr);
        JsonElement articlesElm = eml.getAsJsonObject().get("articles");
        if(articlesElm.isJsonArray()){
            JsonArray articlesJsonArray = articlesElm.getAsJsonArray();
            String showComments = null;
            String articleVideoUrl = null;
            for(JsonElement articleElm:articlesJsonArray){
                if(articleElm.getAsJsonObject().get("sourceId")==null)
                    continue;
                for(Map.Entry<String,JsonElement> para: articleElm.getAsJsonObject().entrySet()){
                    if(!para.getValue().isJsonPrimitive()){
                        para.setValue(jsonParser.parse(para.getValue().toString()));
                    }else {
                        if(para.getKey().equalsIgnoreCase("articlePubDate")){
                            String dateStr = para.getValue().getAsString();
                            String var = formatter.parse(dateStr).getTime()/1000+"";
                            para.setValue(jsonParser.parse(var));
                        }
                    }
                }
                if(articleElm.getAsJsonObject().get("showComments")!=null){
                    showComments = articleElm.getAsJsonObject().get("showComments").toString();
                    articleElm.getAsJsonObject().remove("showComments");
                }
                if(articleElm.getAsJsonObject().get("articleVideoUrl")!=null){
                    articleVideoUrl = articleElm.getAsJsonObject().get("articleVideoUrl").toString();
                    articleElm.getAsJsonObject().remove("articleVideoUrl");
                }
                System.out.println(articleElm);
                Article article = gson.fromJson(articleElm.getAsJsonObject(),Article.class);
                article.setShowComments(showComments);
                article.setArticleVideoUrl(articleVideoUrl);
                articles.add(article);
            }
        }else {
            Article article = gson.fromJson(articlesElm,Article.class);
            articles.add(article);
        }
        System.out.println("----------"+articles.size());
        for(Article article:articles){
            System.out.println(gson.toJson(article));
        }
    }
    /*
    * 将xml序列化Json
    * */
    public static String getJsonFromXml(String xmlString) throws Exception{
        XMLSerializer xmlSerializer = new XMLSerializer();
        JSON json = xmlSerializer.read(xmlString);
        return json.toString();
    }
}
