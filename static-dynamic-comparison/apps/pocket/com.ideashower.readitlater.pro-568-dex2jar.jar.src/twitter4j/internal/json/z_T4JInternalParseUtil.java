package twitter4j.internal.json;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import twitter4j.internal.http.HttpResponse;
import twitter4j.internal.org.json.JSONException;
import twitter4j.internal.org.json.JSONObject;

public final class z_T4JInternalParseUtil
{
  private static final Map formatMapQueue = new HashMap();
  
  private z_T4JInternalParseUtil()
  {
    throw new AssertionError();
  }
  
  public static boolean getBoolean(String paramString, JSONObject paramJSONObject)
  {
    paramString = getRawString(paramString, paramJSONObject);
    if ((paramString == null) || ("null".equals(paramString))) {
      return false;
    }
    return Boolean.valueOf(paramString).booleanValue();
  }
  
  /* Error */
  public static Date getDate(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: getstatic 15	twitter4j/internal/json/z_T4JInternalParseUtil:formatMapQueue	Ljava/util/Map;
    //   3: aload_1
    //   4: invokeinterface 56 2 0
    //   9: checkcast 58	java/util/concurrent/LinkedBlockingQueue
    //   12: astore_2
    //   13: aload_2
    //   14: ifnonnull +122 -> 136
    //   17: new 58	java/util/concurrent/LinkedBlockingQueue
    //   20: dup
    //   21: invokespecial 59	java/util/concurrent/LinkedBlockingQueue:<init>	()V
    //   24: astore_2
    //   25: getstatic 15	twitter4j/internal/json/z_T4JInternalParseUtil:formatMapQueue	Ljava/util/Map;
    //   28: aload_1
    //   29: aload_2
    //   30: invokeinterface 63 3 0
    //   35: pop
    //   36: aload_2
    //   37: invokevirtual 67	java/util/concurrent/LinkedBlockingQueue:poll	()Ljava/lang/Object;
    //   40: checkcast 69	java/text/SimpleDateFormat
    //   43: astore_3
    //   44: aload_3
    //   45: ifnonnull +86 -> 131
    //   48: new 69	java/text/SimpleDateFormat
    //   51: dup
    //   52: aload_1
    //   53: getstatic 75	java/util/Locale:US	Ljava/util/Locale;
    //   56: invokespecial 78	java/text/SimpleDateFormat:<init>	(Ljava/lang/String;Ljava/util/Locale;)V
    //   59: astore_1
    //   60: aload_1
    //   61: ldc 80
    //   63: invokestatic 86	java/util/TimeZone:getTimeZone	(Ljava/lang/String;)Ljava/util/TimeZone;
    //   66: invokevirtual 90	java/text/SimpleDateFormat:setTimeZone	(Ljava/util/TimeZone;)V
    //   69: aload_1
    //   70: aload_0
    //   71: invokevirtual 94	java/text/SimpleDateFormat:parse	(Ljava/lang/String;)Ljava/util/Date;
    //   74: astore_3
    //   75: aload_2
    //   76: aload_1
    //   77: invokevirtual 97	java/util/concurrent/LinkedBlockingQueue:put	(Ljava/lang/Object;)V
    //   80: aload_3
    //   81: areturn
    //   82: astore_3
    //   83: new 99	twitter4j/TwitterException
    //   86: dup
    //   87: new 101	java/lang/StringBuilder
    //   90: dup
    //   91: invokespecial 102	java/lang/StringBuilder:<init>	()V
    //   94: ldc 104
    //   96: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   99: aload_0
    //   100: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   103: ldc 110
    //   105: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   108: invokevirtual 114	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   111: aload_3
    //   112: invokespecial 117	twitter4j/TwitterException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   115: athrow
    //   116: astore_0
    //   117: aload_2
    //   118: aload_1
    //   119: invokevirtual 97	java/util/concurrent/LinkedBlockingQueue:put	(Ljava/lang/Object;)V
    //   122: aload_0
    //   123: athrow
    //   124: astore_0
    //   125: aload_3
    //   126: areturn
    //   127: astore_1
    //   128: goto -6 -> 122
    //   131: aload_3
    //   132: astore_1
    //   133: goto -64 -> 69
    //   136: goto -100 -> 36
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	139	0	paramString1	String
    //   0	139	1	paramString2	String
    //   12	106	2	localLinkedBlockingQueue	java.util.concurrent.LinkedBlockingQueue
    //   43	38	3	localObject	Object
    //   82	50	3	localParseException	java.text.ParseException
    // Exception table:
    //   from	to	target	type
    //   69	75	82	java/text/ParseException
    //   69	75	116	finally
    //   83	116	116	finally
    //   75	80	124	java/lang/InterruptedException
    //   117	122	127	java/lang/InterruptedException
  }
  
  public static Date getDate(String paramString, JSONObject paramJSONObject)
  {
    return getDate(paramString, paramJSONObject, "EEE MMM d HH:mm:ss z yyyy");
  }
  
  public static Date getDate(String paramString1, JSONObject paramJSONObject, String paramString2)
  {
    paramString1 = getUnescapedString(paramString1, paramJSONObject);
    if (("null".equals(paramString1)) || (paramString1 == null)) {
      return null;
    }
    return getDate(paramString1, paramString2);
  }
  
  public static double getDouble(String paramString, JSONObject paramJSONObject)
  {
    paramString = getRawString(paramString, paramJSONObject);
    if ((paramString == null) || ("".equals(paramString)) || ("null".equals(paramString))) {
      return -1.0D;
    }
    return Double.valueOf(paramString).doubleValue();
  }
  
  public static int getInt(String paramString)
  {
    if ((paramString == null) || ("".equals(paramString)) || ("null".equals(paramString))) {
      return -1;
    }
    try
    {
      int i = Integer.valueOf(paramString).intValue();
      return i;
    }
    catch (NumberFormatException paramString) {}
    return -1;
  }
  
  public static int getInt(String paramString, JSONObject paramJSONObject)
  {
    return getInt(getRawString(paramString, paramJSONObject));
  }
  
  public static long getLong(String paramString)
  {
    if ((paramString == null) || ("".equals(paramString)) || ("null".equals(paramString))) {
      return -1L;
    }
    if (paramString.endsWith("+")) {
      return Long.valueOf(paramString.substring(0, paramString.length() - 1)).longValue() + 1L;
    }
    return Long.valueOf(paramString).longValue();
  }
  
  public static long getLong(String paramString, JSONObject paramJSONObject)
  {
    return getLong(getRawString(paramString, paramJSONObject));
  }
  
  public static String getRawString(String paramString, JSONObject paramJSONObject)
  {
    try
    {
      if (paramJSONObject.isNull(paramString)) {
        return null;
      }
      paramString = paramJSONObject.getString(paramString);
      return paramString;
    }
    catch (JSONException paramString) {}
    return null;
  }
  
  static String getURLDecodedString(String paramString, JSONObject paramJSONObject)
  {
    paramJSONObject = getRawString(paramString, paramJSONObject);
    paramString = paramJSONObject;
    if (paramJSONObject != null) {}
    try
    {
      paramString = URLDecoder.decode(paramJSONObject, "UTF-8");
      return paramString;
    }
    catch (UnsupportedEncodingException paramString) {}
    return paramJSONObject;
  }
  
  static String getUnescapedString(String paramString, JSONObject paramJSONObject)
  {
    return HTMLEntity.unescape(getRawString(paramString, paramJSONObject));
  }
  
  public static Date parseTrendsDate(String paramString)
  {
    switch (paramString.length())
    {
    default: 
      return getDate(paramString, "EEE, d MMM yyyy HH:mm:ss z");
    case 10: 
      return new Date(Long.parseLong(paramString) * 1000L);
    }
    return getDate(paramString, "yyyy-MM-dd'T'HH:mm:ss'Z'");
  }
  
  public static int toAccessLevel(HttpResponse paramHttpResponse)
  {
    int i = 0;
    if (paramHttpResponse == null) {
      i = -1;
    }
    do
    {
      return i;
      paramHttpResponse = paramHttpResponse.getResponseHeader("X-Access-Level");
    } while (paramHttpResponse == null);
    switch (paramHttpResponse.length())
    {
    default: 
      return 0;
    case 4: 
      return 1;
    case 10: 
      return 2;
    case 25: 
      return 3;
    }
    return 3;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/twitter4j/internal/json/z_T4JInternalParseUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */