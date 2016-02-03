package com.inmobi.androidsdk;

import com.inmobi.commons.internal.Log;
import com.inmobi.re.container.IMWebView.IMWebViewListener;
import com.inmobi.re.container.mraidimpl.ResizeDimensions;
import java.util.Map;

class e
  implements IMWebView.IMWebViewListener
{
  e(InterstitialView paramInterstitialView) {}
  
  public void onDismissAdScreen()
  {
    InterstitialView.a(this.a, 103, null);
  }
  
  public void onError()
  {
    Log.debug("[InMobi]-[Network]-4.1.1", "Error loading the interstitial ad ");
    InterstitialView.b(this.a).sendEmptyMessage(310);
  }
  
  public void onExpand() {}
  
  public void onExpandClose() {}
  
  public void onLeaveApplication()
  {
    InterstitialView.a(this.a, 104, null);
  }
  
  public void onResize(ResizeDimensions paramResizeDimensions) {}
  
  public void onResizeClose() {}
  
  public void onShowAdScreen()
  {
    InterstitialView.a(this.a, 102, null);
  }
  
  public void onUserInteraction(Map<String, String> paramMap)
  {
    InterstitialView.a(this.a).onInterstitialInteraction(this.a, paramMap);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/inmobi/androidsdk/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */