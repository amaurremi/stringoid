package com.inmobi.commons.analytics.util;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.telephony.TelephonyManager;
import android.util.Base64OutputStream;
import android.util.DisplayMetrics;
import com.inmobi.commons.analytics.bootstrapper.AnalyticsConfigParams;
import com.inmobi.commons.analytics.bootstrapper.AnalyticsEndPointsConfig;
import com.inmobi.commons.analytics.bootstrapper.AnalyticsInitializer;
import com.inmobi.commons.analytics.events.AnalyticsEventsWrapper.IMItemType;
import com.inmobi.commons.analytics.events.AnalyticsEventsWrapper.IMSectionStatus;
import com.inmobi.commons.internal.Log;
import java.io.ByteArrayOutputStream;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.zip.GZIPOutputStream;
import org.json.JSONObject;

public class AnalyticsUtils
{
  public static final String ANALYTICS_LOGGING_TAG = "[InMobi]-[Analytics]-4.1.1";
  public static final String INITIALIZE_NOT_CALLED = "Please call InMobi.initialize or startSession before calling any events API";
  private static String a;
  private static boolean b;
  
  /* Error */
  public static void asyncPingInternal(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore_2
    //   4: aload_3
    //   5: astore_1
    //   6: aload_0
    //   7: ldc 25
    //   9: ldc 27
    //   11: invokevirtual 33	java/lang/String:replaceAll	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   14: astore_0
    //   15: aload_3
    //   16: astore_1
    //   17: ldc 8
    //   19: new 35	java/lang/StringBuilder
    //   22: dup
    //   23: invokespecial 36	java/lang/StringBuilder:<init>	()V
    //   26: ldc 38
    //   28: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   31: aload_0
    //   32: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: invokevirtual 46	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   38: invokestatic 52	com/inmobi/commons/internal/Log:debug	(Ljava/lang/String;Ljava/lang/String;)V
    //   41: aload_3
    //   42: astore_1
    //   43: new 54	java/net/URL
    //   46: dup
    //   47: aload_0
    //   48: invokespecial 56	java/net/URL:<init>	(Ljava/lang/String;)V
    //   51: invokevirtual 60	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   54: checkcast 62	java/net/HttpURLConnection
    //   57: astore_0
    //   58: aload_0
    //   59: sipush 20000
    //   62: invokevirtual 66	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   65: aload_0
    //   66: ldc 68
    //   68: invokevirtual 71	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   71: aload_0
    //   72: invokestatic 77	com/inmobi/commons/internal/InternalSDKUtil:addCommonPropertiesToConnection	(Ljava/net/HttpURLConnection;)V
    //   75: ldc 8
    //   77: new 35	java/lang/StringBuilder
    //   80: dup
    //   81: invokespecial 36	java/lang/StringBuilder:<init>	()V
    //   84: ldc 79
    //   86: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   89: aload_0
    //   90: invokevirtual 83	java/net/HttpURLConnection:getResponseCode	()I
    //   93: invokevirtual 86	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   96: invokevirtual 46	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   99: invokestatic 52	com/inmobi/commons/internal/Log:debug	(Ljava/lang/String;Ljava/lang/String;)V
    //   102: aload_0
    //   103: ifnull +7 -> 110
    //   106: aload_0
    //   107: invokevirtual 89	java/net/HttpURLConnection:disconnect	()V
    //   110: return
    //   111: astore_1
    //   112: aload_2
    //   113: astore_0
    //   114: aload_1
    //   115: astore_2
    //   116: aload_0
    //   117: astore_1
    //   118: ldc 8
    //   120: ldc 91
    //   122: aload_2
    //   123: invokestatic 94	com/inmobi/commons/internal/Log:debug	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   126: aload_0
    //   127: ifnull -17 -> 110
    //   130: aload_0
    //   131: invokevirtual 89	java/net/HttpURLConnection:disconnect	()V
    //   134: return
    //   135: astore_2
    //   136: aload_1
    //   137: astore_0
    //   138: aload_2
    //   139: astore_1
    //   140: aload_0
    //   141: ifnull +7 -> 148
    //   144: aload_0
    //   145: invokevirtual 89	java/net/HttpURLConnection:disconnect	()V
    //   148: aload_1
    //   149: athrow
    //   150: astore_1
    //   151: goto -11 -> 140
    //   154: astore_2
    //   155: goto -39 -> 116
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	158	0	paramString	String
    //   5	38	1	localObject1	Object
    //   111	4	1	localException1	Exception
    //   117	32	1	localObject2	Object
    //   150	1	1	localObject3	Object
    //   3	120	2	localObject4	Object
    //   135	4	2	localObject5	Object
    //   154	1	2	localException2	Exception
    //   1	41	3	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   6	15	111	java/lang/Exception
    //   17	41	111	java/lang/Exception
    //   43	58	111	java/lang/Exception
    //   6	15	135	finally
    //   17	41	135	finally
    //   43	58	135	finally
    //   118	126	135	finally
    //   58	102	150	finally
    //   58	102	154	java/lang/Exception
  }
  
  public static String compressPayload(String paramString)
  {
    try
    {
      ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
      Base64OutputStream localBase64OutputStream = new Base64OutputStream(localByteArrayOutputStream, 0);
      GZIPOutputStream localGZIPOutputStream = new GZIPOutputStream(localBase64OutputStream);
      localGZIPOutputStream.write(paramString.getBytes("UTF-8"));
      localGZIPOutputStream.close();
      localBase64OutputStream.close();
      paramString = localByteArrayOutputStream.toString();
      return paramString;
    }
    catch (Exception paramString)
    {
      Log.internal("[InMobi]-[Analytics]-4.1.1", "Exception compress sdk payload.", paramString);
    }
    return null;
  }
  
  public static String convertItemType(AnalyticsEventsWrapper.IMItemType paramIMItemType)
  {
    String str = null;
    if (paramIMItemType == AnalyticsEventsWrapper.IMItemType.CONSUMABLE) {
      str = "1";
    }
    do
    {
      return str;
      if (paramIMItemType == AnalyticsEventsWrapper.IMItemType.DURABLE) {
        return "2";
      }
    } while (paramIMItemType != AnalyticsEventsWrapper.IMItemType.PERSONALIZATION);
    return "3";
  }
  
  public static String convertLevelStatus(AnalyticsEventsWrapper.IMSectionStatus paramIMSectionStatus)
  {
    String str = null;
    if (paramIMSectionStatus == AnalyticsEventsWrapper.IMSectionStatus.COMPLETED) {
      str = "1";
    }
    do
    {
      return str;
      if (paramIMSectionStatus == AnalyticsEventsWrapper.IMSectionStatus.FAILED) {
        return "2";
      }
    } while (paramIMSectionStatus != AnalyticsEventsWrapper.IMSectionStatus.CANCELED);
    return "3";
  }
  
  public static String convertToJSON(Map<String, String> paramMap)
  {
    if (paramMap.size() > getExtraParamsLimit())
    {
      Log.verbose("[InMobi]-[Analytics]-4.1.1", "Analytics events - number of key-value pairs in attribute map exceeds " + getExtraParamsLimit());
      return null;
    }
    JSONObject localJSONObject;
    String str1;
    String str2;
    try
    {
      localJSONObject = new JSONObject();
      Iterator localIterator = paramMap.keySet().iterator();
      for (;;)
      {
        if (localIterator.hasNext())
        {
          str1 = (String)localIterator.next();
          if ((str1.length() > 0) && (str1.length() <= getMaxparamskey()))
          {
            str2 = (String)paramMap.get(str1);
            if (str2.length() <= getMaxstring())
            {
              localJSONObject.put(str1, paramMap.get(str1));
              continue;
              paramMap = null;
            }
          }
        }
      }
    }
    catch (Exception paramMap)
    {
      Log.internal("[InMobi]-[Analytics]-4.1.1", "Unable to convert map to JSON");
    }
    for (;;)
    {
      return paramMap;
      Log.verbose("[InMobi]-[Analytics]-4.1.1", "Analytics events - value : " + str2 + " ,exceeds inmobi's limitation of " + getMaxstring() + " characters.");
      return null;
      Log.verbose("[InMobi]-[Analytics]-4.1.1", "Analytics events - key : " + str1 + " ,exceeds inmobi's limitation of " + getMaxparamskey() + " characters.");
      return null;
      if (localJSONObject.length() > 0) {
        paramMap = localJSONObject.toString();
      }
    }
  }
  
  public static String getAppVersion(Context paramContext)
  {
    try
    {
      paramContext = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 0).versionName;
      return paramContext;
    }
    catch (Exception paramContext)
    {
      Log.internal("[InMobi]-[Analytics]-4.1.1", "Error retrieving application version");
    }
    return null;
  }
  
  public static String getApplicationName(Context paramContext)
  {
    try
    {
      PackageManager localPackageManager = paramContext.getPackageManager();
      paramContext = (String)localPackageManager.getApplicationLabel(localPackageManager.getApplicationInfo(paramContext.getPackageName(), 0));
      return paramContext;
    }
    catch (Exception paramContext)
    {
      Log.internal("[InMobi]-[Analytics]-4.1.1", "Error retrieving application name");
    }
    return null;
  }
  
  public static Object getCountryISO(Context paramContext)
  {
    TelephonyManager localTelephonyManager = (TelephonyManager)paramContext.getSystemService("phone");
    if (localTelephonyManager.getNetworkCountryIso().equals("")) {
      return paramContext.getResources().getConfiguration().locale.getISO3Country();
    }
    return localTelephonyManager.getNetworkCountryIso();
  }
  
  public static float getDeviceDensity(Context paramContext)
  {
    return paramContext.getResources().getDisplayMetrics().density;
  }
  
  public static String getEventUrl()
  {
    return AnalyticsInitializer.getConfigParams().getEndPoints().getEventsUrl();
  }
  
  public static int getExtraParamsLimit()
  {
    try
    {
      int i = AnalyticsInitializer.getConfigParams().getExtraParamsLimit();
      return i;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public static int getMaxRetryBeforeDiscard()
  {
    try
    {
      int i = AnalyticsInitializer.getConfigParams().getMaxRetryBeforeCacheDiscard();
      return i;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public static long getMaxdbcount()
  {
    try
    {
      int i = AnalyticsInitializer.getConfigParams().getMaxDbEvents();
      long l = i;
      return l;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public static String getMaxevents()
  {
    try
    {
      String str = AnalyticsInitializer.getConfigParams().getGetParamsLimit() + "";
      return str;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public static int getMaxparamskey()
  {
    try
    {
      int i = AnalyticsInitializer.getConfigParams().getMaxKeyLength();
      return i;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public static int getMaxstring()
  {
    try
    {
      int i = AnalyticsInitializer.getConfigParams().getMaxValLength();
      return i;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public static String getScreenHeight(Context paramContext)
  {
    int i = paramContext.getResources().getDisplayMetrics().heightPixels;
    return "" + i;
  }
  
  public static String getScreenWidth(Context paramContext)
  {
    int i = paramContext.getResources().getDisplayMetrics().widthPixels;
    return "" + i;
  }
  
  public static boolean getStartHandle()
  {
    try
    {
      boolean bool = b;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public static long getTimeinterval()
  {
    try
    {
      int i = AnalyticsInitializer.getConfigParams().getPingInterval();
      long l = i;
      return l;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public static String getWebviewUserAgent()
  {
    return a;
  }
  
  public static void setStartHandle(boolean paramBoolean)
  {
    try
    {
      b = paramBoolean;
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public static void setWebviewUserAgent(String paramString)
  {
    a = paramString;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/inmobi/commons/analytics/util/AnalyticsUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */