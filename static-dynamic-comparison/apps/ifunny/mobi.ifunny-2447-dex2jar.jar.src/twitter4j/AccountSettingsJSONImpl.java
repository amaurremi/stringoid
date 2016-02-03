package twitter4j;

import java.io.Serializable;

import twitter4j.conf.Configuration;

class AccountSettingsJSONImpl
        extends TwitterResponseImpl
        implements Serializable, AccountSettings {
    private static final long serialVersionUID = 603189815663175766L;
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

    /* Error */
    private AccountSettingsJSONImpl(HttpResponse paramHttpResponse, JSONObject paramJSONObject) {
        // Byte code:
        //   0: iconst_0
        //   1: istore_3
        //   2: aload_0
        //   3: aload_1
        //   4: invokespecial 33	twitter4j/TwitterResponseImpl:<init>	(Ltwitter4j/HttpResponse;)V
        //   7: aload_2
        //   8: ldc 35
        //   10: invokevirtual 41	twitter4j/JSONObject:getJSONObject	(Ljava/lang/String;)Ltwitter4j/JSONObject;
        //   13: astore_1
        //   14: aload_0
        //   15: ldc 43
        //   17: aload_1
        //   18: invokestatic 49	twitter4j/ParseUtil:getBoolean	(Ljava/lang/String;Ltwitter4j/JSONObject;)Z
        //   21: putfield 51	twitter4j/AccountSettingsJSONImpl:SLEEP_TIME_ENABLED	Z
        //   24: aload_0
        //   25: aload_1
        //   26: ldc 53
        //   28: invokevirtual 57	twitter4j/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
        //   31: putfield 59	twitter4j/AccountSettingsJSONImpl:SLEEP_START_TIME	Ljava/lang/String;
        //   34: aload_0
        //   35: aload_1
        //   36: ldc 61
        //   38: invokevirtual 57	twitter4j/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
        //   41: putfield 63	twitter4j/AccountSettingsJSONImpl:SLEEP_END_TIME	Ljava/lang/String;
        //   44: aload_2
        //   45: ldc 65
        //   47: invokevirtual 69	twitter4j/JSONObject:isNull	(Ljava/lang/String;)Z
        //   50: ifeq +76 -> 126
        //   53: aload_0
        //   54: iconst_0
        //   55: anewarray 71	twitter4j/Location
        //   58: putfield 73	twitter4j/AccountSettingsJSONImpl:TREND_LOCATION	[Ltwitter4j/Location;
        //   61: aload_0
        //   62: ldc 75
        //   64: aload_2
        //   65: invokestatic 49	twitter4j/ParseUtil:getBoolean	(Ljava/lang/String;Ltwitter4j/JSONObject;)Z
        //   68: putfield 77	twitter4j/AccountSettingsJSONImpl:GEO_ENABLED	Z
        //   71: aload_0
        //   72: aload_2
        //   73: ldc 79
        //   75: invokevirtual 57	twitter4j/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
        //   78: putfield 81	twitter4j/AccountSettingsJSONImpl:LANGUAGE	Ljava/lang/String;
        //   81: aload_0
        //   82: ldc 83
        //   84: aload_2
        //   85: invokestatic 49	twitter4j/ParseUtil:getBoolean	(Ljava/lang/String;Ltwitter4j/JSONObject;)Z
        //   88: putfield 85	twitter4j/AccountSettingsJSONImpl:ALWAYS_USE_HTTPS	Z
        //   91: aload_0
        //   92: ldc 87
        //   94: aload_2
        //   95: invokestatic 49	twitter4j/ParseUtil:getBoolean	(Ljava/lang/String;Ltwitter4j/JSONObject;)Z
        //   98: putfield 89	twitter4j/AccountSettingsJSONImpl:DISCOVERABLE_BY_EMAIL	Z
        //   101: aload_2
        //   102: ldc 91
        //   104: invokevirtual 69	twitter4j/JSONObject:isNull	(Ljava/lang/String;)Z
        //   107: ifeq +70 -> 177
        //   110: aload_0
        //   111: aconst_null
        //   112: putfield 93	twitter4j/AccountSettingsJSONImpl:TIMEZONE	Ltwitter4j/TimeZone;
        //   115: aload_0
        //   116: aload_2
        //   117: ldc 95
        //   119: invokevirtual 57	twitter4j/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
        //   122: putfield 97	twitter4j/AccountSettingsJSONImpl:SCREEN_NAME	Ljava/lang/String;
        //   125: return
        //   126: aload_2
        //   127: ldc 65
        //   129: invokevirtual 101	twitter4j/JSONObject:getJSONArray	(Ljava/lang/String;)Ltwitter4j/JSONArray;
        //   132: astore_1
        //   133: aload_0
        //   134: aload_1
        //   135: invokevirtual 107	twitter4j/JSONArray:length	()I
        //   138: anewarray 71	twitter4j/Location
        //   141: putfield 73	twitter4j/AccountSettingsJSONImpl:TREND_LOCATION	[Ltwitter4j/Location;
        //   144: iload_3
        //   145: aload_1
        //   146: invokevirtual 107	twitter4j/JSONArray:length	()I
        //   149: if_icmpge -88 -> 61
        //   152: aload_0
        //   153: getfield 73	twitter4j/AccountSettingsJSONImpl:TREND_LOCATION	[Ltwitter4j/Location;
        //   156: iload_3
        //   157: new 109	twitter4j/LocationJSONImpl
        //   160: dup
        //   161: aload_1
        //   162: iload_3
        //   163: invokevirtual 112	twitter4j/JSONArray:getJSONObject	(I)Ltwitter4j/JSONObject;
        //   166: invokespecial 115	twitter4j/LocationJSONImpl:<init>	(Ltwitter4j/JSONObject;)V
        //   169: aastore
        //   170: iload_3
        //   171: iconst_1
        //   172: iadd
        //   173: istore_3
        //   174: goto -30 -> 144
        //   177: aload_0
        //   178: new 117	twitter4j/TimeZoneJSONImpl
        //   181: dup
        //   182: aload_2
        //   183: ldc 91
        //   185: invokevirtual 41	twitter4j/JSONObject:getJSONObject	(Ljava/lang/String;)Ltwitter4j/JSONObject;
        //   188: invokespecial 118	twitter4j/TimeZoneJSONImpl:<init>	(Ltwitter4j/JSONObject;)V
        //   191: putfield 93	twitter4j/AccountSettingsJSONImpl:TIMEZONE	Ltwitter4j/TimeZone;
        //   194: goto -79 -> 115
        //   197: astore_1
        //   198: new 120	twitter4j/TwitterException
        //   201: dup
        //   202: aload_1
        //   203: invokespecial 123	twitter4j/TwitterException:<init>	(Ljava/lang/Exception;)V
        //   206: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	207	0	this	AccountSettingsJSONImpl
        //   0	207	1	paramHttpResponse	HttpResponse
        //   0	207	2	paramJSONObject	JSONObject
        //   1	173	3	i	int
        // Exception table:
        //   from	to	target	type
        //   7	61	197	twitter4j/JSONException
        //   61	115	197	twitter4j/JSONException
        //   115	125	197	twitter4j/JSONException
        //   126	144	197	twitter4j/JSONException
        //   144	170	197	twitter4j/JSONException
        //   177	194	197	twitter4j/JSONException
    }

    AccountSettingsJSONImpl(HttpResponse paramHttpResponse, Configuration paramConfiguration) {
        this(paramHttpResponse, paramHttpResponse.asJSONObject());
        if (paramConfiguration.isJSONStoreEnabled()) {
            TwitterObjectFactory.clearThreadLocalMap();
            TwitterObjectFactory.registerJSONObject(this, paramHttpResponse.asJSONObject());
        }
    }

    AccountSettingsJSONImpl(JSONObject paramJSONObject) {
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


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/twitter4j/AccountSettingsJSONImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */