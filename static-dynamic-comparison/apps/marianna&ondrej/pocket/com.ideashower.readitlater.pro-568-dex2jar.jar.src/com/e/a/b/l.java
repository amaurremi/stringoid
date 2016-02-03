package com.e.a.b;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import javax.net.ssl.SSLSocket;

class l
  extends k
{
  private final Method b;
  private final Method c;
  
  private l(Method paramMethod1, Class paramClass, Method paramMethod2, Method paramMethod3, Method paramMethod4, Method paramMethod5)
  {
    super(paramMethod1, paramClass, paramMethod2, paramMethod3, null);
    this.b = paramMethod4;
    this.c = paramMethod5;
  }
  
  public void a(SSLSocket paramSSLSocket, byte[] paramArrayOfByte)
  {
    if (!this.a.isInstance(paramSSLSocket)) {
      return;
    }
    try
    {
      this.b.invoke(paramSSLSocket, new Object[] { paramArrayOfByte });
      return;
    }
    catch (IllegalAccessException paramSSLSocket)
    {
      throw new AssertionError(paramSSLSocket);
    }
    catch (InvocationTargetException paramSSLSocket)
    {
      throw new RuntimeException(paramSSLSocket);
    }
  }
  
  public byte[] b(SSLSocket paramSSLSocket)
  {
    if (!this.a.isInstance(paramSSLSocket)) {
      return null;
    }
    try
    {
      paramSSLSocket = (byte[])this.c.invoke(paramSSLSocket, new Object[0]);
      return paramSSLSocket;
    }
    catch (InvocationTargetException paramSSLSocket)
    {
      throw new RuntimeException(paramSSLSocket);
    }
    catch (IllegalAccessException paramSSLSocket)
    {
      throw new AssertionError(paramSSLSocket);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/e/a/b/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */