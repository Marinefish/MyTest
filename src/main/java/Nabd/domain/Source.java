package Nabd.domain;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.HashMap;
import java.util.Map;

/**
 * Author: fangxueshun
 * Description:
 * Date: 2017/6/8
 * Time: 10:56
 */
public class Source {
    private String sourceId;
    private String sourceName;
    private String sourceDescription;
    private String sourceImageUrl;
    private String sourceUrl;
    private String twitterId;
    private String screenName;
    private String followers;
    private String _new;
    private String sourceBackground;
    private String followed;
    private String verified;
    private String hideSourceLogo;
    private String leaveMargin;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public String getSourceId() {
        return sourceId;
    }

    public void setSourceId(String sourceId) {
        this.sourceId = sourceId;
    }

    public String getSourceName() {
        return sourceName;
    }

    public void setSourceName(String sourceName) {
        this.sourceName = sourceName;
    }

    public String getSourceDescription() {
        return sourceDescription;
    }

    public void setSourceDescription(String sourceDescription) {
        this.sourceDescription = sourceDescription;
    }

    public String getSourceImageUrl() {
        return sourceImageUrl;
    }

    public void setSourceImageUrl(String sourceImageUrl) {
        this.sourceImageUrl = sourceImageUrl;
    }

    public String getSourceUrl() {
        return sourceUrl;
    }

    public void setSourceUrl(String sourceUrl) {
        this.sourceUrl = sourceUrl;
    }

    public String getTwitterId() {
        return twitterId;
    }

    public void setTwitterId(String twitterId) {
        this.twitterId = twitterId;
    }

    public String getScreenName() {
        return screenName;
    }

    public void setScreenName(String screenName) {
        this.screenName = screenName;
    }

    public String getFollowers() {
        return followers;
    }

    public void setFollowers(String followers) {
        this.followers = followers;
    }

    public String getNew() {
        return _new;
    }

    public void setNew(String _new) {
        this._new = _new;
    }

    public String getSourceBackground() {
        return sourceBackground;
    }

    public void setSourceBackground(String sourceBackground) {
        this.sourceBackground = sourceBackground;
    }

    public String getFollowed() {
        return followed;
    }

    public void setFollowed(String followed) {
        this.followed = followed;
    }

    public String getVerified() {
        return verified;
    }

    public void setVerified(String verified) {
        this.verified = verified;
    }

    public String getHideSourceLogo() {
        return hideSourceLogo;
    }

    public void setHideSourceLogo(String hideSourceLogo) {
        this.hideSourceLogo = hideSourceLogo;
    }

    public String getLeaveMargin() {
        return leaveMargin;
    }

    public void setLeaveMargin(String leaveMargin) {
        this.leaveMargin = leaveMargin;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }
}
