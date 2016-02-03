package com.amazonaws.http.conn;

import com.amazonaws.org.apache.http.conn.ClientConnectionManager;
import com.amazonaws.org.apache.http.conn.ClientConnectionRequest;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.apache.commons.logging.Log;

class ClientConnectionManagerFactory$Handler
  implements InvocationHandler
{
  private final ClientConnectionManager orig;
  
  ClientConnectionManagerFactory$Handler(ClientConnectionManager paramClientConnectionManager)
  {
    this.orig = paramClientConnectionManager;
  }
  
  public Object invoke(Object paramObject, Method paramMethod, Object[] paramArrayOfObject)
  {
    try
    {
      paramMethod = paramMethod.invoke(this.orig, paramArrayOfObject);
      paramObject = paramMethod;
      if ((paramMethod instanceof ClientConnectionRequest)) {
        paramObject = ClientConnectionRequestFactory.wrap((ClientConnectionRequest)paramMethod);
      }
      return paramObject;
    }
    catch (InvocationTargetException paramObject)
    {
      ClientConnectionManagerFactory.access$000().debug("", (Throwable)paramObject);
      throw ((InvocationTargetException)paramObject).getCause();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/http/conn/ClientConnectionManagerFactory$Handler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */