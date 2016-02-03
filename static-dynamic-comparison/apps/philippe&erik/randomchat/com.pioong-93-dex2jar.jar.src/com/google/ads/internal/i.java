package com.google.ads.internal;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.google.ads.AdActivity;
import com.google.ads.AdRequest.ErrorCode;
import com.google.ads.al;
import com.google.ads.am;
import com.google.ads.n;
import com.google.ads.o;
import com.google.ads.util.AdUtil;
import com.google.ads.util.b;
import com.google.ads.util.f;
import com.google.ads.util.g.b;
import com.google.ads.util.i.b;
import com.google.ads.util.i.c;
import java.util.HashMap;
import java.util.Map;

public class i
  extends WebViewClient
{
  private static final a c = (a)a.a.b();
  protected d a;
  protected boolean b;
  private final Map<String, o> d;
  private final boolean e;
  private boolean f;
  private boolean g;
  private boolean h;
  private boolean i;
  
  public i(d paramd, Map<String, o> paramMap, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.a = paramd;
    this.d = paramMap;
    this.e = paramBoolean1;
    this.g = paramBoolean2;
    this.b = false;
    this.h = false;
    this.i = false;
  }
  
  public static i a(d paramd, Map<String, o> paramMap, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (AdUtil.a >= 11) {
      return new g.b(paramd, paramMap, paramBoolean1, paramBoolean2);
    }
    return new i(paramd, paramMap, paramBoolean1, paramBoolean2);
  }
  
  public void a(boolean paramBoolean)
  {
    this.b = paramBoolean;
  }
  
  public boolean a()
  {
    return this.f;
  }
  
  public void b(boolean paramBoolean)
  {
    this.g = paramBoolean;
  }
  
  public void c(boolean paramBoolean)
  {
    this.h = paramBoolean;
  }
  
  public void d(boolean paramBoolean)
  {
    this.i = paramBoolean;
  }
  
  public void onPageFinished(WebView paramWebView, String paramString)
  {
    this.f = false;
    if (this.h)
    {
      paramString = this.a.k();
      if (paramString == null) {
        break label53;
      }
      paramString.c();
    }
    for (;;)
    {
      this.h = false;
      if (this.i)
      {
        c.a(paramWebView);
        this.i = false;
      }
      return;
      label53:
      b.a("adLoader was null while trying to setFinishedLoadingHtml().");
    }
  }
  
  public void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    this.f = true;
  }
  
  public void onReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2)
  {
    this.f = false;
    paramWebView = this.a.k();
    if (paramWebView != null) {
      paramWebView.a(AdRequest.ErrorCode.NETWORK_ERROR);
    }
  }
  
  public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
  {
    for (;;)
    {
      try
      {
        b.a("shouldOverrideUrlLoading(\"" + paramString + "\")");
        localUri = Uri.parse(paramString);
        if (c.a(localUri))
        {
          c.a(this.a, this.d, localUri, paramWebView);
          return true;
        }
        if (this.g)
        {
          if (AdUtil.a(localUri)) {
            return super.shouldOverrideUrlLoading(paramWebView, paramString);
          }
          paramWebView = new HashMap();
          paramWebView.put("u", paramString);
          AdActivity.launchAdActivity(this.a, new e("intent", paramWebView));
          return true;
        }
        boolean bool = this.e;
        if (!bool) {
          continue;
        }
      }
      catch (Throwable paramWebView)
      {
        Uri localUri;
        Object localObject;
        b.d("An unknown error occurred in shouldOverrideUrlLoading.", paramWebView);
        continue;
        paramWebView = localUri;
        continue;
      }
      try
      {
        localObject = this.a.i();
        paramWebView = (Context)((n)localObject).f.a();
        localObject = (al)((n)localObject).s.a();
        if ((localObject == null) || (!((al)localObject).a(localUri))) {
          continue;
        }
        paramWebView = ((al)localObject).a(localUri, paramWebView);
        paramString = new HashMap();
        paramString.put("u", paramWebView.toString());
        AdActivity.launchAdActivity(this.a, new e("intent", paramString));
        return true;
      }
      catch (am paramWebView)
      {
        b.e("Unable to append parameter to URL: " + paramString);
      }
    }
    b.e("URL is not a GMSG and can't handle URL: " + paramString);
    return true;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/google/ads/internal/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */