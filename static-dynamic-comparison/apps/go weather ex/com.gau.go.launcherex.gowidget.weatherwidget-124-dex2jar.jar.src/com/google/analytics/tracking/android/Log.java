package com.google.analytics.tracking.android;

class Log
{
  static final String LOG_TAG = "GAV2";
  private static boolean debug;
  
  static int d(String paramString)
  {
    return android.util.Log.d("GAV2", formatMessage(paramString));
  }
  
  static int dDebug(String paramString)
  {
    if (debug) {
      return d(paramString);
    }
    return 0;
  }
  
  static boolean debugEnabled()
  {
    return debug;
  }
  
  static int e(String paramString)
  {
    return android.util.Log.e("GAV2", formatMessage(paramString));
  }
  
  static int eDebug(String paramString)
  {
    if (debug) {
      return e(paramString);
    }
    return 0;
  }
  
  private static String formatMessage(String paramString)
  {
    return Thread.currentThread().toString() + ": " + paramString;
  }
  
  static int i(String paramString)
  {
    return android.util.Log.i("GAV2", formatMessage(paramString));
  }
  
  static int iDebug(String paramString)
  {
    if (debug) {
      return i(paramString);
    }
    return 0;
  }
  
  static void setDebug(boolean paramBoolean)
  {
    debug = paramBoolean;
  }
  
  static int v(String paramString)
  {
    return android.util.Log.v("GAV2", formatMessage(paramString));
  }
  
  static int vDebug(String paramString)
  {
    if (debug) {
      return v(paramString);
    }
    return 0;
  }
  
  static int w(String paramString)
  {
    return android.util.Log.w("GAV2", formatMessage(paramString));
  }
  
  static int wDebug(String paramString)
  {
    if (debug) {
      return w(paramString);
    }
    return 0;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/google/analytics/tracking/android/Log.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */