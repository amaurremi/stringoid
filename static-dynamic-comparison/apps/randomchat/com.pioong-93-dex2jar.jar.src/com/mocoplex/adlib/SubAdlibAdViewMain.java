package com.mocoplex.adlib;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
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

public class SubAdlibAdViewMain
  extends SubAdlibAdViewCore
{
  int c = 300;
  public boolean d = false;
  private boolean e = false;
  private WebView f;
  
  public SubAdlibAdViewMain(Context paramContext)
  {
    this(paramContext, false);
  }
  
  public SubAdlibAdViewMain(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, false);
  }
  
  public SubAdlibAdViewMain(Context paramContext, boolean paramBoolean)
  {
    super(paramContext, null);
    this.d = paramBoolean;
    this.f = new WebView(paramContext);
    paramContext = new LinearLayout.LayoutParams(-1, (int)(50.0F * getResources().getDisplayMetrics().density + 0.5F));
    this.f.setLayoutParams(paramContext);
    setVerticalScrollBarEnabled(false);
    setHorizontalScrollBarEnabled(false);
    this.f.setScrollBarStyle(33554432);
    this.f.setVerticalScrollBarEnabled(false);
    this.f.setHorizontalScrollBarEnabled(false);
    this.f.setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        return paramAnonymousMotionEvent.getAction() == 2;
      }
    });
    this.f.getSettings().setLoadWithOverviewMode(true);
    this.f.getSettings().setUseWideViewPort(true);
    this.f.getSettings().setJavaScriptEnabled(true);
    this.f.addJavascriptInterface(new AdlibAndroidBridge(getContext()), "gotoAds");
    this.f.setWebViewClient(new WebViewClient()
    {
      public final void onPageFinished(WebView paramAnonymousWebView, String paramAnonymousString)
      {
        super.onPageFinished(paramAnonymousWebView, paramAnonymousString);
        if (SubAdlibAdViewMain.this.getVisibility() == 4) {
          SubAdlibAdViewMain.this.setVisibility(0);
        }
      }
    });
    setVisibility(4);
    addView(this.f);
    if (this.d)
    {
      if (AdlibConfig.getInstance().b()) {}
    }
    else {
      while (!AdlibConfig.getInstance().c()) {
        return;
      }
    }
    a();
  }
  
  private void a()
  {
    if (this.e) {}
    while (this.f == null) {
      return;
    }
    this.e = true;
    if (this.d)
    {
      this.f.loadUrl("file://" + AdlibConfig.getInstance().e());
      return;
    }
    this.f.loadUrl("file://" + AdlibConfig.getInstance().d());
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
  
  public void clearAdView()
  {
    super.clearAdView();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.f != null)
    {
      removeView(this.f);
      this.f.destroy();
      this.f = null;
    }
  }
  
  public void onPause()
  {
    if (this.f != null)
    {
      a(this.f, "onPause");
      this.f.getSettings().setJavaScriptEnabled(false);
    }
  }
  
  public void onResume()
  {
    if (this.f != null)
    {
      a(this.f, "onResume");
      this.f.getSettings().setJavaScriptEnabled(true);
      this.f.reload();
    }
  }
  
  public void query()
  {
    if (this.d)
    {
      if (!AdlibConfig.getInstance().b()) {
        failed();
      }
    }
    else if (!AdlibConfig.getInstance().c())
    {
      failed();
      return;
    }
    a();
    new Handler().postDelayed(new Runnable()
    {
      public final void run()
      {
        SubAdlibAdViewMain.this.c = 0;
        SubAdlibAdViewMain.this.gotAd();
      }
    }, this.c);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/mocoplex/adlib/SubAdlibAdViewMain.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */