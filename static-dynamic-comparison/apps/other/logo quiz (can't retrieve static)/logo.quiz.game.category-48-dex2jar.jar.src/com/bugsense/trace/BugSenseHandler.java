package com.bugsense.trace;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.util.Log;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class BugSenseHandler
{
  public static boolean I_WANT_TO_DEBUG = false;
  private static HashMap<String, String> crashExtraData = new HashMap();
  private static SharedPreferences.Editor editor;
  private static ExceptionCallback exceptionCallback = null;
  private static boolean isSessionActive = false;
  static String locText;
  static String locTicker = "";
  static String locTitle = "";
  private static SharedPreferences preferences;
  
  static
  {
    locText = "";
  }
  
  public static void addCrashExtraData(String paramString1, String paramString2)
  {
    if (crashExtraData == null) {
      crashExtraData = new HashMap();
    }
    crashExtraData.put(paramString1, Utils.exceedLimitString(paramString2));
  }
  
  public static void addCrashExtraMap(HashMap<String, String> paramHashMap)
  {
    if (crashExtraData == null) {
      crashExtraData = new HashMap();
    }
    paramHashMap = paramHashMap.entrySet().iterator();
    while (paramHashMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramHashMap.next();
      crashExtraData.put(localEntry.getKey(), Utils.exceedLimitString((String)localEntry.getValue()));
    }
  }
  
  public static void clearCrashExtraData()
  {
    if (crashExtraData == null)
    {
      crashExtraData = new HashMap();
      return;
    }
    crashExtraData.clear();
  }
  
  public static void clearTotalCrashesNum() {}
  
  public static void closeSession(Context paramContext)
  {
    isSessionActive = false;
    PingsMechanism.savePing(1, "");
  }
  
  public static void flush(Context paramContext)
  {
    if (G.sendOnlyWiFi)
    {
      if (G.IS_WIFI_ON == 1)
      {
        Log.i(G.TAG, "Flushing...");
        PingsMechanism.getInstance().sendSavedPings();
        CrashMechanism.getInstance().sendSavedCrashes();
        EventsMechanism.getInstance().sendSavedEvents();
      }
      return;
    }
    Log.i(G.TAG, "Flushing...");
    PingsMechanism.getInstance().sendSavedPings();
    CrashMechanism.getInstance().sendSavedCrashes();
    EventsMechanism.getInstance().sendSavedEvents();
  }
  
  protected static ExceptionCallback getCallback()
  {
    return exceptionCallback;
  }
  
  public static HashMap<String, String> getCrashExtraData()
  {
    if (crashExtraData == null) {
      crashExtraData = new HashMap();
    }
    return crashExtraData;
  }
  
  public static String getLastCrashID()
  {
    return Utils.getLastCrashID();
  }
  
  public static int getTotalCrashesNum()
  {
    return Utils.getCrashCounter();
  }
  
  public static void initAndStartSession(Context paramContext, String paramString)
  {
    if (paramContext == null)
    {
      Log.e(G.TAG, "Context is null!");
      return;
    }
    G.TIMESTAMP = System.currentTimeMillis();
    if ((paramString == null) || (paramString.length() < 8) || (paramString.length() > 14)) {
      throw new IllegalArgumentException("Your BugSense API Key is invalid!");
    }
    G.API_KEY = paramString;
    installHandler();
    G.PHONE_MODEL = Build.MODEL;
    G.ANDROID_VERSION = Build.VERSION.RELEASE;
    try
    {
      paramString = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 0);
      G.APP_VERSION = paramString.versionName;
      G.APP_VERSIONCODE = String.valueOf(paramString.versionCode);
      G.APP_PACKAGE = paramString.packageName;
      Utils.setProperties(paramContext);
    }
    catch (Exception paramString)
    {
      try
      {
        do
        {
          G.FILES_PATH = paramContext.getFilesDir().getAbsolutePath();
          if (G.FILES_PATH != null) {
            break;
          }
          Log.e(G.TAG, "G.FILES_PATH GOT NULL!");
          return;
          paramString = paramString;
          Log.e(G.TAG, "Error collecting information about the package!");
        } while (!I_WANT_TO_DEBUG);
        paramString.printStackTrace();
      }
      catch (Exception paramString)
      {
        for (;;)
        {
          if (I_WANT_TO_DEBUG) {
            paramString.printStackTrace();
          }
        }
        if (I_WANT_TO_DEBUG) {
          Log.d(G.TAG, "Files Path set to: " + G.FILES_PATH);
        }
        G.HAS_ROOT = Utils.checkForRoot();
        new Thread(new Runnable()
        {
          public void run()
          {
            G.UID = UidManager.getUid(this.val$context);
            if (!G.proxyEnabled) {
              if (!G.ANALYTICS_URL.contains(G.API_KEY)) {
                G.ANALYTICS_URL = G.ANALYTICS_URL + G.API_KEY + "/" + G.UID;
              }
            }
            for (;;)
            {
              if (BugSenseHandler.I_WANT_TO_DEBUG)
              {
                Log.d(G.TAG, "Crash     URL set to: " + G.URL);
                Log.d(G.TAG, "Analytics URL set to: " + G.ANALYTICS_URL);
              }
              PingsMechanism.transmitPingASync(0);
              try
              {
                BugSenseHandler.access$002(this.val$context.getSharedPreferences(G.TAG, 0));
                BugSenseHandler.access$102(BugSenseHandler.preferences.edit());
                BugSenseHandler.editor.putLong("lastping", System.currentTimeMillis()).commit();
                BugSenseHandler.flush(this.val$context);
                BugSenseHandler.startSession(this.val$context);
                localFile = new File(G.FILES_PATH + "/" + "fixnotification");
                if ((localFile != null) && (localFile.exists())) {
                  str4 = "";
                }
                try
                {
                  localBufferedReader3 = new BufferedReader(new FileReader(localFile.getAbsolutePath()));
                  str1 = str4;
                  localBufferedReader1 = localBufferedReader3;
                  if (localBufferedReader3 == null) {}
                }
                catch (Exception localException2)
                {
                  for (;;)
                  {
                    String str1;
                    BufferedReader localBufferedReader1;
                    label281:
                    localBufferedReader2 = null;
                    String str2 = str4;
                  }
                }
                try
                {
                  str1 = localBufferedReader3.readLine();
                  localBufferedReader1 = localBufferedReader3;
                }
                catch (Exception localException3)
                {
                  String str3 = str4;
                  localBufferedReader2 = localBufferedReader3;
                  break label281;
                }
                if (localBufferedReader1 == null) {}
              }
              catch (Exception localException1)
              {
                try
                {
                  do
                  {
                    File localFile;
                    localBufferedReader1.close();
                    if ((localFile != null) && (localFile.exists())) {
                      localFile.delete();
                    }
                    if ((str1 != null) && (str1.length() > 5)) {
                      BugSense.showUpgradeNotification(this.val$context, str1);
                    }
                    return;
                    G.URL = "http://alt.bugsense.com/api/errors";
                    if (G.ANALYTICS_URL.contains(G.API_KEY)) {
                      break;
                    }
                    G.ANALYTICS_URL = "http://alt.bugsense.com/api/ticks/" + G.API_KEY + "/" + G.UID;
                    break;
                    localException1 = localException1;
                    Log.e(G.TAG, "Preferences are null!");
                  } while (!BugSenseHandler.I_WANT_TO_DEBUG);
                  localException1.printStackTrace();
                }
                catch (IOException localIOException)
                {
                  for (;;)
                  {
                    localIOException.printStackTrace();
                  }
                }
              }
            }
          }
        }).start();
      }
    }
  }
  
  private static void installHandler()
  {
    Log.i(G.TAG, "Registering default exceptions handler");
    Thread.UncaughtExceptionHandler localUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
    if ((localUncaughtExceptionHandler != null) && (I_WANT_TO_DEBUG)) {
      Log.d(G.TAG, "current handler class=" + localUncaughtExceptionHandler.getClass().getName());
    }
    if (!(localUncaughtExceptionHandler instanceof DefaultExceptionHandler)) {
      Thread.setDefaultUncaughtExceptionHandler(new DefaultExceptionHandler(localUncaughtExceptionHandler));
    }
  }
  
  public static void leaveBreadcrumb(String paramString)
  {
    if (G.breadcrumbs == null) {
      G.breadcrumbs = new ArrayList(16);
    }
    if (G.breadcrumbs.size() >= 16) {
      G.breadcrumbs.remove(0);
    }
    G.breadcrumbs.add(paramString);
    if (I_WANT_TO_DEBUG) {
      Log.i(G.TAG, "BreadCrumb: " + paramString + " added.");
    }
  }
  
  public static void removeCrashExtraData(String paramString)
  {
    if (crashExtraData == null) {
      crashExtraData = new HashMap();
    }
    crashExtraData.remove(paramString);
  }
  
  public static void sendDataOverWiFiOnly()
  {
    G.sendOnlyWiFi = true;
    if (I_WANT_TO_DEBUG) {
      Log.i(G.TAG, "BugSense will send data only over WiFi. Please make sure you have the ACCESS_NETWORK_STATE permission.");
    }
  }
  
  public static void sendEvent(String paramString)
  {
    EventsMechanism.saveEvent(paramString);
  }
  
  public static void sendException(Exception paramException)
  {
    sendExceptionMap(new HashMap(0), paramException);
  }
  
  public static void sendExceptionMap(HashMap<String, String> paramHashMap, Exception paramException)
  {
    StringWriter localStringWriter = new StringWriter();
    Object localObject = new PrintWriter(localStringWriter);
    if (G.API_KEY == null) {
      Log.e(G.TAG, "Could not send: API Key is missing");
    }
    for (;;)
    {
      return;
      Log.i(G.TAG, "Saving handled exception");
      paramException.printStackTrace((PrintWriter)localObject);
      paramException = new HashMap();
      if (paramHashMap != null)
      {
        paramHashMap = paramHashMap.entrySet().iterator();
        while (paramHashMap.hasNext())
        {
          localObject = (Map.Entry)paramHashMap.next();
          paramException.put(((Map.Entry)localObject).getKey(), Utils.exceedLimitString((String)((Map.Entry)localObject).getValue()));
        }
      }
      long l1 = 0L;
      for (;;)
      {
        try
        {
          long l2 = System.currentTimeMillis();
          long l3 = G.TIMESTAMP;
          l1 = l2 - l3;
        }
        catch (Exception paramHashMap)
        {
          continue;
        }
        try
        {
          paramHashMap = CrashMechanism.createJSONFromCrash(localStringWriter.toString(), G.IS_WIFI_ON, G.IS_MOBILENET_ON, G.IS_GPS_ON, G.SCREEN_PROPS, Utils.getTime(), getCrashExtraData(), paramException, 0, l1, null);
          try
          {
            CrashMechanism.saveCrash(paramHashMap, 0);
            return;
          }
          catch (Exception paramHashMap)
          {
            Log.e(G.TAG, "Failed to save handled exception ");
          }
          if (!I_WANT_TO_DEBUG) {
            break;
          }
          paramHashMap.printStackTrace();
          return;
        }
        catch (Exception paramHashMap)
        {
          paramHashMap.printStackTrace();
          paramHashMap = "";
        }
      }
    }
  }
  
  public static void sendExceptionMessage(String paramString1, String paramString2, Exception paramException)
  {
    HashMap localHashMap = new HashMap(1);
    if ((paramString1 != null) && (paramString2 != null)) {
      localHashMap.put(paramString1, Utils.exceedLimitString(paramString2));
    }
    sendExceptionMap(localHashMap, paramException);
  }
  
  public static void setExceptionCallback(ExceptionCallback paramExceptionCallback)
  {
    exceptionCallback = paramExceptionCallback;
  }
  
  public static void setLocalizedNotification(String paramString1, String paramString2, String paramString3)
  {
    locTicker = paramString1;
    locTitle = paramString2;
    locText = paramString3;
  }
  
  public static void setLogging(int paramInt)
  {
    G.SEND_LOG = true;
    G.LOG_LINES = paramInt;
  }
  
  public static void setLogging(int paramInt, String paramString)
  {
    G.SEND_LOG = true;
    G.LOG_LINES = paramInt;
    G.LOG_FILTER = paramString;
  }
  
  public static void setLogging(String paramString)
  {
    G.SEND_LOG = true;
    G.LOG_FILTER = paramString;
  }
  
  public static void setLogging(boolean paramBoolean)
  {
    G.SEND_LOG = paramBoolean;
  }
  
  public static void setUserIdentifier(String paramString)
  {
    G.userIdentifier = paramString;
  }
  
  public static void startSession(Context paramContext)
  {
    installHandler();
    Utils.setProperties(paramContext);
    if (!isSessionActive) {
      isSessionActive = true;
    }
    try
    {
      paramContext = paramContext.getSharedPreferences(G.TAG, 0);
      Long localLong = Long.valueOf(paramContext.getLong("lastping", 0L));
      if ((localLong.longValue() == 0L) || (System.currentTimeMillis() > localLong.longValue() + 10000L))
      {
        paramContext.edit().putLong("lastping", System.currentTimeMillis()).commit();
        PingsMechanism.savePing(0, "");
      }
      return;
    }
    catch (NullPointerException paramContext)
    {
      do
      {
        Log.e(G.TAG, "StartSession Preferences are null!");
      } while (!I_WANT_TO_DEBUG);
      paramContext.printStackTrace();
    }
  }
  
  public static void useProxy(boolean paramBoolean)
  {
    G.proxyEnabled = paramBoolean;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/bugsense/trace/BugSenseHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */