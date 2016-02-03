package com.google.ads.mediation.jsadapter;

import android.app.Activity;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.google.ads.AdRequest.ErrorCode;
import com.google.ads.AdSize;
import com.google.ads.mediation.EmptyNetworkExtras;
import com.google.ads.mediation.MediationAdRequest;
import com.google.ads.mediation.MediationBannerAdapter;
import com.google.ads.mediation.MediationBannerListener;
import com.google.android.gms.internal.ct;

public final class JavascriptAdapter
  implements MediationBannerAdapter<EmptyNetworkExtras, JavascriptServerParameters>
{
  private WebView C;
  private FrameLayout D;
  private boolean E;
  private MediationBannerListener k;
  private int v;
  private int w;
  
  public void destroy()
  {
    this.E = true;
  }
  
  public Class<EmptyNetworkExtras> getAdditionalParametersType()
  {
    return EmptyNetworkExtras.class;
  }
  
  public View getBannerView()
  {
    return this.D;
  }
  
  public Class<JavascriptServerParameters> getServerParametersType()
  {
    return JavascriptServerParameters.class;
  }
  
  public WebView getWebView()
  {
    return this.C;
  }
  
  public int getWebViewHeight()
  {
    return this.v;
  }
  
  public int getWebViewWidth()
  {
    return this.w;
  }
  
  public void passbackReceived()
  {
    ct.r("Passback received");
    sendAdNotReceivedUpdate();
  }
  
  public void requestBannerAd(MediationBannerListener paramMediationBannerListener, Activity paramActivity, JavascriptServerParameters paramJavascriptServerParameters, AdSize paramAdSize, MediationAdRequest paramMediationAdRequest, EmptyNetworkExtras paramEmptyNetworkExtras)
  {
    this.k = paramMediationBannerListener;
    if (paramJavascriptServerParameters.height != null)
    {
      i = paramJavascriptServerParameters.height.intValue();
      this.v = i;
      if (paramJavascriptServerParameters.width == null) {
        break label175;
      }
    }
    label175:
    for (int i = paramJavascriptServerParameters.width.intValue();; i = paramAdSize.getWidthInPixels(paramActivity))
    {
      this.w = i;
      this.E = false;
      this.C = new WebView(paramActivity);
      this.C.getSettings().setJavaScriptEnabled(true);
      this.C.setWebViewClient(new BannerWebViewClient(this, paramJavascriptServerParameters.passBackUrl));
      this.C.setBackgroundColor(0);
      this.D = new FrameLayout(paramActivity);
      paramMediationBannerListener = new FrameLayout.LayoutParams(this.w, this.v, 17);
      this.D.addView(this.C, paramMediationBannerListener);
      this.C.loadDataWithBaseURL(null, paramJavascriptServerParameters.htmlScript, "text/html", "utf-8", null);
      return;
      i = paramAdSize.getHeightInPixels(paramActivity);
      break;
    }
  }
  
  public void sendAdNotReceivedUpdate()
  {
    if (!this.E)
    {
      this.E = true;
      this.k.onFailedToReceiveAd(this, AdRequest.ErrorCode.NO_FILL);
    }
  }
  
  public void sendAdReceivedUpdate()
  {
    if (!this.E)
    {
      this.E = true;
      this.k.onReceivedAd(this);
    }
  }
  
  public boolean shouldStopAdCheck()
  {
    return this.E;
  }
  
  public void startCheckingForAd()
  {
    new AdViewCheckTask(this, 200L, 100L).start();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/com/google/ads/mediation/jsadapter/JavascriptAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */