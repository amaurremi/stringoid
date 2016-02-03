package com.e.a;

import java.net.InetSocketAddress;
import java.net.Proxy;

public class p
{
  final a a;
  final Proxy b;
  final InetSocketAddress c;
  final boolean d;
  
  public p(a parama, Proxy paramProxy, InetSocketAddress paramInetSocketAddress, boolean paramBoolean)
  {
    if (parama == null) {
      throw new NullPointerException("address == null");
    }
    if (paramProxy == null) {
      throw new NullPointerException("proxy == null");
    }
    if (paramInetSocketAddress == null) {
      throw new NullPointerException("inetSocketAddress == null");
    }
    this.a = parama;
    this.b = paramProxy;
    this.c = paramInetSocketAddress;
    this.d = paramBoolean;
  }
  
  public a a()
  {
    return this.a;
  }
  
  public Proxy b()
  {
    return this.b;
  }
  
  p c()
  {
    a locala = this.a;
    Proxy localProxy = this.b;
    InetSocketAddress localInetSocketAddress = this.c;
    if (!this.d) {}
    for (boolean bool = true;; bool = false) {
      return new p(locala, localProxy, localInetSocketAddress, bool);
    }
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if ((paramObject instanceof p))
    {
      paramObject = (p)paramObject;
      bool1 = bool2;
      if (this.a.equals(((p)paramObject).a))
      {
        bool1 = bool2;
        if (this.b.equals(((p)paramObject).b))
        {
          bool1 = bool2;
          if (this.c.equals(((p)paramObject).c))
          {
            bool1 = bool2;
            if (this.d == ((p)paramObject).d) {
              bool1 = true;
            }
          }
        }
      }
    }
    return bool1;
  }
  
  public int hashCode()
  {
    int i = this.a.hashCode();
    int j = this.b.hashCode();
    j = this.c.hashCode() + ((i + 527) * 31 + j) * 31;
    if (this.d) {}
    for (i = j * 31;; i = 0) {
      return i + j;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/e/a/p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */