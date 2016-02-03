package com.google.android.gms.analytics;

public class aa
{
  private static GoogleAnalytics vs;
  
  public static boolean cT()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (getLogger() != null)
    {
      bool1 = bool2;
      if (getLogger().getLogLevel() == 0) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private static Logger getLogger()
  {
    if (vs == null) {
      vs = GoogleAnalytics.cM();
    }
    if (vs != null) {
      return vs.getLogger();
    }
    return null;
  }
  
  public static void w(String paramString)
  {
    Logger localLogger = getLogger();
    if (localLogger != null) {
      localLogger.error(paramString);
    }
  }
  
  public static void x(String paramString)
  {
    Logger localLogger = getLogger();
    if (localLogger != null) {
      localLogger.info(paramString);
    }
  }
  
  public static void y(String paramString)
  {
    Logger localLogger = getLogger();
    if (localLogger != null) {
      localLogger.verbose(paramString);
    }
  }
  
  public static void z(String paramString)
  {
    Logger localLogger = getLogger();
    if (localLogger != null) {
      localLogger.warn(paramString);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/google/android/gms/analytics/aa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */