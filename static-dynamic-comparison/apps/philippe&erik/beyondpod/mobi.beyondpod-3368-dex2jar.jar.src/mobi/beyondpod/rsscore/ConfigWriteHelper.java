package mobi.beyondpod.rsscore;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import mobi.beyondpod.rsscore.helpers.CoreHelper;

public abstract class ConfigWriteHelper
{
  public static ConfigWriteHelper getInstance()
  {
    if (CoreHelper.ApiLevel() <= 8) {
      return ConfigWriteHelper.CommitWriter.Holder.sInstance;
    }
    return ConfigWriteHelper.ApplyWriter.Holder.sInstance;
  }
  
  abstract void putBoolean(SharedPreferences paramSharedPreferences, String paramString, boolean paramBoolean);
  
  abstract void putInt(SharedPreferences paramSharedPreferences, String paramString, int paramInt);
  
  abstract void putLong(SharedPreferences paramSharedPreferences, String paramString, long paramLong);
  
  abstract void putString(SharedPreferences paramSharedPreferences, String paramString1, String paramString2);
  
  @SuppressLint({"NewApi"})
  private static class ApplyWriter
    extends ConfigWriteHelper
  {
    @SuppressLint({"NewApi"})
    void putBoolean(SharedPreferences paramSharedPreferences, String paramString, boolean paramBoolean)
    {
      paramSharedPreferences.edit().putBoolean(paramString, paramBoolean).apply();
    }
    
    @SuppressLint({"NewApi"})
    void putInt(SharedPreferences paramSharedPreferences, String paramString, int paramInt)
    {
      paramSharedPreferences.edit().putInt(paramString, paramInt).apply();
    }
    
    @SuppressLint({"NewApi"})
    void putLong(SharedPreferences paramSharedPreferences, String paramString, long paramLong)
    {
      paramSharedPreferences.edit().putLong(paramString, paramLong).apply();
    }
    
    @SuppressLint({"NewApi"})
    void putString(SharedPreferences paramSharedPreferences, String paramString1, String paramString2)
    {
      paramSharedPreferences.edit().putString(paramString1, paramString2).apply();
    }
    
    private static class Holder
    {
      private static final ConfigWriteHelper.ApplyWriter sInstance = new ConfigWriteHelper.ApplyWriter(null);
    }
  }
  
  private static class CommitWriter
    extends ConfigWriteHelper
  {
    void putBoolean(SharedPreferences paramSharedPreferences, String paramString, boolean paramBoolean)
    {
      paramSharedPreferences.edit().putBoolean(paramString, paramBoolean).commit();
    }
    
    void putInt(SharedPreferences paramSharedPreferences, String paramString, int paramInt)
    {
      paramSharedPreferences.edit().putInt(paramString, paramInt).commit();
    }
    
    void putLong(SharedPreferences paramSharedPreferences, String paramString, long paramLong)
    {
      paramSharedPreferences.edit().putLong(paramString, paramLong).commit();
    }
    
    void putString(SharedPreferences paramSharedPreferences, String paramString1, String paramString2)
    {
      paramSharedPreferences.edit().putString(paramString1, paramString2).commit();
    }
    
    private static class Holder
    {
      private static final ConfigWriteHelper.CommitWriter sInstance = new ConfigWriteHelper.CommitWriter(null);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/rsscore/ConfigWriteHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */