package com.amazonaws.http.impl.client;

import com.amazonaws.http.conn.ClientConnectionManagerFactory;
import com.amazonaws.http.protocol.SdkHttpRequestExecutor;
import com.amazonaws.org.apache.http.conn.ClientConnectionManager;
import com.amazonaws.org.apache.http.impl.client.DefaultHttpClient;
import com.amazonaws.org.apache.http.params.HttpParams;
import com.amazonaws.org.apache.http.protocol.HttpRequestExecutor;

public class SdkHttpClient
  extends DefaultHttpClient
{
  public SdkHttpClient(ClientConnectionManager paramClientConnectionManager, HttpParams paramHttpParams)
  {
    super(ClientConnectionManagerFactory.wrap(paramClientConnectionManager), paramHttpParams);
  }
  
  protected HttpRequestExecutor createRequestExecutor()
  {
    return new SdkHttpRequestExecutor();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/http/impl/client/SdkHttpClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */