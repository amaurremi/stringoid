package com.e.a.b;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.SSLSocket;

class n
  extends m
{
  private final Method a;
  private final Method b;
  private final Class c;
  private final Class d;
  
  public n(Method paramMethod1, Method paramMethod2, Method paramMethod3, Class paramClass1, Class paramClass2)
  {
    super(paramMethod1, null);
    this.b = paramMethod2;
    this.a = paramMethod3;
    this.c = paramClass1;
    this.d = paramClass2;
  }
  
  public void a(SSLSocket paramSSLSocket, byte[] paramArrayOfByte)
  {
    int i = 0;
    try
    {
      Object localObject = new ArrayList();
      while (i < paramArrayOfByte.length)
      {
        int j = i + 1;
        i = paramArrayOfByte[i];
        ((List)localObject).add(new String(paramArrayOfByte, j, i, "US-ASCII"));
        i += j;
      }
      paramArrayOfByte = j.class.getClassLoader();
      Class localClass1 = this.c;
      Class localClass2 = this.d;
      localObject = new o((List)localObject);
      paramArrayOfByte = Proxy.newProxyInstance(paramArrayOfByte, new Class[] { localClass1, localClass2 }, (InvocationHandler)localObject);
      this.b.invoke(null, new Object[] { paramSSLSocket, paramArrayOfByte });
      return;
    }
    catch (UnsupportedEncodingException paramSSLSocket)
    {
      throw new AssertionError(paramSSLSocket);
    }
    catch (InvocationTargetException paramSSLSocket)
    {
      throw new AssertionError(paramSSLSocket);
    }
    catch (IllegalAccessException paramSSLSocket)
    {
      throw new AssertionError(paramSSLSocket);
    }
  }
  
  public byte[] b(SSLSocket paramSSLSocket)
  {
    try
    {
      paramSSLSocket = (o)Proxy.getInvocationHandler(this.a.invoke(null, new Object[] { paramSSLSocket }));
      if ((!o.a(paramSSLSocket)) && (o.b(paramSSLSocket) == null))
      {
        Logger.getLogger("com.squareup.okhttp.OkHttpClient").log(Level.INFO, "NPN callback dropped so SPDY is disabled. Is npn-boot on the boot class path?");
        return null;
      }
      if (o.a(paramSSLSocket)) {
        paramSSLSocket = null;
      } else {
        paramSSLSocket = o.b(paramSSLSocket).getBytes("US-ASCII");
      }
    }
    catch (UnsupportedEncodingException paramSSLSocket)
    {
      throw new AssertionError();
    }
    catch (InvocationTargetException paramSSLSocket)
    {
      throw new AssertionError();
    }
    catch (IllegalAccessException paramSSLSocket)
    {
      throw new AssertionError();
    }
    return paramSSLSocket;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/e/a/b/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */