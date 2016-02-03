package com.google.ads.internal;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.util.DisplayMetrics;
import android.view.View.MeasureSpec;
import android.webkit.DownloadListener;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.google.ads.AdActivity;
import com.google.ads.AdSize;
import com.google.ads.m;
import com.google.ads.util.AdUtil;
import com.google.ads.util.b;
import com.google.ads.util.g;
import com.google.ads.util.g.a;
import com.google.ads.util.h.a;
import com.google.ads.util.i.b;
import java.lang.ref.WeakReference;

public class AdWebView
  extends WebView
{
  private WeakReference<AdActivity> a;
  private AdSize b;
  private boolean c;
  private boolean d;
  private boolean e;
  
  public AdWebView(m paramm, AdSize paramAdSize)
  {
    super((Context)paramm.f.a());
    this.b = paramAdSize;
    this.a = null;
    this.c = false;
    this.d = false;
    this.e = false;
    setBackgroundColor(0);
    AdUtil.a(this);
    paramAdSize = getSettings();
    paramAdSize.setSupportMultipleWindows(false);
    paramAdSize.setJavaScriptEnabled(true);
    paramAdSize.setSavePassword(false);
    setDownloadListener(new DownloadListener()
    {
      public void onDownloadStart(String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3, String paramAnonymousString4, long paramAnonymousLong)
      {
        try
        {
          paramAnonymousString2 = new Intent("android.intent.action.VIEW");
          paramAnonymousString2.setDataAndType(Uri.parse(paramAnonymousString1), paramAnonymousString4);
          paramAnonymousString3 = AdWebView.this.d();
          if ((paramAnonymousString3 != null) && (AdUtil.a(paramAnonymousString2, paramAnonymousString3))) {
            paramAnonymousString3.startActivity(paramAnonymousString2);
          }
          return;
        }
        catch (ActivityNotFoundException paramAnonymousString2)
        {
          b.a("Couldn't find an Activity to view url/mimetype: " + paramAnonymousString1 + " / " + paramAnonymousString4);
          return;
        }
        catch (Throwable paramAnonymousString2)
        {
          b.b("Unknown error trying to start activity to view URL: " + paramAnonymousString1, paramAnonymousString2);
        }
      }
    });
    if (AdUtil.a >= 11) {
      g.a(paramAdSize, paramm);
    }
    setScrollBarStyle(33554432);
    if (AdUtil.a >= 14) {
      setWebChromeClient(new h.a(paramm));
    }
    while (AdUtil.a < 11) {
      return;
    }
    setWebChromeClient(new g.a(paramm));
  }
  
  public void a()
  {
    AdActivity localAdActivity = d();
    if (localAdActivity != null) {
      localAdActivity.finish();
    }
  }
  
  public void b()
  {
    if (AdUtil.a >= 11) {
      g.a(this);
    }
    this.d = true;
  }
  
  public void c()
  {
    if ((this.d) && (AdUtil.a >= 11)) {
      g.b(this);
    }
    this.d = false;
  }
  
  public AdActivity d()
  {
    if (this.a != null) {
      return (AdActivity)this.a.get();
    }
    return null;
  }
  
  public void destroy()
  {
    try
    {
      super.destroy();
      setWebViewClient(new WebViewClient());
      return;
    }
    catch (Throwable localThrowable)
    {
      b.b("An error occurred while destroying an AdWebView:", localThrowable);
    }
  }
  
  public boolean e()
  {
    return this.e;
  }
  
  public boolean f()
  {
    return this.d;
  }
  
  public void loadDataWithBaseURL(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    try
    {
      super.loadDataWithBaseURL(paramString1, paramString2, paramString3, paramString4, paramString5);
      return;
    }
    catch (Throwable paramString1)
    {
      b.b("An error occurred while loading data in AdWebView:", paramString1);
    }
  }
  
  public void loadUrl(String paramString)
  {
    try
    {
      super.loadUrl(paramString);
      return;
    }
    catch (Throwable paramString)
    {
      b.b("An error occurred while loading a URL in AdWebView:", paramString);
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int j = Integer.MAX_VALUE;
    try
    {
      if (isInEditMode()) {
        super.onMeasure(paramInt1, paramInt2);
      }
      for (;;)
      {
        return;
        if ((this.b != null) && (!this.c)) {
          break;
        }
        super.onMeasure(paramInt1, paramInt2);
      }
      i2 = View.MeasureSpec.getMode(paramInt1);
    }
    finally {}
    int i2;
    int i = View.MeasureSpec.getSize(paramInt1);
    int m = View.MeasureSpec.getMode(paramInt2);
    int k = View.MeasureSpec.getSize(paramInt2);
    float f = getContext().getResources().getDisplayMetrics().density;
    int n = (int)(this.b.getWidth() * f);
    int i1 = (int)(this.b.getHeight() * f);
    if (i2 != Integer.MIN_VALUE) {
      if (i2 == 1073741824) {
        break label225;
      }
    }
    for (;;)
    {
      label133:
      b.e("Not enough space to show ad! Wants: <" + n + ", " + i1 + ">, Has: <" + i + ", " + k + ">");
      setVisibility(8);
      setMeasuredDimension(i, k);
      break;
      label225:
      label228:
      do
      {
        setMeasuredDimension(n, i1);
        break;
        paramInt1 = Integer.MAX_VALUE;
        break label228;
        paramInt1 = i;
        if (m != Integer.MIN_VALUE)
        {
          paramInt2 = j;
          if (m != 1073741824) {}
        }
        else
        {
          paramInt2 = k;
        }
        if (n - f * 6.0F > paramInt1) {
          break label133;
        }
      } while (i1 <= paramInt2);
    }
  }
  
  public void setAdActivity(AdActivity paramAdActivity)
  {
    this.a = new WeakReference(paramAdActivity);
  }
  
  public void setAdSize(AdSize paramAdSize)
  {
    try
    {
      this.b = paramAdSize;
      requestLayout();
      return;
    }
    finally
    {
      paramAdSize = finally;
      throw paramAdSize;
    }
  }
  
  public void setCustomClose(boolean paramBoolean)
  {
    this.e = paramBoolean;
    if (this.a != null)
    {
      AdActivity localAdActivity = (AdActivity)this.a.get();
      if (localAdActivity != null) {
        localAdActivity.setCustomClose(paramBoolean);
      }
    }
  }
  
  public void setIsExpandedMraid(boolean paramBoolean)
  {
    this.c = paramBoolean;
  }
  
  public void stopLoading()
  {
    try
    {
      super.stopLoading();
      return;
    }
    catch (Throwable localThrowable)
    {
      b.d("An error occurred while stopping loading in AdWebView:", localThrowable);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/paper toss/com.bfs.papertoss-7005-dex2jar.jar!/com/google/ads/internal/AdWebView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */