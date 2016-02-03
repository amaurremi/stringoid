package com.google.android.gms.internal;

public class bz
{
  public static int a(String paramString)
  {
    if (paramString.equals("person")) {
      return 0;
    }
    if (paramString.equals("page")) {
      return 1;
    }
    throw new IllegalArgumentException("Unknown objectType string: " + paramString);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/google/android/gms/internal/bz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */