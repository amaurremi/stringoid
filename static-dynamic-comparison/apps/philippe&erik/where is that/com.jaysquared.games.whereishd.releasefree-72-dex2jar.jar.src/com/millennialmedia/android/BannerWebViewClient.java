package com.millennialmedia.android;

class BannerWebViewClient
  extends MMWebViewClient
{
  BannerWebViewClient(MMWebViewClient.MMWebViewClientListener paramMMWebViewClientListener, HttpRedirection.RedirectionListenerImpl paramRedirectionListenerImpl)
  {
    super(paramMMWebViewClientListener, paramRedirectionListenerImpl);
  }
  
  void setMraidState(MMWebView paramMMWebView)
  {
    paramMMWebView.setMraidPlacementTypeInline();
    paramMMWebView.setMraidDefault();
    paramMMWebView.setMraidReady();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/millennialmedia/android/BannerWebViewClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */