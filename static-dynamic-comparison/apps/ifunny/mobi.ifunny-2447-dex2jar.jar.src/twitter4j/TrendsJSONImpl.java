package twitter4j;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;

import twitter4j.conf.Configuration;

final class TrendsJSONImpl
        extends TwitterResponseImpl
        implements Serializable, Trends {
    private static final long serialVersionUID = 2054973282133379835L;
    private Date asOf;
    private Location location;
    private Date trendAt;
    private Trend[] trends;

    TrendsJSONImpl(String paramString) {
        this(paramString, false);
    }

    TrendsJSONImpl(String paramString, boolean paramBoolean) {
        init(paramString, paramBoolean);
    }

    TrendsJSONImpl(Date paramDate1, Location paramLocation, Date paramDate2, Trend[] paramArrayOfTrend) {
        this.asOf = paramDate1;
        this.location = paramLocation;
        this.trendAt = paramDate2;
        this.trends = paramArrayOfTrend;
    }

    TrendsJSONImpl(HttpResponse paramHttpResponse, Configuration paramConfiguration) {
        super(paramHttpResponse);
        init(paramHttpResponse.asString(), paramConfiguration.isJSONStoreEnabled());
        if (paramConfiguration.isJSONStoreEnabled()) {
            TwitterObjectFactory.clearThreadLocalMap();
            TwitterObjectFactory.registerJSONObject(this, paramHttpResponse.asString());
        }
    }

    static ResponseList<Trends> createTrendsList(HttpResponse paramHttpResponse, boolean paramBoolean) {
        Object localObject = paramHttpResponse.asJSONObject();
        ResponseListImpl localResponseListImpl;
        for (; ; ) {
            String str;
            Trend[] arrayOfTrend;
            try {
                Date localDate = ParseUtil.parseTrendsDate(((JSONObject) localObject).getString("as_of"));
                JSONObject localJSONObject = ((JSONObject) localObject).getJSONObject("trends");
                localObject = extractLocation((JSONObject) localObject, paramBoolean);
                localResponseListImpl = new ResponseListImpl(localJSONObject.length(), paramHttpResponse);
                Iterator localIterator = localJSONObject.keys();
                if (!localIterator.hasNext()) {
                    break;
                }
                str = (String) localIterator.next();
                arrayOfTrend = jsonArrayToTrendArray(localJSONObject.getJSONArray(str), paramBoolean);
                if (str.length() == 19) {
                    localResponseListImpl.add(new TrendsJSONImpl(localDate, (Location) localObject, ParseUtil.getDate(str, "yyyy-MM-dd HH:mm:ss"), arrayOfTrend));
                    continue;
                }
                if (str.length() != 16) {
                    break label206;
                }
            } catch (JSONException localJSONException) {
                throw new TwitterException(localJSONException.getMessage() + ":" + paramHttpResponse.asString(), localJSONException);
            }
            localResponseListImpl.add(new TrendsJSONImpl(localJSONException, (Location) localObject, ParseUtil.getDate(str, "yyyy-MM-dd HH:mm"), arrayOfTrend));
            continue;
            label206:
            if (str.length() == 10) {
                localResponseListImpl.add(new TrendsJSONImpl(localJSONException, (Location) localObject, ParseUtil.getDate(str, "yyyy-MM-dd"), arrayOfTrend));
            }
        }
        Collections.sort(localResponseListImpl);
        return localResponseListImpl;
    }

    private static Location extractLocation(JSONObject paramJSONObject, boolean paramBoolean) {
        if (paramJSONObject.isNull("locations")) {
        }
        for (; ; ) {
            return null;
            try {
                paramJSONObject = LocationJSONImpl.createLocationList(paramJSONObject.getJSONArray("locations"), paramBoolean);
                if (paramJSONObject.size() == 0) {
                    continue;
                }
                return (Location) paramJSONObject.get(0);
            } catch (JSONException paramJSONObject) {
                throw new AssertionError("locations can't be null");
            }
        }
    }

    private static Trend[] jsonArrayToTrendArray(JSONArray paramJSONArray, boolean paramBoolean) {
        Trend[] arrayOfTrend = new Trend[paramJSONArray.length()];
        int i = 0;
        while (i < paramJSONArray.length()) {
            arrayOfTrend[i] = new TrendJSONImpl(paramJSONArray.getJSONObject(i), paramBoolean);
            i += 1;
        }
        return arrayOfTrend;
    }

    public int compareTo(Trends paramTrends) {
        return this.trendAt.compareTo(paramTrends.getTrendAt());
    }

    public boolean equals(Object paramObject) {
        if (this == paramObject) {
        }
        do {
            return true;
            if (!(paramObject instanceof Trends)) {
                return false;
            }
            paramObject = (Trends) paramObject;
            if (this.asOf != null) {
                if (this.asOf.equals(((Trends) paramObject).getAsOf())) {
                }
            } else {
                while (((Trends) paramObject).getAsOf() != null) {
                    return false;
                }
            }
            if (this.trendAt != null) {
                if (this.trendAt.equals(((Trends) paramObject).getTrendAt())) {
                }
            } else {
                while (((Trends) paramObject).getTrendAt() != null) {
                    return false;
                }
            }
        } while (Arrays.equals(this.trends, ((Trends) paramObject).getTrends()));
        return false;
    }

    public Date getAsOf() {
        return this.asOf;
    }

    public Location getLocation() {
        return this.location;
    }

    public Date getTrendAt() {
        return this.trendAt;
    }

    public Trend[] getTrends() {
        return this.trends;
    }

    public int hashCode() {
        int k = 0;
        int i;
        if (this.asOf != null) {
            i = this.asOf.hashCode();
            if (this.trendAt == null) {
                break label64;
            }
        }
        label64:
        for (int j = this.trendAt.hashCode(); ; j = 0) {
            if (this.trends != null) {
                k = Arrays.hashCode(this.trends);
            }
            return (j + i * 31) * 31 + k;
            i = 0;
            break;
        }
    }

    void init(String paramString, boolean paramBoolean) {
        for (; ; ) {
            try {
                if (paramString.startsWith("[")) {
                    paramString = new JSONArray(paramString);
                    if (paramString.length() > 0) {
                        paramString = paramString.getJSONObject(0);
                        this.asOf = ParseUtil.parseTrendsDate(paramString.getString("as_of"));
                        this.location = extractLocation(paramString, paramBoolean);
                        paramString = paramString.getJSONArray("trends");
                        this.trendAt = this.asOf;
                        this.trends = jsonArrayToTrendArray(paramString, paramBoolean);
                        return;
                    }
                    throw new TwitterException("No trends found on the specified woeid");
                }
            } catch (JSONException paramString) {
                throw new TwitterException(paramString.getMessage(), paramString);
            }
            paramString = new JSONObject(paramString);
        }
    }

    public String toString() {
        StringBuilder localStringBuilder = new StringBuilder().append("TrendsJSONImpl{asOf=").append(this.asOf).append(", trendAt=").append(this.trendAt).append(", trends=");
        if (this.trends == null) {
        }
        for (Object localObject = null; ; localObject = Arrays.asList(this.trends)) {
            return localObject + '}';
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/twitter4j/TrendsJSONImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */