package nabd.domain;

import java.util.List;

/**
 * Author: fangxueshun
 * Description:
 * Date: 2017/6/8
 * Time: 11:02
 */
public class Category {
    private String categoryId;
    private String categoryName;
    private String categoryImageUrl;
    private String categoryDateAdded;
    private String categoryHasNewSources;
    private List<SubCategory> subCategories;

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryImageUrl() {
        return categoryImageUrl;
    }

    public void setCategoryImageUrl(String categoryImageUrl) {
        this.categoryImageUrl = categoryImageUrl;
    }

    public String getCategoryDateAdded() {
        return categoryDateAdded;
    }

    public void setCategoryDateAdded(String categoryDateAdded) {
        this.categoryDateAdded = categoryDateAdded;
    }

    public String getCategoryHasNewSources() {
        return categoryHasNewSources;
    }

    public void setCategoryHasNewSources(String categoryHasNewSources) {
        this.categoryHasNewSources = categoryHasNewSources;
    }

    public List<SubCategory> getSubCategories() {
        return subCategories;
    }

    public void setSubCategories(List<SubCategory> subCategories) {
        this.subCategories = subCategories;
    }
}
