package com.google.android.gms.analytics;

public class z
{
  private static GoogleAnalytics AT;
  
  public static void T(String paramString)
  {
    Logger localLogger = getLogger();
    if (localLogger != null) {
      localLogger.error(paramString);
    }
  }
  
  public static void U(String paramString)
  {
    Logger localLogger = getLogger();
    if (localLogger != null) {
      localLogger.info(paramString);
    }
  }
  
  public static void V(String paramString)
  {
    Logger localLogger = getLogger();
    if (localLogger != null) {
      localLogger.verbose(paramString);
    }
  }
  
  public static void W(String paramString)
  {
    Logger localLogger = getLogger();
    if (localLogger != null) {
      localLogger.warn(paramString);
    }
  }
  
  public static boolean eL()
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
    if (AT == null) {
      AT = GoogleAnalytics.eE();
    }
    if (AT != null) {
      return AT.getLogger();
    }
    return null;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/analytics/z.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */