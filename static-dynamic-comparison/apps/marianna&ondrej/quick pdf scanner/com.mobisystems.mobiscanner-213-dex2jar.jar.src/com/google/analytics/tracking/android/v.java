package com.google.analytics.tracking.android;

public class v
{
  private static s kY;
  
  public static void A(String paramString)
  {
    Logger localLogger = ka();
    if (localLogger != null) {
      localLogger.q(paramString);
    }
  }
  
  public static void B(String paramString)
  {
    Logger localLogger = ka();
    if (localLogger != null) {
      localLogger.info(paramString);
    }
  }
  
  public static void C(String paramString)
  {
    Logger localLogger = ka();
    if (localLogger != null) {
      localLogger.o(paramString);
    }
  }
  
  public static void D(String paramString)
  {
    Logger localLogger = ka();
    if (localLogger != null) {
      localLogger.p(paramString);
    }
  }
  
  private static Logger ka()
  {
    if (kY == null) {
      kY = s.jX();
    }
    if (kY != null) {
      return kY.ka();
    }
    return null;
  }
  
  public static boolean kf()
  {
    if (ka() != null) {
      return Logger.LogLevel.kZ.equals(ka().jx());
    }
    return false;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/analytics/tracking/android/v.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */