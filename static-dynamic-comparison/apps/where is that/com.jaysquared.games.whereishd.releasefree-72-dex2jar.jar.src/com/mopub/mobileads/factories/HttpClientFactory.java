package com.mopub.mobileads.factories;

import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;

public class HttpClientFactory
{
  public static final int SOCKET_SIZE = 8192;
  private static HttpClientFactory instance = new HttpClientFactory();
  
  public static DefaultHttpClient create()
  {
    return instance.internalCreate(0);
  }
  
  public static DefaultHttpClient create(int paramInt)
  {
    return instance.internalCreate(paramInt);
  }
  
  @Deprecated
  public static void setInstance(HttpClientFactory paramHttpClientFactory)
  {
    instance = paramHttpClientFactory;
  }
  
  protected DefaultHttpClient internalCreate(int paramInt)
  {
    BasicHttpParams localBasicHttpParams = new BasicHttpParams();
    if (paramInt > 0)
    {
      HttpConnectionParams.setConnectionTimeout(localBasicHttpParams, paramInt);
      HttpConnectionParams.setSoTimeout(localBasicHttpParams, paramInt);
    }
    HttpConnectionParams.setSocketBufferSize(localBasicHttpParams, 8192);
    return new DefaultHttpClient(localBasicHttpParams);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/mopub/mobileads/factories/HttpClientFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */