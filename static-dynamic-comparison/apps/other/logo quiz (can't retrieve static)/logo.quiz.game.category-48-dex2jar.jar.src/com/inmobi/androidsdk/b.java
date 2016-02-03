package com.inmobi.androidsdk;

import com.inmobi.commons.internal.Log;
import com.inmobi.re.container.IMWebView.IMWebViewListener;
import com.inmobi.re.container.mraidimpl.ResizeDimensions;

class b
  implements IMWebView.IMWebViewListener
{
  b(IMAdView paramIMAdView) {}
  
  public void onDismissAdScreen()
  {
    IMAdView.a(this.a, 103, null);
  }
  
  public void onError()
  {
    Log.debug("InMobiAndroidSDK_3.7.1", "Error loading ad ");
    IMAdView.t(this.a).sendEmptyMessage(111);
  }
  
  public void onExpand()
  {
    IMAdView.a(this.a, 102, null);
  }
  
  public void onExpandClose()
  {
    IMAdView.a(this.a, 103, null);
  }
  
  public void onLeaveApplication()
  {
    IMAdView.a(this.a, 104, null);
  }
  
  public void onResize(ResizeDimensions paramResizeDimensions)
  {
    IMAdView.a(this.a, 105, null);
  }
  
  public void onResizeClose()
  {
    IMAdView.a(this.a, 106, null);
  }
  
  public void onShowAdScreen()
  {
    IMAdView.a(this.a, 102, null);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/inmobi/androidsdk/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */