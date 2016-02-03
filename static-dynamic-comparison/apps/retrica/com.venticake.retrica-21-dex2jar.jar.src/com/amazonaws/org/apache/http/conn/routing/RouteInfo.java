package com.amazonaws.org.apache.http.conn.routing;

import com.amazonaws.org.apache.http.HttpHost;
import java.net.InetAddress;

public abstract interface RouteInfo
{
  public abstract int getHopCount();
  
  public abstract HttpHost getHopTarget(int paramInt);
  
  public abstract InetAddress getLocalAddress();
  
  public abstract HttpHost getTargetHost();
  
  public abstract boolean isLayered();
  
  public abstract boolean isSecure();
  
  public abstract boolean isTunnelled();
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/org/apache/http/conn/routing/RouteInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */