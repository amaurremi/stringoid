package com.inmobi.androidsdk;

import com.inmobi.commons.internal.Log;
import com.inmobi.re.container.IMWebView.IMWebViewListener;
import com.inmobi.re.container.mraidimpl.ResizeDimensions;

class e
  implements IMWebView.IMWebViewListener
{
  e(IMAdInterstitial paramIMAdInterstitial) {}
  
  public void onDismissAdScreen()
  {
    IMAdInterstitial.a(this.a, 103, null);
  }
  
  public void onError()
  {
    Log.debug("InMobiAndroidSDK_3.7.1", "Error loading the interstitial ad ");
    IMAdInterstitial.b(this.a).sendEmptyMessage(310);
  }
  
  public void onExpand() {}
  
  public void onExpandClose() {}
  
  public void onLeaveApplication()
  {
    IMAdInterstitial.a(this.a, 104, null);
  }
  
  public void onResize(ResizeDimensions paramResizeDimensions) {}
  
  public void onResizeClose() {}
  
  public void onShowAdScreen()
  {
    IMAdInterstitial.a(this.a, 102, null);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/inmobi/androidsdk/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */