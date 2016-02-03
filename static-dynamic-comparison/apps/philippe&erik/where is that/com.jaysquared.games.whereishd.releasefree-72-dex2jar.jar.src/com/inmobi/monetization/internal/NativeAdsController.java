package com.inmobi.monetization.internal;

import com.inmobi.androidsdk.bootstrapper.ConfigParams;
import com.inmobi.androidsdk.bootstrapper.Initializer;
import com.inmobi.androidsdk.bootstrapper.NativeConfigParams;
import com.inmobi.commons.internal.InternalSDKUtil;
import com.inmobi.commons.internal.Log;
import com.inmobi.monetization.IMErrorCode;
import com.inmobi.monetization.internal.abstraction.INativeAdController;
import com.inmobi.monetization.internal.abstraction.INativeAdListener;
import com.inmobi.monetization.internal.objects.NativeAdsCache;

public class NativeAdsController
  implements INativeAdController
{
  private static NativeAdsController d = null;
  private ServiceProvider a = ServiceProvider.getInstance();
  private INativeAdListener b;
  private boolean c = false;
  
  private void a(String paramString, NativeAdRequest paramNativeAdRequest)
  {
    if (InternalSDKUtil.checkNetworkAvailibility(InternalSDKUtil.getContext()))
    {
      Log.internal("[InMobi]-[Monetization]", "Fetching Native Ads");
      this.a.getNativeAd(paramNativeAdRequest, this);
      return;
    }
    onAdRequestFailed(paramNativeAdRequest, IMErrorCode.NETWORK_ERROR);
  }
  
  public static NativeAdsController getInstance()
  {
    if (d == null) {
      d = new NativeAdsController();
    }
    return d;
  }
  
  public void getAd(String paramString, NativeAdRequest paramNativeAdRequest, INativeAdListener paramINativeAdListener)
  {
    this.c = false;
    this.b = paramINativeAdListener;
    paramINativeAdListener = NativeAdsCache.getInstance().getCachedAd(paramString);
    int i = NativeAdsCache.getInstance().getNumCachedAds(paramString);
    int j = Initializer.getConfigParams().getNativeSdkConfigParams().getmMinLimit();
    if (paramINativeAdListener == null) {
      a(paramString, paramNativeAdRequest);
    }
    do
    {
      do
      {
        return;
        if (i >= j) {
          break;
        }
        this.c = true;
        a(paramString, paramNativeAdRequest);
      } while (this.b == null);
      this.b.onNativeRequestSucceeded(paramINativeAdListener);
      return;
      this.c = true;
    } while (this.b == null);
    this.b.onNativeRequestSucceeded(paramINativeAdListener);
  }
  
  public void onAdRequestFailed(NativeAdRequest paramNativeAdRequest, IMErrorCode paramIMErrorCode)
  {
    Log.debug("[InMobi]-[Monetization]", "Native ad failed: ");
    if ((!this.c) && (this.b != null))
    {
      this.c = true;
      this.b.onNativeRequestFailed(paramIMErrorCode);
    }
  }
  
  public void onAdRequestSucceded(NativeAdRequest paramNativeAdRequest, NativeAdResponse paramNativeAdResponse)
  {
    Log.debug("[InMobi]-[Monetization]", "Native ad received: ");
    NativeAdsCache.getInstance().saveNativeAds(paramNativeAdRequest.getAppId(), paramNativeAdResponse.a());
    if ((!this.c) && (this.b != null))
    {
      this.c = true;
      paramNativeAdRequest = NativeAdsCache.getInstance().getCachedAd(paramNativeAdRequest.getAppId());
      if (paramNativeAdRequest != null) {
        this.b.onNativeRequestSucceeded(paramNativeAdRequest);
      }
    }
    else
    {
      return;
    }
    this.b.onNativeRequestFailed(IMErrorCode.INTERNAL_ERROR);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/inmobi/monetization/internal/NativeAdsController.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */