package com.jirbo.adcolony;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Window;
import android.webkit.GeolocationPermissions.Callback;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import java.util.ArrayList;

public class AdColonyBrowser
  extends Activity
{
  static boolean A = false;
  static boolean B = false;
  static boolean C = false;
  static boolean a = true;
  public static String url;
  static boolean v = false;
  static boolean w = false;
  static boolean x = false;
  static boolean y = false;
  static boolean z = true;
  WebView b;
  ADCImage c;
  ADCImage d;
  ADCImage e;
  ADCImage f;
  ADCImage g;
  ADCImage h;
  ADCImage i;
  ADCImage j;
  ADCImage k;
  RelativeLayout l;
  RelativeLayout m;
  boolean n = false;
  boolean o = false;
  boolean p = false;
  boolean q = false;
  ProgressBar r;
  DisplayMetrics s;
  AdColonyBrowser.a t;
  AdColonyBrowser.c u;
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    paramConfiguration = new RelativeLayout.LayoutParams(-2, this.s.heightPixels - (int)(1.5D * this.g.g));
    paramConfiguration.addRule(3, this.l.getId());
    this.b.setLayoutParams(paramConfiguration);
    z = true;
    this.t.invalidate();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    B = true;
    this.c = new ADCImage(a.j("browser_back_image_normal"));
    this.d = new ADCImage(a.j("browser_stop_image_normal"));
    this.e = new ADCImage(a.j("browser_reload_image_normal"));
    this.f = new ADCImage(a.j("browser_forward_image_normal"));
    this.g = new ADCImage(a.j("browser_close_image_normal"));
    this.h = new ADCImage(a.j("browser_glow_button"));
    this.i = new ADCImage(a.j("browser_icon"));
    this.j = new ADCImage(a.j("browser_back_image_normal"), true);
    this.k = new ADCImage(a.j("browser_forward_image_normal"), true);
    this.s = AdColony.activity().getResources().getDisplayMetrics();
    float f1 = this.s.widthPixels / this.s.xdpi;
    float f2 = this.s.heightPixels / this.s.ydpi;
    double d1 = Math.sqrt(f1 * f1 + f2 * f2);
    double d2 = Math.sqrt(this.s.widthPixels * this.s.widthPixels + this.s.heightPixels * this.s.heightPixels) / d1 / 220.0D;
    d1 = d2;
    if (d2 > 1.8D) {
      d1 = 1.8D;
    }
    z = true;
    v = false;
    w = false;
    C = false;
    this.c.a(d1);
    this.d.a(d1);
    this.e.a(d1);
    this.f.a(d1);
    this.g.a(d1);
    this.h.a(d1);
    this.j.a(d1);
    this.k.a(d1);
    this.r = new ProgressBar(this);
    this.r.setVisibility(4);
    this.m = new RelativeLayout(this);
    this.l = new RelativeLayout(this);
    this.l.setBackgroundColor(-3355444);
    if (!a.m)
    {
      this.l.setLayoutParams(new RelativeLayout.LayoutParams(-1, (int)(this.c.g * 1.5D)));
      requestWindowFeature(1);
      getWindow().setFlags(1024, 1024);
      getWindow().requestFeature(2);
      setVolumeControlStream(3);
      this.b = new WebView(this);
      this.b.getSettings().setJavaScriptEnabled(true);
      this.b.getSettings().setBuiltInZoomControls(true);
      this.b.getSettings().setUseWideViewPort(true);
      this.b.getSettings().setLoadWithOverviewMode(true);
      this.b.getSettings().setGeolocationEnabled(true);
      if (a)
      {
        if (a.m) {
          break label949;
        }
        if (Build.VERSION.SDK_INT < 10) {
          break label941;
        }
        setRequestedOrientation(6);
      }
      label572:
      a = true;
      this.b.setWebChromeClient(new WebChromeClient()
      {
        public void onGeolocationPermissionsShowPrompt(String paramAnonymousString, GeolocationPermissions.Callback paramAnonymousCallback)
        {
          paramAnonymousCallback.invoke(paramAnonymousString, true, false);
        }
        
        public void onProgressChanged(WebView paramAnonymousWebView, int paramAnonymousInt)
        {
          AdColonyBrowser.this.setProgress(paramAnonymousInt * 1000);
        }
      });
      this.b.setWebViewClient(new WebViewClient()
      {
        public void onPageFinished(WebView paramAnonymousWebView, String paramAnonymousString)
        {
          if (!AdColonyBrowser.C)
          {
            AdColonyBrowser.y = true;
            AdColonyBrowser.x = false;
            AdColonyBrowser.this.r.setVisibility(4);
            AdColonyBrowser.v = AdColonyBrowser.this.b.canGoBack();
            AdColonyBrowser.w = AdColonyBrowser.this.b.canGoForward();
          }
          AdColonyBrowser.this.t.invalidate();
        }
        
        public void onPageStarted(WebView paramAnonymousWebView, String paramAnonymousString, Bitmap paramAnonymousBitmap)
        {
          if (!AdColonyBrowser.C)
          {
            AdColonyBrowser.x = true;
            AdColonyBrowser.y = false;
            AdColonyBrowser.this.r.setVisibility(0);
          }
          AdColonyBrowser.this.t.invalidate();
        }
        
        public void onReceivedError(WebView paramAnonymousWebView, int paramAnonymousInt, String paramAnonymousString1, String paramAnonymousString2)
        {
          l.d.a("Error viewing URL: ").b(paramAnonymousString1);
          AdColonyBrowser.this.finish();
        }
        
        public boolean shouldOverrideUrlLoading(WebView paramAnonymousWebView, String paramAnonymousString)
        {
          if ((paramAnonymousString.startsWith("market://")) || (paramAnonymousString.startsWith("amzn://")))
          {
            paramAnonymousWebView = new Intent("android.intent.action.VIEW", Uri.parse(paramAnonymousString));
            if (a.I != null) {
              a.I.startActivity(paramAnonymousWebView);
            }
            return true;
          }
          return false;
        }
      });
      this.t = new AdColonyBrowser.a(this, this);
      this.u = new AdColonyBrowser.c(this, this);
      this.m.setBackgroundColor(16777215);
      this.m.addView(this.l);
      this.l.setId(12345);
      paramBundle = new RelativeLayout.LayoutParams(-2, this.s.heightPixels - (int)(this.g.g * 1.5D));
      paramBundle.addRule(3, this.l.getId());
      this.m.addView(this.b, paramBundle);
      paramBundle = new RelativeLayout.LayoutParams(-2, 20);
      paramBundle.addRule(3, this.l.getId());
      paramBundle.setMargins(0, -10, 0, 0);
      this.m.addView(this.u, paramBundle);
      if (this.s.widthPixels <= this.s.heightPixels) {
        break label959;
      }
    }
    label941:
    label949:
    label959:
    for (int i1 = this.s.widthPixels;; i1 = this.s.heightPixels)
    {
      this.m.addView(this.t, new RelativeLayout.LayoutParams(i1 * 2, i1 * 2));
      paramBundle = new RelativeLayout.LayoutParams(-2, this.s.heightPixels - (int)(this.g.g * 1.5D));
      paramBundle.addRule(3, this.l.getId());
      this.m.addView(new AdColonyBrowser.b(this, this), paramBundle);
      setContentView(this.m);
      this.b.loadUrl(url);
      l.c.a("Viewing ").b(url);
      return;
      this.l.setLayoutParams(new RelativeLayout.LayoutParams(-1, (int)(this.c.g * 1.5D)));
      break;
      setRequestedOrientation(0);
      break label572;
      setRequestedOrientation(a.w);
      break label572;
    }
  }
  
  public void onDestroy()
  {
    if ((!a.u) && (A == true))
    {
      int i1 = 0;
      while (i1 < a.Z.size())
      {
        ((Bitmap)a.Z.get(i1)).recycle();
        i1 += 1;
      }
      a.Z.clear();
    }
    A = false;
    B = false;
    super.onDestroy();
  }
  
  public void onPause()
  {
    super.onPause();
    this.t.b();
  }
  
  public void onResume()
  {
    super.onResume();
    z = true;
    this.t.invalidate();
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/jirbo/adcolony/AdColonyBrowser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */