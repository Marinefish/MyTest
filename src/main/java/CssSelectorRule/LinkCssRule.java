package CssSelectorRule;


import com.google.gson.annotations.Expose;

import java.util.Date;
import java.util.List;

/**
 * Author: fangxueshun
 * Description:
 * Date: 2017/3/30
 * Time: 17:26
 */
public class LinkCssRule extends CssContentRule{
    @Expose
    private String site;
    @Expose
    private final ContentType contentType = ContentType.LINKS;
    @Expose
    private List<CssRulePrototype> urls;
    private Date createTime;
    private Date updateTime;

    public Date getCreateTime() {
        return createTime;
    }
    @Override
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }
    @Override
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    @Override
    public ContentType getContentType() {
        return contentType;
    }

    public List<CssRulePrototype> getUrls() {
        return urls;
    }

    public void setUrls(List<CssRulePrototype> urls) {
        this.urls = urls;
    }

}
