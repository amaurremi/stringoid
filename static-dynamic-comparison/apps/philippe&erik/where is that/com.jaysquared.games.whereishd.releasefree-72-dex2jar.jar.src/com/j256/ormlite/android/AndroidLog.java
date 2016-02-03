package com.j256.ormlite.android;

import com.j256.ormlite.logger.Log.Level;
import com.j256.ormlite.logger.LoggerFactory;

public class AndroidLog
  implements com.j256.ormlite.logger.Log
{
  private static final String ALL_LOGS_NAME = "ORMLite";
  private static final int MAX_TAG_LENGTH = 23;
  private static final int REFRESH_LEVEL_CACHE_EVERY = 200;
  private String className;
  private final boolean[] levelCache;
  private volatile int levelCacheC = 0;
  
  public AndroidLog(String paramString)
  {
    this.className = LoggerFactory.getSimpleClassName(paramString);
    int i = this.className.length();
    if (i > 23) {
      this.className = this.className.substring(i - 23, i);
    }
    int j = 0;
    paramString = Log.Level.values();
    int n = paramString.length;
    i = 0;
    while (i < n)
    {
      int m = levelToAndroidLevel(paramString[i]);
      int k = j;
      if (m > j) {
        k = m;
      }
      i += 1;
      j = k;
    }
    this.levelCache = new boolean[j + 1];
    refreshLevelCache();
  }
  
  private boolean isLevelEnabledInternal(int paramInt)
  {
    return (android.util.Log.isLoggable(this.className, paramInt)) || (android.util.Log.isLoggable("ORMLite", paramInt));
  }
  
  private int levelToAndroidLevel(Log.Level paramLevel)
  {
    switch (paramLevel)
    {
    case ???: 
    default: 
      return 4;
    case ???: 
      return 2;
    case ???: 
      return 3;
    case ???: 
      return 5;
    case ???: 
      return 6;
    }
    return 6;
  }
  
  private void refreshLevelCache()
  {
    Log.Level[] arrayOfLevel = Log.Level.values();
    int j = arrayOfLevel.length;
    int i = 0;
    while (i < j)
    {
      int k = levelToAndroidLevel(arrayOfLevel[i]);
      if (k < this.levelCache.length) {
        this.levelCache[k] = isLevelEnabledInternal(k);
      }
      i += 1;
    }
  }
  
  public boolean isLevelEnabled(Log.Level paramLevel)
  {
    int i = this.levelCacheC + 1;
    this.levelCacheC = i;
    if (i >= 200)
    {
      refreshLevelCache();
      this.levelCacheC = 0;
    }
    i = levelToAndroidLevel(paramLevel);
    if (i < this.levelCache.length) {
      return this.levelCache[i];
    }
    return isLevelEnabledInternal(i);
  }
  
  public void log(Log.Level paramLevel, String paramString)
  {
    switch (paramLevel)
    {
    default: 
      android.util.Log.i(this.className, paramString);
      return;
    case ???: 
      android.util.Log.v(this.className, paramString);
      return;
    case ???: 
      android.util.Log.d(this.className, paramString);
      return;
    case ???: 
      android.util.Log.i(this.className, paramString);
      return;
    case ???: 
      android.util.Log.w(this.className, paramString);
      return;
    case ???: 
      android.util.Log.e(this.className, paramString);
      return;
    }
    android.util.Log.e(this.className, paramString);
  }
  
  public void log(Log.Level paramLevel, String paramString, Throwable paramThrowable)
  {
    switch (paramLevel)
    {
    default: 
      android.util.Log.i(this.className, paramString, paramThrowable);
      return;
    case ???: 
      android.util.Log.v(this.className, paramString, paramThrowable);
      return;
    case ???: 
      android.util.Log.d(this.className, paramString, paramThrowable);
      return;
    case ???: 
      android.util.Log.i(this.className, paramString, paramThrowable);
      return;
    case ???: 
      android.util.Log.w(this.className, paramString, paramThrowable);
      return;
    case ???: 
      android.util.Log.e(this.className, paramString, paramThrowable);
      return;
    }
    android.util.Log.e(this.className, paramString, paramThrowable);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/j256/ormlite/android/AndroidLog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */