package com.flurry.android.monolithic.sdk.impl;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.net.Uri;
import android.text.TextUtils;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.flurry.android.impl.ads.FlurryAdModule;
import com.flurry.android.impl.ads.avro.protocol.v6.AdUnit;
import java.util.Collections;
import java.util.List;
import java.util.Map;

class aa
  extends WebViewClient
{
  private aa(o paramo) {}
  
  public void onLoadResource(WebView paramWebView, String paramString)
  {
    ja.a(3, o.a(this.a), "onLoadResource: url = " + paramString);
    super.onLoadResource(paramWebView, paramString);
    if ((paramString == null) || (paramWebView == null) || (paramWebView != o.b(this.a))) {}
    do
    {
      do
      {
        do
        {
          return;
          if (!paramString.equalsIgnoreCase(o.b(this.a).getUrl())) {
            o.c(this.a);
          }
        } while (o.d(this.a));
        paramWebView = Uri.parse(paramString).getLastPathSegment();
      } while ((paramWebView == null) || (!paramWebView.equalsIgnoreCase("mraid.js")));
      o.a(this.a, true);
      o.e(this.a);
    } while (!o.f(this.a));
    o.g(this.a);
    o.h(this.a);
  }
  
  public void onPageFinished(WebView paramWebView, String paramString)
  {
    ja.a(3, o.a(this.a), "onPageFinished: url = " + paramString);
    if ((paramString == null) || (paramWebView == null) || (paramWebView != o.b(this.a))) {}
    do
    {
      return;
      o.c(this.a);
      o.k(this.a);
      if ((o.l(this.a) != null) && (o.l(this.a).isShowing())) {
        o.l(this.a).dismiss();
      }
      if ((!this.a.a(o.b(this.a))) && ((this.a.getCurrentBinding() == 2) || (this.a.getCurrentBinding() == 1)))
      {
        ja.a(3, o.a(this.a), "adding WebView to AdUnityView");
        this.a.addView(o.b(this.a));
      }
      o.b(this.a, true);
    } while (!o.d(this.a));
    o.g(this.a);
    o.h(this.a);
  }
  
  public void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    ja.a(3, o.a(this.a), "onPageStarted: url = " + paramString);
    if ((paramString == null) || (paramWebView == null) || (paramWebView != o.b(this.a))) {
      return;
    }
    o.i(this.a);
    o.j(this.a);
    o.b(this.a, false);
    o.a(this.a, false);
  }
  
  public void onReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2)
  {
    if ((o.l(this.a) != null) && (o.l(this.a).isShowing())) {
      o.l(this.a).dismiss();
    }
    this.a.a("renderFailed", Collections.emptyMap(), this.a.d, this.a.c, this.a.e, 0);
  }
  
  public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
  {
    ja.a(3, o.a(this.a), "shouldOverrideUrlLoading: url = " + paramString);
    if ((paramString == null) || (paramWebView == null) || (paramWebView != o.b(this.a))) {
      return false;
    }
    Object localObject1 = cp.b(o.b(this.a).getUrl());
    paramWebView = paramString;
    Object localObject2;
    if (!TextUtils.isEmpty((CharSequence)localObject1))
    {
      paramWebView = paramString;
      if (paramString.startsWith((String)localObject1))
      {
        localObject1 = paramString.substring(((String)localObject1).length());
        localObject2 = Uri.parse((String)localObject1);
        paramWebView = paramString;
        if (((Uri)localObject2).isHierarchical())
        {
          paramWebView = paramString;
          if (!TextUtils.isEmpty(((Uri)localObject2).getScheme()))
          {
            paramWebView = paramString;
            if (!TextUtils.isEmpty(((Uri)localObject2).getAuthority()))
            {
              ja.a(3, o.a(this.a), "shouldOverrideUrlLoading: target url = " + (String)localObject1);
              paramWebView = (WebView)localObject1;
            }
          }
        }
      }
    }
    paramString = Uri.parse(paramWebView);
    if ((paramString.getScheme() != null) && (paramString.getScheme().equals("flurry")))
    {
      paramWebView = paramString.getQueryParameter("event");
      if (paramWebView != null)
      {
        o.m(this.a).add(paramWebView);
        paramString = je.f(paramString.getEncodedQuery());
        if (!paramString.containsKey("guid")) {
          break label299;
        }
        localObject1 = o.a(this.a, (String)paramString.get("guid"));
        localObject2 = o.b(this.a, (String)paramString.get("guid"));
        if ((localObject1 != null) && (localObject2 != null)) {
          this.a.a(paramWebView, paramString, (AdUnit)localObject1, (m)localObject2, 0, 0);
        }
      }
      for (;;)
      {
        return true;
        label299:
        this.a.a(paramWebView, paramString, this.a.d, this.a.c, this.a.e, 0);
      }
    }
    this.a.a("clicked", Collections.emptyMap(), this.a.d, this.a.c, this.a.e, 0);
    if (this.a.d()) {
      o.b(this.a).loadUrl(paramWebView);
    }
    for (;;)
    {
      return true;
      this.a.b.a().a(this.a.getContext(), paramWebView, true, this.a.d);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/aa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */