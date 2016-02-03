package com.google.android.gms.internal;

import android.text.TextUtils;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import java.net.URI;
import java.net.URISyntaxException;

public class fd
  extends WebViewClient
{
  private final ey lL;
  private final String sQ = G(paramString);
  private boolean sR = false;
  private final dp sS;
  
  public fd(dp paramdp, ey paramey, String paramString)
  {
    this.lL = paramey;
    this.sS = paramdp;
  }
  
  private String G(String paramString)
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
        ev.A(localIndexOutOfBoundsException.getMessage());
      }
    }
    return paramString;
  }
  
  protected boolean F(String paramString)
  {
    paramString = G(paramString);
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return false;
      try
      {
        Object localObject1 = new URI(paramString);
        if ("passback".equals(((URI)localObject1).getScheme()))
        {
          ev.z("Passback received");
          this.sS.bk();
          return true;
        }
        if (!TextUtils.isEmpty(this.sQ))
        {
          Object localObject2 = new URI(this.sQ);
          paramString = ((URI)localObject2).getHost();
          String str = ((URI)localObject1).getHost();
          localObject2 = ((URI)localObject2).getPath();
          localObject1 = ((URI)localObject1).getPath();
          if ((hl.equal(paramString, str)) && (hl.equal(localObject2, localObject1)))
          {
            ev.z("Passback received");
            this.sS.bk();
            return true;
          }
        }
      }
      catch (URISyntaxException paramString)
      {
        ev.A(paramString.getMessage());
      }
    }
    return false;
  }
  
  public void onLoadResource(WebView paramWebView, String paramString)
  {
    ev.z("JavascriptAdWebViewClient::onLoadResource: " + paramString);
    if (!F(paramString)) {
      this.lL.bW().onLoadResource(this.lL, paramString);
    }
  }
  
  public void onPageFinished(WebView paramWebView, String paramString)
  {
    ev.z("JavascriptAdWebViewClient::onPageFinished: " + paramString);
    if (!this.sR)
    {
      this.sS.bj();
      this.sR = true;
    }
  }
  
  public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
  {
    ev.z("JavascriptAdWebViewClient::shouldOverrideUrlLoading: " + paramString);
    if (F(paramString))
    {
      ev.z("shouldOverrideUrlLoading: received passback url");
      return true;
    }
    return this.lL.bW().shouldOverrideUrlLoading(this.lL, paramString);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/internal/fd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */