package twitter4j;

import java.io.Serializable;

final class TrendJSONImpl
        implements Serializable, Trend {
    private static final long serialVersionUID = -4353426776065521132L;
    private final String name;
    private String query = null;
    private String url = null;

    TrendJSONImpl(JSONObject paramJSONObject) {
        this(paramJSONObject, false);
    }

    TrendJSONImpl(JSONObject paramJSONObject, boolean paramBoolean) {
        this.name = ParseUtil.getRawString("name", paramJSONObject);
        this.url = ParseUtil.getRawString("url", paramJSONObject);
        this.query = ParseUtil.getRawString("query", paramJSONObject);
        if (paramBoolean) {
            TwitterObjectFactory.registerJSONObject(this, paramJSONObject);
        }
    }

    public boolean equals(Object paramObject) {
        if (this == paramObject) {
        }
        do {
            return true;
            if (!(paramObject instanceof Trend)) {
                return false;
            }
            paramObject = (Trend) paramObject;
            if (!this.name.equals(((Trend) paramObject).getName())) {
                return false;
            }
            if (this.query != null) {
                if (this.query.equals(((Trend) paramObject).getQuery())) {
                }
            } else {
                while (((Trend) paramObject).getQuery() != null) {
                    return false;
                }
            }
            if (this.url == null) {
                break;
            }
        } while (this.url.equals(((Trend) paramObject).getURL()));
        for (; ; ) {
            return false;
            if (((Trend) paramObject).getURL() == null) {
                break;
            }
        }
    }

    public String getName() {
        return this.name;
    }

    public String getQuery() {
        return this.query;
    }

    public String getURL() {
        return this.url;
    }

    public int hashCode() {
        int j = 0;
        int k = this.name.hashCode();
        if (this.url != null) {
        }
        for (int i = this.url.hashCode(); ; i = 0) {
            if (this.query != null) {
                j = this.query.hashCode();
            }
            return (i + k * 31) * 31 + j;
        }
    }

    public String toString() {
        return "TrendJSONImpl{name='" + this.name + '\'' + ", url='" + this.url + '\'' + ", query='" + this.query + '\'' + '}';
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/twitter4j/TrendJSONImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */