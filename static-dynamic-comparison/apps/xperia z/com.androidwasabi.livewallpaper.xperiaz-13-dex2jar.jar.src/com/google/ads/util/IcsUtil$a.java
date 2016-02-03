package com.google.ads.util;

import android.view.View;
import android.webkit.WebChromeClient.CustomViewCallback;
import com.google.ads.n;

public class IcsUtil$a
  extends g.a
{
  public IcsUtil$a(n paramn)
  {
    super(paramn);
  }
  
  public void onShowCustomView(View paramView, int paramInt, WebChromeClient.CustomViewCallback paramCustomViewCallback)
  {
    paramCustomViewCallback.onCustomViewHidden();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/google/ads/util/IcsUtil$a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */