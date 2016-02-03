package com.google.android.gms.internal;

import android.content.Context;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class fa
  extends ey
{
  public fa(ex paramex, boolean paramBoolean)
  {
    super(paramex, paramBoolean);
  }
  
  protected WebResourceResponse c(Context paramContext, String paramString1, String paramString2)
  {
    paramString2 = (HttpURLConnection)new URL(paramString2).openConnection();
    try
    {
      eo.a(paramContext, paramString1, true, paramString2);
      paramString2.connect();
      paramContext = new WebResourceResponse("application/javascript", "UTF-8", new ByteArrayInputStream(eo.a(new InputStreamReader(paramString2.getInputStream())).getBytes("UTF-8")));
      return paramContext;
    }
    finally
    {
      paramString2.disconnect();
    }
  }
  
  public WebResourceResponse shouldInterceptRequest(WebView paramWebView, String paramString)
  {
    try
    {
      if (!"mraid.js".equalsIgnoreCase(new File(paramString).getName())) {
        return super.shouldInterceptRequest(paramWebView, paramString);
      }
      if (!(paramWebView instanceof ex))
      {
        eu.D("Tried to intercept request from a WebView that wasn't an AdWebView.");
        return super.shouldInterceptRequest(paramWebView, paramString);
      }
      Object localObject = (ex)paramWebView;
      ((ex)localObject).cb().aS();
      if (((ex)localObject).V().mf)
      {
        eu.C("shouldInterceptRequest(http://media.admob.com/mraid/v1/mraid_app_interstitial.js)");
        return c(((ex)localObject).getContext(), this.lN.cd().sw, "http://media.admob.com/mraid/v1/mraid_app_interstitial.js");
      }
      if (((ex)localObject).ce())
      {
        eu.C("shouldInterceptRequest(http://media.admob.com/mraid/v1/mraid_app_expanded_banner.js)");
        return c(((ex)localObject).getContext(), this.lN.cd().sw, "http://media.admob.com/mraid/v1/mraid_app_expanded_banner.js");
      }
      eu.C("shouldInterceptRequest(http://media.admob.com/mraid/v1/mraid_app_banner.js)");
      localObject = c(((ex)localObject).getContext(), this.lN.cd().sw, "http://media.admob.com/mraid/v1/mraid_app_banner.js");
      return (WebResourceResponse)localObject;
    }
    catch (IOException localIOException)
    {
      eu.D("Could not fetching MRAID JS. " + localIOException.getMessage());
    }
    return super.shouldInterceptRequest(paramWebView, paramString);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/internal/fa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */