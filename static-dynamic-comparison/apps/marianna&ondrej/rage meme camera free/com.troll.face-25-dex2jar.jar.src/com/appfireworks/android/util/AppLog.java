package com.appfireworks.android.util;

import android.text.format.DateFormat;
import android.util.Log;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Date;

public class AppLog
{
  private static boolean doLog = false;
  private static String preText = "";
  
  public static void d(String paramString1, String paramString2)
  {
    if (doLog) {
      Log.d(paramString1, preText + paramString2);
    }
  }
  
  public static void e(String paramString1, String paramString2)
  {
    if (doLog) {
      Log.e(paramString1, preText + paramString2);
    }
  }
  
  public static void enableLog(boolean paramBoolean)
  {
    Log.i("AppFireworks", "enableLog: " + paramBoolean);
    doLog = paramBoolean;
  }
  
  public static void i(String paramString1, String paramString2)
  {
    if (doLog) {
      Log.i(paramString1, preText + paramString2);
    }
  }
  
  public static void printStackTrace(String paramString, Exception paramException)
  {
    StringWriter localStringWriter = new StringWriter();
    paramException.printStackTrace(new PrintWriter(localStringWriter));
    Log.d(paramString, localStringWriter.toString());
  }
  
  public static void setPreText(String paramString)
  {
    preText = paramString;
  }
  
  public static void timeTracK(String paramString1, String paramString2)
  {
    if (doLog)
    {
      CharSequence localCharSequence = DateFormat.format("h:mm:ss", new Date().getTime());
      Log.v(paramString1, "Function - " + paramString2 + ": Time = " + localCharSequence);
    }
  }
  
  public static void v(String paramString1, String paramString2)
  {
    if (doLog) {
      Log.v(paramString1, preText + paramString2);
    }
  }
  
  public static void w(String paramString1, String paramString2)
  {
    if (doLog) {
      Log.w(paramString1, preText + paramString2);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/rage meme camera free/com.troll.face-25-dex2jar.jar!/com/appfireworks/android/util/AppLog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */