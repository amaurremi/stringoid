package com.mopub.mobileads;

import android.util.Log;
import java.lang.reflect.Constructor;
import java.util.HashMap;

public abstract class BaseInterstitialAdapter
{
  private static final HashMap<String, String> sInterstitialAdapterMap = new HashMap();
  protected BaseInterstitialAdapterListener mAdapterListener;
  protected MoPubInterstitial mInterstitial;
  protected boolean mInvalidated;
  protected String mJsonParams;
  
  static
  {
    sInterstitialAdapterMap.put("mraid", "com.mopub.mobileads.MraidInterstitialAdapter");
    sInterstitialAdapterMap.put("admob_full", "com.mopub.mobileads.GoogleAdMobInterstitialAdapter");
    sInterstitialAdapterMap.put("millennial_full", "com.mopub.mobileads.MillennialInterstitialAdapter");
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
      Log.d("MoPub", "Couldn't find " + str + "class." + " Make sure the project includes the adapter library for " + str + " from the extras folder");
    }
    return null;
  }
  
  private static String classStringForAdapterType(String paramString)
  {
    return (String)sInterstitialAdapterMap.get(paramString);
  }
  
  public static BaseInterstitialAdapter getAdapterForType(String paramString)
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
      localObject = (BaseInterstitialAdapter)((Class)localObject).getConstructor(new Class[0]).newInstance(new Object[0]);
      return (BaseInterstitialAdapter)localObject;
    }
    catch (Exception localException)
    {
      Log.d("MoPub", "Couldn't create native interstitial adapter for type: " + paramString);
    }
    return null;
  }
  
  public void init(MoPubInterstitial paramMoPubInterstitial, String paramString)
  {
    this.mInterstitial = paramMoPubInterstitial;
    this.mJsonParams = paramString;
    this.mInvalidated = false;
  }
  
  public void invalidate()
  {
    this.mInterstitial = null;
    this.mAdapterListener = null;
    this.mInvalidated = true;
  }
  
  public boolean isInvalidated()
  {
    return this.mInvalidated;
  }
  
  public abstract void loadInterstitial();
  
  public void setAdapterListener(BaseInterstitialAdapterListener paramBaseInterstitialAdapterListener)
  {
    this.mAdapterListener = paramBaseInterstitialAdapterListener;
  }
  
  public abstract void showInterstitial();
  
  public static abstract interface BaseInterstitialAdapterListener
  {
    public abstract void onNativeInterstitialClicked(BaseInterstitialAdapter paramBaseInterstitialAdapter);
    
    public abstract void onNativeInterstitialExpired(BaseInterstitialAdapter paramBaseInterstitialAdapter);
    
    public abstract void onNativeInterstitialFailed(BaseInterstitialAdapter paramBaseInterstitialAdapter);
    
    public abstract void onNativeInterstitialLoaded(BaseInterstitialAdapter paramBaseInterstitialAdapter);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/paper toss/com.bfs.papertoss-7005-dex2jar.jar!/com/mopub/mobileads/BaseInterstitialAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */