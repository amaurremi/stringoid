package com.vungle.publisher.log;

import android.text.TextUtils;
import android.util.Log;

public class Logger
{
  public static final String AD_TAG = "VungleAd";
  public static final String ASYNC_TAG = "VungleAsync";
  public static final String CONFIG_TAG = "VungleConfig";
  public static final String DATABASE_DUMP_TAG = "VungleDatabaseDump";
  public static final String DATABASE_TAG = "VungleDatabase";
  public static final String DEVICE_TAG = "VungleDevice";
  public static final String EVENT_TAG = "VungleEvent";
  public static final String FILE_TAG = "VungleFile";
  public static final String INJECT_TAG = "VungleInject";
  public static final String NETWORK_TAG = "VungleNetwork";
  public static final String PREPARE_TAG = "VunglePrepare";
  public static final String PROTOCOL_TAG = "VungleProtocol";
  public static final String REPORT_TAG = "VungleReport";
  public static final String SERVICE_TAG = "VungleService";
  public static final String VUNGLE_TAG = "Vungle";
  
  private static void a(int paramInt, String paramString1, String paramString2, Throwable paramThrowable)
  {
    int j = 1;
    boolean bool = Log.isLoggable("VungleDebug", 3);
    int i;
    if (((!bool) && (paramInt > 5)) || ((bool) && (Log.isLoggable("Vungle", paramInt))))
    {
      if (TextUtils.isEmpty(paramString2)) {
        break label115;
      }
      i = 1;
      if (paramThrowable == null) {
        break label121;
      }
    }
    for (;;)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      if (i != 0) {
        localStringBuilder.append(paramString2);
      }
      if ((i != 0) && (j != 0)) {
        localStringBuilder.append("\n");
      }
      if (j != 0) {
        localStringBuilder.append(Log.getStackTraceString(paramThrowable));
      }
      Log.println(paramInt, paramString1, localStringBuilder.toString());
      return;
      label115:
      i = 0;
      break;
      label121:
      j = 0;
    }
  }
  
  public static void d(String paramString1, String paramString2)
  {
    a(3, paramString1, paramString2, null);
  }
  
  public static void d(String paramString1, String paramString2, Throwable paramThrowable)
  {
    a(3, paramString1, paramString2, paramThrowable);
  }
  
  public static void d(String paramString, Throwable paramThrowable)
  {
    a(3, paramString, null, paramThrowable);
  }
  
  public static void e(String paramString1, String paramString2)
  {
    a(6, paramString1, paramString2, null);
  }
  
  public static void e(String paramString1, String paramString2, Throwable paramThrowable)
  {
    a(6, paramString2, null, paramThrowable);
  }
  
  public static void e(String paramString, Throwable paramThrowable)
  {
    a(6, paramString, null, paramThrowable);
  }
  
  public static void i(String paramString1, String paramString2)
  {
    a(4, paramString1, paramString2, null);
  }
  
  public static void v(String paramString1, String paramString2)
  {
    a(2, paramString1, paramString2, null);
  }
  
  public static void w(String paramString1, String paramString2)
  {
    a(5, paramString1, paramString2, null);
  }
  
  public static void w(String paramString1, String paramString2, Throwable paramThrowable)
  {
    a(5, paramString1, paramString2, paramThrowable);
  }
  
  public static void w(String paramString, Throwable paramThrowable)
  {
    a(5, paramString, null, paramThrowable);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/vungle/publisher/log/Logger.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */