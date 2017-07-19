package CssSelectorRule;

/**
 * Author: fangxueshun
 * Description:
 * Date: 2017/3/31
 * Time: 17:52
 */
public class CssRuleFactory {

    public CssContentRule getCssContentRule(ContentType contentType){
        CssContentRule cssContentRule = null;
        switch (contentType) {
            case ARTICLE:
                return new ArticleCssRule();
            case IMAGE:
                return new ImageCssRule();
            case LINKS:
                return new LinkCssRule();
        }
        return cssContentRule;
    }

}
