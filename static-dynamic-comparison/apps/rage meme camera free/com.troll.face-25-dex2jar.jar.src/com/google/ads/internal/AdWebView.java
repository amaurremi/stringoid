package com.google.ads.internal;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnTouchListener;
import android.webkit.DownloadListener;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.google.ads.AdActivity;
import com.google.ads.AdSize;
import com.google.ads.ak;
import com.google.ads.n;
import com.google.ads.util.AdUtil;
import com.google.ads.util.IcsUtil.a;
import com.google.ads.util.b;
import com.google.ads.util.g;
import com.google.ads.util.g.a;
import com.google.ads.util.h;
import com.google.ads.util.i.b;
import com.google.ads.util.i.c;
import java.lang.ref.WeakReference;

public class AdWebView
  extends WebView
{
  protected final n a;
  private WeakReference<AdActivity> b;
  private AdSize c;
  private boolean d;
  private boolean e;
  private boolean f;
  
  public AdWebView(n paramn, AdSize paramAdSize)
  {
    super((Context)paramn.f.a());
    this.a = paramn;
    this.c = paramAdSize;
    this.b = null;
    this.d = false;
    this.e = false;
    this.f = false;
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
          paramAnonymousString3 = AdWebView.this.i();
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
    if (AdUtil.a >= 17) {
      h.a(paramAdSize, paramn);
    }
    do
    {
      for (;;)
      {
        setScrollBarStyle(33554432);
        if (AdUtil.a < 14) {
          break;
        }
        setWebChromeClient(new IcsUtil.a(paramn));
        return;
        if (AdUtil.a >= 11) {
          g.a(paramAdSize, paramn);
        }
      }
    } while (AdUtil.a < 11);
    setWebChromeClient(new g.a(paramn));
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      setOnTouchListener(new View.OnTouchListener()
      {
        public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          return paramAnonymousMotionEvent.getAction() == 2;
        }
      });
      return;
    }
    setOnTouchListener(null);
  }
  
  public void destroy()
  {
    try
    {
      super.destroy();
    }
    catch (Throwable localThrowable1)
    {
      for (;;)
      {
        try
        {
          setWebViewClient(new WebViewClient());
          return;
        }
        catch (Throwable localThrowable2) {}
        localThrowable1 = localThrowable1;
        b.d("An error occurred while destroying an AdWebView:", localThrowable1);
      }
    }
  }
  
  public void f()
  {
    AdActivity localAdActivity = i();
    if (localAdActivity != null) {
      localAdActivity.finish();
    }
  }
  
  public void g()
  {
    if (AdUtil.a >= 11) {
      g.a(this);
    }
    this.e = true;
  }
  
  public void h()
  {
    if ((this.e) && (AdUtil.a >= 11)) {
      g.b(this);
    }
    this.e = false;
  }
  
  public AdActivity i()
  {
    if (this.b != null) {
      return (AdActivity)this.b.get();
    }
    return null;
  }
  
  public boolean j()
  {
    return this.f;
  }
  
  public boolean k()
  {
    return this.e;
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
      b.d("An error occurred while loading data in AdWebView:", paramString1);
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
      b.d("An error occurred while loading a URL in AdWebView:", paramString);
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
        if ((this.c != null) && (!this.d)) {
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
    float f1 = getContext().getResources().getDisplayMetrics().density;
    int n = (int)(this.c.getWidth() * f1);
    int i1 = (int)(this.c.getHeight() * f1);
    if (i2 != Integer.MIN_VALUE) {
      if (i2 == 1073741824) {
        break label225;
      }
    }
    for (;;)
    {
      label133:
      b.b("Not enough space to show ad! Wants: <" + n + ", " + i1 + ">, Has: <" + i + ", " + k + ">");
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
        if (n - f1 * 6.0F > paramInt1) {
          break label133;
        }
      } while (i1 <= paramInt2);
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    ak localak = (ak)this.a.r.a();
    if (localak != null) {
      localak.a(paramMotionEvent);
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void setAdActivity(AdActivity paramAdActivity)
  {
    this.b = new WeakReference(paramAdActivity);
  }
  
  public void setAdSize(AdSize paramAdSize)
  {
    try
    {
      this.c = paramAdSize;
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
    this.f = paramBoolean;
    if (this.b != null)
    {
      AdActivity localAdActivity = (AdActivity)this.b.get();
      if (localAdActivity != null) {
        localAdActivity.setCustomClose(paramBoolean);
      }
    }
  }
  
  public void setIsExpandedMraid(boolean paramBoolean)
  {
    this.d = paramBoolean;
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


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/rage meme camera free/com.troll.face-25-dex2jar.jar!/com/google/ads/internal/AdWebView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */