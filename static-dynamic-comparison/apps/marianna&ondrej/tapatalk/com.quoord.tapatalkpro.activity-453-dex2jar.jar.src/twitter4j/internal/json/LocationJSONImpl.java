package twitter4j.internal.json;

import twitter4j.Location;
import twitter4j.ResponseList;
import twitter4j.TwitterException;
import twitter4j.conf.Configuration;
import twitter4j.internal.http.HttpResponse;
import twitter4j.internal.org.json.JSONArray;
import twitter4j.internal.org.json.JSONException;
import twitter4j.internal.org.json.JSONObject;

final class LocationJSONImpl
        implements Location {
    private static final long serialVersionUID = 7095092358530897222L;
    private final String countryCode;
    private final String countryName;
    private final String name;
    private final int placeCode;
    private final String placeName;
    private final String url;
    private final int woeid;

    /* Error */
    LocationJSONImpl(JSONObject paramJSONObject)
            throws TwitterException {
        // Byte code:
        //   0: aload_0
        //   1: invokespecial 28	java/lang/Object:<init>	()V
        //   4: aload_0
        //   5: ldc 29
        //   7: aload_1
        //   8: invokestatic 35	twitter4j/internal/json/z_T4JInternalParseUtil:getInt	(Ljava/lang/String;Ltwitter4j/internal/org/json/JSONObject;)I
        //   11: putfield 37	twitter4j/internal/json/LocationJSONImpl:woeid	I
        //   14: aload_0
        //   15: ldc 39
        //   17: aload_1
        //   18: invokestatic 43	twitter4j/internal/json/z_T4JInternalParseUtil:getUnescapedString	(Ljava/lang/String;Ltwitter4j/internal/org/json/JSONObject;)Ljava/lang/String;
        //   21: putfield 45	twitter4j/internal/json/LocationJSONImpl:countryName	Ljava/lang/String;
        //   24: aload_0
        //   25: ldc 46
        //   27: aload_1
        //   28: invokestatic 49	twitter4j/internal/json/z_T4JInternalParseUtil:getRawString	(Ljava/lang/String;Ltwitter4j/internal/org/json/JSONObject;)Ljava/lang/String;
        //   31: putfield 51	twitter4j/internal/json/LocationJSONImpl:countryCode	Ljava/lang/String;
        //   34: aload_1
        //   35: ldc 53
        //   37: invokevirtual 59	twitter4j/internal/org/json/JSONObject:isNull	(Ljava/lang/String;)Z
        //   40: ifne +51 -> 91
        //   43: aload_1
        //   44: ldc 53
        //   46: invokevirtual 63	twitter4j/internal/org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Ltwitter4j/internal/org/json/JSONObject;
        //   49: astore_2
        //   50: aload_0
        //   51: ldc 64
        //   53: aload_2
        //   54: invokestatic 43	twitter4j/internal/json/z_T4JInternalParseUtil:getUnescapedString	(Ljava/lang/String;Ltwitter4j/internal/org/json/JSONObject;)Ljava/lang/String;
        //   57: putfield 66	twitter4j/internal/json/LocationJSONImpl:placeName	Ljava/lang/String;
        //   60: aload_0
        //   61: ldc 68
        //   63: aload_2
        //   64: invokestatic 35	twitter4j/internal/json/z_T4JInternalParseUtil:getInt	(Ljava/lang/String;Ltwitter4j/internal/org/json/JSONObject;)I
        //   67: putfield 70	twitter4j/internal/json/LocationJSONImpl:placeCode	I
        //   70: aload_0
        //   71: ldc 64
        //   73: aload_1
        //   74: invokestatic 43	twitter4j/internal/json/z_T4JInternalParseUtil:getUnescapedString	(Ljava/lang/String;Ltwitter4j/internal/org/json/JSONObject;)Ljava/lang/String;
        //   77: putfield 72	twitter4j/internal/json/LocationJSONImpl:name	Ljava/lang/String;
        //   80: aload_0
        //   81: ldc 73
        //   83: aload_1
        //   84: invokestatic 43	twitter4j/internal/json/z_T4JInternalParseUtil:getUnescapedString	(Ljava/lang/String;Ltwitter4j/internal/org/json/JSONObject;)Ljava/lang/String;
        //   87: putfield 75	twitter4j/internal/json/LocationJSONImpl:url	Ljava/lang/String;
        //   90: return
        //   91: aload_0
        //   92: aconst_null
        //   93: putfield 66	twitter4j/internal/json/LocationJSONImpl:placeName	Ljava/lang/String;
        //   96: aload_0
        //   97: iconst_m1
        //   98: putfield 70	twitter4j/internal/json/LocationJSONImpl:placeCode	I
        //   101: goto -31 -> 70
        //   104: astore_1
        //   105: new 23	twitter4j/TwitterException
        //   108: dup
        //   109: aload_1
        //   110: invokespecial 78	twitter4j/TwitterException:<init>	(Ljava/lang/Exception;)V
        //   113: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	114	0	this	LocationJSONImpl
        //   0	114	1	paramJSONObject	JSONObject
        //   49	15	2	localJSONObject	JSONObject
        // Exception table:
        //   from	to	target	type
        //   4	70	104	twitter4j/internal/org/json/JSONException
        //   70	90	104	twitter4j/internal/org/json/JSONException
        //   91	101	104	twitter4j/internal/org/json/JSONException
    }

    static ResponseList<Location> createLocationList(HttpResponse paramHttpResponse, Configuration paramConfiguration)
            throws TwitterException {
        if (paramConfiguration.isJSONStoreEnabled()) {
            DataObjectFactoryUtil.clearThreadLocalMap();
        }
        return createLocationList(paramHttpResponse.asJSONArray(), paramConfiguration.isJSONStoreEnabled());
    }

    static ResponseList<Location> createLocationList(JSONArray paramJSONArray, boolean paramBoolean)
            throws TwitterException {
        for (; ; ) {
            int i;
            try {
                int j = paramJSONArray.length();
                ResponseListImpl localResponseListImpl = new ResponseListImpl(j, null);
                i = 0;
                if (i < j) {
                    JSONObject localJSONObject = paramJSONArray.getJSONObject(i);
                    LocationJSONImpl localLocationJSONImpl = new LocationJSONImpl(localJSONObject);
                    localResponseListImpl.add(localLocationJSONImpl);
                    if (paramBoolean) {
                        DataObjectFactoryUtil.registerJSONObject(localLocationJSONImpl, localJSONObject);
                    }
                } else {
                    if (paramBoolean) {
                        DataObjectFactoryUtil.registerJSONObject(localResponseListImpl, paramJSONArray);
                    }
                    return localResponseListImpl;
                }
            } catch (JSONException paramJSONArray) {
                throw new TwitterException(paramJSONArray);
            } catch (TwitterException paramJSONArray) {
                throw paramJSONArray;
            }
            i += 1;
        }
    }

    public boolean equals(Object paramObject) {
        if (this == paramObject) {
        }
        do {
            return true;
            if (!(paramObject instanceof LocationJSONImpl)) {
                return false;
            }
            paramObject = (LocationJSONImpl) paramObject;
        } while (this.woeid == ((LocationJSONImpl) paramObject).woeid);
        return false;
    }

    public String getCountryCode() {
        return this.countryCode;
    }

    public String getCountryName() {
        return this.countryName;
    }

    public String getName() {
        return this.name;
    }

    public int getPlaceCode() {
        return this.placeCode;
    }

    public String getPlaceName() {
        return this.placeName;
    }

    public String getURL() {
        return this.url;
    }

    public int getWoeid() {
        return this.woeid;
    }

    public int hashCode() {
        return this.woeid;
    }

    public String toString() {
        return "LocationJSONImpl{woeid=" + this.woeid + ", countryName='" + this.countryName + '\'' + ", countryCode='" + this.countryCode + '\'' + ", placeName='" + this.placeName + '\'' + ", placeCode='" + this.placeCode + '\'' + ", name='" + this.name + '\'' + ", url='" + this.url + '\'' + '}';
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/twitter4j/internal/json/LocationJSONImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */