package com.amazonaws.http.conn;

import com.amazonaws.org.apache.http.conn.ClientConnectionRequest;
import java.lang.reflect.Proxy;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

class ClientConnectionRequestFactory
{
  private static final Class<?>[] interfaces = { ClientConnectionRequest.class, Wrapped.class };
  private static final Log log = LogFactory.getLog(ClientConnectionRequestFactory.class);
  
  static ClientConnectionRequest wrap(ClientConnectionRequest paramClientConnectionRequest)
  {
    if ((paramClientConnectionRequest instanceof Wrapped)) {
      throw new IllegalArgumentException();
    }
    return (ClientConnectionRequest)Proxy.newProxyInstance(ClientConnectionRequestFactory.class.getClassLoader(), interfaces, new ClientConnectionRequestFactory.Handler(paramClientConnectionRequest));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/http/conn/ClientConnectionRequestFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */