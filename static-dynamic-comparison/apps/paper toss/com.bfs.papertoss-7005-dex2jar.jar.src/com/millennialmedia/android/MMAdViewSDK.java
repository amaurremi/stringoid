package com.millennialmedia.android;

import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.location.Location;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;
import android.util.Log;
import java.security.MessageDigest;
import java.util.Iterator;
import java.util.List;

public final class MMAdViewSDK
{
  static final String BASEURL = "http://androidsdk.ads.mp.mydas.mobi/getAd.php5?";
  static final String BASE_PATH = "getAd.php5?";
  static final int CACHE_REQUEST_TIMEOUT = 30000;
  static final int CLOSE_ACTIVITY_DURATION = 400;
  static String COMMA;
  public static final String DEFAULT_APID = "28911";
  public static final int DEFAULT_VIEWID = 1897808289;
  static final String EMPTY = "";
  static final String ERR_BROKENREF = "The reference to the ad view was broken.";
  static final String ERR_NOACTIVITY = "The ad view does not have a parent activity.";
  static final String ERR_NOT_MAIN_THREAD = "Only the main thread can access an MMAdView.";
  static final String HTTPS = "https";
  static final String JSON_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss ZZZZ";
  public static final int LOG_LEVEL_DEBUG = 1;
  public static final int LOG_LEVEL_NORMAL = 0;
  public static final int LOG_LEVEL_PRIVATE = 3;
  public static final int LOG_LEVEL_PRIVATE_VERBOSE = 4;
  public static final int LOG_LEVEL_VERBOSE = 2;
  static final int LOG_REQUEST_TIMEOUT = 10000;
  static final int MIN_REFRESH = 15;
  static final int OPEN_ACTIVITY_DURATION = 600;
  static final String PREFS_NAME = "MillennialMediaSettings";
  static final String PRIVATE_CACHE_DIR = ".mmsyscache";
  static final int REQUEST_TIMEOUT = 3000;
  public static final String SDKLOG = "MillennialMediaSDK";
  public static final String SDKVER = "4.6.0-12.07.16.a";
  public static boolean broadcastEvents;
  public static boolean debugMode;
  static MMDemographic demographic;
  static boolean disableAdMinRefresh = false;
  private static String getAuidOrHdidValue = null;
  private static String getAuidValue;
  private static String getHdidValue;
  private static String getMMdidValue;
  public static Location location;
  public static int logLevel;
  static String macId;
  static Handler mainHandler;
  
  static
  {
    demographic = new MMDemographic();
    COMMA = ",";
    mainHandler = new Handler(Looper.getMainLooper());
    getMMdidValue = null;
    getAuidValue = null;
    getHdidValue = null;
  }
  
  private static String byteArrayToString(byte[] paramArrayOfByte)
  {
    StringBuilder localStringBuilder = new StringBuilder(paramArrayOfByte.length * 2);
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      localStringBuilder.append(String.format("%02X", new Object[] { Byte.valueOf(paramArrayOfByte[i]) }));
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  public static String getAuid(Context paramContext)
  {
    if (getAuidValue != null) {
      return getAuidValue;
    }
    Object localObject3 = "android_idandroid_id";
    TelephonyManager localTelephonyManager = (TelephonyManager)paramContext.getSystemService("phone");
    Object localObject1 = localObject3;
    if (localTelephonyManager != null) {}
    try
    {
      localObject1 = localTelephonyManager.getDeviceId();
      if (localObject1 != null)
      {
        localObject3 = localObject1;
        if (((String)localObject1).length() != 0) {}
      }
      else
      {
        localObject3 = localObject1;
        if (paramContext != null) {
          localObject3 = Settings.Secure.getString(paramContext.getContentResolver(), "android_id");
        }
      }
      if (localObject3 != null)
      {
        paramContext = (Context)localObject3;
        if (((String)localObject3).length() != 0) {}
      }
      else
      {
        paramContext = null;
      }
      getAuidValue = paramContext;
      return paramContext;
    }
    catch (SecurityException localSecurityException)
    {
      for (;;)
      {
        localSecurityException.printStackTrace();
        Object localObject2 = localObject3;
      }
    }
  }
  
  static String getAuidOrHdid(Context paramContext)
  {
    boolean bool = HandShake.sharedHandShake(paramContext).hdid;
    if (getAuidOrHdidValue != null)
    {
      if ((bool) && (getAuidOrHdidValue.startsWith("mmh_"))) {
        return getAuidOrHdidValue;
      }
      if ((!bool) && (!getAuidOrHdidValue.startsWith("mmh_"))) {
        return getAuidOrHdidValue;
      }
    }
    if (bool)
    {
      paramContext = getHdid(paramContext);
      getAuidOrHdidValue = paramContext;
      return paramContext;
    }
    paramContext = getAuid(paramContext);
    getAuidOrHdidValue = paramContext;
    return paramContext;
  }
  
  static String getConnectionType(Context paramContext)
  {
    paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
    if (paramContext == null) {
      return "unknown";
    }
    if ((paramContext.getActiveNetworkInfo() != null) && (paramContext.getActiveNetworkInfo().isConnected() == true))
    {
      int i = paramContext.getActiveNetworkInfo().getType();
      int j = paramContext.getActiveNetworkInfo().getSubtype();
      if (i == 1) {
        return "wifi";
      }
      if (i == 0)
      {
        switch (j)
        {
        default: 
          return "unknown";
        case 7: 
          return "1xrtt";
        case 4: 
          return "cdma";
        case 2: 
          return "edge";
        case 14: 
          return "ehrpd";
        case 5: 
          return "evdo_0";
        case 6: 
          return "evdo_a";
        case 12: 
          return "evdo_b";
        case 1: 
          return "gprs";
        case 8: 
          return "hsdpa";
        case 10: 
          return "hspa";
        case 15: 
          return "hspap";
        case 9: 
          return "hsupa";
        case 11: 
          return "iden";
        case 13: 
          return "lte";
        }
        return "umts";
      }
      return "unknown";
    }
    return "offline";
  }
  
  static int getDpi(Context paramContext)
  {
    return 160;
  }
  
  static String getHdid(Context paramContext)
  {
    Object localObject = null;
    if (getHdidValue != null) {
      paramContext = getHdidValue;
    }
    String str;
    do
    {
      return paramContext;
      str = getAuid(paramContext);
      paramContext = (Context)localObject;
    } while (str == null);
    paramContext = new StringBuilder("mmh_");
    try
    {
      paramContext.append(byteArrayToString(MessageDigest.getInstance("MD5").digest(str.getBytes())));
      paramContext.append("_");
      paramContext.append(byteArrayToString(MessageDigest.getInstance("SHA1").digest(str.getBytes())));
      paramContext = paramContext.toString();
      getHdidValue = paramContext;
      return paramContext;
    }
    catch (Exception paramContext)
    {
      Log.v(paramContext.getMessage());
    }
    return null;
  }
  
  static String getMMdid(Context paramContext)
  {
    Object localObject = null;
    for (;;)
    {
      try
      {
        if (getMMdidValue != null)
        {
          paramContext = getMMdidValue;
          return paramContext;
        }
        str = Settings.Secure.getString(paramContext.getContentResolver(), "android_id");
        paramContext = (Context)localObject;
        if (str != null) {
          paramContext = new StringBuilder("mmh_");
        }
      }
      finally
      {
        try
        {
          String str;
          paramContext.append(byteArrayToString(MessageDigest.getInstance("MD5").digest(str.getBytes())));
          paramContext.append("_");
          paramContext.append(byteArrayToString(MessageDigest.getInstance("SHA1").digest(str.getBytes())));
          paramContext = paramContext.toString();
          getMMdidValue = paramContext;
        }
        catch (Exception paramContext)
        {
          Log.v(paramContext.getMessage());
          paramContext = (Context)localObject;
        }
        paramContext = finally;
      }
    }
  }
  
  public static String hasAccelerometer(Context paramContext)
  {
    if (paramContext == null) {
      return "false";
    }
    paramContext = ((SensorManager)paramContext.getSystemService("sensor")).getSensorList(1);
    int i = 0;
    paramContext = paramContext.iterator();
    while (paramContext.hasNext()) {
      if (((Sensor)paramContext.next()).getType() == 1) {
        i = 1;
      }
    }
    if (i != 0) {
      return "true";
    }
    return "false";
  }
  
  static boolean isConnected(Context paramContext)
  {
    boolean bool = true;
    paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
    if (paramContext == null) {
      return false;
    }
    if ((paramContext.getActiveNetworkInfo() != null) && (paramContext.getActiveNetworkInfo().isConnected() == true)) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
  
  static boolean isUiThread()
  {
    return mainHandler.getLooper() == Looper.myLooper();
  }
  
  public static void resetCache(Context paramContext)
  {
    AdCache.resetCache(paramContext);
  }
  
  static void runOnUiThread(Runnable paramRunnable)
  {
    if (mainHandler.getLooper() == Looper.myLooper())
    {
      paramRunnable.run();
      return;
    }
    mainHandler.post(paramRunnable);
  }
  
  static void setMMdid(String paramString)
  {
    try
    {
      getMMdidValue = paramString;
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  static class Event
  {
    public static final String ACTION_DISPLAY_STARTED = "millennialmedia.action.ACTION_DISPLAY_STARTED";
    public static final String ACTION_FETCH_FAILED = "millennialmedia.action.ACTION_FETCH_FAILED";
    public static final String ACTION_FETCH_FINISHED_CACHING = "millennialmedia.action.ACTION_FETCH_FINISHED_CACHING";
    public static final String ACTION_FETCH_STARTED_CACHING = "millennialmedia.action.ACTION_FETCH_STARTED_CACHING";
    public static final String ACTION_GETAD_FAILED = "millennialmedia.action.ACTION_GETAD_FAILED";
    public static final String ACTION_GETAD_SUCCEEDED = "millennialmedia.action.ACTION_GETAD_SUCCEEDED";
    public static final String ACTION_INTENT_STARTED = "millennialmedia.action.ACTION_INTENT_STARTED";
    public static final String ACTION_OVERLAY_CLOSED = "millennialmedia.action.ACTION_OVERLAY_CLOSED";
    public static final String ACTION_OVERLAY_OPENED = "millennialmedia.action.ACTION_OVERLAY_OPENED";
    public static final String ACTION_OVERLAY_TAP = "millennialmedia.action.ACTION_OVERLAY_TAP";
    public static final String CATEGORY_SDK = "millennialmedia.category.CATEGORY_SDK";
    public static final String INTENT_EMAIL = "email";
    public static final String INTENT_EXTERNAL_BROWSER = "browser";
    public static final String INTENT_MAPS = "geo";
    public static final String INTENT_MARKET = "market";
    public static final String INTENT_PHONE_CALL = "tel";
    public static final String INTENT_STREAMING_VIDEO = "streamingVideo";
    public static final String INTENT_TXT_MESSAGE = "sms";
    private static final String KEY_ERROR = "error";
    private static final String KEY_ID = "id";
    static final String KEY_INTENT_TYPE = "intentType";
    static final String KEY_INTERNAL_ID = "internalId";
    static final String KEY_PACKAGE_NAME = "packageName";
    
    static void displayStarted(Context paramContext, MMAdView paramMMAdView)
    {
      MMAdViewSDK.runOnUiThread(new Runnable()
      {
        public void run()
        {
          if ((this.val$adView != null) && (this.val$adView.listener != null)) {}
          try
          {
            this.val$adView.listener.MMAdOverlayLaunched(this.val$adView);
            return;
          }
          catch (Exception localException)
          {
            MMAdViewSDK.Log.w("Exception raised in your MMAdListener: ", new Object[] { localException });
          }
        }
      });
      if (MMAdViewSDK.broadcastEvents)
      {
        Intent localIntent = new Intent("millennialmedia.action.ACTION_DISPLAY_STARTED");
        localIntent.addCategory("millennialmedia.category.CATEGORY_SDK");
        localIntent.putExtra("packageName", paramContext.getPackageName());
        if (paramMMAdView != null)
        {
          localIntent.putExtra("id", paramMMAdView.getId());
          localIntent.putExtra("internalId", paramMMAdView.adViewId.longValue());
        }
        paramContext.sendBroadcast(localIntent);
      }
    }
    
    static void fetchFailed(Context paramContext, MMAdView paramMMAdView, final MMAdView.Request paramRequest, final MMError paramMMError)
    {
      MMAdViewSDK.runOnUiThread(new Runnable()
      {
        public void run()
        {
          if ((this.val$adView != null) && (this.val$adView.listener != null)) {}
          try
          {
            this.val$adView.listener.MMAdCachingCompleted(this.val$adView, false);
            if (paramRequest.requestListener != null) {
              paramRequest.requestListener.requestFailed(this.val$adView, paramMMError);
            }
            return;
          }
          catch (Exception localException)
          {
            for (;;)
            {
              MMAdViewSDK.Log.w("Exception raised in your MMAdListener: ", new Object[] { localException });
            }
          }
        }
      });
      if (MMAdViewSDK.broadcastEvents)
      {
        paramRequest = new Intent("millennialmedia.action.ACTION_FETCH_FAILED");
        paramRequest.addCategory("millennialmedia.category.CATEGORY_SDK");
        paramRequest.putExtra("packageName", paramContext.getPackageName());
        if (paramMMAdView != null)
        {
          paramRequest.putExtra("id", paramMMAdView.getId());
          paramRequest.putExtra("internalId", paramMMAdView.adViewId.longValue());
        }
        paramRequest.putExtra("error", paramMMError);
        paramContext.sendBroadcast(paramRequest);
      }
    }
    
    static void fetchFinishedCaching(Context paramContext, MMAdView paramMMAdView, final MMAdView.Request paramRequest)
    {
      MMAdViewSDK.runOnUiThread(new Runnable()
      {
        public void run()
        {
          if ((this.val$adView != null) && (this.val$adView.listener != null)) {}
          try
          {
            this.val$adView.listener.MMAdCachingCompleted(this.val$adView, true);
            if (paramRequest.requestListener != null) {
              paramRequest.requestListener.requestSucceeded(this.val$adView);
            }
            return;
          }
          catch (Exception localException)
          {
            for (;;)
            {
              MMAdViewSDK.Log.w("Exception raised in your MMAdListener: ", new Object[] { localException });
            }
          }
        }
      });
      if (MMAdViewSDK.broadcastEvents)
      {
        paramRequest = new Intent("millennialmedia.action.ACTION_FETCH_FINISHED_CACHING");
        paramRequest.addCategory("millennialmedia.category.CATEGORY_SDK");
        paramRequest.putExtra("packageName", paramContext.getPackageName());
        if (paramMMAdView != null)
        {
          paramRequest.putExtra("id", paramMMAdView.getId());
          paramRequest.putExtra("internalId", paramMMAdView.adViewId.longValue());
        }
        paramContext.sendBroadcast(paramRequest);
      }
    }
    
    static void fetchStartedCaching(Context paramContext, MMAdView paramMMAdView)
    {
      MMAdViewSDK.runOnUiThread(new Runnable()
      {
        public void run()
        {
          if ((this.val$adView != null) && (this.val$adView.listener != null)) {}
          try
          {
            this.val$adView.listener.MMAdRequestIsCaching(this.val$adView);
            return;
          }
          catch (Exception localException)
          {
            MMAdViewSDK.Log.w("Exception raised in your MMAdListener: ", new Object[] { localException });
          }
        }
      });
      if (MMAdViewSDK.broadcastEvents)
      {
        Intent localIntent = new Intent("millennialmedia.action.ACTION_FETCH_STARTED_CACHING");
        localIntent.addCategory("millennialmedia.category.CATEGORY_SDK");
        localIntent.putExtra("packageName", paramContext.getPackageName());
        if (paramMMAdView != null)
        {
          localIntent.putExtra("id", paramMMAdView.getId());
          localIntent.putExtra("internalId", paramMMAdView.adViewId.longValue());
        }
        paramContext.sendBroadcast(localIntent);
      }
    }
    
    static void getAdFailed(Context paramContext, MMAdView paramMMAdView, final MMAdView.Request paramRequest, final MMError paramMMError)
    {
      MMAdViewSDK.runOnUiThread(new Runnable()
      {
        public void run()
        {
          if ((this.val$adView != null) && (this.val$adView.listener != null)) {}
          try
          {
            this.val$adView.listener.MMAdFailed(this.val$adView);
            if (paramRequest.requestListener != null) {
              paramRequest.requestListener.requestFailed(this.val$adView, paramMMError);
            }
            return;
          }
          catch (Exception localException)
          {
            for (;;)
            {
              MMAdViewSDK.Log.w("Exception raised in your MMAdListener: ", new Object[] { localException });
            }
          }
        }
      });
      if (MMAdViewSDK.broadcastEvents)
      {
        paramRequest = new Intent("millennialmedia.action.ACTION_GETAD_FAILED");
        paramRequest.addCategory("millennialmedia.category.CATEGORY_SDK");
        paramRequest.putExtra("packageName", paramContext.getPackageName());
        if (paramMMAdView != null)
        {
          paramRequest.putExtra("id", paramMMAdView.getId());
          paramRequest.putExtra("internalId", paramMMAdView.adViewId.longValue());
        }
        paramRequest.putExtra("error", paramMMError);
        paramContext.sendBroadcast(paramRequest);
      }
    }
    
    static void getAdSuccess(Context paramContext, MMAdView paramMMAdView, final MMAdView.Request paramRequest)
    {
      MMAdViewSDK.runOnUiThread(new Runnable()
      {
        public void run()
        {
          if ((this.val$adView != null) && (this.val$adView.listener != null)) {}
          try
          {
            this.val$adView.listener.MMAdReturned(this.val$adView);
            if (paramRequest.requestListener != null) {
              paramRequest.requestListener.requestSucceeded(this.val$adView);
            }
            return;
          }
          catch (Exception localException)
          {
            for (;;)
            {
              MMAdViewSDK.Log.w("Exception raised in your MMAdListener: ", new Object[] { localException });
            }
          }
        }
      });
      if (MMAdViewSDK.broadcastEvents)
      {
        paramRequest = new Intent("millennialmedia.action.ACTION_GETAD_SUCCEEDED");
        paramRequest.addCategory("millennialmedia.category.CATEGORY_SDK");
        paramRequest.putExtra("packageName", paramContext.getPackageName());
        if (paramMMAdView != null)
        {
          paramRequest.putExtra("id", paramMMAdView.getId());
          paramRequest.putExtra("internalId", paramMMAdView.adViewId.longValue());
        }
        paramContext.sendBroadcast(paramRequest);
      }
    }
    
    static void intentStarted(Context paramContext, MMAdView paramMMAdView, String paramString)
    {
      if (MMAdViewSDK.broadcastEvents)
      {
        Intent localIntent = new Intent("millennialmedia.action.ACTION_INTENT_STARTED");
        localIntent.addCategory("millennialmedia.category.CATEGORY_SDK");
        localIntent.putExtra("packageName", paramContext.getPackageName());
        localIntent.putExtra("intentType", paramString);
        if (paramMMAdView != null)
        {
          localIntent.putExtra("id", paramMMAdView.getId());
          localIntent.putExtra("internalId", paramMMAdView.adViewId.longValue());
        }
        paramContext.sendBroadcast(localIntent);
      }
    }
    
    static void overlayClosed(Context paramContext)
    {
      if (MMAdViewSDK.broadcastEvents)
      {
        Intent localIntent = new Intent("millennialmedia.action.ACTION_OVERLAY_CLOSED");
        localIntent.addCategory("millennialmedia.category.CATEGORY_SDK");
        localIntent.putExtra("packageName", paramContext.getPackageName());
        paramContext.sendBroadcast(localIntent);
      }
    }
    
    static void overlayOpened(Context paramContext, MMAdView paramMMAdView)
    {
      MMAdViewSDK.runOnUiThread(new Runnable()
      {
        public void run()
        {
          if ((this.val$adView != null) && (this.val$adView.listener != null)) {}
          try
          {
            this.val$adView.listener.MMAdOverlayLaunched(this.val$adView);
            return;
          }
          catch (Exception localException)
          {
            MMAdViewSDK.Log.w("Exception raised in your MMAdListener: ", new Object[] { localException });
          }
        }
      });
      if (MMAdViewSDK.broadcastEvents)
      {
        Intent localIntent = new Intent("millennialmedia.action.ACTION_OVERLAY_OPENED");
        localIntent.addCategory("millennialmedia.category.CATEGORY_SDK");
        localIntent.putExtra("packageName", paramContext.getPackageName());
        if (paramMMAdView != null)
        {
          localIntent.putExtra("id", paramMMAdView.getId());
          localIntent.putExtra("internalId", paramMMAdView.adViewId.longValue());
        }
        paramContext.sendBroadcast(localIntent);
      }
    }
    
    static void overlayTap(Context paramContext)
    {
      if (MMAdViewSDK.broadcastEvents)
      {
        Intent localIntent = new Intent("millennialmedia.action.ACTION_OVERLAY_TAP");
        localIntent.addCategory("millennialmedia.category.CATEGORY_SDK");
        localIntent.putExtra("packageName", paramContext.getPackageName());
        paramContext.sendBroadcast(localIntent);
      }
    }
    
    static void requestFailed(Context paramContext, MMAdView paramMMAdView, MMAdView.Request paramRequest, MMError paramMMError)
    {
      if (paramRequest.fetch)
      {
        fetchFailed(paramContext, paramMMAdView, paramRequest, paramMMError);
        return;
      }
      getAdFailed(paramContext, paramMMAdView, paramRequest, paramMMError);
    }
  }
  
  static class Log
  {
    static void d(String paramString)
    {
      if (MMAdViewSDK.logLevel >= 1) {
        Log.i("MillennialMediaSDK", "Diagnostic - " + paramString);
      }
    }
    
    static void d(String paramString, Object... paramVarArgs)
    {
      if (MMAdViewSDK.logLevel >= 1) {
        Log.i("MillennialMediaSDK", "Diagnostic - " + String.format(paramString, paramVarArgs));
      }
    }
    
    static void d(Throwable paramThrowable)
    {
      if (MMAdViewSDK.logLevel >= 1) {
        d(Log.getStackTraceString(paramThrowable));
      }
    }
    
    static void e(String paramString)
    {
      Log.e("MillennialMediaSDK", paramString);
    }
    
    static void e(String paramString, Object... paramVarArgs)
    {
      Log.e("MillennialMediaSDK", String.format(paramString, paramVarArgs));
    }
    
    static void e(Throwable paramThrowable)
    {
      e(Log.getStackTraceString(paramThrowable));
    }
    
    static void i(String paramString)
    {
      Log.i("MillennialMediaSDK", paramString);
    }
    
    static void i(String paramString, Object... paramVarArgs)
    {
      Log.i("MillennialMediaSDK", String.format(paramString, paramVarArgs));
    }
    
    static void i(Throwable paramThrowable)
    {
      i(Log.getStackTraceString(paramThrowable));
    }
    
    static void p(String paramString)
    {
      if (MMAdViewSDK.logLevel > 2) {
        Log.i("MillennialMediaSDK", "Private - " + paramString);
      }
    }
    
    static void p(String paramString, Object... paramVarArgs)
    {
      if (MMAdViewSDK.logLevel > 2) {
        Log.i("MillennialMediaSDK", "Private - " + String.format(paramString, paramVarArgs));
      }
    }
    
    static void p(Throwable paramThrowable)
    {
      if (MMAdViewSDK.logLevel > 2) {
        p(Log.getStackTraceString(paramThrowable));
      }
    }
    
    static void v(String paramString)
    {
      if (MMAdViewSDK.logLevel >= 2) {
        Log.i("MillennialMediaSDK", "Verbose - " + paramString);
      }
    }
    
    static void v(String paramString, Object... paramVarArgs)
    {
      if (MMAdViewSDK.logLevel >= 2) {
        Log.i("MillennialMediaSDK", "Verbose - " + String.format(paramString, paramVarArgs));
      }
    }
    
    static void v(Throwable paramThrowable)
    {
      if (MMAdViewSDK.logLevel >= 2) {
        v(Log.getStackTraceString(paramThrowable));
      }
    }
    
    static void w(String paramString)
    {
      Log.w("MillennialMediaSDK", paramString);
    }
    
    static void w(String paramString, Object... paramVarArgs)
    {
      Log.w("MillennialMediaSDK", String.format(paramString, paramVarArgs));
    }
    
    static void w(Throwable paramThrowable)
    {
      w(Log.getStackTraceString(paramThrowable));
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/paper toss/com.bfs.papertoss-7005-dex2jar.jar!/com/millennialmedia/android/MMAdViewSDK.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */