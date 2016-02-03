package com.google.android.gms.internal;

public final class im
  implements ik
{
  private static im Hs;
  
  public static ik fW()
  {
    try
    {
      if (Hs == null) {
        Hs = new im();
      }
      im localim = Hs;
      return localim;
    }
    finally {}
  }
  
  public long currentTimeMillis()
  {
    return System.currentTimeMillis();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/internal/im.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */