package com.google.ads.util;

import android.annotation.TargetApi;
import android.view.View;
import android.webkit.WebChromeClient.CustomViewCallback;
import com.google.ads.m;

@TargetApi(14)
public class h
{
  public static class a
    extends g.a
  {
    public a(m paramm)
    {
      super();
    }
    
    public void onShowCustomView(View paramView, int paramInt, WebChromeClient.CustomViewCallback paramCustomViewCallback)
    {
      paramCustomViewCallback.onCustomViewHidden();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/paper toss/com.bfs.papertoss-7005-dex2jar.jar!/com/google/ads/util/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */