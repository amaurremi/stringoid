package com.squareup.okhttp;

import com.squareup.okhttp.internal.InternalCache;
import com.squareup.okhttp.internal.huc.CacheAdapter;
import com.squareup.okhttp.internal.huc.HttpURLConnectionImpl;
import com.squareup.okhttp.internal.huc.HttpsURLConnectionImpl;
import java.net.HttpURLConnection;
import java.net.Proxy;
import java.net.ResponseCache;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLStreamHandler;
import java.net.URLStreamHandlerFactory;

public final class OkUrlFactory
  implements URLStreamHandlerFactory, Cloneable
{
  private final OkHttpClient client;
  
  public OkUrlFactory(OkHttpClient paramOkHttpClient)
  {
    this.client = paramOkHttpClient;
  }
  
  public OkHttpClient client()
  {
    return this.client;
  }
  
  public OkUrlFactory clone()
  {
    return new OkUrlFactory(this.client.clone());
  }
  
  public URLStreamHandler createURLStreamHandler(final String paramString)
  {
    if ((!paramString.equals("http")) && (!paramString.equals("https"))) {
      return null;
    }
    new URLStreamHandler()
    {
      protected int getDefaultPort()
      {
        if (paramString.equals("http")) {
          return 80;
        }
        if (paramString.equals("https")) {
          return 443;
        }
        throw new AssertionError();
      }
      
      protected URLConnection openConnection(URL paramAnonymousURL)
      {
        return OkUrlFactory.this.open(paramAnonymousURL);
      }
      
      protected URLConnection openConnection(URL paramAnonymousURL, Proxy paramAnonymousProxy)
      {
        return OkUrlFactory.this.open(paramAnonymousURL, paramAnonymousProxy);
      }
    };
  }
  
  ResponseCache getResponseCache()
  {
    InternalCache localInternalCache = this.client.internalCache();
    if ((localInternalCache instanceof CacheAdapter)) {
      return ((CacheAdapter)localInternalCache).getDelegate();
    }
    return null;
  }
  
  public HttpURLConnection open(URL paramURL)
  {
    return open(paramURL, this.client.getProxy());
  }
  
  HttpURLConnection open(URL paramURL, Proxy paramProxy)
  {
    String str = paramURL.getProtocol();
    OkHttpClient localOkHttpClient = this.client.copyWithDefaults();
    localOkHttpClient.setProxy(paramProxy);
    if (str.equals("http")) {
      return new HttpURLConnectionImpl(paramURL, localOkHttpClient);
    }
    if (str.equals("https")) {
      return new HttpsURLConnectionImpl(paramURL, localOkHttpClient);
    }
    throw new IllegalArgumentException("Unexpected protocol: " + str);
  }
  
  OkUrlFactory setResponseCache(ResponseCache paramResponseCache)
  {
    OkHttpClient localOkHttpClient = this.client;
    if (paramResponseCache != null) {}
    for (paramResponseCache = new CacheAdapter(paramResponseCache);; paramResponseCache = null)
    {
      localOkHttpClient.setInternalCache(paramResponseCache);
      return this;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/squareup/okhttp/OkUrlFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */