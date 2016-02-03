package com.jaysquared.games.whereishd.utils;

import android.util.Log;

public class SLog
{
  public static boolean isRelease = false;
  
  public static void d(String paramString1, String paramString2)
  {
    if (!isRelease) {
      Log.d(paramString1, paramString2);
    }
  }
  
  public static void e(String paramString1, String paramString2)
  {
    Log.e(paramString1, paramString2);
  }
  
  public static void i(String paramString1, String paramString2)
  {
    if (!isRelease) {
      Log.i(paramString1, paramString2);
    }
  }
  
  public static void v(String paramString1, String paramString2)
  {
    if (!isRelease) {
      Log.v(paramString1, paramString2);
    }
  }
  
  public static void w(String paramString1, String paramString2)
  {
    Log.w(paramString1, paramString2);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/jaysquared/games/whereishd/utils/SLog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */