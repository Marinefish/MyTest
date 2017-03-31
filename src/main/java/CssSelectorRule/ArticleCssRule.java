package CssSelectorRule;

import com.google.gson.annotations.Expose;

import java.util.Date;

/**
 * Author: fangxueshun
 * Description:
 * Date: 2017/3/30
 * Time: 17:12
 */
public class ArticleCssRule extends CssContentRule{
    @Expose
    private String site;
    private final ContentType contentType = ContentType.ARTICLE;
    @Expose
    private CssRulePrototype title;
    @Expose
    private CssRulePrototype author;
    @Expose
    private CssRulePrototype date;
    @Expose
    public CssRulePrototype html;
    @Expose
    public ImageCssRule image;
    public Date createTime;
    public Date updateTime;


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

    public CssRulePrototype getAuthor() {
        return author;
    }

    public void setAuthor(CssRulePrototype author) {
        this.author = author;
    }

    public CssRulePrototype getDate() {
        return date;
    }

    public void setDate(CssRulePrototype date) {
        this.date = date;
    }

    public CssRulePrototype getHtml() {
        return html;
    }

    public void setHtml(CssRulePrototype html) {
        this.html = html;
    }

    public ImageCssRule getImage() {
        return image;
    }

    public void setImage(ImageCssRule image) {
        this.image = image;
    }
}
