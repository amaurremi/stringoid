package com.google.ads.mediation.customevent;

import android.app.Activity;
import android.view.View;
import com.google.ads.AdRequest.ErrorCode;
import com.google.ads.AdSize;
import com.google.ads.g;
import com.google.ads.mediation.MediationAdRequest;
import com.google.ads.mediation.MediationBannerAdapter;
import com.google.ads.mediation.MediationBannerListener;
import com.google.ads.mediation.MediationInterstitialAdapter;
import com.google.ads.mediation.MediationInterstitialListener;
import com.google.ads.util.a;
import com.google.ads.util.b;

public class CustomEventAdapter
  implements MediationBannerAdapter<CustomEventExtras, CustomEventServerParameters>, MediationInterstitialAdapter<CustomEventExtras, CustomEventServerParameters>
{
  private String a;
  private CustomEventBanner b = null;
  private CustomEventAdapter.a c = null;
  private CustomEventInterstitial d = null;
  
  private <T> T a(String paramString1, Class<T> paramClass, String paramString2)
  {
    try
    {
      paramString2 = g.a(paramString1, paramClass);
      return paramString2;
    }
    catch (ClassNotFoundException paramClass)
    {
      a("Make sure you created a visible class named: " + paramString1 + ". ", paramClass);
      return null;
    }
    catch (ClassCastException paramString1)
    {
      for (;;)
      {
        a("Make sure your custom event implements the " + paramClass.getName() + " interface.", paramString1);
      }
    }
    catch (IllegalAccessException paramClass)
    {
      for (;;)
      {
        a("Make sure the default constructor for class " + paramString1 + " is visible. ", paramClass);
      }
    }
    catch (InstantiationException paramClass)
    {
      for (;;)
      {
        a("Make sure the name " + paramString1 + " does not denote an abstract class or an interface.", paramClass);
      }
    }
    catch (Throwable paramString1)
    {
      for (;;)
      {
        a("", paramString1);
      }
    }
  }
  
  private void a(String paramString, Throwable paramThrowable)
  {
    b.b("Error during processing of custom event with label: '" + this.a + "'. Skipping custom event. " + paramString, paramThrowable);
  }
  
  public void destroy()
  {
    if (this.b != null) {
      this.b.destroy();
    }
    if (this.d != null) {
      this.d.destroy();
    }
  }
  
  public Class<CustomEventExtras> getAdditionalParametersType()
  {
    return CustomEventExtras.class;
  }
  
  public View getBannerView()
  {
    a.b(this.c);
    return this.c.a();
  }
  
  public Class<CustomEventServerParameters> getServerParametersType()
  {
    return CustomEventServerParameters.class;
  }
  
  public void requestBannerAd(MediationBannerListener paramMediationBannerListener, Activity paramActivity, CustomEventServerParameters paramCustomEventServerParameters, AdSize paramAdSize, MediationAdRequest paramMediationAdRequest, CustomEventExtras paramCustomEventExtras)
  {
    a.a(this.a);
    this.a = paramCustomEventServerParameters.label;
    Object localObject = paramCustomEventServerParameters.className;
    String str1 = paramCustomEventServerParameters.parameter;
    this.b = ((CustomEventBanner)a((String)localObject, CustomEventBanner.class, this.a));
    if (this.b == null)
    {
      paramMediationBannerListener.onFailedToReceiveAd(this, AdRequest.ErrorCode.INTERNAL_ERROR);
      return;
    }
    a.a(this.c);
    this.c = new CustomEventAdapter.a(this, paramMediationBannerListener);
    for (;;)
    {
      try
      {
        localObject = this.b;
        CustomEventAdapter.a locala = this.c;
        String str2 = this.a;
        if (paramCustomEventExtras == null)
        {
          paramCustomEventServerParameters = null;
          ((CustomEventBanner)localObject).requestBannerAd(locala, paramActivity, str2, str1, paramAdSize, paramMediationAdRequest, paramCustomEventServerParameters);
          return;
        }
      }
      catch (Throwable paramActivity)
      {
        a("", paramActivity);
        paramMediationBannerListener.onFailedToReceiveAd(this, AdRequest.ErrorCode.INTERNAL_ERROR);
        return;
      }
      paramCustomEventServerParameters = paramCustomEventExtras.getExtra(this.a);
    }
  }
  
  public void requestInterstitialAd(MediationInterstitialListener paramMediationInterstitialListener, Activity paramActivity, CustomEventServerParameters paramCustomEventServerParameters, MediationAdRequest paramMediationAdRequest, CustomEventExtras paramCustomEventExtras)
  {
    a.a(this.a);
    this.a = paramCustomEventServerParameters.label;
    Object localObject = paramCustomEventServerParameters.className;
    String str1 = paramCustomEventServerParameters.parameter;
    this.d = ((CustomEventInterstitial)a((String)localObject, CustomEventInterstitial.class, this.a));
    if (this.d == null)
    {
      paramMediationInterstitialListener.onFailedToReceiveAd(this, AdRequest.ErrorCode.INTERNAL_ERROR);
      return;
    }
    for (;;)
    {
      try
      {
        localObject = this.d;
        CustomEventAdapter.b localb = new CustomEventAdapter.b(this, paramMediationInterstitialListener);
        String str2 = this.a;
        if (paramCustomEventExtras == null)
        {
          paramCustomEventServerParameters = null;
          ((CustomEventInterstitial)localObject).requestInterstitialAd(localb, paramActivity, str2, str1, paramMediationAdRequest, paramCustomEventServerParameters);
          return;
        }
      }
      catch (Throwable paramActivity)
      {
        a("", paramActivity);
        paramMediationInterstitialListener.onFailedToReceiveAd(this, AdRequest.ErrorCode.INTERNAL_ERROR);
        return;
      }
      paramCustomEventServerParameters = paramCustomEventExtras.getExtra(this.a);
    }
  }
  
  public void showInterstitial()
  {
    a.b(this.d);
    try
    {
      this.d.showInterstitial();
      return;
    }
    catch (Throwable localThrowable)
    {
      b.b("Exception when showing custom event labeled '" + this.a + "'.", localThrowable);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/google/ads/mediation/customevent/CustomEventAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */