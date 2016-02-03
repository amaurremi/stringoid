package com.ideashower.readitlater.a;

import com.e.a.a.a;
import com.e.a.c;
import com.ideashower.readitlater.util.e;
import java.net.CookieHandler;
import java.net.CookieManager;
import java.security.GeneralSecurityException;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.SSLContext;

public final class w
{
  private static a a;
  private static com.e.a.m b;
  
  public static void a() {}
  
  private static void a(com.e.a.m paramm)
  {
    try
    {
      SSLContext localSSLContext = SSLContext.getInstance("TLS");
      localSSLContext.init(null, null, null);
      paramm.a(localSSLContext.getSocketFactory());
      return;
    }
    catch (GeneralSecurityException paramm)
    {
      e.a("socket factory failed to init");
      g.s().b(paramm);
    }
  }
  
  public static void b() {}
  
  public static a c()
  {
    return a;
  }
  
  public static CookieManager d()
  {
    return (CookieManager)a.a().e();
  }
  
  public static ag e()
  {
    new ag()
    {
      public void a()
      {
        try
        {
          w.f().j().b();
          return;
        }
        catch (Throwable localThrowable)
        {
          e.a(localThrowable);
        }
      }
      
      public void b() {}
      
      public void c() {}
    };
  }
  
  private static void h()
  {
    CookieHandler.setDefault(new CookieManager());
    a = new a();
    b = a.a();
    b.a(5L, TimeUnit.SECONDS);
    b.b(60L, TimeUnit.SECONDS);
    b.a(CookieHandler.getDefault());
    a(b);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/a/w.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */