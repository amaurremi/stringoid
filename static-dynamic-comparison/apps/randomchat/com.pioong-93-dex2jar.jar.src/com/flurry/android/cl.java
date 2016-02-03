package com.flurry.android;

import android.content.Context;
import android.content.res.Resources;
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

final class cl
  extends RelativeLayout
  implements View.OnClickListener
{
  private final String TAG = getClass().getSimpleName();
  private WebView du;
  private WebViewClient dw;
  private WebChromeClient dx;
  private boolean eG;
  private ImageView eH;
  private ImageView eI;
  private ImageView eJ;
  private f eK;
  private y eL;
  private bh eM;
  private boolean eN;
  
  public cl(Context paramContext, String paramString)
  {
    super(paramContext);
    this.du = new WebView(paramContext);
    this.dw = new c(this);
    this.dx = new am(this);
    this.du.getSettings().setJavaScriptEnabled(true);
    this.du.getSettings().setUseWideViewPort(true);
    if (l.SDK_INT >= 7) {
      this.du.getSettings().setLoadWithOverviewMode(true);
    }
    this.du.getSettings().setBuiltInZoomControls(true);
    if (l.SDK_INT >= 11) {
      this.du.getSettings().setDisplayZoomControls(false);
    }
    this.du.setWebViewClient(this.dw);
    this.du.setWebChromeClient(this.dx);
    this.du.loadUrl(paramString);
    this.eH = new ImageView(paramContext);
    this.eH.setId(0);
    this.eH.setImageDrawable(getResources().getDrawable(17301560));
    this.eH.setOnClickListener(this);
    this.eI = new ImageView(paramContext);
    this.eI.setId(1);
    this.eI.setImageDrawable(getResources().getDrawable(17301580));
    this.eI.setOnClickListener(this);
    this.eJ = new ImageView(paramContext);
    this.eJ.setId(2);
    this.eJ.setImageDrawable(getResources().getDrawable(17301565));
    this.eJ.setOnClickListener(this);
    setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    addView(this.du);
    paramContext = new RelativeLayout.LayoutParams(-2, -2);
    paramContext.addRule(14);
    addView(this.eH, paramContext);
    paramContext = new RelativeLayout.LayoutParams(-2, -2);
    paramContext.addRule(9);
    addView(this.eI, paramContext);
    paramContext = new RelativeLayout.LayoutParams(-2, -2);
    paramContext.addRule(11);
    addView(this.eJ, paramContext);
  }
  
  public final void a(bh parambh)
  {
    this.eM = parambh;
  }
  
  public final void a(f paramf)
  {
    this.eK = paramf;
  }
  
  public final void a(y paramy)
  {
    this.eL = paramy;
  }
  
  public final boolean canGoBack()
  {
    return (this.eG) || ((this.du != null) && (this.du.canGoBack()));
  }
  
  public final void destroy()
  {
    if (this.du != null)
    {
      removeView(this.du);
      this.du.stopLoading();
      if (l.SDK_INT >= 11) {
        this.du.onPause();
      }
      this.du.destroy();
      this.du = null;
    }
  }
  
  public final void goBack()
  {
    if (this.eG) {
      this.dx.onHideCustomView();
    }
    while (this.du == null) {
      return;
    }
    this.du.goBack();
  }
  
  public final void onClick(View paramView)
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
        } while (this.eL == null);
        this.eL.h.finish();
        return;
      } while ((this.du == null) || (!this.du.canGoForward()));
      this.du.goForward();
      return;
      if ((this.du != null) && (this.du.canGoBack()))
      {
        this.du.goBack();
        return;
      }
    } while (this.eL == null);
    this.eL.h.finish();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/flurry/android/cl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */