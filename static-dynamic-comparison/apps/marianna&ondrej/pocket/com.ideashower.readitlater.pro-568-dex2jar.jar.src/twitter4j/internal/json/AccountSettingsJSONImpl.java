package twitter4j.internal.json;

import java.io.Serializable;
import twitter4j.AccountSettings;
import twitter4j.Location;
import twitter4j.TimeZone;
import twitter4j.conf.Configuration;
import twitter4j.internal.http.HttpResponse;
import twitter4j.internal.org.json.JSONObject;

class AccountSettingsJSONImpl
  extends TwitterResponseImpl
  implements Serializable, AccountSettings
{
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
  {
    this(paramHttpResponse, paramHttpResponse.asJSONObject());
    if (paramConfiguration.isJSONStoreEnabled())
    {
      DataObjectFactoryUtil.clearThreadLocalMap();
      DataObjectFactoryUtil.registerJSONObject(this, paramHttpResponse.asJSONObject());
    }
  }
  
  /* Error */
  private AccountSettingsJSONImpl(HttpResponse paramHttpResponse, JSONObject paramJSONObject)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: aload_0
    //   3: aload_1
    //   4: invokespecial 59	twitter4j/internal/json/TwitterResponseImpl:<init>	(Ltwitter4j/internal/http/HttpResponse;)V
    //   7: aload_2
    //   8: ldc 61
    //   10: invokevirtual 67	twitter4j/internal/org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Ltwitter4j/internal/org/json/JSONObject;
    //   13: astore_1
    //   14: aload_0
    //   15: ldc 69
    //   17: aload_1
    //   18: invokestatic 75	twitter4j/internal/json/z_T4JInternalParseUtil:getBoolean	(Ljava/lang/String;Ltwitter4j/internal/org/json/JSONObject;)Z
    //   21: putfield 77	twitter4j/internal/json/AccountSettingsJSONImpl:SLEEP_TIME_ENABLED	Z
    //   24: aload_0
    //   25: aload_1
    //   26: ldc 79
    //   28: invokevirtual 83	twitter4j/internal/org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   31: putfield 85	twitter4j/internal/json/AccountSettingsJSONImpl:SLEEP_START_TIME	Ljava/lang/String;
    //   34: aload_0
    //   35: aload_1
    //   36: ldc 87
    //   38: invokevirtual 83	twitter4j/internal/org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   41: putfield 89	twitter4j/internal/json/AccountSettingsJSONImpl:SLEEP_END_TIME	Ljava/lang/String;
    //   44: aload_2
    //   45: ldc 91
    //   47: invokevirtual 95	twitter4j/internal/org/json/JSONObject:isNull	(Ljava/lang/String;)Z
    //   50: ifeq +79 -> 129
    //   53: aload_0
    //   54: iconst_0
    //   55: anewarray 97	twitter4j/Location
    //   58: putfield 99	twitter4j/internal/json/AccountSettingsJSONImpl:TREND_LOCATION	[Ltwitter4j/Location;
    //   61: aload_0
    //   62: ldc 101
    //   64: aload_2
    //   65: invokestatic 75	twitter4j/internal/json/z_T4JInternalParseUtil:getBoolean	(Ljava/lang/String;Ltwitter4j/internal/org/json/JSONObject;)Z
    //   68: putfield 103	twitter4j/internal/json/AccountSettingsJSONImpl:GEO_ENABLED	Z
    //   71: aload_0
    //   72: aload_2
    //   73: ldc 105
    //   75: invokevirtual 83	twitter4j/internal/org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   78: putfield 107	twitter4j/internal/json/AccountSettingsJSONImpl:LANGUAGE	Ljava/lang/String;
    //   81: aload_0
    //   82: ldc 109
    //   84: aload_2
    //   85: invokestatic 75	twitter4j/internal/json/z_T4JInternalParseUtil:getBoolean	(Ljava/lang/String;Ltwitter4j/internal/org/json/JSONObject;)Z
    //   88: putfield 111	twitter4j/internal/json/AccountSettingsJSONImpl:ALWAYS_USE_HTTPS	Z
    //   91: aload_0
    //   92: ldc 113
    //   94: aload_2
    //   95: invokestatic 75	twitter4j/internal/json/z_T4JInternalParseUtil:getBoolean	(Ljava/lang/String;Ltwitter4j/internal/org/json/JSONObject;)Z
    //   98: putfield 115	twitter4j/internal/json/AccountSettingsJSONImpl:DISCOVERABLE_BY_EMAIL	Z
    //   101: aload_0
    //   102: new 117	twitter4j/internal/json/TimeZoneJSONImpl
    //   105: dup
    //   106: aload_2
    //   107: ldc 119
    //   109: invokevirtual 67	twitter4j/internal/org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Ltwitter4j/internal/org/json/JSONObject;
    //   112: invokespecial 122	twitter4j/internal/json/TimeZoneJSONImpl:<init>	(Ltwitter4j/internal/org/json/JSONObject;)V
    //   115: putfield 124	twitter4j/internal/json/AccountSettingsJSONImpl:TIMEZONE	Ltwitter4j/TimeZone;
    //   118: aload_0
    //   119: aload_2
    //   120: ldc 126
    //   122: invokevirtual 83	twitter4j/internal/org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   125: putfield 128	twitter4j/internal/json/AccountSettingsJSONImpl:SCREEN_NAME	Ljava/lang/String;
    //   128: return
    //   129: aload_2
    //   130: ldc 91
    //   132: invokevirtual 132	twitter4j/internal/org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Ltwitter4j/internal/org/json/JSONArray;
    //   135: astore_1
    //   136: aload_0
    //   137: aload_1
    //   138: invokevirtual 138	twitter4j/internal/org/json/JSONArray:length	()I
    //   141: anewarray 97	twitter4j/Location
    //   144: putfield 99	twitter4j/internal/json/AccountSettingsJSONImpl:TREND_LOCATION	[Ltwitter4j/Location;
    //   147: iload_3
    //   148: aload_1
    //   149: invokevirtual 138	twitter4j/internal/org/json/JSONArray:length	()I
    //   152: if_icmpge -91 -> 61
    //   155: aload_0
    //   156: getfield 99	twitter4j/internal/json/AccountSettingsJSONImpl:TREND_LOCATION	[Ltwitter4j/Location;
    //   159: iload_3
    //   160: new 140	twitter4j/internal/json/LocationJSONImpl
    //   163: dup
    //   164: aload_1
    //   165: iload_3
    //   166: invokevirtual 143	twitter4j/internal/org/json/JSONArray:getJSONObject	(I)Ltwitter4j/internal/org/json/JSONObject;
    //   169: invokespecial 144	twitter4j/internal/json/LocationJSONImpl:<init>	(Ltwitter4j/internal/org/json/JSONObject;)V
    //   172: aastore
    //   173: iload_3
    //   174: iconst_1
    //   175: iadd
    //   176: istore_3
    //   177: goto -30 -> 147
    //   180: astore_1
    //   181: new 146	twitter4j/TwitterException
    //   184: dup
    //   185: aload_1
    //   186: invokespecial 149	twitter4j/TwitterException:<init>	(Ljava/lang/Exception;)V
    //   189: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	190	0	this	AccountSettingsJSONImpl
    //   0	190	1	paramHttpResponse	HttpResponse
    //   0	190	2	paramJSONObject	JSONObject
    //   1	176	3	i	int
    // Exception table:
    //   from	to	target	type
    //   7	61	180	twitter4j/internal/org/json/JSONException
    //   61	128	180	twitter4j/internal/org/json/JSONException
    //   129	147	180	twitter4j/internal/org/json/JSONException
    //   147	173	180	twitter4j/internal/org/json/JSONException
  }
  
  AccountSettingsJSONImpl(JSONObject paramJSONObject)
  {
    this(null, paramJSONObject);
  }
  
  public String getLanguage()
  {
    return this.LANGUAGE;
  }
  
  public String getScreenName()
  {
    return this.SCREEN_NAME;
  }
  
  public String getSleepEndTime()
  {
    return this.SLEEP_END_TIME;
  }
  
  public String getSleepStartTime()
  {
    return this.SLEEP_START_TIME;
  }
  
  public TimeZone getTimeZone()
  {
    return this.TIMEZONE;
  }
  
  public Location[] getTrendLocations()
  {
    return this.TREND_LOCATION;
  }
  
  public boolean isAlwaysUseHttps()
  {
    return this.ALWAYS_USE_HTTPS;
  }
  
  public boolean isDiscoverableByEmail()
  {
    return this.DISCOVERABLE_BY_EMAIL;
  }
  
  public boolean isGeoEnabled()
  {
    return this.GEO_ENABLED;
  }
  
  public boolean isSleepTimeEnabled()
  {
    return this.SLEEP_TIME_ENABLED;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/twitter4j/internal/json/AccountSettingsJSONImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */