package com.squareup.okhttp.internal.huc;

import com.squareup.okhttp.Handshake;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.internal.http.HttpEngine;
import java.net.URL;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;

public final class HttpsURLConnectionImpl
  extends DelegatingHttpsURLConnection
{
  private final HttpURLConnectionImpl delegate;
  
  public HttpsURLConnectionImpl(HttpURLConnectionImpl paramHttpURLConnectionImpl)
  {
    super(paramHttpURLConnectionImpl);
    this.delegate = paramHttpURLConnectionImpl;
  }
  
  public HttpsURLConnectionImpl(URL paramURL, OkHttpClient paramOkHttpClient)
  {
    this(new HttpURLConnectionImpl(paramURL, paramOkHttpClient));
  }
  
  public long getContentLengthLong()
  {
    return this.delegate.getContentLengthLong();
  }
  
  public long getHeaderFieldLong(String paramString, long paramLong)
  {
    return this.delegate.getHeaderFieldLong(paramString, paramLong);
  }
  
  public HostnameVerifier getHostnameVerifier()
  {
    return this.delegate.client.getHostnameVerifier();
  }
  
  public SSLSocketFactory getSSLSocketFactory()
  {
    return this.delegate.client.getSslSocketFactory();
  }
  
  protected Handshake handshake()
  {
    if (this.delegate.httpEngine == null) {
      throw new IllegalStateException("Connection has not yet been established");
    }
    if (this.delegate.httpEngine.hasResponse()) {
      return this.delegate.httpEngine.getResponse().handshake();
    }
    return this.delegate.handshake;
  }
  
  public void setFixedLengthStreamingMode(long paramLong)
  {
    this.delegate.setFixedLengthStreamingMode(paramLong);
  }
  
  public void setHostnameVerifier(HostnameVerifier paramHostnameVerifier)
  {
    this.delegate.client.setHostnameVerifier(paramHostnameVerifier);
  }
  
  public void setSSLSocketFactory(SSLSocketFactory paramSSLSocketFactory)
  {
    this.delegate.client.setSslSocketFactory(paramSSLSocketFactory);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/squareup/okhttp/internal/huc/HttpsURLConnectionImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */