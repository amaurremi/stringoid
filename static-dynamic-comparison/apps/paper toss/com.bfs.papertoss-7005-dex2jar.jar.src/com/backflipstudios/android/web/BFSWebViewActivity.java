package com.backflipstudios.android.web;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.ViewGroup.LayoutParams;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class BFSWebViewActivity
  extends Activity
{
  public static final String EXTRA_PAGE_URL = "__bfs_extra_web_view_page_url";
  private WebView m_webView = null;
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.m_webView = new WebView(this);
    this.m_webView.getSettings().setJavaScriptEnabled(true);
    this.m_webView.setWebViewClient(new Client());
    paramBundle = getIntent().getStringExtra("__bfs_extra_web_view_page_url");
    if (paramBundle != null) {
      this.m_webView.loadUrl(paramBundle);
    }
    setContentView(this.m_webView, new ViewGroup.LayoutParams(-1, -1));
  }
  
  private class Client
    extends WebViewClient
  {
    public Client() {}
    
    public void onPageFinished(WebView paramWebView, String paramString) {}
    
    public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
    {
      return false;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/paper toss/com.bfs.papertoss-7005-dex2jar.jar!/com/backflipstudios/android/web/BFSWebViewActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */