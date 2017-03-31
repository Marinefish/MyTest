package CssSelectorRule;

import com.google.gson.annotations.Expose;

import java.util.List;

/**
 * Author: fangxueshun
 * Description:Css选择器原型
 * Date: 2017/3/30
 * Time: 16:46
 */
public class CssRulePrototype {
    @Expose
    private String valueSelector;//css选择
    @Expose
    private String attributeSelector;//属性选择
    @Expose
    private List<String> ignoreSelector;//过滤选择

    public String getValueSelector() {
        return valueSelector;
    }

    public void setValueSelector(String valueSelector) {
        this.valueSelector = valueSelector;
    }

    public String getAttributeSelector() {
        return attributeSelector;
    }

    public void setAttributeSelector(String attributeSelector) {
        this.attributeSelector = attributeSelector;
    }

    public List<String> getIgnoreSelector() {
        return ignoreSelector;
    }

    public void setIgnoreSelector(List<String> ignoreSelector) {
        this.ignoreSelector = ignoreSelector;
    }
}
