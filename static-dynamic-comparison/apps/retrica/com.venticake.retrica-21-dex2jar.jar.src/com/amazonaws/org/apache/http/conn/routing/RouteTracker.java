package com.amazonaws.org.apache.http.conn.routing;

import com.amazonaws.org.apache.http.HttpHost;
import com.amazonaws.org.apache.http.util.LangUtils;
import java.net.InetAddress;
import org.apache.http.annotation.NotThreadSafe;

@NotThreadSafe
public final class RouteTracker
  implements RouteInfo, Cloneable
{
  private boolean connected;
  private RouteInfo.LayerType layered;
  private final InetAddress localAddress;
  private HttpHost[] proxyChain;
  private boolean secure;
  private final HttpHost targetHost;
  private RouteInfo.TunnelType tunnelled;
  
  public RouteTracker(HttpHost paramHttpHost, InetAddress paramInetAddress)
  {
    if (paramHttpHost == null) {
      throw new IllegalArgumentException("Target host may not be null.");
    }
    this.targetHost = paramHttpHost;
    this.localAddress = paramInetAddress;
    this.tunnelled = RouteInfo.TunnelType.PLAIN;
    this.layered = RouteInfo.LayerType.PLAIN;
  }
  
  public RouteTracker(HttpRoute paramHttpRoute)
  {
    this(paramHttpRoute.getTargetHost(), paramHttpRoute.getLocalAddress());
  }
  
  public Object clone()
  {
    return super.clone();
  }
  
  public final void connectProxy(HttpHost paramHttpHost, boolean paramBoolean)
  {
    if (paramHttpHost == null) {
      throw new IllegalArgumentException("Proxy host may not be null.");
    }
    if (this.connected) {
      throw new IllegalStateException("Already connected.");
    }
    this.connected = true;
    this.proxyChain = new HttpHost[] { paramHttpHost };
    this.secure = paramBoolean;
  }
  
  public final void connectTarget(boolean paramBoolean)
  {
    if (this.connected) {
      throw new IllegalStateException("Already connected.");
    }
    this.connected = true;
    this.secure = paramBoolean;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject == this) {}
    do
    {
      return true;
      if (!(paramObject instanceof RouteTracker)) {
        return false;
      }
      paramObject = (RouteTracker)paramObject;
    } while ((this.connected == ((RouteTracker)paramObject).connected) && (this.secure == ((RouteTracker)paramObject).secure) && (this.tunnelled == ((RouteTracker)paramObject).tunnelled) && (this.layered == ((RouteTracker)paramObject).layered) && (LangUtils.equals(this.targetHost, ((RouteTracker)paramObject).targetHost)) && (LangUtils.equals(this.localAddress, ((RouteTracker)paramObject).localAddress)) && (LangUtils.equals(this.proxyChain, ((RouteTracker)paramObject).proxyChain)));
    return false;
  }
  
  public final int getHopCount()
  {
    int i = 0;
    if (this.connected)
    {
      if (this.proxyChain == null) {
        i = 1;
      }
    }
    else {
      return i;
    }
    return this.proxyChain.length + 1;
  }
  
  public final HttpHost getHopTarget(int paramInt)
  {
    if (paramInt < 0) {
      throw new IllegalArgumentException("Hop index must not be negative: " + paramInt);
    }
    int i = getHopCount();
    if (paramInt >= i) {
      throw new IllegalArgumentException("Hop index " + paramInt + " exceeds tracked route length " + i + ".");
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
  
  public final HttpHost getTargetHost()
  {
    return this.targetHost;
  }
  
  public final int hashCode()
  {
    int i = LangUtils.hashCode(LangUtils.hashCode(17, this.targetHost), this.localAddress);
    int k = i;
    if (this.proxyChain != null)
    {
      int j = 0;
      for (;;)
      {
        k = i;
        if (j >= this.proxyChain.length) {
          break;
        }
        i = LangUtils.hashCode(i, this.proxyChain[j]);
        j += 1;
      }
    }
    return LangUtils.hashCode(LangUtils.hashCode(LangUtils.hashCode(LangUtils.hashCode(k, this.connected), this.secure), this.tunnelled), this.layered);
  }
  
  public final boolean isConnected()
  {
    return this.connected;
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
  
  public final void layerProtocol(boolean paramBoolean)
  {
    if (!this.connected) {
      throw new IllegalStateException("No layered protocol unless connected.");
    }
    this.layered = RouteInfo.LayerType.LAYERED;
    this.secure = paramBoolean;
  }
  
  public void reset()
  {
    this.connected = false;
    this.proxyChain = null;
    this.tunnelled = RouteInfo.TunnelType.PLAIN;
    this.layered = RouteInfo.LayerType.PLAIN;
    this.secure = false;
  }
  
  public final HttpRoute toRoute()
  {
    if (!this.connected) {
      return null;
    }
    return new HttpRoute(this.targetHost, this.localAddress, this.proxyChain, this.secure, this.tunnelled, this.layered);
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(getHopCount() * 30 + 50);
    localStringBuilder.append("RouteTracker[");
    if (this.localAddress != null)
    {
      localStringBuilder.append(this.localAddress);
      localStringBuilder.append("->");
    }
    localStringBuilder.append('{');
    if (this.connected) {
      localStringBuilder.append('c');
    }
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
    if (this.proxyChain != null)
    {
      int i = 0;
      while (i < this.proxyChain.length)
      {
        localStringBuilder.append(this.proxyChain[i]);
        localStringBuilder.append("->");
        i += 1;
      }
    }
    localStringBuilder.append(this.targetHost);
    localStringBuilder.append(']');
    return localStringBuilder.toString();
  }
  
  public final void tunnelProxy(HttpHost paramHttpHost, boolean paramBoolean)
  {
    if (paramHttpHost == null) {
      throw new IllegalArgumentException("Proxy host may not be null.");
    }
    if (!this.connected) {
      throw new IllegalStateException("No tunnel unless connected.");
    }
    if (this.proxyChain == null) {
      throw new IllegalStateException("No proxy tunnel without proxy.");
    }
    HttpHost[] arrayOfHttpHost = new HttpHost[this.proxyChain.length + 1];
    System.arraycopy(this.proxyChain, 0, arrayOfHttpHost, 0, this.proxyChain.length);
    arrayOfHttpHost[(arrayOfHttpHost.length - 1)] = paramHttpHost;
    this.proxyChain = arrayOfHttpHost;
    this.secure = paramBoolean;
  }
  
  public final void tunnelTarget(boolean paramBoolean)
  {
    if (!this.connected) {
      throw new IllegalStateException("No tunnel unless connected.");
    }
    if (this.proxyChain == null) {
      throw new IllegalStateException("No tunnel without proxy.");
    }
    this.tunnelled = RouteInfo.TunnelType.TUNNELLED;
    this.secure = paramBoolean;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/org/apache/http/conn/routing/RouteTracker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */