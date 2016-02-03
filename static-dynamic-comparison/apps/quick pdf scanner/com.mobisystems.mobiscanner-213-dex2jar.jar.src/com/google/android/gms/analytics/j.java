package com.google.android.gms.analytics;

public class j
{
  private static c mP;
  
  public static void C(String paramString)
  {
    e locale = kK();
    if (locale != null) {
      locale.o(paramString);
    }
  }
  
  public static void D(String paramString)
  {
    e locale = kK();
    if (locale != null) {
      locale.p(paramString);
    }
  }
  
  public static void Z(String paramString)
  {
    e locale = kK();
    if (locale != null) {
      locale.q(paramString);
    }
  }
  
  public static void aa(String paramString)
  {
    e locale = kK();
    if (locale != null) {
      locale.info(paramString);
    }
  }
  
  private static e kK()
  {
    if (mP == null) {
      mP = c.kI();
    }
    if (mP != null) {
      return mP.kK();
    }
    return null;
  }
  
  public static boolean kO()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (kK() != null)
    {
      bool1 = bool2;
      if (kK().kL() == 0) {
        bool1 = true;
      }
    }
    return bool1;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/analytics/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */