package com.squareup.okhttp.internal.http;

import com.squareup.okhttp.Address;
import com.squareup.okhttp.Connection;
import com.squareup.okhttp.ConnectionPool;
import com.squareup.okhttp.Route;
import com.squareup.okhttp.internal.Dns;
import com.squareup.okhttp.internal.Internal;
import com.squareup.okhttp.internal.RouteDatabase;
import com.squareup.okhttp.internal.Util;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Proxy.Type;
import java.net.ProxySelector;
import java.net.Socket;
import java.net.URI;
import java.net.UnknownHostException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLProtocolException;

public final class RouteSelector
{
  public static final String SSL_V3 = "SSLv3";
  public static final String TLS_V1 = "TLSv1";
  private final Address address;
  private final Dns dns;
  private boolean hasNextProxy;
  private InetSocketAddress lastInetSocketAddress;
  private Proxy lastProxy;
  private int nextSocketAddressIndex;
  private String nextTlsVersion;
  private final ConnectionPool pool;
  private final List<Route> postponedRoutes;
  private final ProxySelector proxySelector;
  private Iterator<Proxy> proxySelectorProxies;
  private final RouteDatabase routeDatabase;
  private InetAddress[] socketAddresses;
  private int socketPort;
  private final URI uri;
  private Proxy userSpecifiedProxy;
  
  public RouteSelector(Address paramAddress, URI paramURI, ProxySelector paramProxySelector, ConnectionPool paramConnectionPool, Dns paramDns, RouteDatabase paramRouteDatabase)
  {
    this.address = paramAddress;
    this.uri = paramURI;
    this.proxySelector = paramProxySelector;
    this.pool = paramConnectionPool;
    this.dns = paramDns;
    this.routeDatabase = paramRouteDatabase;
    this.postponedRoutes = new LinkedList();
    resetNextProxy(paramURI, paramAddress.getProxy());
  }
  
  private boolean hasNextInetSocketAddress()
  {
    return this.socketAddresses != null;
  }
  
  private boolean hasNextPostponed()
  {
    return !this.postponedRoutes.isEmpty();
  }
  
  private boolean hasNextProxy()
  {
    return this.hasNextProxy;
  }
  
  private boolean hasNextTlsVersion()
  {
    return this.nextTlsVersion != null;
  }
  
  private InetSocketAddress nextInetSocketAddress()
    throws UnknownHostException
  {
    Object localObject = this.socketAddresses;
    int i = this.nextSocketAddressIndex;
    this.nextSocketAddressIndex = (i + 1);
    localObject = new InetSocketAddress(localObject[i], this.socketPort);
    if (this.nextSocketAddressIndex == this.socketAddresses.length)
    {
      this.socketAddresses = null;
      this.nextSocketAddressIndex = 0;
    }
    return (InetSocketAddress)localObject;
  }
  
  private Route nextPostponed()
  {
    return (Route)this.postponedRoutes.remove(0);
  }
  
  private Proxy nextProxy()
  {
    if (this.userSpecifiedProxy != null)
    {
      this.hasNextProxy = false;
      return this.userSpecifiedProxy;
    }
    if (this.proxySelectorProxies != null) {
      while (this.proxySelectorProxies.hasNext())
      {
        Proxy localProxy = (Proxy)this.proxySelectorProxies.next();
        if (localProxy.type() != Proxy.Type.DIRECT) {
          return localProxy;
        }
      }
    }
    this.hasNextProxy = false;
    return Proxy.NO_PROXY;
  }
  
  private String nextTlsVersion()
  {
    if (this.nextTlsVersion == null) {
      throw new IllegalStateException("No next TLS version");
    }
    if (this.nextTlsVersion.equals("TLSv1"))
    {
      this.nextTlsVersion = "SSLv3";
      return "TLSv1";
    }
    if (this.nextTlsVersion.equals("SSLv3"))
    {
      this.nextTlsVersion = null;
      return "SSLv3";
    }
    throw new AssertionError();
  }
  
  private void resetNextInetSocketAddress(Proxy paramProxy)
    throws UnknownHostException
  {
    this.socketAddresses = null;
    if (paramProxy.type() == Proxy.Type.DIRECT) {
      paramProxy = this.uri.getHost();
    }
    InetSocketAddress localInetSocketAddress;
    for (this.socketPort = Util.getEffectivePort(this.uri);; this.socketPort = localInetSocketAddress.getPort())
    {
      this.socketAddresses = this.dns.getAllByName(paramProxy);
      this.nextSocketAddressIndex = 0;
      return;
      paramProxy = paramProxy.address();
      if (!(paramProxy instanceof InetSocketAddress)) {
        throw new IllegalArgumentException("Proxy.address() is not an InetSocketAddress: " + paramProxy.getClass());
      }
      localInetSocketAddress = (InetSocketAddress)paramProxy;
      paramProxy = localInetSocketAddress.getHostName();
    }
  }
  
  private void resetNextProxy(URI paramURI, Proxy paramProxy)
  {
    this.hasNextProxy = true;
    if (paramProxy != null) {
      this.userSpecifiedProxy = paramProxy;
    }
    do
    {
      return;
      paramURI = this.proxySelector.select(paramURI);
    } while (paramURI == null);
    this.proxySelectorProxies = paramURI.iterator();
  }
  
  private void resetNextTlsVersion()
  {
    if (this.address.getSslSocketFactory() != null) {}
    for (String str = "TLSv1";; str = "SSLv3")
    {
      this.nextTlsVersion = str;
      return;
    }
  }
  
  public void connectFailed(Connection paramConnection, IOException paramIOException)
  {
    if (Internal.instance.recycleCount(paramConnection) > 0) {}
    for (;;)
    {
      return;
      paramConnection = paramConnection.getRoute();
      if ((paramConnection.getProxy().type() != Proxy.Type.DIRECT) && (this.proxySelector != null)) {
        this.proxySelector.connectFailed(this.uri, paramConnection.getProxy().address(), paramIOException);
      }
      this.routeDatabase.failed(paramConnection);
      if ((!(paramIOException instanceof SSLHandshakeException)) && (!(paramIOException instanceof SSLProtocolException))) {
        while (hasNextTlsVersion())
        {
          paramConnection = new Route(this.address, this.lastProxy, this.lastInetSocketAddress, nextTlsVersion());
          this.routeDatabase.failed(paramConnection);
        }
      }
    }
  }
  
  public boolean hasNext()
  {
    return (hasNextTlsVersion()) || (hasNextInetSocketAddress()) || (hasNextProxy()) || (hasNextPostponed());
  }
  
  public Connection next(String paramString)
    throws IOException
  {
    for (;;)
    {
      localObject = this.pool.get(this.address);
      if (localObject == null) {
        break;
      }
      if ((paramString.equals("GET")) || (Internal.instance.isReadable((Connection)localObject))) {
        return (Connection)localObject;
      }
      ((Connection)localObject).getSocket().close();
    }
    if (!hasNextTlsVersion())
    {
      if (!hasNextInetSocketAddress())
      {
        if (!hasNextProxy())
        {
          if (!hasNextPostponed()) {
            throw new NoSuchElementException();
          }
          return new Connection(this.pool, nextPostponed());
        }
        this.lastProxy = nextProxy();
        resetNextInetSocketAddress(this.lastProxy);
      }
      this.lastInetSocketAddress = nextInetSocketAddress();
      resetNextTlsVersion();
    }
    Object localObject = nextTlsVersion();
    localObject = new Route(this.address, this.lastProxy, this.lastInetSocketAddress, (String)localObject);
    if (this.routeDatabase.shouldPostpone((Route)localObject))
    {
      this.postponedRoutes.add(localObject);
      return next(paramString);
    }
    return new Connection(this.pool, (Route)localObject);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/squareup/okhttp/internal/http/RouteSelector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */