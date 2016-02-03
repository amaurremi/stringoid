package com.amazonaws.http.conn;

import com.amazonaws.org.apache.http.conn.ClientConnectionManager;
import com.amazonaws.org.apache.http.pool.ConnPoolControl;
import java.lang.reflect.Proxy;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class ClientConnectionManagerFactory
{
  private static final Log log = LogFactory.getLog(ClientConnectionManagerFactory.class);
  
  public static ClientConnectionManager wrap(ClientConnectionManager paramClientConnectionManager)
  {
    if ((paramClientConnectionManager instanceof Wrapped)) {
      throw new IllegalArgumentException();
    }
    Class[] arrayOfClass;
    if ((paramClientConnectionManager instanceof ConnPoolControl))
    {
      arrayOfClass = new Class[3];
      arrayOfClass[0] = ClientConnectionManager.class;
      arrayOfClass[1] = ConnPoolControl.class;
      arrayOfClass[2] = Wrapped.class;
    }
    for (;;)
    {
      return (ClientConnectionManager)Proxy.newProxyInstance(ClientConnectionManagerFactory.class.getClassLoader(), arrayOfClass, new ClientConnectionManagerFactory.Handler(paramClientConnectionManager));
      arrayOfClass = new Class[2];
      arrayOfClass[0] = ClientConnectionManager.class;
      arrayOfClass[1] = Wrapped.class;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/http/conn/ClientConnectionManagerFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */