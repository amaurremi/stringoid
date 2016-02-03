package com.google.android.gms.internal;

public final class il
  implements ij
{
  private static il Hv;
  
  public static ij gb()
  {
    try
    {
      if (Hv == null) {
        Hv = new il();
      }
      il localil = Hv;
      return localil;
    }
    finally {}
  }
  
  public long currentTimeMillis()
  {
    return System.currentTimeMillis();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/internal/il.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */