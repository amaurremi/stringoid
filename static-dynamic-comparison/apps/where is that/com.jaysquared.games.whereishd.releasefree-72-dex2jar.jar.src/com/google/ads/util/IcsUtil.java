package com.google.ads.util;

import android.annotation.TargetApi;
import android.view.View;
import android.webkit.WebChromeClient.CustomViewCallback;
import com.google.ads.AdSize;
import com.google.ads.internal.ActivationOverlay;
import com.google.ads.internal.AdWebView;
import com.google.ads.n;

@TargetApi(14)
public class IcsUtil
{
  public static class IcsAdWebView
    extends AdWebView
  {
    public IcsAdWebView(n paramn, AdSize paramAdSize)
    {
      super(paramAdSize);
    }
    
    public boolean canScrollHorizontally(int paramInt)
    {
      if (this.a.e.a() != null) {
        return !((ActivationOverlay)this.a.e.a()).b();
      }
      return super.canScrollHorizontally(paramInt);
    }
    
    public boolean canScrollVertically(int paramInt)
    {
      if (this.a.e.a() != null) {
        return !((ActivationOverlay)this.a.e.a()).b();
      }
      return super.canScrollVertically(paramInt);
    }
  }
  
  public static class a
    extends g.a
  {
    public a(n paramn)
    {
      super();
    }
    
    public void onShowCustomView(View paramView, int paramInt, WebChromeClient.CustomViewCallback paramCustomViewCallback)
    {
      paramCustomViewCallback.onCustomViewHidden();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/google/ads/util/IcsUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */