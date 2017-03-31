package CssSelectorRule;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
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
    public void testInvert(){
        Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
        JsonParser jsonParser = new JsonParser();
        String testStr = "{\"contentType\":\"ARTICLE\",\"html\":{\"valueSelector\":\"value\",\"attributeSelector\":\"attr\",\"ignoreSelector\":[\"ignore\"]},\"image\":{\"contentType\":\"IMAGE\",\"title\":{\"valueSelector\":\"value\",\"attributeSelector\":\"attr\",\"ignoreSelector\":[\"ignore\"]},\"url\":{\"valueSelector\":\"value\",\"attributeSelector\":\"attr\",\"ignoreSelector\":[\"ignore\"]},\"imageBlock\":{\"valueSelector\":\"value\",\"attributeSelector\":\"attr\",\"ignoreSelector\":[\"ignore\"]}}}";
        JsonElement jsonElement = jsonParser.parse(testStr);
        ArticleCssRule articleCssRule = gson.fromJson(jsonElement,ArticleCssRule.class);
        System.out.printf(gson.toJson(articleCssRule));
    }

}