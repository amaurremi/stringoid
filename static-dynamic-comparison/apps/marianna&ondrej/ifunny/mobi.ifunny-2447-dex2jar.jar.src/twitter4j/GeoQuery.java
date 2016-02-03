package twitter4j;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public final class GeoQuery
        implements Serializable {
    private static final long serialVersionUID = 5434503339001056634L;
    private String accuracy = null;
    private String granularity = null;
    private String ip = null;
    private GeoLocation location;
    private int maxResults = -1;
    private String query = null;

    public GeoQuery(String paramString) {
        this.ip = paramString;
    }

    public GeoQuery(GeoLocation paramGeoLocation) {
        this.location = paramGeoLocation;
    }

    private void appendParameter(String paramString, double paramDouble, List<HttpParameter> paramList) {
        paramList.add(new HttpParameter(paramString, String.valueOf(paramDouble)));
    }

    private void appendParameter(String paramString, int paramInt, List<HttpParameter> paramList) {
        if (paramInt > 0) {
            paramList.add(new HttpParameter(paramString, String.valueOf(paramInt)));
        }
    }

    private void appendParameter(String paramString1, String paramString2, List<HttpParameter> paramList) {
        if (paramString2 != null) {
            paramList.add(new HttpParameter(paramString1, paramString2));
        }
    }

    public GeoQuery accuracy(String paramString) {
        setAccuracy(paramString);
        return this;
    }

    HttpParameter[] asHttpParameterArray() {
        ArrayList localArrayList = new ArrayList();
        if (this.location != null) {
            appendParameter("lat", this.location.getLatitude(), localArrayList);
            appendParameter("long", this.location.getLongitude(), localArrayList);
        }
        if (this.ip != null) {
            appendParameter("ip", this.ip, localArrayList);
        }
        appendParameter("accuracy", this.accuracy, localArrayList);
        appendParameter("query", this.query, localArrayList);
        appendParameter("granularity", this.granularity, localArrayList);
        appendParameter("max_results", this.maxResults, localArrayList);
        return (HttpParameter[]) localArrayList.toArray(new HttpParameter[localArrayList.size()]);
    }

    public boolean equals(Object paramObject) {
        if (this == paramObject) {
        }
        do {
            return true;
            if ((paramObject == null) || (getClass() != paramObject.getClass())) {
                return false;
            }
            paramObject = (GeoQuery) paramObject;
            if (this.maxResults != ((GeoQuery) paramObject).maxResults) {
                return false;
            }
            if (this.accuracy != null) {
                if (this.accuracy.equals(((GeoQuery) paramObject).accuracy)) {
                }
            } else {
                while (((GeoQuery) paramObject).accuracy != null) {
                    return false;
                }
            }
            if (this.granularity != null) {
                if (this.granularity.equals(((GeoQuery) paramObject).granularity)) {
                }
            } else {
                while (((GeoQuery) paramObject).granularity != null) {
                    return false;
                }
            }
            if (this.ip != null) {
                if (this.ip.equals(((GeoQuery) paramObject).ip)) {
                }
            } else {
                while (((GeoQuery) paramObject).ip != null) {
                    return false;
                }
            }
            if (this.location == null) {
                break;
            }
        } while (this.location.equals(((GeoQuery) paramObject).location));
        for (; ; ) {
            return false;
            if (((GeoQuery) paramObject).location == null) {
                break;
            }
        }
    }

    public String getAccuracy() {
        return this.accuracy;
    }

    public String getGranularity() {
        return this.granularity;
    }

    public String getIp() {
        return this.ip;
    }

    public GeoLocation getLocation() {
        return this.location;
    }

    public int getMaxResults() {
        return this.maxResults;
    }

    public String getQuery() {
        return this.query;
    }

    public GeoQuery granularity(String paramString) {
        setGranularity(paramString);
        return this;
    }

    public int hashCode() {
        int m = 0;
        int i;
        int j;
        if (this.location != null) {
            i = this.location.hashCode();
            if (this.ip == null) {
                break label95;
            }
            j = this.ip.hashCode();
            label33:
            if (this.accuracy == null) {
                break label100;
            }
        }
        label95:
        label100:
        for (int k = this.accuracy.hashCode(); ; k = 0) {
            if (this.granularity != null) {
                m = this.granularity.hashCode();
            }
            return ((k + (j + i * 31) * 31) * 31 + m) * 31 + this.maxResults;
            i = 0;
            break;
            j = 0;
            break label33;
        }
    }

    public GeoQuery maxResults(int paramInt) {
        setMaxResults(paramInt);
        return this;
    }

    public void setAccuracy(String paramString) {
        this.accuracy = paramString;
    }

    public void setGranularity(String paramString) {
        this.granularity = paramString;
    }

    public void setMaxResults(int paramInt) {
        this.maxResults = paramInt;
    }

    public void setQuery(String paramString) {
        this.query = paramString;
    }

    public String toString() {
        return "GeoQuery{location=" + this.location + ", query='" + this.query + '\'' + ", ip='" + this.ip + '\'' + ", accuracy='" + this.accuracy + '\'' + ", granularity='" + this.granularity + '\'' + ", maxResults=" + this.maxResults + '}';
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/twitter4j/GeoQuery.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */