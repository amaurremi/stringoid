package com.mopub.mobileads;

import android.util.Log;
import java.lang.reflect.Constructor;
import java.util.HashMap;

public abstract class BaseAdapter
{
  private static final HashMap<String, String> sAdapterMap = new HashMap();
  protected boolean mInvalidated;
  protected String mJsonParams;
  protected MoPubView mMoPubView;
  
  static
  {
    sAdapterMap.put("admob_native", "com.mopub.mobileads.GoogleAdMobAdapter");
    sAdapterMap.put("millennial_native", "com.mopub.mobileads.MillennialAdapter");
    sAdapterMap.put("mraid", "com.mopub.mobileads.MraidAdapter");
  }
  
  private static Class<?> classForAdapterType(String paramString)
  {
    String str = classStringForAdapterType(paramString);
    if (str == null)
    {
      Log.d("MoPub", "Couldn't find a handler for this ad type: " + paramString + "." + " MoPub for Android does not support it at this time.");
      return null;
    }
    try
    {
      paramString = Class.forName(str);
      return paramString;
    }
    catch (ClassNotFoundException paramString)
    {
      Log.d("MoPub", "Couldn't find " + str + " class." + " Make sure the project includes the adapter library for " + str + " from the extras folder");
    }
    return null;
  }
  
  private static String classStringForAdapterType(String paramString)
  {
    return (String)sAdapterMap.get(paramString);
  }
  
  public static BaseAdapter getAdapterForType(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    Object localObject = classForAdapterType(paramString);
    if (localObject == null) {
      return null;
    }
    try
    {
      localObject = (BaseAdapter)((Class)localObject).getConstructor(new Class[0]).newInstance(new Object[0]);
      return (BaseAdapter)localObject;
    }
    catch (Exception localException)
    {
      Log.d("MoPub", "Couldn't create native adapter for type: " + paramString);
    }
    return null;
  }
  
  public void init(MoPubView paramMoPubView, String paramString)
  {
    this.mMoPubView = paramMoPubView;
    this.mJsonParams = paramString;
    this.mInvalidated = false;
  }
  
  public void invalidate()
  {
    this.mMoPubView = null;
    this.mInvalidated = true;
  }
  
  public boolean isInvalidated()
  {
    return this.mInvalidated;
  }
  
  public abstract void loadAd();
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/paper toss/com.bfs.papertoss-7005-dex2jar.jar!/com/mopub/mobileads/BaseAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */