package com.jtpgodorncrqoeurl;

import android.app.Activity;
import android.webkit.WebChromeClient;
import android.webkit.WebView;

final class h
  extends WebChromeClient
{
  h(AdBrowser paramAdBrowser) {}
  
  public final void onProgressChanged(WebView paramWebView, int paramInt)
  {
    Activity localActivity = (Activity)paramWebView.getContext();
    localActivity.setTitle("Loading...");
    localActivity.setProgress(paramInt * 100);
    if (paramInt == 100) {
      localActivity.setTitle(paramWebView.getUrl());
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/rage meme camera free/com.troll.face-25-dex2jar.jar!/com/jtpgodorncrqoeurl/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */