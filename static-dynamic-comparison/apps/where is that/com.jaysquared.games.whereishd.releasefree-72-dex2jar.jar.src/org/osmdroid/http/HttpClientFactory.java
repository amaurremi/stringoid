package org.osmdroid.http;

import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.HttpParams;

public class HttpClientFactory
{
  private static IHttpClientFactory mFactoryInstance = new IHttpClientFactory()
  {
    public HttpClient createHttpClient()
    {
      DefaultHttpClient localDefaultHttpClient = new DefaultHttpClient();
      localDefaultHttpClient.getParams().setParameter("http.useragent", "osmdroid");
      return localDefaultHttpClient;
    }
  };
  
  public static HttpClient createHttpClient()
  {
    return mFactoryInstance.createHttpClient();
  }
  
  public static void setFactoryInstance(IHttpClientFactory paramIHttpClientFactory)
  {
    mFactoryInstance = paramIHttpClientFactory;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/org/osmdroid/http/HttpClientFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */