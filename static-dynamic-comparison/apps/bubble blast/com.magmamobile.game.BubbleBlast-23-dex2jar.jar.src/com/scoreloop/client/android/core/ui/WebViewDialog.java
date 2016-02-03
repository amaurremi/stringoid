package com.scoreloop.client.android.core.ui;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;

public class WebViewDialog
  extends Dialog
{
  private WebView a;
  private WebViewClient b;
  
  public WebViewDialog(Context paramContext)
  {
    super(paramContext);
    c();
  }
  
  public WebViewDialog(Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
    c();
  }
  
  private void c()
  {
    this.a = new WebView(getContext());
  }
  
  protected View a(Context paramContext, View paramView)
  {
    paramContext = new FrameLayout(paramContext);
    paramContext.setLayoutParams(new LinearLayout.LayoutParams(-1, -1, 1.0F));
    Display localDisplay = getWindow().getWindowManager().getDefaultDisplay();
    paramContext.setMinimumHeight(localDisplay.getHeight() - 90);
    paramContext.setMinimumWidth(localDisplay.getWidth() - 20);
    paramContext.addView(paramView);
    paramView = this.a.getZoomControls();
    paramContext.addView(paramView, new FrameLayout.LayoutParams(-1, -2, 80));
    paramView.setVisibility(8);
    return paramContext;
  }
  
  public void a()
  {
    this.a.stopLoading();
  }
  
  protected void a(WebSettings paramWebSettings)
  {
    paramWebSettings.setJavaScriptEnabled(true);
    paramWebSettings.setDefaultTextEncodingName("UTF-8");
  }
  
  protected void a(WebView paramWebView, String paramString) {}
  
  public void a(String paramString)
  {
    this.a.loadUrl(paramString);
  }
  
  public void b()
  {
    CookieSyncManager localCookieSyncManager = CookieSyncManager.createInstance(getContext());
    CookieManager.getInstance().removeAllCookie();
    localCookieSyncManager.sync();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onStart();
    paramBundle = getContext();
    LinearLayout localLinearLayout = new LinearLayout(paramBundle);
    localLinearLayout.setOrientation(1);
    localLinearLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    setContentView(localLinearLayout);
    this.a.setLayoutParams(new LinearLayout.LayoutParams(-1, -1, 1.0F));
    this.b = new a(null);
    this.a.setWebViewClient(this.b);
    localLinearLayout.addView(a(paramBundle, this.a));
    a(this.a.getSettings());
  }
  
  private class a
    extends WebViewClient
  {
    private a() {}
    
    public void onLoadResource(WebView paramWebView, String paramString)
    {
      WebViewDialog.this.a(paramWebView, paramString);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/scoreloop/client/android/core/ui/WebViewDialog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */