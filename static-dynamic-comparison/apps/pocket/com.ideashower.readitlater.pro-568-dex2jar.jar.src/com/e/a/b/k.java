package com.e.a.b;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.InetSocketAddress;
import java.net.Socket;
import javax.net.ssl.SSLSocket;

class k
  extends m
{
  protected final Class a;
  private final Method b;
  private final Method c;
  
  private k(Method paramMethod1, Class paramClass, Method paramMethod2, Method paramMethod3)
  {
    super(paramMethod1, null);
    this.a = paramClass;
    this.b = paramMethod2;
    this.c = paramMethod3;
  }
  
  public void a(Socket paramSocket, InetSocketAddress paramInetSocketAddress, int paramInt)
  {
    try
    {
      paramSocket.connect(paramInetSocketAddress, paramInt);
      return;
    }
    catch (SecurityException paramSocket)
    {
      paramInetSocketAddress = new IOException("Exception in connect");
      paramInetSocketAddress.initCause(paramSocket);
      throw paramInetSocketAddress;
    }
  }
  
  public void a(SSLSocket paramSSLSocket, String paramString)
  {
    super.a(paramSSLSocket, paramString);
    if (this.a.isInstance(paramSSLSocket)) {}
    try
    {
      this.b.invoke(paramSSLSocket, new Object[] { Boolean.valueOf(true) });
      this.c.invoke(paramSSLSocket, new Object[] { paramString });
      return;
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


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/e/a/b/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */