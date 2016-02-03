package com.flurry.android;

import android.content.Context;
import android.view.ViewGroup;
import com.flurry.android.impl.ads.FlurryAdModule;
import com.flurry.android.monolithic.sdk.impl.bw;
import com.flurry.android.monolithic.sdk.impl.ja;
import java.util.Map;

public class FlurryAds
{
  private static final String a = FlurryAds.class.getSimpleName();
  
  public static void clearLocation()
  {
    FlurryAdModule.getInstance().j();
  }
  
  public static void clearTargetingKeywords()
  {
    FlurryAdModule.getInstance().u();
  }
  
  public static void clearUserCookies()
  {
    FlurryAdModule.getInstance().s();
  }
  
  public static void displayAd(Context paramContext, String paramString, ViewGroup paramViewGroup)
  {
    if (paramContext == null)
    {
      ja.b(a, "Context passed to displayAd was null.");
      return;
    }
    if (paramString == null)
    {
      ja.b(a, "Ad space name passed to displayAd was null.");
      return;
    }
    if (paramString.length() == 0)
    {
      ja.b(a, "Ad space name passed to displayAd was empty.");
      return;
    }
    if (paramViewGroup == null)
    {
      ja.b(a, "ViewGroup  passed to displayAd was null.");
      return;
    }
    FlurryAdModule.getInstance().a(paramContext);
    try
    {
      FlurryAdModule.getInstance().b().a(paramContext, paramString, paramViewGroup);
      return;
    }
    catch (Throwable paramContext)
    {
      ja.b(a, "Exception while displaying Ad: ", paramContext);
    }
  }
  
  public static void enableTestAds(boolean paramBoolean)
  {
    FlurryAdModule.getInstance().a(paramBoolean);
  }
  
  public static void fetchAd(Context paramContext, String paramString, ViewGroup paramViewGroup, FlurryAdSize paramFlurryAdSize)
  {
    if (paramContext == null)
    {
      ja.b(a, "Context passed to fetchAd was null.");
      return;
    }
    if (paramString == null)
    {
      ja.b(a, "Ad space name passed to fetchAd was null.");
      return;
    }
    if (paramString.length() == 0)
    {
      ja.b(a, "Ad space name passed to fetchAd was empty.");
      return;
    }
    if (paramViewGroup == null)
    {
      ja.b(a, "ViewGroup passed to fetchAd was null.");
      return;
    }
    if (paramFlurryAdSize == null)
    {
      ja.b(a, "FlurryAdSize passed to fetchAd was null.");
      return;
    }
    FlurryAdModule.getInstance().a(paramContext);
    try
    {
      FlurryAdModule.getInstance().b().a(paramContext, paramString, paramViewGroup, paramFlurryAdSize);
      return;
    }
    catch (Throwable paramContext)
    {
      ja.b(a, "Exception while fetching Ad: ", paramContext);
    }
  }
  
  @Deprecated
  public static boolean getAd(Context paramContext, String paramString, ViewGroup paramViewGroup, FlurryAdSize paramFlurryAdSize, long paramLong)
  {
    if (paramContext == null)
    {
      ja.b(a, "Context passed to getAd was null.");
      return false;
    }
    if (paramString == null)
    {
      ja.b(a, "Ad space name passed to getAd was null.");
      return false;
    }
    if (paramString.length() == 0)
    {
      ja.b(a, "Ad space name passed to getAd was empty.");
      return false;
    }
    if (paramViewGroup == null)
    {
      ja.b(a, "ViewGroup passed to getAd was null.");
      return false;
    }
    if (paramFlurryAdSize == null)
    {
      ja.b(a, "FlurryAdSize passed to getAd was null.");
      return false;
    }
    FlurryAdModule.getInstance().a(paramContext);
    try
    {
      boolean bool = FlurryAdModule.getInstance().b().a(paramContext, paramString, paramFlurryAdSize, paramViewGroup, paramLong);
      return bool;
    }
    catch (Throwable paramContext)
    {
      ja.b(a, "Exception while getting Ad : ", paramContext);
    }
    return false;
  }
  
  public static void initializeAds(Context paramContext)
  {
    if (paramContext == null)
    {
      ja.b(a, "Context passed to initializeAds was null.");
      return;
    }
    FlurryAdModule.getInstance().a(paramContext);
    try
    {
      FlurryAdModule.getInstance().e(paramContext);
      return;
    }
    catch (Throwable paramContext)
    {
      ja.b(a, "Exception while initializing Ads: ", paramContext);
    }
  }
  
  @Deprecated
  public static boolean isAdAvailable(Context paramContext, String paramString, FlurryAdSize paramFlurryAdSize, long paramLong)
  {
    if (paramContext == null)
    {
      ja.b(a, "Context passed to isAdAvailable was null.");
      return false;
    }
    if (paramString == null)
    {
      ja.b(a, "Ad space name passed to isAdAvailable was null.");
      return false;
    }
    if (paramString.length() == 0)
    {
      ja.b(a, "Ad space name passed to isAdAvailable was empty.");
      return false;
    }
    if (paramFlurryAdSize == null)
    {
      ja.b(a, "FlurryAdSize passed to isAdAvailable was null.");
      return false;
    }
    FlurryAdModule.getInstance().a(paramContext);
    try
    {
      boolean bool = FlurryAdModule.getInstance().b().a(paramString, paramFlurryAdSize, paramLong);
      return bool;
    }
    catch (Throwable paramContext)
    {
      ja.b(a, "Exception while checking Ads if available: ", paramContext);
    }
    return false;
  }
  
  public static boolean isAdReady(String paramString)
  {
    if (paramString == null)
    {
      ja.b(a, "Ad space name passed to isAdReady was null.");
      return false;
    }
    if (paramString.length() == 0)
    {
      ja.b(a, "Ad space name passed to isAdReady was empty.");
      return false;
    }
    return FlurryAdModule.getInstance().b().b(paramString);
  }
  
  public static void removeAd(Context paramContext, String paramString, ViewGroup paramViewGroup)
  {
    if (paramContext == null)
    {
      ja.b(a, "Context passed to removeAd was null.");
      return;
    }
    if (paramString == null)
    {
      ja.b(a, "Ad space name passed to removeAd was null.");
      return;
    }
    if (paramString.length() == 0)
    {
      ja.b(a, "Ad space name passed to removeAd was empty.");
      return;
    }
    if (paramViewGroup == null)
    {
      ja.b(a, "ViewGroup passed to removeAd was null.");
      return;
    }
    FlurryAdModule.getInstance().a(paramContext);
    try
    {
      FlurryAdModule.getInstance().b().a(paramContext, paramString);
      return;
    }
    catch (Throwable paramContext)
    {
      ja.b(a, "Exception while removing Ad: ", paramContext);
    }
  }
  
  public static void setAdListener(FlurryAdListener paramFlurryAdListener)
  {
    FlurryAdModule.getInstance().a(paramFlurryAdListener);
  }
  
  public static void setAdLogUrl(String paramString)
  {
    FlurryAdModule.getInstance().b(paramString);
  }
  
  public static void setAdServerUrl(String paramString)
  {
    FlurryAdModule.getInstance().a(paramString);
  }
  
  public static void setCustomAdNetworkHandler(ICustomAdNetworkHandler paramICustomAdNetworkHandler)
  {
    if (paramICustomAdNetworkHandler == null)
    {
      ja.b(a, "ICustomAdNetworkHandler passed to setCustomAdNetworkHandler was null.");
      return;
    }
    FlurryAdModule.getInstance().a(paramICustomAdNetworkHandler);
  }
  
  static void setFixedAdId(String paramString, CharSequence paramCharSequence)
  {
    FlurryAdModule.getInstance().a(paramString, paramCharSequence);
  }
  
  public static void setLocation(float paramFloat1, float paramFloat2)
  {
    FlurryAdModule.getInstance().a(paramFloat1, paramFloat2);
  }
  
  public static void setTargetingKeywords(Map<String, String> paramMap)
  {
    if (paramMap == null) {
      ja.b(a, "targetingKeywords Map passed to setTargetingKeywords was null.");
    }
    while (paramMap == null) {
      return;
    }
    FlurryAdModule.getInstance().c(paramMap);
  }
  
  public static void setUserCookies(Map<String, String> paramMap)
  {
    if (paramMap == null)
    {
      ja.b(a, "userCookies Map passed to setUserCookies was null.");
      return;
    }
    FlurryAdModule.getInstance().b(paramMap);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/FlurryAds.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */