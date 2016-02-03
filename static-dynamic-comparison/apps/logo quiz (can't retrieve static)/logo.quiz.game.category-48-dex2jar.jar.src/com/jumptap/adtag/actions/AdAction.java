package com.jumptap.adtag.actions;

import android.content.Context;
import android.util.Log;
import com.jumptap.adtag.JtAdView;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.params.HttpClientParams;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;

public abstract class AdAction
{
  protected String redirectedUrl = null;
  protected String url = null;
  protected String useragent = null;
  
  public static String getRedirectedUrl(String paramString1, String paramString2)
  {
    DefaultHttpClient localDefaultHttpClient = new DefaultHttpClient();
    Object localObject = localDefaultHttpClient.getParams();
    HttpClientParams.setRedirecting((HttpParams)localObject, false);
    HttpConnectionParams.setSocketBufferSize((HttpParams)localObject, 8192);
    try
    {
      localObject = new HttpGet(paramString1);
      ((HttpGet)localObject).setHeader("User-Agent", paramString2);
      paramString2 = localDefaultHttpClient.execute((HttpUriRequest)localObject);
      if (paramString2 != null)
      {
        paramString2 = paramString2.getFirstHeader("Location");
        if (paramString2 != null) {
          return paramString2.getValue();
        }
        Log.e("JtAd", "AdAction: cannot find Location header in the respons of :" + paramString1);
        return null;
      }
    }
    catch (Exception paramString1)
    {
      Log.e("JtAd", "getRedirectedUrl:" + paramString1.toString());
      return null;
    }
    Log.e("JtAd", "AdAction: cannot execute:" + paramString1);
    return null;
  }
  
  public static String getRedirectedUrlWithPredicate(String paramString1, String paramString2, UrlPredicate paramUrlPredicate)
  {
    int i = 0;
    while ((paramString1 != null) && (i < 4) && (!paramUrlPredicate.test(paramString1)))
    {
      i += 1;
      paramString1 = getRedirectedUrl(paramString1, paramString2);
    }
    paramString2 = paramString1;
    if ("".equals(paramString1)) {
      paramString2 = null;
    }
    return paramString2;
  }
  
  public abstract void perform(Context paramContext, JtAdView paramJtAdView);
  
  public void setRedirectedUrl(String paramString)
  {
    this.redirectedUrl = paramString;
  }
  
  public void setUrl(String paramString)
  {
    this.url = paramString;
  }
  
  public void setUserAgent(String paramString)
  {
    this.useragent = paramString;
  }
  
  public static abstract interface UrlPredicate
  {
    public abstract boolean test(String paramString);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/jumptap/adtag/actions/AdAction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */