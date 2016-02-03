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
  private a c = null;
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
    this.c = new a(paramMediationBannerListener);
    for (;;)
    {
      try
      {
        localObject = this.b;
        a locala = this.c;
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
        b localb = new b(paramMediationInterstitialListener);
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
  
  private class a
    implements CustomEventBannerListener
  {
    private View b;
    private final MediationBannerListener c;
    
    public a(MediationBannerListener paramMediationBannerListener)
    {
      this.c = paramMediationBannerListener;
    }
    
    private String b()
    {
      return "Banner custom event labeled '" + CustomEventAdapter.a(CustomEventAdapter.this) + "'";
    }
    
    public View a()
    {
      try
      {
        View localView = this.b;
        return localView;
      }
      finally
      {
        localObject = finally;
        throw ((Throwable)localObject);
      }
    }
    
    public void onClick()
    {
      b.a(b() + " called onClick().");
      this.c.onClick(CustomEventAdapter.this);
    }
    
    public void onDismissScreen()
    {
      b.a(b() + " called onDismissScreen().");
      this.c.onDismissScreen(CustomEventAdapter.this);
    }
    
    public void onFailedToReceiveAd()
    {
      b.a(b() + " called onFailedToReceiveAd().");
      this.c.onFailedToReceiveAd(CustomEventAdapter.this, AdRequest.ErrorCode.NO_FILL);
    }
    
    public void onLeaveApplication()
    {
      try
      {
        b.a(b() + " called onLeaveApplication().");
        this.c.onLeaveApplication(CustomEventAdapter.this);
        return;
      }
      finally
      {
        localObject = finally;
        throw ((Throwable)localObject);
      }
    }
    
    public void onPresentScreen()
    {
      b.a(b() + " called onPresentScreen().");
      this.c.onPresentScreen(CustomEventAdapter.this);
    }
    
    public void onReceivedAd(View paramView)
    {
      try
      {
        b.a(b() + " called onReceivedAd.");
        this.b = paramView;
        this.c.onReceivedAd(CustomEventAdapter.this);
        return;
      }
      finally
      {
        paramView = finally;
        throw paramView;
      }
    }
  }
  
  private class b
    implements CustomEventInterstitialListener
  {
    private final MediationInterstitialListener b;
    
    public b(MediationInterstitialListener paramMediationInterstitialListener)
    {
      this.b = paramMediationInterstitialListener;
    }
    
    private String a()
    {
      return "Interstitial custom event labeled '" + CustomEventAdapter.a(CustomEventAdapter.this) + "'";
    }
    
    public void onDismissScreen()
    {
      b.a(a() + " called onDismissScreen().");
      this.b.onDismissScreen(CustomEventAdapter.this);
    }
    
    public void onFailedToReceiveAd()
    {
      b.a(a() + " called onFailedToReceiveAd().");
      this.b.onFailedToReceiveAd(CustomEventAdapter.this, AdRequest.ErrorCode.NO_FILL);
    }
    
    public void onLeaveApplication()
    {
      try
      {
        b.a(a() + " called onLeaveApplication().");
        this.b.onLeaveApplication(CustomEventAdapter.this);
        return;
      }
      finally
      {
        localObject = finally;
        throw ((Throwable)localObject);
      }
    }
    
    public void onPresentScreen()
    {
      b.a(a() + " called onPresentScreen().");
      this.b.onPresentScreen(CustomEventAdapter.this);
    }
    
    public void onReceivedAd()
    {
      b.a(a() + " called onReceivedAd.");
      this.b.onReceivedAd(CustomEventAdapter.this);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/google/ads/mediation/customevent/CustomEventAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */