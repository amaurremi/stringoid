package com.google.android.gms.games.internal.constants;

public final class PlatformType
{
  public static String cm(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      throw new IllegalArgumentException("Unknown platform type: " + paramInt);
    case 0: 
      return "ANDROID";
    case 1: 
      return "IOS";
    }
    return "WEB_APP";
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/games/internal/constants/PlatformType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */