package com.google.android.gms.internal;

import android.text.TextUtils;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.atomic.apps.ringtone.cutter.aa;
import java.net.URI;
import java.net.URISyntaxException;

public final class cn
  extends WebViewClient
{
  private final String a;
  private boolean b;
  private final bW c;
  private final be d;
  
  public cn(be parambe, bW parambW, String paramString)
  {
    this.a = b(paramString);
    this.b = false;
    this.c = parambW;
    this.d = parambe;
  }
  
  private boolean a(String paramString)
  {
    paramString = b(paramString);
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return false;
      try
      {
        Object localObject1 = new URI(paramString);
        if ("passback".equals(((URI)localObject1).getScheme()))
        {
          aa.a("Passback received");
          this.d.b();
          return true;
        }
        if (!TextUtils.isEmpty(this.a))
        {
          Object localObject2 = new URI(this.a);
          paramString = ((URI)localObject2).getHost();
          String str = ((URI)localObject1).getHost();
          localObject2 = ((URI)localObject2).getPath();
          localObject1 = ((URI)localObject1).getPath();
          if ((c.a(paramString, str)) && (c.a(localObject2, localObject1)))
          {
            aa.a("Passback received");
            this.d.b();
            return true;
          }
        }
      }
      catch (URISyntaxException paramString)
      {
        aa.b(paramString.getMessage());
      }
    }
    return false;
  }
  
  private static String b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return paramString;
      try
      {
        if (paramString.endsWith("/"))
        {
          String str = paramString.substring(0, paramString.length() - 1);
          return str;
        }
      }
      catch (IndexOutOfBoundsException localIndexOutOfBoundsException)
      {
        aa.b(localIndexOutOfBoundsException.getMessage());
      }
    }
    return paramString;
  }
  
  public final void onLoadResource(WebView paramWebView, String paramString)
  {
    aa.a("JavascriptAdWebViewClient::onLoadResource: " + paramString);
    if (!a(paramString)) {
      this.c.f().onLoadResource(this.c, paramString);
    }
  }
  
  public final void onPageFinished(WebView paramWebView, String paramString)
  {
    aa.a("JavascriptAdWebViewClient::onPageFinished: " + paramString);
    if (!this.b)
    {
      this.d.a();
      this.b = true;
    }
  }
  
  public final boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
  {
    aa.a("JavascriptAdWebViewClient::shouldOverrideUrlLoading: " + paramString);
    if (a(paramString))
    {
      aa.a("shouldOverrideUrlLoading: received passback url");
      return true;
    }
    return this.c.f().shouldOverrideUrlLoading(this.c, paramString);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/mp3 cutter/com.atomic.apps.ringtone.cutter-100007-dex2jar.jar!/com/google/android/gms/internal/cn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */