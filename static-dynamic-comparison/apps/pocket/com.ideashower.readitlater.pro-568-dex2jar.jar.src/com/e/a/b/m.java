package com.e.a.b;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.NetworkInterface;
import java.net.Socket;
import java.net.SocketException;

class m
  extends j
{
  private final Method a;
  
  private m(Method paramMethod)
  {
    this.a = paramMethod;
  }
  
  public int c(Socket paramSocket)
  {
    try
    {
      NetworkInterface localNetworkInterface = NetworkInterface.getByInetAddress(paramSocket.getLocalAddress());
      if (localNetworkInterface == null) {
        return super.c(paramSocket);
      }
      int i = ((Integer)this.a.invoke(localNetworkInterface, new Object[0])).intValue();
      return i;
    }
    catch (NullPointerException localNullPointerException)
    {
      return super.c(paramSocket);
    }
    catch (SocketException localSocketException)
    {
      return super.c(paramSocket);
    }
    catch (IllegalAccessException paramSocket)
    {
      throw new AssertionError(paramSocket);
    }
    catch (InvocationTargetException paramSocket)
    {
      if ((paramSocket.getCause() instanceof IOException)) {
        throw ((IOException)paramSocket.getCause());
      }
      throw new RuntimeException(paramSocket.getCause());
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/e/a/b/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */