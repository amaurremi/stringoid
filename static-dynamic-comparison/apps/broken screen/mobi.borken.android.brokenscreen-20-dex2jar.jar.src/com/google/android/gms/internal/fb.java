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

public class fb
  extends ez
{
  public fb(ey paramey, boolean paramBoolean)
  {
    super(paramey, paramBoolean);
  }
  
  protected WebResourceResponse c(Context paramContext, String paramString1, String paramString2)
    throws IOException
  {
    paramString2 = (HttpURLConnection)new URL(paramString2).openConnection();
    try
    {
      ep.a(paramContext, paramString1, true, paramString2);
      paramString2.connect();
      paramContext = new WebResourceResponse("application/javascript", "UTF-8", new ByteArrayInputStream(ep.a(new InputStreamReader(paramString2.getInputStream())).getBytes("UTF-8")));
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
      if (!(paramWebView instanceof ey))
      {
        ev.D("Tried to intercept request from a WebView that wasn't an AdWebView.");
        return super.shouldInterceptRequest(paramWebView, paramString);
      }
      Object localObject = (ey)paramWebView;
      ((ey)localObject).bW().aN();
      if (((ey)localObject).Q().md)
      {
        ev.C("shouldInterceptRequest(http://media.admob.com/mraid/v1/mraid_app_interstitial.js)");
        return c(((ey)localObject).getContext(), this.lL.bY().st, "http://media.admob.com/mraid/v1/mraid_app_interstitial.js");
      }
      if (((ey)localObject).bZ())
      {
        ev.C("shouldInterceptRequest(http://media.admob.com/mraid/v1/mraid_app_expanded_banner.js)");
        return c(((ey)localObject).getContext(), this.lL.bY().st, "http://media.admob.com/mraid/v1/mraid_app_expanded_banner.js");
      }
      ev.C("shouldInterceptRequest(http://media.admob.com/mraid/v1/mraid_app_banner.js)");
      localObject = c(((ey)localObject).getContext(), this.lL.bY().st, "http://media.admob.com/mraid/v1/mraid_app_banner.js");
      return (WebResourceResponse)localObject;
    }
    catch (IOException localIOException)
    {
      ev.D("Could not fetching MRAID JS. " + localIOException.getMessage());
    }
    return super.shouldInterceptRequest(paramWebView, paramString);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/internal/fb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */