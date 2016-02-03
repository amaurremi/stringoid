package com.mocoplex.adlib;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout.LayoutParams;
import java.lang.reflect.Method;

public class SubAdlibAdViewCrossBanner
  extends SubAdlibAdViewCore
{
  boolean c = false;
  private WebView d;
  
  public SubAdlibAdViewCrossBanner(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public SubAdlibAdViewCrossBanner(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.d = new WebView(paramContext);
    paramContext = new LinearLayout.LayoutParams(-1, (int)(50.0F * getResources().getDisplayMetrics().density + 0.5F));
    this.d.setLayoutParams(paramContext);
    setVerticalScrollBarEnabled(false);
    setHorizontalScrollBarEnabled(false);
    this.d.setScrollBarStyle(33554432);
    this.d.setVerticalScrollBarEnabled(false);
    this.d.setHorizontalScrollBarEnabled(false);
    this.d.setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        return paramAnonymousMotionEvent.getAction() == 2;
      }
    });
    this.d.getSettings().setLoadWithOverviewMode(true);
    this.d.getSettings().setUseWideViewPort(true);
    this.d.getSettings().setJavaScriptEnabled(true);
    this.d.addJavascriptInterface(new AdlibAndroidBridge(getContext()), "gotoAds");
    this.d.setWebViewClient(new WebViewClient()
    {
      public final void onPageFinished(WebView paramAnonymousWebView, String paramAnonymousString)
      {
        super.onPageFinished(paramAnonymousWebView, paramAnonymousString);
        if (SubAdlibAdViewCrossBanner.this.c)
        {
          SubAdlibAdViewCrossBanner.this.gotAd();
          SubAdlibAdViewCrossBanner.this.c = false;
        }
      }
    });
    addView(this.d);
    if (e.a().d() == 0) {
      e.a().c();
    }
  }
  
  private static void a(WebView paramWebView, String paramString)
  {
    try
    {
      WebView.class.getMethod(paramString, new Class[0]).invoke(paramWebView, new Object[0]);
      return;
    }
    catch (Exception paramWebView) {}
  }
  
  public final void a(String paramString)
  {
    if (this.d != null) {
      this.d.loadUrl("file://" + AdlibConfig.getInstance().h(paramString));
    }
  }
  
  public void clearAdView()
  {
    super.clearAdView();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.d != null)
    {
      removeView(this.d);
      this.d.destroy();
      this.d = null;
    }
  }
  
  public void onPause()
  {
    if (this.d != null)
    {
      a(this.d, "onPause");
      this.d.getSettings().setJavaScriptEnabled(false);
    }
  }
  
  public void onResume()
  {
    if (this.d != null)
    {
      a(this.d, "onResume");
      this.d.getSettings().setJavaScriptEnabled(true);
      this.d.reload();
    }
  }
  
  public void query()
  {
    String str = e.a().e();
    if (str == null)
    {
      failed();
      return;
    }
    this.c = true;
    a(str);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/mocoplex/adlib/SubAdlibAdViewCrossBanner.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */