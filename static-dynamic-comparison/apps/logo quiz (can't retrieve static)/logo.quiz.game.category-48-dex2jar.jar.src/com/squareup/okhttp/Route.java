package com.squareup.okhttp;

import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Proxy.Type;

public final class Route
{
  final Address address;
  final InetSocketAddress inetSocketAddress;
  final Proxy proxy;
  final String tlsVersion;
  
  public Route(Address paramAddress, Proxy paramProxy, InetSocketAddress paramInetSocketAddress, String paramString)
  {
    if (paramAddress == null) {
      throw new NullPointerException("address == null");
    }
    if (paramProxy == null) {
      throw new NullPointerException("proxy == null");
    }
    if (paramInetSocketAddress == null) {
      throw new NullPointerException("inetSocketAddress == null");
    }
    if (paramString == null) {
      throw new NullPointerException("tlsVersion == null");
    }
    this.address = paramAddress;
    this.proxy = paramProxy;
    this.inetSocketAddress = paramInetSocketAddress;
    this.tlsVersion = paramString;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if ((paramObject instanceof Route))
    {
      paramObject = (Route)paramObject;
      bool1 = bool2;
      if (this.address.equals(((Route)paramObject).address))
      {
        bool1 = bool2;
        if (this.proxy.equals(((Route)paramObject).proxy))
        {
          bool1 = bool2;
          if (this.inetSocketAddress.equals(((Route)paramObject).inetSocketAddress))
          {
            bool1 = bool2;
            if (this.tlsVersion.equals(((Route)paramObject).tlsVersion)) {
              bool1 = true;
            }
          }
        }
      }
    }
    return bool1;
  }
  
  public Address getAddress()
  {
    return this.address;
  }
  
  public Proxy getProxy()
  {
    return this.proxy;
  }
  
  public InetSocketAddress getSocketAddress()
  {
    return this.inetSocketAddress;
  }
  
  public String getTlsVersion()
  {
    return this.tlsVersion;
  }
  
  public int hashCode()
  {
    return (((this.address.hashCode() + 527) * 31 + this.proxy.hashCode()) * 31 + this.inetSocketAddress.hashCode()) * 31 + this.tlsVersion.hashCode();
  }
  
  public boolean requiresTunnel()
  {
    return (this.address.sslSocketFactory != null) && (this.proxy.type() == Proxy.Type.HTTP);
  }
  
  boolean supportsNpn()
  {
    return !this.tlsVersion.equals("SSLv3");
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/squareup/okhttp/Route.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */