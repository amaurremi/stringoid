package com.amazonaws.http;

import com.amazonaws.ClientConfiguration;
import com.amazonaws.org.apache.http.impl.conn.PoolingClientConnectionManager;
import com.amazonaws.org.apache.http.params.HttpParams;

class ConnectionManagerFactory
{
  public static PoolingClientConnectionManager createPoolingClientConnManager(ClientConfiguration paramClientConfiguration, HttpParams paramHttpParams)
  {
    paramHttpParams = new PoolingClientConnectionManager();
    paramHttpParams.setDefaultMaxPerRoute(paramClientConfiguration.getMaxConnections());
    paramHttpParams.setMaxTotal(paramClientConfiguration.getMaxConnections());
    if (paramClientConfiguration.useReaper()) {
      IdleConnectionReaper.registerConnectionManager(paramHttpParams);
    }
    return paramHttpParams;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/http/ConnectionManagerFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */