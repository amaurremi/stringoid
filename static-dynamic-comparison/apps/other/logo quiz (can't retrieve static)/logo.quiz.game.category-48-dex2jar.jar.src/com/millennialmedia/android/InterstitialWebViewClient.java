package com.millennialmedia.android;

class InterstitialWebViewClient
  extends MMWebViewClient
{
  InterstitialWebViewClient(MMWebViewClient.MMWebViewClientListener paramMMWebViewClientListener, HttpRedirection.RedirectionListenerImpl paramRedirectionListenerImpl)
  {
    super(paramMMWebViewClientListener, paramRedirectionListenerImpl);
  }
  
  void setMraidState(MMWebView paramMMWebView)
  {
    paramMMWebView.setMraidPlacementTypeInterstitial();
    paramMMWebView.setMraidDefault();
    paramMMWebView.setMraidReady();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/millennialmedia/android/InterstitialWebViewClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */