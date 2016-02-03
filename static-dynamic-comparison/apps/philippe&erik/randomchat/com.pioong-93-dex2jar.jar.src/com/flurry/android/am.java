package com.flurry.android;

import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebChromeClient.CustomViewCallback;

final class am
  extends WebChromeClient
{
  private am(cl paramcl, byte paramByte) {}
  
  public final void onHideCustomView()
  {
    if (cl.d(this.e) != null) {
      cl.d(this.e).Z();
    }
    cl.b(this.e, false);
  }
  
  public final void onShowCustomView(View paramView, int paramInt, WebChromeClient.CustomViewCallback paramCustomViewCallback)
  {
    cl.b(this.e, true);
    if (cl.d(this.e) != null) {
      cl.d(this.e).a(this.e, paramView, paramInt, new by(paramCustomViewCallback));
    }
  }
  
  public final void onShowCustomView(View paramView, WebChromeClient.CustomViewCallback paramCustomViewCallback)
  {
    cl.b(this.e, true);
    if (cl.d(this.e) != null)
    {
      bh localbh = cl.d(this.e);
      cl localcl = this.e;
      paramCustomViewCallback = new by(paramCustomViewCallback);
      localbh.a(localcl, paramView, localbh.h.getRequestedOrientation(), paramCustomViewCallback);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/flurry/android/am.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */