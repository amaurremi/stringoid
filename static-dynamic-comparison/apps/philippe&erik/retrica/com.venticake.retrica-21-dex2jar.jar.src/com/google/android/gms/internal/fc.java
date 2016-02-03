package com.google.android.gms.internal;

import android.text.TextUtils;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import java.net.URI;
import java.net.URISyntaxException;

public class fc
  extends WebViewClient
{
  private final ex lN;
  private final String sT = G(paramString);
  private boolean sU = false;
  private final do sV;
  
  public fc(do paramdo, ex paramex, String paramString)
  {
    this.lN = paramex;
    this.sV = paramdo;
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
        eu.A(localIndexOutOfBoundsException.getMessage());
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
          eu.z("Passback received");
          this.sV.bp();
          return true;
        }
        if (!TextUtils.isEmpty(this.sT))
        {
          Object localObject2 = new URI(this.sT);
          paramString = ((URI)localObject2).getHost();
          String str = ((URI)localObject1).getHost();
          localObject2 = ((URI)localObject2).getPath();
          localObject1 = ((URI)localObject1).getPath();
          if ((hk.equal(paramString, str)) && (hk.equal(localObject2, localObject1)))
          {
            eu.z("Passback received");
            this.sV.bp();
            return true;
          }
        }
      }
      catch (URISyntaxException paramString)
      {
        eu.A(paramString.getMessage());
      }
    }
    return false;
  }
  
  public void onLoadResource(WebView paramWebView, String paramString)
  {
    eu.z("JavascriptAdWebViewClient::onLoadResource: " + paramString);
    if (!F(paramString)) {
      this.lN.cb().onLoadResource(this.lN, paramString);
    }
  }
  
  public void onPageFinished(WebView paramWebView, String paramString)
  {
    eu.z("JavascriptAdWebViewClient::onPageFinished: " + paramString);
    if (!this.sU)
    {
      this.sV.bo();
      this.sU = true;
    }
  }
  
  public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
  {
    eu.z("JavascriptAdWebViewClient::shouldOverrideUrlLoading: " + paramString);
    if (F(paramString))
    {
      eu.z("shouldOverrideUrlLoading: received passback url");
      return true;
    }
    return this.lN.cb().shouldOverrideUrlLoading(this.lN, paramString);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/internal/fc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */