package com.amazonaws.org.apache.http.conn.routing;

import com.amazonaws.org.apache.http.HttpHost;
import com.amazonaws.org.apache.http.util.LangUtils;
import java.net.InetAddress;
import org.apache.http.annotation.Immutable;

@Immutable
public final class HttpRoute
  implements RouteInfo, Cloneable
{
  private static final HttpHost[] EMPTY_HTTP_HOST_ARRAY = new HttpHost[0];
  private final RouteInfo.LayerType layered;
  private final InetAddress localAddress;
  private final HttpHost[] proxyChain;
  private final boolean secure;
  private final HttpHost targetHost;
  private final RouteInfo.TunnelType tunnelled;
  
  public HttpRoute(HttpHost paramHttpHost)
  {
    this(null, paramHttpHost, EMPTY_HTTP_HOST_ARRAY, false, RouteInfo.TunnelType.PLAIN, RouteInfo.LayerType.PLAIN);
  }
  
  public HttpRoute(HttpHost paramHttpHost1, InetAddress paramInetAddress, HttpHost paramHttpHost2, boolean paramBoolean) {}
  
  public HttpRoute(HttpHost paramHttpHost, InetAddress paramInetAddress, boolean paramBoolean)
  {
    this(paramInetAddress, paramHttpHost, EMPTY_HTTP_HOST_ARRAY, paramBoolean, RouteInfo.TunnelType.PLAIN, RouteInfo.LayerType.PLAIN);
  }
  
  public HttpRoute(HttpHost paramHttpHost, InetAddress paramInetAddress, HttpHost[] paramArrayOfHttpHost, boolean paramBoolean, RouteInfo.TunnelType paramTunnelType, RouteInfo.LayerType paramLayerType)
  {
    this(paramInetAddress, paramHttpHost, toChain(paramArrayOfHttpHost), paramBoolean, paramTunnelType, paramLayerType);
  }
  
  private HttpRoute(InetAddress paramInetAddress, HttpHost paramHttpHost, HttpHost[] paramArrayOfHttpHost, boolean paramBoolean, RouteInfo.TunnelType paramTunnelType, RouteInfo.LayerType paramLayerType)
  {
    if (paramHttpHost == null) {
      throw new IllegalArgumentException("Target host may not be null.");
    }
    if (paramArrayOfHttpHost == null) {
      throw new IllegalArgumentException("Proxies may not be null.");
    }
    if ((paramTunnelType == RouteInfo.TunnelType.TUNNELLED) && (paramArrayOfHttpHost.length == 0)) {
      throw new IllegalArgumentException("Proxy required if tunnelled.");
    }
    RouteInfo.TunnelType localTunnelType = paramTunnelType;
    if (paramTunnelType == null) {
      localTunnelType = RouteInfo.TunnelType.PLAIN;
    }
    paramTunnelType = paramLayerType;
    if (paramLayerType == null) {
      paramTunnelType = RouteInfo.LayerType.PLAIN;
    }
    this.targetHost = paramHttpHost;
    this.localAddress = paramInetAddress;
    this.proxyChain = paramArrayOfHttpHost;
    this.secure = paramBoolean;
    this.tunnelled = localTunnelType;
    this.layered = paramTunnelType;
  }
  
  private static HttpHost[] toChain(HttpHost paramHttpHost)
  {
    if (paramHttpHost == null) {
      return EMPTY_HTTP_HOST_ARRAY;
    }
    return new HttpHost[] { paramHttpHost };
  }
  
  private static HttpHost[] toChain(HttpHost[] paramArrayOfHttpHost)
  {
    if ((paramArrayOfHttpHost == null) || (paramArrayOfHttpHost.length < 1)) {
      return EMPTY_HTTP_HOST_ARRAY;
    }
    int j = paramArrayOfHttpHost.length;
    int i = 0;
    while (i < j)
    {
      if (paramArrayOfHttpHost[i] == null) {
        throw new IllegalArgumentException("Proxy chain may not contain null elements.");
      }
      i += 1;
    }
    HttpHost[] arrayOfHttpHost = new HttpHost[paramArrayOfHttpHost.length];
    System.arraycopy(paramArrayOfHttpHost, 0, arrayOfHttpHost, 0, paramArrayOfHttpHost.length);
    return arrayOfHttpHost;
  }
  
  public Object clone()
  {
    return super.clone();
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof HttpRoute)) {
        break;
      }
      paramObject = (HttpRoute)paramObject;
    } while ((this.secure == ((HttpRoute)paramObject).secure) && (this.tunnelled == ((HttpRoute)paramObject).tunnelled) && (this.layered == ((HttpRoute)paramObject).layered) && (LangUtils.equals(this.targetHost, ((HttpRoute)paramObject).targetHost)) && (LangUtils.equals(this.localAddress, ((HttpRoute)paramObject).localAddress)) && (LangUtils.equals(this.proxyChain, ((HttpRoute)paramObject).proxyChain)));
    return false;
    return false;
  }
  
  public final int getHopCount()
  {
    return this.proxyChain.length + 1;
  }
  
  public final HttpHost getHopTarget(int paramInt)
  {
    if (paramInt < 0) {
      throw new IllegalArgumentException("Hop index must not be negative: " + paramInt);
    }
    int i = getHopCount();
    if (paramInt >= i) {
      throw new IllegalArgumentException("Hop index " + paramInt + " exceeds route length " + i);
    }
    if (paramInt < i - 1) {
      return this.proxyChain[paramInt];
    }
    return this.targetHost;
  }
  
  public final InetAddress getLocalAddress()
  {
    return this.localAddress;
  }
  
  public final HttpHost getProxyHost()
  {
    if (this.proxyChain.length == 0) {
      return null;
    }
    return this.proxyChain[0];
  }
  
  public final HttpHost getTargetHost()
  {
    return this.targetHost;
  }
  
  public final int hashCode()
  {
    int j = LangUtils.hashCode(LangUtils.hashCode(17, this.targetHost), this.localAddress);
    int i = 0;
    while (i < this.proxyChain.length)
    {
      j = LangUtils.hashCode(j, this.proxyChain[i]);
      i += 1;
    }
    return LangUtils.hashCode(LangUtils.hashCode(LangUtils.hashCode(j, this.secure), this.tunnelled), this.layered);
  }
  
  public final boolean isLayered()
  {
    return this.layered == RouteInfo.LayerType.LAYERED;
  }
  
  public final boolean isSecure()
  {
    return this.secure;
  }
  
  public final boolean isTunnelled()
  {
    return this.tunnelled == RouteInfo.TunnelType.TUNNELLED;
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(getHopCount() * 30 + 50);
    if (this.localAddress != null)
    {
      localStringBuilder.append(this.localAddress);
      localStringBuilder.append("->");
    }
    localStringBuilder.append('{');
    if (this.tunnelled == RouteInfo.TunnelType.TUNNELLED) {
      localStringBuilder.append('t');
    }
    if (this.layered == RouteInfo.LayerType.LAYERED) {
      localStringBuilder.append('l');
    }
    if (this.secure) {
      localStringBuilder.append('s');
    }
    localStringBuilder.append("}->");
    HttpHost[] arrayOfHttpHost = this.proxyChain;
    int j = arrayOfHttpHost.length;
    int i = 0;
    while (i < j)
    {
      localStringBuilder.append(arrayOfHttpHost[i]);
      localStringBuilder.append("->");
      i += 1;
    }
    localStringBuilder.append(this.targetHost);
    return localStringBuilder.toString();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/org/apache/http/conn/routing/HttpRoute.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */