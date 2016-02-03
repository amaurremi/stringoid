package com.squareup.okhttp;

import com.squareup.okhttp.internal.Util;
import java.net.Proxy;
import java.net.UnknownHostException;
import java.util.List;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;

public final class Address
{
  final Authenticator authenticator;
  final HostnameVerifier hostnameVerifier;
  final List<Protocol> protocols;
  final Proxy proxy;
  final SocketFactory socketFactory;
  final SSLSocketFactory sslSocketFactory;
  final String uriHost;
  final int uriPort;
  
  public Address(String paramString, int paramInt, SocketFactory paramSocketFactory, SSLSocketFactory paramSSLSocketFactory, HostnameVerifier paramHostnameVerifier, Authenticator paramAuthenticator, Proxy paramProxy, List<Protocol> paramList)
    throws UnknownHostException
  {
    if (paramString == null) {
      throw new NullPointerException("uriHost == null");
    }
    if (paramInt <= 0) {
      throw new IllegalArgumentException("uriPort <= 0: " + paramInt);
    }
    if (paramAuthenticator == null) {
      throw new IllegalArgumentException("authenticator == null");
    }
    if (paramList == null) {
      throw new IllegalArgumentException("protocols == null");
    }
    this.proxy = paramProxy;
    this.uriHost = paramString;
    this.uriPort = paramInt;
    this.socketFactory = paramSocketFactory;
    this.sslSocketFactory = paramSSLSocketFactory;
    this.hostnameVerifier = paramHostnameVerifier;
    this.authenticator = paramAuthenticator;
    this.protocols = Util.immutableList(paramList);
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if ((paramObject instanceof Address))
    {
      paramObject = (Address)paramObject;
      bool1 = bool2;
      if (Util.equal(this.proxy, ((Address)paramObject).proxy))
      {
        bool1 = bool2;
        if (this.uriHost.equals(((Address)paramObject).uriHost))
        {
          bool1 = bool2;
          if (this.uriPort == ((Address)paramObject).uriPort)
          {
            bool1 = bool2;
            if (Util.equal(this.sslSocketFactory, ((Address)paramObject).sslSocketFactory))
            {
              bool1 = bool2;
              if (Util.equal(this.hostnameVerifier, ((Address)paramObject).hostnameVerifier))
              {
                bool1 = bool2;
                if (Util.equal(this.authenticator, ((Address)paramObject).authenticator))
                {
                  bool1 = bool2;
                  if (Util.equal(this.protocols, ((Address)paramObject).protocols)) {
                    bool1 = true;
                  }
                }
              }
            }
          }
        }
      }
    }
    return bool1;
  }
  
  public Authenticator getAuthenticator()
  {
    return this.authenticator;
  }
  
  public HostnameVerifier getHostnameVerifier()
  {
    return this.hostnameVerifier;
  }
  
  public List<Protocol> getProtocols()
  {
    return this.protocols;
  }
  
  public Proxy getProxy()
  {
    return this.proxy;
  }
  
  public SocketFactory getSocketFactory()
  {
    return this.socketFactory;
  }
  
  public SSLSocketFactory getSslSocketFactory()
  {
    return this.sslSocketFactory;
  }
  
  public String getUriHost()
  {
    return this.uriHost;
  }
  
  public int getUriPort()
  {
    return this.uriPort;
  }
  
  public int hashCode()
  {
    int k = 0;
    int m = this.uriHost.hashCode();
    int n = this.uriPort;
    int i;
    if (this.sslSocketFactory != null)
    {
      i = this.sslSocketFactory.hashCode();
      if (this.hostnameVerifier == null) {
        break label123;
      }
    }
    label123:
    for (int j = this.hostnameVerifier.hashCode();; j = 0)
    {
      int i1 = this.authenticator.hashCode();
      if (this.proxy != null) {
        k = this.proxy.hashCode();
      }
      return ((((((m + 527) * 31 + n) * 31 + i) * 31 + j) * 31 + i1) * 31 + k) * 31 + this.protocols.hashCode();
      i = 0;
      break;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/squareup/okhttp/Address.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */