package com.inmobi.androidsdk;

import com.inmobi.commons.internal.Log;
import com.inmobi.re.container.IMWebView.IMWebViewListener;
import com.inmobi.re.container.mraidimpl.ResizeDimensions;
import java.util.Map;

class b
  implements IMWebView.IMWebViewListener
{
  b(BannerView paramBannerView) {}
  
  public void onDismissAdScreen()
  {
    BannerView.a(this.a, 103, null);
  }
  
  public void onError()
  {
    Log.debug("[InMobi]-[Network]-4.1.1", "Error loading ad ");
    BannerView.p(this.a).sendEmptyMessage(111);
  }
  
  public void onExpand()
  {
    BannerView.a(this.a, 102, null);
  }
  
  public void onExpandClose()
  {
    BannerView.a(this.a, 103, null);
  }
  
  public void onLeaveApplication()
  {
    BannerView.a(this.a, 104, null);
  }
  
  public void onResize(ResizeDimensions paramResizeDimensions)
  {
    BannerView.a(this.a, 105, null);
  }
  
  public void onResizeClose()
  {
    BannerView.a(this.a, 106, null);
  }
  
  public void onShowAdScreen()
  {
    BannerView.a(this.a, 102, null);
  }
  
  public void onUserInteraction(Map<String, String> paramMap)
  {
    BannerView.a(this.a).onBannerInteraction(this.a, paramMap);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/inmobi/androidsdk/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */