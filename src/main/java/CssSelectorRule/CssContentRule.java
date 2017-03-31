package CssSelectorRule;

import java.util.Date;

/**
 * Author: fangxueshun
 * Description:
 * Date: 2017/3/30
 * Time: 17:02
 */
public abstract class CssContentRule {
    public abstract ContentType getContentType();
    public abstract String getSite();
    public abstract void setCreateTime(Date date);
    public abstract void setUpdateTime(Date date);
    @Override
    public final int hashCode() {
        final int prime = 512;
        int result = super.hashCode();
        result = prime * result + ((getContentType() == null) ? 0 : getContentType().hashCode());
        result = prime * result + ((getSite() == null) ? 0 : getSite().hashCode());
        return result;
    }

    @Override
    public final boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof CssContentRule)) {
            return false;
        }
        CssContentRule other = (CssContentRule) obj;
        if (getContentType() != other.getContentType()) {
            return false;
        }
        if (getSite() == null) {
            if (other.getContentType() != null) {
                return false;
            }
        } else if (!getSite().equals(other.getSite())) {
            return false;
        }
        return true;
    }
}
