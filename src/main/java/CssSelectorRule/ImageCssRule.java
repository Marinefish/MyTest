package CssSelectorRule;


import com.google.gson.annotations.Expose;

import java.util.Date;

/**
 * Author: fangxueshun
 * Description:
 * Date: 2017/3/30
 * Time: 17:20
 */
public class ImageCssRule extends CssContentRule{
    private String site;
    private final ContentType contentType = ContentType.IMAGE;
    @Expose
    private CssRulePrototype title;
    @Expose
    private CssRulePrototype url;
    @Expose
    private CssRulePrototype imageBlock;
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

    public CssRulePrototype getTitle() {
        return title;
    }

    public void setTitle(CssRulePrototype title) {
        this.title = title;
    }

    public CssRulePrototype getUrl() {
        return url;
    }

    public void setUrl(CssRulePrototype url) {
        this.url = url;
    }

    public CssRulePrototype getImageBlock() {
        return imageBlock;
    }

    public void setImageBlock(CssRulePrototype imageBlock) {
        this.imageBlock = imageBlock;
    }
}
