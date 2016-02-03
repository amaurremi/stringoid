package com.millennialmedia.android;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.media.AudioManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.os.StatFs;
import android.provider.Settings.Secure;
import android.provider.Settings.System;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;
import java.io.File;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.util.Enumeration;
import java.util.Locale;
import java.util.Map;
import org.apache.http.conn.util.InetAddressUtils;

public final class MMSDK
{
  private static final String BASE_URL_TRACK_EVENT = "http://ads.mp.mydas.mobi/pixel?id=";
  static final int CACHE_REQUEST_TIMEOUT = 30000;
  static final int CLOSE_ACTIVITY_DURATION = 400;
  static String COMMA;
  public static final String DEFAULT_APID = "28911";
  public static final String DEFAULT_BANNER_APID = "28913";
  public static final String DEFAULT_RECT_APID = "28914";
  static final String EMPTY = "";
  static final int HANDSHAKE_REQUEST_TIMEOUT = 3000;
  static final String JSON_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss ZZZZ";
  public static final int LOG_LEVEL_DEBUG = 1;
  public static final int LOG_LEVEL_ERROR = 0;
  public static final int LOG_LEVEL_INFO = 2;
  @Deprecated
  public static final int LOG_LEVEL_INTERNAL = 4;
  @Deprecated
  public static final int LOG_LEVEL_PRIVATE_VERBOSE = 5;
  public static final int LOG_LEVEL_VERBOSE = 3;
  static final int OPEN_ACTIVITY_DURATION = 600;
  static final String PREFS_NAME = "MillennialMediaSettings";
  static final int REQUEST_TIMEOUT = 10000;
  public static final String SDKLOG = "MillennialMediaSDK";
  public static final String VERSION = "5.1.0-13.08.12.a";
  @Deprecated
  public static boolean debugMode;
  @Deprecated
  static boolean disableAdMinRefresh = false;
  private static String getMMdidValue;
  private static boolean hasSpeechKit;
  private static boolean isBroadcastingEvents;
  static int logLevel;
  static String macId;
  static Handler mainHandler;
  private static int nextDefaultId = 1897808289;
  
  static
  {
    COMMA = ",";
    mainHandler = new Handler(Looper.getMainLooper());
    getMMdidValue = null;
    hasSpeechKit = false;
    try
    {
      System.loadLibrary("nmsp_speex");
      hasSpeechKit = true;
      return;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError) {}
  }
  
  static String byteArrayToString(byte[] paramArrayOfByte)
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
  
  static void checkActivity(Context paramContext)
  {
    PackageManager localPackageManager = paramContext.getPackageManager();
    try
    {
      localPackageManager.getActivityInfo(new ComponentName(paramContext, "com.millennialmedia.android.MMActivity"), 128);
      return;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      Log.e("Activity MMActivity not declared in AndroidManifest.xml");
      localNameNotFoundException.printStackTrace();
      createMissingPermissionDialog(paramContext, "MMActivity class").show();
    }
  }
  
  static void checkPermissions(Context paramContext)
  {
    if (paramContext.checkCallingOrSelfPermission("android.permission.INTERNET") == -1) {
      createMissingPermissionDialog(paramContext, "INTERNET permission").show();
    }
    if (paramContext.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") == -1) {
      createMissingPermissionDialog(paramContext, "ACCESS_NETWORK_STATE permission").show();
    }
  }
  
  private static AlertDialog createMissingPermissionDialog(Context paramContext, String paramString)
  {
    paramContext = new AlertDialog.Builder(paramContext).create();
    paramContext.setTitle("Whoops!");
    paramContext.setMessage(String.format("The developer has forgot to declare the %s in the manifest file. Please reach out to the developer to remove this error.", new Object[] { paramString }));
    paramContext.setButton(-3, "OK", new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        paramAnonymousDialogInterface.cancel();
      }
    });
    paramContext.show();
    return paramContext;
  }
  
  public static boolean getBroadcastEvents()
  {
    return isBroadcastingEvents;
  }
  
  static Configuration getConfiguration(Context paramContext)
  {
    return paramContext.getResources().getConfiguration();
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
  
  public static int getDefaultAdId()
  {
    try
    {
      int i = nextDefaultId + 1;
      nextDefaultId = i;
      return i;
    }
    finally {}
  }
  
  static float getDensity(Context paramContext)
  {
    paramContext = getMetrics(paramContext);
    if (paramContext == null) {
      return 1.0F;
    }
    return paramContext.density;
  }
  
  private static String getDensityString(Context paramContext)
  {
    return Float.toString(getDensity(paramContext));
  }
  
  static String getDpiHeight(Context paramContext)
  {
    if (needsRawDisplayMethod())
    {
      String str = getRawSize(paramContext, "getRawHeight");
      if (!TextUtils.isEmpty(str)) {
        return str;
      }
    }
    return getDpiHeightFrom(getMetrics(paramContext));
  }
  
  private static String getDpiHeightFrom(DisplayMetrics paramDisplayMetrics)
  {
    return Integer.toString(paramDisplayMetrics.heightPixels);
  }
  
  static String getDpiWidth(Context paramContext)
  {
    if (needsRawDisplayMethod())
    {
      String str = getRawSize(paramContext, "getRawWidth");
      if (!TextUtils.isEmpty(str)) {
        return str;
      }
    }
    return getDpiWidthFrom(getMetrics(paramContext));
  }
  
  private static String getDpiWidthFrom(DisplayMetrics paramDisplayMetrics)
  {
    return Integer.toString(paramDisplayMetrics.widthPixels);
  }
  
  static String getIpAddress(Context paramContext)
  {
    StringBuilder localStringBuilder;
    try
    {
      localStringBuilder = new StringBuilder();
      Enumeration localEnumeration1 = NetworkInterface.getNetworkInterfaces();
      for (;;)
      {
        if (!localEnumeration1.hasMoreElements()) {
          break label139;
        }
        Enumeration localEnumeration2 = ((NetworkInterface)localEnumeration1.nextElement()).getInetAddresses();
        while (localEnumeration2.hasMoreElements())
        {
          paramContext = (InetAddress)localEnumeration2.nextElement();
          if (!paramContext.isLoopbackAddress())
          {
            if (localStringBuilder.length() > 0) {
              localStringBuilder.append(',');
            }
            paramContext = paramContext.getHostAddress().toUpperCase();
            if (!InetAddressUtils.isIPv4Address(paramContext)) {
              break label109;
            }
            localStringBuilder.append(paramContext);
          }
        }
      }
      i = paramContext.indexOf('%');
    }
    catch (Exception paramContext)
    {
      Log.e(paramContext);
      return "";
    }
    label109:
    int i;
    if (i < 0) {}
    for (;;)
    {
      localStringBuilder.append(paramContext);
      break;
      paramContext = paramContext.substring(0, i);
    }
    label139:
    paramContext = localStringBuilder.toString();
    return paramContext;
  }
  
  public static int getLogLevel()
  {
    return logLevel;
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
  
  static String getMcc(Context paramContext)
  {
    Configuration localConfiguration = getConfiguration(paramContext);
    if (localConfiguration.mcc == 0)
    {
      paramContext = getNetworkOperator(paramContext);
      if ((paramContext != null) && (paramContext.length() >= 6)) {
        return paramContext.substring(0, 3);
      }
    }
    return String.valueOf(localConfiguration.mcc);
  }
  
  static int getMediaVolume(Context paramContext)
  {
    return ((AudioManager)paramContext.getApplicationContext().getSystemService("audio")).getStreamVolume(3);
  }
  
  static DisplayMetrics getMetrics(Context paramContext)
  {
    paramContext = paramContext.getResources().getDisplayMetrics();
    if (needsRealDisplayMethod()) {}
    try
    {
      Display.class.getMethod("getRealMetrics", new Class[0]).invoke(paramContext, new Object[0]);
      return paramContext;
    }
    catch (Exception localException) {}
    return paramContext;
  }
  
  static String getMnc(Context paramContext)
  {
    Configuration localConfiguration = getConfiguration(paramContext);
    if (localConfiguration.mnc == 0)
    {
      paramContext = getNetworkOperator(paramContext);
      if ((paramContext != null) && (paramContext.length() >= 6)) {
        return paramContext.substring(3);
      }
    }
    return String.valueOf(localConfiguration.mnc);
  }
  
  static String getNetworkOperator(Context paramContext)
  {
    return ((TelephonyManager)paramContext.getSystemService("phone")).getNetworkOperator();
  }
  
  static String getOrientation(Context paramContext)
  {
    switch (paramContext.getResources().getConfiguration().orientation)
    {
    default: 
      return "default";
    case 1: 
      return "portrait";
    case 2: 
      return "landscape";
    }
    return "square";
  }
  
  static final String getOrientationLocked(Context paramContext)
  {
    if (Settings.System.getString(paramContext.getContentResolver(), "accelerometer_rotation").equals("1")) {
      return "false";
    }
    return "true";
  }
  
  private static String getRawSize(Context paramContext, String paramString)
  {
    String str = null;
    if ((paramContext instanceof Activity)) {
      paramContext = ((Activity)paramContext).getWindowManager().getDefaultDisplay();
    }
    try
    {
      int i = ((Integer)Display.class.getMethod(paramString, new Class[0]).invoke(paramContext, new Object[0])).intValue();
      str = String.valueOf(i);
      return str;
    }
    catch (Exception paramContext) {}
    return null;
  }
  
  static String getSupportsSms(Context paramContext)
  {
    return String.valueOf(paramContext.getPackageManager().hasSystemFeature("android.hardware.telephony"));
  }
  
  static String getSupportsTel(Context paramContext)
  {
    return String.valueOf(paramContext.getPackageManager().hasSystemFeature("android.hardware.telephony"));
  }
  
  static boolean hasSetTranslationMethod()
  {
    return Integer.parseInt(Build.VERSION.SDK) >= 11;
  }
  
  private static String hasSpeechKit(Context paramContext)
  {
    if (hasSpeechKit) {
      return "true";
    }
    return "false";
  }
  
  static String hasVoiceAbility(Context paramContext)
  {
    if (!paramContext.getPackageManager().hasSystemFeature("android.hardware.microphone")) {
      return "false";
    }
    if (getMediaVolume(paramContext) == 0) {
      return "false";
    }
    int i = ((AudioManager)paramContext.getApplicationContext().getSystemService("audio")).getRingerMode();
    if ((i == 0) || (i == 1)) {
      return "false";
    }
    return "true";
  }
  
  public static void initialize(Context paramContext)
  {
    paramContext = HandShake.sharedHandShake(paramContext);
    paramContext.sendInitRequest();
    paramContext.startSession();
  }
  
  static void insertUrlCommonValues(Context paramContext, Map<String, String> paramMap)
  {
    paramMap.put("density", getDensityString(paramContext));
    paramMap.put("hpx", getDpiHeight(paramContext));
    paramMap.put("wpx", getDpiWidth(paramContext));
    paramMap.put("sk", hasSpeechKit(paramContext));
    paramMap.put("mic", hasVoiceAbility(paramContext));
    if (isCachedVideoSupportedOnDevice(paramContext)) {
      paramMap.put("cachedvideo", "true");
    }
    for (;;)
    {
      if (Build.MODEL != null) {
        paramMap.put("dm", Build.MODEL);
      }
      if (Build.VERSION.RELEASE != null) {
        paramMap.put("dv", "Android" + Build.VERSION.RELEASE);
      }
      Object localObject1 = getMMdid(paramContext);
      if (localObject1 != null) {
        paramMap.put("mmdid", localObject1);
      }
      paramMap.put("sdkversion", "5.1.0-13.08.12.a");
      paramMap.put("mmisdk", "5.1.0-13.08.12.a");
      paramMap.put("mcc", getMcc(paramContext));
      paramMap.put("mnc", getMnc(paramContext));
      localObject1 = Locale.getDefault();
      if (localObject1 != null)
      {
        paramMap.put("language", ((Locale)localObject1).getLanguage());
        paramMap.put("country", ((Locale)localObject1).getCountry());
      }
      try
      {
        localObject1 = paramContext.getPackageName();
        paramMap.put("pkid", localObject1);
        Object localObject2 = paramContext.getPackageManager();
        paramMap.put("pknm", ((PackageManager)localObject2).getApplicationLabel(((PackageManager)localObject2).getApplicationInfo((String)localObject1, 0)).toString());
        if (debugMode) {
          paramMap.put("debug", "true");
        }
        localObject1 = HandShake.sharedHandShake(paramContext).getSchemesList(paramContext);
        if (localObject1 != null) {
          paramMap.put("appsids", localObject1);
        }
        localObject1 = AdCache.getCachedVideoList(paramContext);
        if (localObject1 != null) {
          paramMap.put("vid", localObject1);
        }
        for (;;)
        {
          try
          {
            String str1 = getConnectionType(paramContext);
            if (!AdCache.isExternalStorageAvailable(paramContext)) {
              continue;
            }
            localObject1 = new StatFs(AdCache.getCacheDirectory(paramContext).getAbsolutePath());
            String str2 = Long.toString(((StatFs)localObject1).getAvailableBlocks() * ((StatFs)localObject1).getBlockSize());
            localObject2 = null;
            localObject1 = null;
            Object localObject3 = paramContext.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
            if (localObject3 != null)
            {
              if (((Intent)localObject3).getIntExtra("plugged", 0) != 0) {
                continue;
              }
              localObject1 = "false";
              float f = 100.0F / ((Intent)localObject3).getIntExtra("scale", 100);
              localObject3 = Integer.toString((int)(((Intent)localObject3).getIntExtra("level", 0) * f));
              localObject2 = localObject1;
              localObject1 = localObject3;
            }
            if ((localObject1 != null) && (((String)localObject1).length() > 0)) {
              paramMap.put("bl", localObject1);
            }
            if ((localObject2 != null) && (((String)localObject2).length() > 0)) {
              paramMap.put("plugged", localObject2);
            }
            if (str2.length() > 0) {
              paramMap.put("space", str2);
            }
            if (str1 != null) {
              paramMap.put("conn", str1);
            }
            paramContext = URLEncoder.encode(getIpAddress(paramContext), "UTF-8");
            if (!TextUtils.isEmpty(paramContext)) {
              paramMap.put("pip", paramContext);
            }
          }
          catch (Exception paramContext)
          {
            Log.v(paramContext);
            continue;
          }
          MMRequest.insertLocation(paramMap);
          return;
          paramMap.put("cachedvideo", "false");
          break;
          localObject1 = new StatFs(paramContext.getFilesDir().getPath());
          continue;
          localObject1 = "true";
        }
      }
      catch (Exception localException)
      {
        for (;;) {}
      }
    }
  }
  
  static boolean isCachedVideoSupportedOnDevice(Context paramContext)
  {
    return (paramContext.checkCallingOrSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") != -1) && ((!Build.VERSION.SDK.equalsIgnoreCase("8")) || ((Environment.getExternalStorageState().equals("mounted")) && (AdCache.isExternalEnabled)));
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
  
  private static boolean needsRawDisplayMethod()
  {
    return (Integer.parseInt(Build.VERSION.SDK) >= 13) && (Integer.parseInt(Build.VERSION.SDK) <= 16);
  }
  
  private static boolean needsRealDisplayMethod()
  {
    return Integer.parseInt(Build.VERSION.SDK) >= 17;
  }
  
  static void printDiagnostics(MMAdImpl paramMMAdImpl)
  {
    if (paramMMAdImpl == null) {}
    Context localContext;
    do
    {
      return;
      localContext = paramMMAdImpl.getContext();
      Log.i("MMAd External ID: %d", new Object[] { Integer.valueOf(paramMMAdImpl.getId()) });
      Log.i("MMAd Internal ID: %d", new Object[] { Long.valueOf(paramMMAdImpl.internalId) });
      Log.i("APID: %s", new Object[] { paramMMAdImpl.apid });
      if (!AdCache.isExternalStorageAvailable(localContext)) {
        break;
      }
      paramMMAdImpl = "";
      Log.i("SD card is %savailable.", new Object[] { paramMMAdImpl });
    } while (localContext == null);
    Log.i("Package: %s", new Object[] { localContext.getPackageName() });
    Log.i("MMDID: %s", new Object[] { getMMdid(localContext) });
    Log.i("Permissions:");
    if (localContext.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") == -1)
    {
      paramMMAdImpl = "not ";
      label149:
      Log.i("android.permission.ACCESS_NETWORK_STATE is %spresent", new Object[] { paramMMAdImpl });
      if (localContext.checkCallingOrSelfPermission("android.permission.INTERNET") != -1) {
        break label340;
      }
      paramMMAdImpl = "not ";
      label177:
      Log.i("android.permission.INTERNET is %spresent", new Object[] { paramMMAdImpl });
      if (localContext.checkCallingOrSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") != -1) {
        break label346;
      }
      paramMMAdImpl = "not ";
      label206:
      Log.i("android.permission.WRITE_EXTERNAL_STORAGE is %spresent", new Object[] { paramMMAdImpl });
      if (localContext.checkCallingOrSelfPermission("android.permission.VIBRATE") != -1) {
        break label352;
      }
      paramMMAdImpl = "not ";
      label235:
      Log.i("android.permission.VIBRATE is %spresent", new Object[] { paramMMAdImpl });
      if (localContext.checkCallingOrSelfPermission("android.permission.ACCESS_COARSE_LOCATION") != -1) {
        break label358;
      }
      paramMMAdImpl = "not ";
      label264:
      Log.i("android.permission.ACCESS_COARSE_LOCATION is %spresent", new Object[] { paramMMAdImpl });
      if (localContext.checkCallingOrSelfPermission("android.permission.ACCESS_FINE_LOCATION") != -1) {
        break label364;
      }
    }
    label340:
    label346:
    label352:
    label358:
    label364:
    for (paramMMAdImpl = "not ";; paramMMAdImpl = "")
    {
      Log.i("android.permission.ACCESS_FINE_LOCATION is %spresent", new Object[] { paramMMAdImpl });
      Log.i("Cached Ads:");
      AdCache.iterateCachedAds(localContext, 2, new AdCache.Iterator()
      {
        boolean callback(CachedAd paramAnonymousCachedAd)
        {
          String str2 = paramAnonymousCachedAd.getTypeString();
          String str3 = paramAnonymousCachedAd.getId();
          String str1;
          if (paramAnonymousCachedAd.isOnDisk(this.val$context))
          {
            str1 = "";
            if (!paramAnonymousCachedAd.isExpired()) {
              break label69;
            }
          }
          label69:
          for (paramAnonymousCachedAd = "";; paramAnonymousCachedAd = "not ")
          {
            MMSDK.Log.i("%s %s is %son disk. Is %sexpired.", new Object[] { str2, str3, str1, paramAnonymousCachedAd });
            return true;
            str1 = "not ";
            break;
          }
        }
      });
      return;
      paramMMAdImpl = "not ";
      break;
      paramMMAdImpl = "";
      break label149;
      paramMMAdImpl = "";
      break label177;
      paramMMAdImpl = "";
      break label206;
      paramMMAdImpl = "";
      break label235;
      paramMMAdImpl = "";
      break label264;
    }
  }
  
  static boolean removeAccelForJira1164()
  {
    return Integer.parseInt(Build.VERSION.SDK) >= 14;
  }
  
  public static void resetCache(Context paramContext)
  {
    AdCache.resetCache(paramContext);
  }
  
  static void runOnUiThread(Runnable paramRunnable)
  {
    if (isUiThread())
    {
      paramRunnable.run();
      return;
    }
    mainHandler.post(paramRunnable);
  }
  
  static void runOnUiThreadDelayed(Runnable paramRunnable, long paramLong)
  {
    mainHandler.postDelayed(paramRunnable, paramLong);
  }
  
  public static void setBroadcastEvents(boolean paramBoolean)
  {
    isBroadcastingEvents = paramBoolean;
  }
  
  public static void setLogLevel(int paramInt)
  {
    logLevel = paramInt;
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
  
  static boolean supportsFullScreenInline()
  {
    return Integer.parseInt(Build.VERSION.SDK) >= 11;
  }
  
  public static void trackConversion(Context paramContext, String paramString)
  {
    MMConversionTracker.trackConversion(paramContext, paramString, null);
  }
  
  public static void trackConversion(Context paramContext, String paramString, MMRequest paramMMRequest)
  {
    MMConversionTracker.trackConversion(paramContext, paramString, paramMMRequest);
  }
  
  public static void trackEvent(Context paramContext, String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      paramContext = getMMdid(paramContext);
      if (!TextUtils.isEmpty(paramContext)) {
        Utils.HttpUtils.executeUrl("http://ads.mp.mydas.mobi/pixel?id=" + paramString + "&mmdid=" + paramContext);
      }
    }
  }
  
  static class Event
  {
    public static final String INTENT_EMAIL = "email";
    public static final String INTENT_EXTERNAL_BROWSER = "browser";
    public static final String INTENT_MAPS = "geo";
    public static final String INTENT_MARKET = "market";
    public static final String INTENT_PHONE_CALL = "tel";
    public static final String INTENT_STREAMING_VIDEO = "streamingVideo";
    public static final String INTENT_TXT_MESSAGE = "sms";
    private static final String KEY_ERROR = "error";
    static final String KEY_INTENT_TYPE = "intentType";
    static final String KEY_INTERNAL_ID = "internalId";
    static final String KEY_PACKAGE_NAME = "packageName";
    
    static void adSingleTap(MMAdImpl paramMMAdImpl)
    {
      if (paramMMAdImpl == null) {}
      do
      {
        return;
        MMSDK.runOnUiThread(new Runnable()
        {
          public void run()
          {
            if ((this.val$adImpl != null) && (this.val$adImpl.requestListener != null)) {}
            try
            {
              this.val$adImpl.requestListener.onSingleTap(this.val$adImpl.getCallingAd());
              return;
            }
            catch (Exception localException)
            {
              MMSDK.Log.w("Exception raised in your RequestListener: ", new Object[] { localException });
            }
          }
        });
      } while (!MMSDK.isBroadcastingEvents);
      sendIntent(paramMMAdImpl.getContext(), new Intent("millennialmedia.action.ACTION_OVERLAY_TAP"), paramMMAdImpl.internalId);
      sendIntent(paramMMAdImpl.getContext(), new Intent("millennialmedia.action.ACTION_AD_SINGLE_TAP"), paramMMAdImpl.internalId);
    }
    
    static void displayStarted(MMAdImpl paramMMAdImpl)
    {
      if (paramMMAdImpl == null)
      {
        MMSDK.Log.w("No Context in the listener: ");
        return;
      }
      if (MMSDK.isBroadcastingEvents) {
        sendIntent(paramMMAdImpl.getContext(), new Intent("millennialmedia.action.ACTION_DISPLAY_STARTED"), paramMMAdImpl.internalId);
      }
      overlayOpened(paramMMAdImpl);
    }
    
    static void fetchStartedCaching(MMAdImpl paramMMAdImpl)
    {
      if (paramMMAdImpl == null) {
        MMSDK.Log.w("No Context in the listener: ");
      }
      do
      {
        return;
        MMSDK.runOnUiThread(new Runnable()
        {
          public void run()
          {
            if ((this.val$adImpl != null) && (this.val$adImpl.requestListener != null)) {}
            try
            {
              this.val$adImpl.requestListener.MMAdRequestIsCaching(this.val$adImpl.getCallingAd());
              return;
            }
            catch (Exception localException)
            {
              MMSDK.Log.w("Exception raised in your RequestListener: ", new Object[] { localException });
            }
          }
        });
      } while (!MMSDK.isBroadcastingEvents);
      sendIntent(paramMMAdImpl.getContext(), new Intent("millennialmedia.action.ACTION_FETCH_STARTED_CACHING"), paramMMAdImpl.internalId);
    }
    
    static void intentStarted(Context paramContext, String paramString, long paramLong)
    {
      if ((MMSDK.isBroadcastingEvents) && (paramString != null)) {
        sendIntent(paramContext, new Intent("millennialmedia.action.ACTION_INTENT_STARTED").putExtra("intentType", paramString), paramLong);
      }
    }
    
    protected static void logEvent(String paramString)
    {
      MMSDK.Log.d("Logging event to: %s", new Object[] { paramString });
      Utils.ThreadUtils.execute(new Runnable()
      {
        public void run()
        {
          HttpGetRequest localHttpGetRequest = new HttpGetRequest();
          try
          {
            localHttpGetRequest.get(this.val$logString);
            return;
          }
          catch (Exception localException)
          {
            localException.printStackTrace();
          }
        }
      });
    }
    
    static void overlayClosed(MMAdImpl paramMMAdImpl)
    {
      if (paramMMAdImpl == null) {
        MMSDK.Log.w("No Context in the listener: ");
      }
      do
      {
        return;
        MMSDK.runOnUiThread(new Runnable()
        {
          public void run()
          {
            if ((this.val$adImpl != null) && (this.val$adImpl.requestListener != null)) {}
            try
            {
              this.val$adImpl.requestListener.MMAdOverlayClosed(this.val$adImpl.getCallingAd());
              return;
            }
            catch (Exception localException)
            {
              MMSDK.Log.w("Exception raised in your RequestListener: ", new Object[] { localException });
            }
          }
        });
      } while ((!MMSDK.isBroadcastingEvents) || (paramMMAdImpl.getContext() == null));
      sendIntent(paramMMAdImpl.getContext(), new Intent("millennialmedia.action.ACTION_OVERLAY_CLOSED"), paramMMAdImpl.internalId);
    }
    
    static void overlayOpened(MMAdImpl paramMMAdImpl)
    {
      if (paramMMAdImpl == null)
      {
        MMSDK.Log.w("No Context in the listener: ");
        return;
      }
      MMSDK.runOnUiThread(new Runnable()
      {
        public void run()
        {
          if ((this.val$adImpl != null) && (this.val$adImpl.requestListener != null)) {}
          try
          {
            this.val$adImpl.requestListener.MMAdOverlayLaunched(this.val$adImpl.getCallingAd());
            return;
          }
          catch (Exception localException)
          {
            MMSDK.Log.w("Exception raised in your RequestListener: ", new Object[] { localException });
          }
        }
      });
      overlayOpenedBroadCast(paramMMAdImpl.getContext(), paramMMAdImpl.internalId);
    }
    
    static void overlayOpenedBroadCast(Context paramContext, long paramLong)
    {
      if (MMSDK.isBroadcastingEvents) {
        sendIntent(paramContext, new Intent("millennialmedia.action.ACTION_OVERLAY_OPENED"), paramLong);
      }
    }
    
    static void requestCompleted(MMAdImpl paramMMAdImpl)
    {
      if (paramMMAdImpl == null) {
        MMSDK.Log.w("No Context in the listener: ");
      }
      do
      {
        return;
        MMSDK.runOnUiThread(new Runnable()
        {
          public void run()
          {
            if ((this.val$adImpl != null) && (this.val$adImpl.requestListener != null)) {}
            try
            {
              this.val$adImpl.requestListener.requestCompleted(this.val$adImpl.getCallingAd());
              return;
            }
            catch (Exception localException)
            {
              MMSDK.Log.w("Exception raised in your RequestListener: ", new Object[] { localException });
            }
          }
        });
      } while (!MMSDK.isBroadcastingEvents);
      String str = paramMMAdImpl.getRequestCompletedAction();
      sendIntent(paramMMAdImpl.getContext(), new Intent(str), paramMMAdImpl.internalId);
    }
    
    static void requestFailed(MMAdImpl paramMMAdImpl, final MMException paramMMException)
    {
      if (paramMMAdImpl == null) {
        MMSDK.Log.w("No Context in the listener: ");
      }
      do
      {
        return;
        MMSDK.runOnUiThread(new Runnable()
        {
          public void run()
          {
            if ((this.val$adImpl != null) && (this.val$adImpl.requestListener != null)) {}
            try
            {
              this.val$adImpl.requestListener.requestFailed(this.val$adImpl.getCallingAd(), paramMMException);
              return;
            }
            catch (Exception localException)
            {
              MMSDK.Log.w("Exception raised in your RequestListener: ", new Object[] { localException });
            }
          }
        });
      } while (!MMSDK.isBroadcastingEvents);
      String str = paramMMAdImpl.getRequestFailedAction();
      sendIntent(paramMMAdImpl.getContext(), new Intent(str).putExtra("error", paramMMException), paramMMAdImpl.internalId);
    }
    
    private static final void sendIntent(Context paramContext, Intent paramIntent, long paramLong)
    {
      if (paramContext != null)
      {
        paramIntent.addCategory("millennialmedia.category.CATEGORY_SDK");
        if (paramLong != -4L) {
          paramIntent.putExtra("internalId", paramLong);
        }
        paramIntent.putExtra("packageName", paramContext.getPackageName());
        str = paramIntent.getStringExtra("intentType");
        if (TextUtils.isEmpty(str)) {
          break label120;
        }
      }
      label120:
      for (String str = String.format(" Type[%s]", new Object[] { str });; str = "")
      {
        MMSDK.Log.v(" @@ Intent: " + paramIntent.getAction() + " " + str + " for " + paramLong);
        paramContext.sendBroadcast(paramIntent);
        return;
      }
    }
  }
  
  static class Log
  {
    static void d(String paramString)
    {
      if (MMSDK.logLevel >= 1) {
        Log.i("MillennialMediaSDK", "Diagnostic - " + paramString);
      }
    }
    
    static void d(String paramString, Object... paramVarArgs)
    {
      if (MMSDK.logLevel >= 1) {
        Log.i("MillennialMediaSDK", "Diagnostic - " + String.format(paramString, paramVarArgs));
      }
    }
    
    static void d(Throwable paramThrowable)
    {
      if (MMSDK.logLevel >= 1) {
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
      if (MMSDK.logLevel > 3) {
        Log.i("MillennialMediaSDK", "Private - " + paramString);
      }
    }
    
    static void p(String paramString, Object... paramVarArgs)
    {
      if (MMSDK.logLevel > 3) {
        Log.i("MillennialMediaSDK", "Private - " + String.format(paramString, paramVarArgs));
      }
    }
    
    static void p(Throwable paramThrowable)
    {
      if (MMSDK.logLevel > 3) {
        p(Log.getStackTraceString(paramThrowable));
      }
    }
    
    static void v(String paramString)
    {
      if (MMSDK.logLevel >= 3) {
        Log.i("MillennialMediaSDK", "Verbose - " + paramString);
      }
    }
    
    static void v(String paramString, Object... paramVarArgs)
    {
      if (MMSDK.logLevel >= 3) {
        Log.i("MillennialMediaSDK", "Verbose - " + String.format(paramString, paramVarArgs));
      }
    }
    
    static void v(Throwable paramThrowable)
    {
      if (MMSDK.logLevel >= 3) {
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


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/millennialmedia/android/MMSDK.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */