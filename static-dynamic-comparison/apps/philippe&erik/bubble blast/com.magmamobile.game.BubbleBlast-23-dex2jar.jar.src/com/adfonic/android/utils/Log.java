package com.adfonic.android.utils;

public class Log
{
  private static boolean AD_REQUEST_LOGGING_ENABLED = true;
  private static final int ERROR = 6;
  private static final int INFO = 2;
  private static final boolean PRODUCTION_MODE = false;
  public static final String TAG = "Adfonic";
  private static final int VERBOSE = 2;
  
  public static void adRequestDetails(String paramString)
  {
    try
    {
      if ((AD_REQUEST_LOGGING_ENABLED) && (verboseLoggingEnabled())) {
        android.util.Log.i("Adfonic", paramString);
      }
      return;
    }
    catch (Throwable paramString) {}
  }
  
  public static void adRequestSummary(String paramString)
  {
    try
    {
      if (AD_REQUEST_LOGGING_ENABLED) {
        android.util.Log.i("Adfonic", paramString);
      }
      return;
    }
    catch (Throwable paramString) {}
  }
  
  public static void e(String paramString)
  {
    try
    {
      android.util.Log.e("Adfonic", getDetailedLog(paramString));
      return;
    }
    catch (Throwable paramString) {}
  }
  
  public static void e(String paramString, Throwable paramThrowable)
  {
    try
    {
      android.util.Log.e("Adfonic", getDetailedLog(paramString), paramThrowable);
      return;
    }
    catch (Throwable paramString) {}
  }
  
  public static boolean errorLoggingEnabled()
  {
    try
    {
      boolean bool = android.util.Log.isLoggable("Adfonic", 6);
      return bool;
    }
    catch (Throwable localThrowable) {}
    return true;
  }
  
  private static String getDetailedLog(String paramString)
  {
    return getDetailedLog(paramString, 5);
  }
  
  private static String getDetailedLog(String paramString, int paramInt)
  {
    Thread localThread = Thread.currentThread();
    StackTraceElement localStackTraceElement = localThread.getStackTrace()[paramInt];
    String str = localStackTraceElement.getFileName();
    return "[" + localThread.getName() + "][" + str.substring(0, str.length() - 5) + "." + localStackTraceElement.getMethodName() + ":" + localStackTraceElement.getLineNumber() + "] " + paramString;
  }
  
  public static void i(String paramString)
  {
    try
    {
      android.util.Log.i("Adfonic", getDetailedLog(paramString));
      return;
    }
    catch (Throwable paramString) {}
  }
  
  public static boolean infoLoggingEnabled()
  {
    try
    {
      boolean bool = android.util.Log.isLoggable("Adfonic", 2);
      return bool;
    }
    catch (Throwable localThrowable) {}
    return true;
  }
  
  public static void setAdLoggingEnabled(boolean paramBoolean)
  {
    AD_REQUEST_LOGGING_ENABLED = paramBoolean;
  }
  
  public static void v(String paramString)
  {
    try
    {
      android.util.Log.v("Adfonic", getDetailedLog(paramString));
      return;
    }
    catch (Throwable paramString) {}
  }
  
  public static boolean verboseLoggingEnabled()
  {
    try
    {
      boolean bool = android.util.Log.isLoggable("Adfonic", 2);
      return bool;
    }
    catch (Throwable localThrowable) {}
    return true;
  }
  
  public static void w(String paramString)
  {
    try
    {
      android.util.Log.w("Adfonic", getDetailedLog(paramString));
      return;
    }
    catch (Throwable paramString) {}
  }
  
  public static void w(String paramString, Throwable paramThrowable)
  {
    try
    {
      android.util.Log.w("Adfonic", getDetailedLog(paramString), paramThrowable);
      return;
    }
    catch (RuntimeException paramString) {}
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/adfonic/android/utils/Log.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */