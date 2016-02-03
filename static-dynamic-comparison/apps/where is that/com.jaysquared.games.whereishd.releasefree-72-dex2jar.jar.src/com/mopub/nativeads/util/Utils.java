package com.mopub.nativeads.util;

import android.util.Log;

public class Utils
{
  public static void MoPubLog(String paramString)
  {
    MoPubLog(paramString, null);
  }
  
  public static void MoPubLog(String paramString, Exception paramException)
  {
    Log.d("MoPub Native", paramString, paramException);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/mopub/nativeads/util/Utils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */