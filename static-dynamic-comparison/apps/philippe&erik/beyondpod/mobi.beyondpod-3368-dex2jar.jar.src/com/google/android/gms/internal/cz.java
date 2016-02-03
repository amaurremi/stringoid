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

public final class cz
  extends cx
{
  public cz(cw paramcw, boolean paramBoolean)
  {
    super(paramcw, paramBoolean);
  }
  
  private static WebResourceResponse d(Context paramContext, String paramString1, String paramString2)
    throws IOException
  {
    paramString2 = (HttpURLConnection)new URL(paramString2).openConnection();
    try
    {
      co.a(paramContext, paramString1, true, paramString2);
      paramString2.connect();
      paramContext = new WebResourceResponse("application/javascript", "UTF-8", new ByteArrayInputStream(co.a(new InputStreamReader(paramString2.getInputStream())).getBytes("UTF-8")));
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
      if (!(paramWebView instanceof cw))
      {
        ct.v("Tried to intercept request from a WebView that wasn't an AdWebView.");
        return super.shouldInterceptRequest(paramWebView, paramString);
      }
      Object localObject = (cw)paramWebView;
      ((cw)localObject).aC().Y();
      if (((cw)localObject).y().eG)
      {
        ct.u("shouldInterceptRequest(http://media.admob.com/mraid/v1/mraid_app_interstitial.js)");
        return d(((cw)localObject).getContext(), this.gv.aE().iJ, "http://media.admob.com/mraid/v1/mraid_app_interstitial.js");
      }
      if (((cw)localObject).aF())
      {
        ct.u("shouldInterceptRequest(http://media.admob.com/mraid/v1/mraid_app_expanded_banner.js)");
        return d(((cw)localObject).getContext(), this.gv.aE().iJ, "http://media.admob.com/mraid/v1/mraid_app_expanded_banner.js");
      }
      ct.u("shouldInterceptRequest(http://media.admob.com/mraid/v1/mraid_app_banner.js)");
      localObject = d(((cw)localObject).getContext(), this.gv.aE().iJ, "http://media.admob.com/mraid/v1/mraid_app_banner.js");
      return (WebResourceResponse)localObject;
    }
    catch (IOException localIOException)
    {
      ct.v("Could not fetching MRAID JS. " + localIOException.getMessage());
    }
    return super.shouldInterceptRequest(paramWebView, paramString);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/com/google/android/gms/internal/cz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */