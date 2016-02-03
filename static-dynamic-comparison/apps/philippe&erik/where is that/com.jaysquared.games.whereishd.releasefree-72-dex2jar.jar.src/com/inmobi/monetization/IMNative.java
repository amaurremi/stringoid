package com.inmobi.monetization;

import android.os.Handler;
import android.view.ViewGroup;
import com.inmobi.commons.InMobi;
import com.inmobi.commons.internal.InternalSDKUtil;
import com.inmobi.monetization.internal.NativeAdRequest;
import com.inmobi.monetization.internal.NativeAdsController;
import com.inmobi.monetization.internal.TrackerView;
import com.inmobi.monetization.internal.abstraction.INativeAdListener;
import com.inmobi.monetization.internal.objects.NativeAd;
import java.util.HashMap;
import java.util.Map;

public class IMNative
{
  TrackerView a = null;
  private String b = null;
  private String c = null;
  private String d = null;
  private String e = null;
  private IMNativeListener f = null;
  private Handler g;
  private NativeAdRequest h = null;
  private boolean i = false;
  private a j = a.g;
  private INativeAdListener k = new a(this);
  
  public IMNative(IMNativeListener paramIMNativeListener)
  {
    a(InMobi.getAppId(), paramIMNativeListener);
    a(a.a);
  }
  
  public IMNative(String paramString, IMNativeListener paramIMNativeListener)
  {
    if ((paramString == null) || ("".equals(paramString.trim())))
    {
      android.util.Log.e("[InMobi]-[Monetization]", "Please create an instance of native ad with valid appId");
      return;
    }
    a(paramString, paramIMNativeListener);
    a(a.a);
  }
  
  protected IMNative(String paramString1, String paramString2, String paramString3)
  {
    this.b = paramString1;
    this.c = paramString2;
    this.d = paramString3;
  }
  
  private a a()
  {
    try
    {
      a locala = this.j;
      return locala;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  private void a(a parama)
  {
    try
    {
      this.j = parama;
      return;
    }
    finally
    {
      parama = finally;
      throw parama;
    }
  }
  
  private void a(String paramString, IMNativeListener paramIMNativeListener)
  {
    if (!InternalSDKUtil.isInitializedSuccessfully())
    {
      android.util.Log.e("[InMobi]-[Monetization]", "Please initialize inmobi before requesting for native ads");
      return;
    }
    new NativeAd(null, null, null);
    this.e = paramString.trim();
    this.f = paramIMNativeListener;
    this.h = new NativeAdRequest(this.e);
    try
    {
      this.g = new Handler();
      return;
    }
    catch (Throwable paramString)
    {
      android.util.Log.e("[InMobi]-[Monetization]", "Please create a native ad instance in the main thread");
    }
  }
  
  public void attachToView(final ViewGroup paramViewGroup)
  {
    try
    {
      if (!InternalSDKUtil.isInitializedSuccessfully())
      {
        android.util.Log.e("[InMobi]-[Monetization]", "Please initialize inmobi before requesting for native ads");
        return;
      }
      if (!this.i)
      {
        android.util.Log.e("[InMobi]-[Monetization]", "Please load a native ad before attach");
        return;
      }
    }
    catch (Exception paramViewGroup)
    {
      android.util.Log.e("[InMobi]-[Monetization]", "Please pass a valid view to attach");
      return;
    }
    if (paramViewGroup == null)
    {
      android.util.Log.e("[InMobi]-[Monetization]", "Please pass a valid view to attach");
      return;
    }
    if (a() == a.d)
    {
      com.inmobi.commons.internal.Log.debug("[InMobi]-[Monetization]", "Ad is already attached");
      return;
    }
    if (a() == a.c)
    {
      if (this.g == null)
      {
        android.util.Log.e("[InMobi]-[Monetization]", "Please create a native ad instance in the main thread");
        return;
      }
      this.g.post(new b(paramViewGroup));
      a(a.d);
      return;
    }
    android.util.Log.e("[InMobi]-[Monetization]", "Cannot attach an ad which is not ready or detached from view");
  }
  
  public void detachFromView()
  {
    if (!InternalSDKUtil.isInitializedSuccessfully())
    {
      android.util.Log.e("[InMobi]-[Monetization]", "Please initialize inmobi before requesting for native ads");
      return;
    }
    if (!this.i)
    {
      android.util.Log.e("[InMobi]-[Monetization]", "Please load a native ad before detach");
      return;
    }
    if (a() == a.d)
    {
      if (this.g == null)
      {
        android.util.Log.e("[InMobi]-[Monetization]", "Please create a native ad instance in the main thread");
        return;
      }
      this.g.post(new c());
      this.i = false;
      a(a.e);
      return;
    }
    com.inmobi.commons.internal.Log.debug("[InMobi]-[Monetization]", "Please attach the native ad view before calling detach");
  }
  
  public String getContent()
  {
    return this.b;
  }
  
  public void handleClick(final HashMap<String, String> paramHashMap)
  {
    if (!InternalSDKUtil.isInitializedSuccessfully())
    {
      android.util.Log.e("[InMobi]-[Monetization]", "Please initialize inmobi before requesting for native ads");
      return;
    }
    if (!this.i)
    {
      android.util.Log.e("[InMobi]-[Monetization]", "Cannot handle click, native ad not loaded or detached from view");
      return;
    }
    if (a() == a.d)
    {
      if (this.g == null)
      {
        android.util.Log.e("[InMobi]-[Monetization]", "Please create a native ad instance in the main thread");
        return;
      }
      this.g.post(new d(paramHashMap));
      return;
    }
    com.inmobi.commons.internal.Log.debug("[InMobi]-[Monetization]", "Please attach to view before handling any events");
  }
  
  public void loadAd()
  {
    if (!InternalSDKUtil.isInitializedSuccessfully()) {}
    do
    {
      android.util.Log.e("[InMobi]-[Monetization]", "Please initialize inmobi before requesting for native ads");
      do
      {
        return;
      } while ((this.e == null) || ("".equals(this.e)));
      if (this.g == null)
      {
        android.util.Log.e("[InMobi]-[Monetization]", "Please create a native ad instance in the main thread");
        return;
      }
      if (a() == a.a)
      {
        com.inmobi.commons.internal.Log.debug("[InMobi]-[Monetization]", "Loading Native Ad");
        a(a.b);
        NativeAdsController.getInstance().getAd(this.e, this.h, this.k);
        return;
      }
      if (a() == a.b)
      {
        android.util.Log.e("[InMobi]-[Monetization]", "Ad is already loading. Please wait");
        return;
      }
    } while (a() == a.g);
    com.inmobi.commons.internal.Log.debug("[InMobi]-[Monetization]", "Loading native ad");
    if (a() == a.d) {
      detachFromView();
    }
    this.b = null;
    this.c = null;
    this.d = null;
    a(a.b);
    NativeAdsController.getInstance().getAd(this.e, this.h, this.k);
  }
  
  public void setKeywords(String paramString)
  {
    if ((paramString == null) || ("".equals(paramString.trim())))
    {
      com.inmobi.commons.internal.Log.debug("[InMobi]-[Network]-4.1.1", "Keywords cannot be null or blank.");
      return;
    }
    this.h.setKeywords(paramString);
  }
  
  public void setRefTagParam(String paramString1, String paramString2)
  {
    if ((paramString1 == null) || ("".equals(paramString1.trim())))
    {
      com.inmobi.commons.internal.Log.debug("[InMobi]-[Network]-4.1.1", "Ref tag key cannot be null or blank.");
      return;
    }
    if ((paramString2 == null) || ("".equals(paramString2.trim())))
    {
      com.inmobi.commons.internal.Log.debug("[InMobi]-[Network]-4.1.1", "RefTag value cannot be null or blank.");
      return;
    }
    this.h.setRefTagParam(paramString1, paramString2);
  }
  
  public void setRequestParams(Map<String, String> paramMap)
  {
    if ((paramMap == null) || (paramMap.isEmpty()))
    {
      com.inmobi.commons.internal.Log.debug("[InMobi]-[Network]-4.1.1", "Request params cannot be null or empty.");
      return;
    }
    this.h.setRequestParams(paramMap);
  }
  
  private static enum a
  {
    private a() {}
  }
  
  class b
    implements Runnable
  {
    b(ViewGroup paramViewGroup) {}
    
    public void run()
    {
      try
      {
        IMNative.this.a = new TrackerView(paramViewGroup.getContext(), IMNative.a(IMNative.this), IMNative.b(IMNative.this));
        paramViewGroup.addView(IMNative.this.a);
        return;
      }
      catch (Exception localException)
      {
        android.util.Log.e("[InMobi]-[Monetization]", "Failed to attach the view");
        IMNative.a(IMNative.this, IMNative.a.f);
      }
    }
  }
  
  class c
    implements Runnable
  {
    c() {}
    
    public void run()
    {
      try
      {
        if (IMNative.this.a != null)
        {
          IMNative.this.a.destroy();
          IMNative.this.a = null;
          return;
        }
        android.util.Log.e("[InMobi]-[Monetization]", "Please attach the native ad view before calling detach");
        IMNative.a(IMNative.this, IMNative.a.f);
        return;
      }
      catch (Exception localException)
      {
        IMNative.a(IMNative.this, IMNative.a.f);
        com.inmobi.commons.internal.Log.debug("[InMobi]-[Monetization]", "Failed to detach a view");
      }
    }
  }
  
  class d
    implements Runnable
  {
    d(HashMap paramHashMap) {}
    
    public void run()
    {
      try
      {
        IMNative.this.a.click(paramHashMap);
        return;
      }
      catch (Exception localException)
      {
        com.inmobi.commons.internal.Log.debug("[InMobi]-[Monetization]", "Failed to track click");
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/inmobi/monetization/IMNative.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */