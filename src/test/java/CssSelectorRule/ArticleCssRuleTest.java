package CssSelectorRule;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Author: fangxueshun
 * Description:
 * Date: 2017/3/31
 * Time: 23:38
 */
public class ArticleCssRuleTest {
    @Test
    public void testArticle() throws Exception {
        CssRulePrototype cssRulePrototype = new CssRulePrototype();
        ImageCssRule imageCssRule = new ImageCssRule();
        ArticleCssRule articleCssRule = new ArticleCssRule();
        Gson gson = new Gson();
        JsonParser jsonParser = new JsonParser();
        cssRulePrototype.setAttributeSelector("attr");
        cssRulePrototype.setValueSelector("value");
        cssRulePrototype.setIgnoreSelector(Arrays.asList("ignore"));
        imageCssRule.setImageBlock(cssRulePrototype);
        imageCssRule.setTitle(cssRulePrototype);
        imageCssRule.setUrl(cssRulePrototype);
        articleCssRule.setImage(imageCssRule);
        articleCssRule.setHtml(cssRulePrototype);
        System.out.printf(gson.toJson(articleCssRule));


    }

    @Test
    public void testInvert()throws Exception{
//        Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
//        JsonParser jsonParser = new JsonParser();
//        String testStr = "{\"contentType\":\"ARTICLE\",\"html\":{\"valueSelector\":\"value\",\"attributeSelector\":\"attr\",\"ignoreSelector\":[\"ignore\"]},\"image\":{\"contentType\":\"IMAGE\",\"title\":{\"valueSelector\":\"value\",\"attributeSelector\":\"attr\",\"ignoreSelector\":[\"ignore\"]},\"url\":{\"valueSelector\":\"value\",\"attributeSelector\":\"attr\",\"ignoreSelector\":[\"ignore\"]},\"imageBlock\":{\"valueSelector\":\"value\",\"attributeSelector\":\"attr\",\"ignoreSelector\":[\"ignore\"]}}}";
//        JsonElement jsonElement = jsonParser.parse(testStr);
//        ArticleCssRule articleCssRule = gson.fromJson(jsonElement,ArticleCssRule.class);
//        System.out.printf(gson.toJson(articleCssRule));
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("http://www.okaz.com.sa/morearticles/%D9%85%D8%AD%D9%84%D9%8A%D8%A7%D8%AA/")
                .get()
                .addHeader("cache-control", "no-cache")
                .addHeader("postman-token", "b34fff06-885b-af28-8561-af72500cea56")
                .build();

        Response response = client.newCall(request).execute();
        System.out.println(response.body().string());
    }

}