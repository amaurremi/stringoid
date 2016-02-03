package com.tapjoy;

import android.util.Log;
import java.util.ArrayList;

public class TapjoyLog
{
  private static final int MAX_STRING_SIZE = 4096;
  private static final String TAG = "TapjoyLog";
  private static ArrayList<String> logHistory;
  private static boolean saveLog = false;
  private static boolean showLog = false;
  
  public static void clearLogHistory()
  {
    if (logHistory != null) {
      logHistory.clear();
    }
  }
  
  public static void d(String paramString1, String paramString2)
  {
    if (showLog) {
      Log.d(paramString1, paramString2);
    }
    if (saveLog) {
      logHistory.add(paramString2);
    }
  }
  
  public static void e(String paramString1, String paramString2)
  {
    if (showLog) {
      Log.e(paramString1, paramString2);
    }
    if (saveLog) {
      logHistory.add(paramString2);
    }
  }
  
  public static void enableLogging(boolean paramBoolean)
  {
    Log.i("TapjoyLog", "enableLogging: " + paramBoolean);
    showLog = paramBoolean;
  }
  
  public static ArrayList<String> getLogHistory()
  {
    return logHistory;
  }
  
  public static void i(String paramString1, String paramString2)
  {
    if (showLog)
    {
      if (paramString2.length() > 4096)
      {
        int i = 0;
        while (i <= paramString2.length() / 4096)
        {
          int k = (i + 1) * 4096;
          int j = k;
          if (k > paramString2.length()) {
            j = paramString2.length();
          }
          Log.i(paramString1, paramString2.substring(i * 4096, j));
          i += 1;
        }
      }
      Log.i(paramString1, paramString2);
    }
    if (saveLog) {
      logHistory.add(paramString2);
    }
  }
  
  public static void saveLogHistory(boolean paramBoolean)
  {
    saveLog = paramBoolean;
    if (saveLog)
    {
      logHistory = new ArrayList(1024);
      return;
    }
    logHistory = null;
  }
  
  public static void v(String paramString1, String paramString2)
  {
    if (showLog) {
      Log.v(paramString1, paramString2);
    }
    if (saveLog) {
      logHistory.add(paramString2);
    }
  }
  
  public static void w(String paramString1, String paramString2)
  {
    if (showLog) {
      Log.w(paramString1, paramString2);
    }
    if (saveLog) {
      logHistory.add(paramString2);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/tapjoy/TapjoyLog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */