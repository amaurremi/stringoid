package com.flurry.android.monolithic.sdk.impl;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;

@SuppressLint({"SetJavaScriptEnabled"})
public final class ar
  extends RelativeLayout
  implements View.OnClickListener
{
  private final String a = getClass().getSimpleName();
  private WebView b;
  private WebViewClient c;
  private WebChromeClient d;
  private boolean e;
  private ImageView f;
  private ImageView g;
  private ImageView h;
  private final int i = 0;
  private final int j = 1;
  private final int k = 2;
  private az l;
  private av m;
  private aw n;
  private boolean o;
  
  @TargetApi(11)
  public ar(Context paramContext, String paramString)
  {
    super(paramContext);
    this.b = new WebView(paramContext);
    this.c = new au(this, null);
    this.d = new at(this, null);
    this.b.getSettings().setJavaScriptEnabled(true);
    this.b.getSettings().setUseWideViewPort(true);
    this.b.getSettings().setLoadWithOverviewMode(true);
    this.b.getSettings().setBuiltInZoomControls(true);
    if (Build.VERSION.SDK_INT >= 11) {
      this.b.getSettings().setDisplayZoomControls(false);
    }
    this.b.setWebViewClient(this.c);
    this.b.setWebChromeClient(this.d);
    this.b.loadUrl(paramString);
    this.f = new ImageView(paramContext);
    this.f.setId(0);
    this.f.setImageDrawable(getResources().getDrawable(17301560));
    this.f.setOnClickListener(this);
    this.g = new ImageView(paramContext);
    this.g.setId(1);
    this.g.setImageDrawable(getResources().getDrawable(17301580));
    this.g.setOnClickListener(this);
    this.h = new ImageView(paramContext);
    this.h.setId(2);
    this.h.setImageDrawable(getResources().getDrawable(17301565));
    this.h.setOnClickListener(this);
    setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    addView(this.b);
    paramContext = new RelativeLayout.LayoutParams(-2, -2);
    paramContext.addRule(14);
    addView(this.f, paramContext);
    paramContext = new RelativeLayout.LayoutParams(-2, -2);
    paramContext.addRule(9);
    addView(this.g, paramContext);
    paramContext = new RelativeLayout.LayoutParams(-2, -2);
    paramContext.addRule(11);
    addView(this.h, paramContext);
  }
  
  public boolean a()
  {
    return (this.e) || ((this.b != null) && (this.b.canGoBack()));
  }
  
  public void b()
  {
    if (this.e) {
      this.d.onHideCustomView();
    }
    while (this.b == null) {
      return;
    }
    this.b.goBack();
  }
  
  @TargetApi(11)
  public void c()
  {
    if (this.b != null)
    {
      removeView(this.b);
      this.b.stopLoading();
      if (Build.VERSION.SDK_INT >= 11) {
        this.b.onPause();
      }
      this.b.destroy();
      this.b = null;
    }
  }
  
  public av getBasicWebViewClosingHandler()
  {
    return this.m;
  }
  
  public aw getBasicWebViewFullScreenTransitionHandler()
  {
    return this.n;
  }
  
  public az getBasicWebViewUrlLoadingHandler()
  {
    return this.l;
  }
  
  public String getUrl()
  {
    String str = null;
    if (this.b != null) {
      str = this.b.getUrl();
    }
    return str;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    do
    {
      do
      {
        do
        {
          return;
        } while (this.m == null);
        this.m.a(this, ay.c);
        return;
      } while ((this.b == null) || (!this.b.canGoForward()));
      this.b.goForward();
      return;
      if ((this.b != null) && (this.b.canGoBack()))
      {
        this.b.goBack();
        return;
      }
    } while (this.m == null);
    this.m.a(this, ay.b);
  }
  
  public void setBasicWebViewClosingHandler(av paramav)
  {
    this.m = paramav;
  }
  
  public void setBasicWebViewFullScreenTransitionHandler(aw paramaw)
  {
    this.n = paramaw;
  }
  
  public void setBasicWebViewUrlLoadingHandler(az paramaz)
  {
    this.l = paramaz;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/ar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */