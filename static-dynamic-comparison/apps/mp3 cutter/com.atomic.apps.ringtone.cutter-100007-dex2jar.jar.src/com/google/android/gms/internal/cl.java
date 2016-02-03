package com.google.android.gms.internal;

import android.content.Context;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import com.atomic.apps.ringtone.cutter.aa;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public final class cl
  extends bY
{
  public cl(bW parambW, boolean paramBoolean)
  {
    super(parambW, paramBoolean);
  }
  
  private static WebResourceResponse a(Context paramContext, String paramString1, String paramString2)
  {
    paramString2 = (HttpURLConnection)new URL(paramString2).openConnection();
    try
    {
      bN.a(paramContext, paramString1, true, paramString2);
      paramString2.connect();
      paramContext = new WebResourceResponse("application/javascript", "UTF-8", new ByteArrayInputStream(bN.a(new InputStreamReader(paramString2.getInputStream())).getBytes("UTF-8")));
      return paramContext;
    }
    finally
    {
      paramString2.disconnect();
    }
  }
  
  public final WebResourceResponse shouldInterceptRequest(WebView paramWebView, String paramString)
  {
    try
    {
      if (!"mraid.js".equalsIgnoreCase(new File(paramString).getName())) {
        return super.shouldInterceptRequest(paramWebView, paramString);
      }
      if (!(paramWebView instanceof bW))
      {
        aa.e("Tried to intercept request from a WebView that wasn't an AdWebView.");
        return super.shouldInterceptRequest(paramWebView, paramString);
      }
      Object localObject = (bW)paramWebView;
      ((bW)localObject).f().c();
      if (((bW)localObject).e().e)
      {
        aa.d("shouldInterceptRequest(http://media.admob.com/mraid/v1/mraid_app_interstitial.js)");
        return a(((bW)localObject).getContext(), this.a.h().b, "http://media.admob.com/mraid/v1/mraid_app_interstitial.js");
      }
      if (((bW)localObject).i())
      {
        aa.d("shouldInterceptRequest(http://media.admob.com/mraid/v1/mraid_app_expanded_banner.js)");
        return a(((bW)localObject).getContext(), this.a.h().b, "http://media.admob.com/mraid/v1/mraid_app_expanded_banner.js");
      }
      aa.d("shouldInterceptRequest(http://media.admob.com/mraid/v1/mraid_app_banner.js)");
      localObject = a(((bW)localObject).getContext(), this.a.h().b, "http://media.admob.com/mraid/v1/mraid_app_banner.js");
      return (WebResourceResponse)localObject;
    }
    catch (IOException localIOException)
    {
      aa.e("Could not fetching MRAID JS. " + localIOException.getMessage());
    }
    return super.shouldInterceptRequest(paramWebView, paramString);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/mp3 cutter/com.atomic.apps.ringtone.cutter-100007-dex2jar.jar!/com/google/android/gms/internal/cl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */