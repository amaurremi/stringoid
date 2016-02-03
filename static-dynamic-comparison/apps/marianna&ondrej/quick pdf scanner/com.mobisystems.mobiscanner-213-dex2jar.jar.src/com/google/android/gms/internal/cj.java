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

public final class cj
  extends ch
{
  public cj(dd paramdd, boolean paramBoolean)
  {
    super(paramdd, paramBoolean);
  }
  
  private static WebResourceResponse e(Context paramContext, String paramString1, String paramString2)
  {
    paramString2 = (HttpURLConnection)new URL(paramString2).openConnection();
    try
    {
      bw.a(paramContext, paramString1, true, paramString2);
      paramString2.connect();
      paramContext = new WebResourceResponse("application/javascript", "UTF-8", new ByteArrayInputStream(bw.a(new InputStreamReader(paramString2.getInputStream())).getBytes("UTF-8")));
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
      if (!(paramWebView instanceof dd))
      {
        ce.D("Tried to intercept request from a WebView that wasn't an AdWebView.");
        return super.shouldInterceptRequest(paramWebView, paramString);
      }
      Object localObject = (dd)paramWebView;
      ((dd)localObject).pX().pl();
      if (((dd)localObject).oO().xa)
      {
        ce.C("shouldInterceptRequest(http://media.admob.com/mraid/v1/mraid_app_interstitial.js)");
        return e(((dd)localObject).getContext(), this.CB.pZ().FK, "http://media.admob.com/mraid/v1/mraid_app_interstitial.js");
      }
      if (((dd)localObject).qa())
      {
        ce.C("shouldInterceptRequest(http://media.admob.com/mraid/v1/mraid_app_expanded_banner.js)");
        return e(((dd)localObject).getContext(), this.CB.pZ().FK, "http://media.admob.com/mraid/v1/mraid_app_expanded_banner.js");
      }
      ce.C("shouldInterceptRequest(http://media.admob.com/mraid/v1/mraid_app_banner.js)");
      localObject = e(((dd)localObject).getContext(), this.CB.pZ().FK, "http://media.admob.com/mraid/v1/mraid_app_banner.js");
      return (WebResourceResponse)localObject;
    }
    catch (IOException localIOException)
    {
      ce.D("Could not fetching MRAID JS. " + localIOException.getMessage());
    }
    return super.shouldInterceptRequest(paramWebView, paramString);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/internal/cj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */