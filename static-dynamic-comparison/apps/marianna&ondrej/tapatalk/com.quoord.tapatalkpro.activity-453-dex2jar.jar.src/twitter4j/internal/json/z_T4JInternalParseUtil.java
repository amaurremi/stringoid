package twitter4j.internal.json;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;

import twitter4j.TwitterException;
import twitter4j.internal.http.HttpResponse;
import twitter4j.internal.org.json.JSONException;
import twitter4j.internal.org.json.JSONObject;

public final class z_T4JInternalParseUtil {
    private static final Map<String, LinkedBlockingQueue<SimpleDateFormat>> formatMapQueue = new HashMap();

    private z_T4JInternalParseUtil() {
        throw new AssertionError();
    }

    public static boolean getBoolean(String paramString, JSONObject paramJSONObject) {
        paramString = getRawString(paramString, paramJSONObject);
        if ((paramString == null) || ("null".equals(paramString))) {
            return false;
        }
        return Boolean.valueOf(paramString).booleanValue();
    }

    /* Error */
    public static Date getDate(String paramString1, String paramString2)
            throws TwitterException {
        // Byte code:
        //   0: getstatic 16	twitter4j/internal/json/z_T4JInternalParseUtil:formatMapQueue	Ljava/util/Map;
        //   3: aload_1
        //   4: invokeinterface 59 2 0
        //   9: checkcast 61	java/util/concurrent/LinkedBlockingQueue
        //   12: astore_3
        //   13: aload_3
        //   14: astore_2
        //   15: aload_3
        //   16: ifnonnull +22 -> 38
        //   19: new 61	java/util/concurrent/LinkedBlockingQueue
        //   22: dup
        //   23: invokespecial 62	java/util/concurrent/LinkedBlockingQueue:<init>	()V
        //   26: astore_2
        //   27: getstatic 16	twitter4j/internal/json/z_T4JInternalParseUtil:formatMapQueue	Ljava/util/Map;
        //   30: aload_1
        //   31: aload_2
        //   32: invokeinterface 66 3 0
        //   37: pop
        //   38: aload_2
        //   39: invokevirtual 70	java/util/concurrent/LinkedBlockingQueue:poll	()Ljava/lang/Object;
        //   42: checkcast 72	java/text/SimpleDateFormat
        //   45: astore 4
        //   47: aload 4
        //   49: astore_3
        //   50: aload 4
        //   52: ifnonnull +24 -> 76
        //   55: new 72	java/text/SimpleDateFormat
        //   58: dup
        //   59: aload_1
        //   60: getstatic 78	java/util/Locale:US	Ljava/util/Locale;
        //   63: invokespecial 81	java/text/SimpleDateFormat:<init>	(Ljava/lang/String;Ljava/util/Locale;)V
        //   66: astore_3
        //   67: aload_3
        //   68: ldc 83
        //   70: invokestatic 89	java/util/TimeZone:getTimeZone	(Ljava/lang/String;)Ljava/util/TimeZone;
        //   73: invokevirtual 93	java/text/SimpleDateFormat:setTimeZone	(Ljava/util/TimeZone;)V
        //   76: aload_3
        //   77: aload_0
        //   78: invokevirtual 97	java/text/SimpleDateFormat:parse	(Ljava/lang/String;)Ljava/util/Date;
        //   81: astore_1
        //   82: aload_2
        //   83: aload_3
        //   84: invokevirtual 100	java/util/concurrent/LinkedBlockingQueue:put	(Ljava/lang/Object;)V
        //   87: aload_1
        //   88: areturn
        //   89: astore_1
        //   90: new 49	twitter4j/TwitterException
        //   93: dup
        //   94: new 102	java/lang/StringBuilder
        //   97: dup
        //   98: invokespecial 103	java/lang/StringBuilder:<init>	()V
        //   101: ldc 105
        //   103: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   106: aload_0
        //   107: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   110: ldc 111
        //   112: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   115: invokevirtual 115	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   118: aload_1
        //   119: invokespecial 118	twitter4j/TwitterException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
        //   122: athrow
        //   123: astore_0
        //   124: aload_2
        //   125: aload_3
        //   126: invokevirtual 100	java/util/concurrent/LinkedBlockingQueue:put	(Ljava/lang/Object;)V
        //   129: aload_0
        //   130: athrow
        //   131: astore_0
        //   132: aload_1
        //   133: areturn
        //   134: astore_1
        //   135: goto -6 -> 129
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	138	0	paramString1	String
        //   0	138	1	paramString2	String
        //   14	111	2	localObject1	Object
        //   12	114	3	localObject2	Object
        //   45	6	4	localSimpleDateFormat	SimpleDateFormat
        // Exception table:
        //   from	to	target	type
        //   76	82	89	java/text/ParseException
        //   76	82	123	finally
        //   90	123	123	finally
        //   82	87	131	java/lang/InterruptedException
        //   124	129	134	java/lang/InterruptedException
    }

    public static Date getDate(String paramString, JSONObject paramJSONObject)
            throws TwitterException {
        return getDate(paramString, paramJSONObject, "EEE MMM d HH:mm:ss z yyyy");
    }

    public static Date getDate(String paramString1, JSONObject paramJSONObject, String paramString2)
            throws TwitterException {
        paramString1 = getUnescapedString(paramString1, paramJSONObject);
        if (("null".equals(paramString1)) || (paramString1 == null)) {
            return null;
        }
        return getDate(paramString1, paramString2);
    }

    public static double getDouble(String paramString, JSONObject paramJSONObject) {
        paramString = getRawString(paramString, paramJSONObject);
        if ((paramString == null) || ("".equals(paramString)) || ("null".equals(paramString))) {
            return -1.0D;
        }
        return Double.valueOf(paramString).doubleValue();
    }

    public static int getInt(String paramString) {
        if ((paramString == null) || ("".equals(paramString)) || ("null".equals(paramString))) {
            return -1;
        }
        try {
            int i = Integer.valueOf(paramString).intValue();
            return i;
        } catch (NumberFormatException paramString) {
        }
        return -1;
    }

    public static int getInt(String paramString, JSONObject paramJSONObject) {
        return getInt(getRawString(paramString, paramJSONObject));
    }

    public static long getLong(String paramString) {
        if ((paramString == null) || ("".equals(paramString)) || ("null".equals(paramString))) {
            return -1L;
        }
        if (paramString.endsWith("+")) {
            return Long.valueOf(paramString.substring(0, paramString.length() - 1)).longValue() + 1L;
        }
        return Long.valueOf(paramString).longValue();
    }

    public static long getLong(String paramString, JSONObject paramJSONObject) {
        return getLong(getRawString(paramString, paramJSONObject));
    }

    public static String getRawString(String paramString, JSONObject paramJSONObject) {
        try {
            if (paramJSONObject.isNull(paramString)) {
                return null;
            }
            paramString = paramJSONObject.getString(paramString);
            return paramString;
        } catch (JSONException paramString) {
        }
        return null;
    }

    static String getURLDecodedString(String paramString, JSONObject paramJSONObject) {
        paramJSONObject = getRawString(paramString, paramJSONObject);
        paramString = paramJSONObject;
        if (paramJSONObject != null) {
        }
        try {
            paramString = URLDecoder.decode(paramJSONObject, "UTF-8");
            return paramString;
        } catch (UnsupportedEncodingException paramString) {
        }
        return paramJSONObject;
    }

    static String getUnescapedString(String paramString, JSONObject paramJSONObject) {
        return HTMLEntity.unescape(getRawString(paramString, paramJSONObject));
    }

    public static Date parseTrendsDate(String paramString)
            throws TwitterException {
        switch (paramString.length()) {
            default:
                return getDate(paramString, "EEE, d MMM yyyy HH:mm:ss z");
            case 10:
                return new Date(Long.parseLong(paramString) * 1000L);
        }
        return getDate(paramString, "yyyy-MM-dd'T'HH:mm:ss'Z'");
    }

    public static int toAccessLevel(HttpResponse paramHttpResponse) {
        if (paramHttpResponse == null) {
            return -1;
        }
        paramHttpResponse = paramHttpResponse.getResponseHeader("X-Access-Level");
        if (paramHttpResponse == null) {
            return 0;
        }
        switch (paramHttpResponse.length()) {
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


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/twitter4j/internal/json/z_T4JInternalParseUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */