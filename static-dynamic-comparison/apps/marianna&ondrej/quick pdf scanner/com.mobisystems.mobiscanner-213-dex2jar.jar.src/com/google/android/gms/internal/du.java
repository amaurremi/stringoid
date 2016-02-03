package com.google.android.gms.internal;

public final class du
  implements dt
{
  private static du Md;
  
  public static dt qX()
  {
    try
    {
      if (Md == null) {
        Md = new du();
      }
      du localdu = Md;
      return localdu;
    }
    finally {}
  }
  
  public long currentTimeMillis()
  {
    return System.currentTimeMillis();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/internal/du.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */