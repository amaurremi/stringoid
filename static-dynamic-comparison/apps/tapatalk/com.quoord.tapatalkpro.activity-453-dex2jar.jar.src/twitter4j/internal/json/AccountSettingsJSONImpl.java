package twitter4j.internal.json;

import java.io.Serializable;

import twitter4j.AccountSettings;
import twitter4j.Location;
import twitter4j.TimeZone;
import twitter4j.TwitterException;
import twitter4j.conf.Configuration;
import twitter4j.internal.http.HttpResponse;
import twitter4j.internal.org.json.JSONObject;

class AccountSettingsJSONImpl
        extends TwitterResponseImpl
        implements AccountSettings, Serializable {
    private static final long serialVersionUID = 7983363611306383416L;
    private final boolean ALWAYS_USE_HTTPS;
    private final boolean DISCOVERABLE_BY_EMAIL;
    private final boolean GEO_ENABLED;
    private final String LANGUAGE;
    private final String SCREEN_NAME;
    private final String SLEEP_END_TIME;
    private final String SLEEP_START_TIME;
    private final boolean SLEEP_TIME_ENABLED;
    private final TimeZone TIMEZONE;
    private final Location[] TREND_LOCATION;

    AccountSettingsJSONImpl(HttpResponse paramHttpResponse, Configuration paramConfiguration)
            throws TwitterException {
        this(paramHttpResponse, paramHttpResponse.asJSONObject());
        if (paramConfiguration.isJSONStoreEnabled()) {
            DataObjectFactoryUtil.clearThreadLocalMap();
            DataObjectFactoryUtil.registerJSONObject(this, paramHttpResponse.asJSONObject());
        }
    }

    /* Error */
    private AccountSettingsJSONImpl(HttpResponse paramHttpResponse, JSONObject paramJSONObject)
            throws TwitterException {
        // Byte code:
        //   0: aload_0
        //   1: aload_1
        //   2: invokespecial 62	twitter4j/internal/json/TwitterResponseImpl:<init>	(Ltwitter4j/internal/http/HttpResponse;)V
        //   5: aload_2
        //   6: ldc 64
        //   8: invokevirtual 70	twitter4j/internal/org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Ltwitter4j/internal/org/json/JSONObject;
        //   11: astore_1
        //   12: aload_0
        //   13: ldc 72
        //   15: aload_1
        //   16: invokestatic 78	twitter4j/internal/json/z_T4JInternalParseUtil:getBoolean	(Ljava/lang/String;Ltwitter4j/internal/org/json/JSONObject;)Z
        //   19: putfield 80	twitter4j/internal/json/AccountSettingsJSONImpl:SLEEP_TIME_ENABLED	Z
        //   22: aload_0
        //   23: aload_1
        //   24: ldc 82
        //   26: invokevirtual 86	twitter4j/internal/org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
        //   29: putfield 88	twitter4j/internal/json/AccountSettingsJSONImpl:SLEEP_START_TIME	Ljava/lang/String;
        //   32: aload_0
        //   33: aload_1
        //   34: ldc 90
        //   36: invokevirtual 86	twitter4j/internal/org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
        //   39: putfield 92	twitter4j/internal/json/AccountSettingsJSONImpl:SLEEP_END_TIME	Ljava/lang/String;
        //   42: aload_2
        //   43: ldc 94
        //   45: invokevirtual 98	twitter4j/internal/org/json/JSONObject:isNull	(Ljava/lang/String;)Z
        //   48: ifeq +79 -> 127
        //   51: aload_0
        //   52: iconst_0
        //   53: anewarray 100	twitter4j/Location
        //   56: putfield 102	twitter4j/internal/json/AccountSettingsJSONImpl:TREND_LOCATION	[Ltwitter4j/Location;
        //   59: aload_0
        //   60: ldc 104
        //   62: aload_2
        //   63: invokestatic 78	twitter4j/internal/json/z_T4JInternalParseUtil:getBoolean	(Ljava/lang/String;Ltwitter4j/internal/org/json/JSONObject;)Z
        //   66: putfield 106	twitter4j/internal/json/AccountSettingsJSONImpl:GEO_ENABLED	Z
        //   69: aload_0
        //   70: aload_2
        //   71: ldc 108
        //   73: invokevirtual 86	twitter4j/internal/org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
        //   76: putfield 110	twitter4j/internal/json/AccountSettingsJSONImpl:LANGUAGE	Ljava/lang/String;
        //   79: aload_0
        //   80: ldc 112
        //   82: aload_2
        //   83: invokestatic 78	twitter4j/internal/json/z_T4JInternalParseUtil:getBoolean	(Ljava/lang/String;Ltwitter4j/internal/org/json/JSONObject;)Z
        //   86: putfield 114	twitter4j/internal/json/AccountSettingsJSONImpl:ALWAYS_USE_HTTPS	Z
        //   89: aload_0
        //   90: ldc 116
        //   92: aload_2
        //   93: invokestatic 78	twitter4j/internal/json/z_T4JInternalParseUtil:getBoolean	(Ljava/lang/String;Ltwitter4j/internal/org/json/JSONObject;)Z
        //   96: putfield 118	twitter4j/internal/json/AccountSettingsJSONImpl:DISCOVERABLE_BY_EMAIL	Z
        //   99: aload_0
        //   100: new 120	twitter4j/internal/json/TimeZoneJSONImpl
        //   103: dup
        //   104: aload_2
        //   105: ldc 122
        //   107: invokevirtual 70	twitter4j/internal/org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Ltwitter4j/internal/org/json/JSONObject;
        //   110: invokespecial 125	twitter4j/internal/json/TimeZoneJSONImpl:<init>	(Ltwitter4j/internal/org/json/JSONObject;)V
        //   113: putfield 127	twitter4j/internal/json/AccountSettingsJSONImpl:TIMEZONE	Ltwitter4j/TimeZone;
        //   116: aload_0
        //   117: aload_2
        //   118: ldc -127
        //   120: invokevirtual 86	twitter4j/internal/org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
        //   123: putfield 131	twitter4j/internal/json/AccountSettingsJSONImpl:SCREEN_NAME	Ljava/lang/String;
        //   126: return
        //   127: aload_2
        //   128: ldc 94
        //   130: invokevirtual 135	twitter4j/internal/org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Ltwitter4j/internal/org/json/JSONArray;
        //   133: astore_1
        //   134: aload_0
        //   135: aload_1
        //   136: invokevirtual 141	twitter4j/internal/org/json/JSONArray:length	()I
        //   139: anewarray 100	twitter4j/Location
        //   142: putfield 102	twitter4j/internal/json/AccountSettingsJSONImpl:TREND_LOCATION	[Ltwitter4j/Location;
        //   145: iconst_0
        //   146: istore_3
        //   147: iload_3
        //   148: aload_1
        //   149: invokevirtual 141	twitter4j/internal/org/json/JSONArray:length	()I
        //   152: if_icmpge -93 -> 59
        //   155: aload_0
        //   156: getfield 102	twitter4j/internal/json/AccountSettingsJSONImpl:TREND_LOCATION	[Ltwitter4j/Location;
        //   159: iload_3
        //   160: new 143	twitter4j/internal/json/LocationJSONImpl
        //   163: dup
        //   164: aload_1
        //   165: iload_3
        //   166: invokevirtual 146	twitter4j/internal/org/json/JSONArray:getJSONObject	(I)Ltwitter4j/internal/org/json/JSONObject;
        //   169: invokespecial 147	twitter4j/internal/json/LocationJSONImpl:<init>	(Ltwitter4j/internal/org/json/JSONObject;)V
        //   172: aastore
        //   173: iload_3
        //   174: iconst_1
        //   175: iadd
        //   176: istore_3
        //   177: goto -30 -> 147
        //   180: astore_1
        //   181: new 30	twitter4j/TwitterException
        //   184: dup
        //   185: aload_1
        //   186: invokespecial 150	twitter4j/TwitterException:<init>	(Ljava/lang/Exception;)V
        //   189: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	190	0	this	AccountSettingsJSONImpl
        //   0	190	1	paramHttpResponse	HttpResponse
        //   0	190	2	paramJSONObject	JSONObject
        //   146	31	3	i	int
        // Exception table:
        //   from	to	target	type
        //   5	59	180	twitter4j/internal/org/json/JSONException
        //   59	126	180	twitter4j/internal/org/json/JSONException
        //   127	145	180	twitter4j/internal/org/json/JSONException
        //   147	173	180	twitter4j/internal/org/json/JSONException
    }

    AccountSettingsJSONImpl(JSONObject paramJSONObject)
            throws TwitterException {
        this(null, paramJSONObject);
    }

    public String getLanguage() {
        return this.LANGUAGE;
    }

    public String getScreenName() {
        return this.SCREEN_NAME;
    }

    public String getSleepEndTime() {
        return this.SLEEP_END_TIME;
    }

    public String getSleepStartTime() {
        return this.SLEEP_START_TIME;
    }

    public TimeZone getTimeZone() {
        return this.TIMEZONE;
    }

    public Location[] getTrendLocations() {
        return this.TREND_LOCATION;
    }

    public boolean isAlwaysUseHttps() {
        return this.ALWAYS_USE_HTTPS;
    }

    public boolean isDiscoverableByEmail() {
        return this.DISCOVERABLE_BY_EMAIL;
    }

    public boolean isGeoEnabled() {
        return this.GEO_ENABLED;
    }

    public boolean isSleepTimeEnabled() {
        return this.SLEEP_TIME_ENABLED;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/twitter4j/internal/json/AccountSettingsJSONImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */