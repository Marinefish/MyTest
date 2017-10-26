package nabd;

import nabd.domain.Category;
import nabd.domain.Source;
import nabd.domain.SubCategory;
import com.google.gson.*;
import com.squareup.okhttp.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: fangxueshun
 * Description:
 * Date: 2017/6/7
 * Time: 20:34
 */
public class ParseCategory {

    private static JsonParser jsonParser = new JsonParser();
    private static Gson gson = new Gson();
    public static void main(String[] args) throws Exception {
        String filePath = "C:\\learning\\labd\\nabd_json";
        String encoding = "utf-8";
        List<Category> categories = new ArrayList<>();
        String categoriesJsonStr = ReadWriteFileWithEncode.read(filePath, encoding);
        JsonElement categoriesElm  = jsonParser.parse(categoriesJsonStr);
        JsonArray categoriesArray=categoriesElm.getAsJsonObject().get("xml").getAsJsonObject().get("categories").getAsJsonObject().get("category").getAsJsonArray();
        //分类
        for(JsonElement categoryElm:categoriesArray){
            Category category = new Category();
            String categoryId = categoryElm.getAsJsonObject().get("categoryId").getAsString();
            String categoryName = categoryElm.getAsJsonObject().get("categoryName").getAsString();
            category.setCategoryId(categoryId);
            category.setCategoryName(categoryName);
            JsonElement subCategoriesElm = categoryElm.getAsJsonObject().get("subCategories").getAsJsonObject().get("subCategory");

            //子分类
            List<SubCategory> subCategories = new ArrayList<>();
            if(subCategoriesElm.isJsonArray()){
                JsonArray subCategoriesJsonArray = subCategoriesElm.getAsJsonArray();
                for(JsonElement subCategoryElm:subCategoriesJsonArray){
                    SubCategory subCategory = new SubCategory();
                    String subCategoryId = subCategoryElm.getAsJsonObject().get("subCategoryId").getAsString();
                    String subCategoryName = subCategoryElm.getAsJsonObject().get("subCategoryName").getAsString();
                    subCategory.setSubCategoryId(subCategoryId);
                    subCategory.setSubCategoryName(subCategoryName);
                    //新闻源
                    subCategory.setSources(getSources(subCategoryElm.getAsJsonObject().get("sources").getAsJsonObject().get("source")));
                    subCategory.setSourcesSize(subCategory.getSources().size());
                    subCategories.add(subCategory);

                }
            }else {
                SubCategory subCategory = new SubCategory();
                JsonObject subCategoriesJsonObj = subCategoriesElm.getAsJsonObject();
                String subCategoryId = subCategoriesJsonObj.get("subCategoryId").getAsString();
                String subCategoryName = subCategoriesJsonObj.get("subCategoryName").getAsString();
                subCategory.setSubCategoryId(subCategoryId);
                subCategory.setSubCategoryName(subCategoryName);
                //新闻源
                subCategory.setSources(getSources(subCategoriesJsonObj.get("sources").getAsJsonObject().get("source")));
                subCategory.setSourcesSize(subCategory.getSources().size());
                subCategories.add(subCategory);
            }
            category.setSubCategories(subCategories);
//            if(categoryId.equalsIgnoreCase("18")){
//                categories.add(category);
//                break;
//            }
            categories.add(category);
        }
        //输出
        int categoryCur = 1;
        int total = 0;
        for(Category category:categories){
//            System.out.println("1."+categoryCur+"------categoryId:"+category.getCategoryId()+"------");
//            int subCategoryCur = 1;
            for(SubCategory subCategory:category.getSubCategories()){
                System.out.println(subCategory.getSourcesSize());
                total=total+subCategory.getSourcesSize();
//                System.out.println("#############################################");
//                System.out.println("1."+categoryCur+"."+subCategoryCur+"----subCategoryId:"+subCategory.getSubCategoryId());
//                System.out.println("1."+categoryCur+"."+subCategoryCur+"----subCategoryName:"+subCategory.getSubCategoryName());
//                System.out.println("=======getSourceId=======");
                for(Source source:subCategory.getSources()){
                    System.out.println(source.getSourceId());
                    follow(source.getSourceId());
                }
//                System.out.println("=======getSourceName=======");
//                for(Source source:subCategory.getSources()){
//                    System.out.println(source.getSourceName());
//                }
//                System.out.println("=======getSourceUrl=======");
//                for(Source source:subCategory.getSources()){
//                    System.out.println(source.getSourceUrl().trim());
//                }
//                System.out.println("=======getSourceImageUrl=======");
//                for(Source source:subCategory.getSources()){
//                    System.out.println(source.getSourceImageUrl().trim());
//                }
//                System.out.println("=======getFollowers=======");
//                for(Source source:subCategory.getSources()){
//                    System.out.println(source.getFollowers());
//                }
//                System.out.println("=======getTwitterId=======");
//                for(Source source:subCategory.getSources()){
//                    System.out.println(source.getTwitterId());
//                }
//                subCategoryCur++;
            }

            categoryCur++;
        }
        System.out.println(total);
    }

    private static List<Source> getSources(JsonElement sourcesElm){
        List<Source> sources = new ArrayList<>();
        if(sourcesElm.isJsonArray()){
            for(JsonElement sourceElm:sourcesElm.getAsJsonArray()){
                JsonObject sourObj = sourceElm.getAsJsonObject();
                Source source = new Source();
                String sourceId = sourObj.get("sourceId").getAsString();
                String sourceName = sourObj.get("sourceName").getAsString();
                String sourceDescription = sourObj.get("sourceDescription")!=null?sourObj.get("sourceDescription").getAsString():"--";
                String sourceImageUrl = sourObj.get("sourceImageUrl").getAsString();
                String sourceUrl = sourObj.get("sourceUrl")!=null?sourObj.get("sourceUrl").getAsString():"--";
                String twitterId = sourObj.get("twitterId")!=null?sourObj.get("twitterId").getAsString():"--";
                String screenName = sourObj.get("screenName").getAsString();
                String followers = sourObj.get("followers").getAsString();

                source.setSourceId(sourceId);
                source.setSourceName(sourceName);
                source.setSourceDescription(sourceDescription);
                source.setSourceImageUrl(sourceImageUrl);
                source.setSourceUrl(sourceUrl);
                source.setTwitterId(twitterId);
                source.setScreenName(screenName);
                source.setFollowers(followers);
                sources.add(source);
            }
        }else {
            JsonObject sourObj = sourcesElm.getAsJsonObject();
            Source source = new Source();
            String sourceId = sourObj.get("sourceId").getAsString();
            String sourceName = sourObj.get("sourceName").getAsString();
            String sourceDescription = sourObj.get("sourceDescription")!=null?sourObj.get("sourceDescription").getAsString():"--";
            String sourceImageUrl = sourObj.get("sourceImageUrl").getAsString();
            String sourceUrl = sourObj.get("sourceUrl")!=null?sourObj.get("sourceUrl").getAsString():"--";
            String twitterId = sourObj.get("twitterId")!=null?sourObj.get("twitterId").getAsString():"--";
            String screenName = sourObj.get("screenName").getAsString();
            String followers = sourObj.get("followers").getAsString();
            ;
            source.setSourceId(sourceId);
            source.setSourceName(sourceName);
            source.setSourceDescription(sourceDescription);
            source.setSourceImageUrl(sourceImageUrl);
            source.setSourceUrl(sourceUrl);
            source.setTwitterId(twitterId);
            source.setScreenName(screenName);
            source.setFollowers(followers);
            sources.add(source);
        }
        return sources;
    }

    private static void follow(String id) throws Exception{
        OkHttpClient client = new OkHttpClient();

        MediaType mediaType = MediaType.parse("application/json;charset=UTF-8");
        RequestBody body = RequestBody.create(mediaType, "{\"collectionName\":\"crawler_content_parser\"}");
        Request request = new Request.Builder()
            .url("https://3203498-appengine.com/app/android_follow_source.php?source_id="+id+"&hash=8fc3ff64441c3094423d846b563e22d4&user_id=16367529&app_version=5.6&device=1&sn=c85b7641ec3d2775&t=0&salt=5726ece35eeeba74ff06e27f74eea020&w=480&h=853&r=1497011433920&age=&gender=0&nationality=0&test=0&u_id=&token=fB40OCh3QwU%3AAPA91bF_Eq1LJ6GFbfZQk2DJqWp1ttfsDVD5KjaK3iUKWptXQ4FKsSzX8dlmOYkmxGPyWS_RK37v0uJpWJp19a8uK5lKDkSgV6o-Gkdq0moxQgFtwd5Oe2Go4Pegs3E0cRmTZoxmhzyK&os_v=4.4.2&brand=vivo&manufacturer=BBK&model=vivo%20S7i(t)&product=bbk72_t_jb3&andi=eb72021a-cd53-49a1-a84e-6d644ff81ae9&limit_ad=0&google=0&mobo=0&fbApp=0&tw=0&so=0&ta=0&ma=0&na=0&hc=0&sho3=0&night=0&ipk=com.android.vending&signature=pCFE1K6yfJVgjYLkUzSAZGbp4RQ%3D%0A")
            .get()
            .addHeader("content-type", "application/json;charset=UTF-8")
            .addHeader("cache-control", "no-cache")
            .addHeader("postman-token", "8b5438bb-6f18-5b43-6040-c837832d3631")
            .build();
        Response response = client.newCall(request).execute();
        System.out.println(response.body().string());
    }
}
