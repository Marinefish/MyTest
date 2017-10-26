package nabd.domain;

import java.util.List;

/**
 * Author: fangxueshun
 * Description:
 * Date: 2017/6/8
 * Time: 11:00
 */
public class SubCategory {
    private String subCategoryId;
    private String subCategoryName;
    private Integer sourcesSize;
    private List<Source> sources;

    public Integer getSourcesSize() {
        return sourcesSize;
    }

    public void setSourcesSize(Integer sourcesSize) {
        this.sourcesSize = sourcesSize;
    }

    public String getSubCategoryId() {
        return subCategoryId;
    }

    public void setSubCategoryId(String subCategoryId) {
        this.subCategoryId = subCategoryId;
    }

    public String getSubCategoryName() {
        return subCategoryName;
    }

    public void setSubCategoryName(String subCategoryName) {
        this.subCategoryName = subCategoryName;
    }

    public List<Source> getSources() {
        return sources;
    }

    public void setSources(List<Source> sources) {
        this.sources = sources;
    }
}
