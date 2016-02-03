package com.amazonaws.org.apache.http.conn.routing;

import com.amazonaws.org.apache.http.HttpHost;
import java.net.InetAddress;
import org.apache.http.annotation.Immutable;

@Immutable
public class BasicRouteDirector
  implements HttpRouteDirector
{
  protected int directStep(RouteInfo paramRouteInfo1, RouteInfo paramRouteInfo2)
  {
    if (paramRouteInfo2.getHopCount() > 1) {}
    while ((!paramRouteInfo1.getTargetHost().equals(paramRouteInfo2.getTargetHost())) || (paramRouteInfo1.isSecure() != paramRouteInfo2.isSecure()) || ((paramRouteInfo1.getLocalAddress() != null) && (!paramRouteInfo1.getLocalAddress().equals(paramRouteInfo2.getLocalAddress())))) {
      return -1;
    }
    return 0;
  }
  
  protected int firstStep(RouteInfo paramRouteInfo)
  {
    int i = 1;
    if (paramRouteInfo.getHopCount() > 1) {
      i = 2;
    }
    return i;
  }
  
  public int nextStep(RouteInfo paramRouteInfo1, RouteInfo paramRouteInfo2)
  {
    if (paramRouteInfo1 == null) {
      throw new IllegalArgumentException("Planned route may not be null.");
    }
    if ((paramRouteInfo2 == null) || (paramRouteInfo2.getHopCount() < 1)) {
      return firstStep(paramRouteInfo1);
    }
    if (paramRouteInfo1.getHopCount() > 1) {
      return proxiedStep(paramRouteInfo1, paramRouteInfo2);
    }
    return directStep(paramRouteInfo1, paramRouteInfo2);
  }
  
  protected int proxiedStep(RouteInfo paramRouteInfo1, RouteInfo paramRouteInfo2)
  {
    if (paramRouteInfo2.getHopCount() <= 1) {}
    label90:
    do
    {
      do
      {
        int j;
        int k;
        do
        {
          do
          {
            return -1;
          } while (!paramRouteInfo1.getTargetHost().equals(paramRouteInfo2.getTargetHost()));
          j = paramRouteInfo1.getHopCount();
          k = paramRouteInfo2.getHopCount();
        } while (j < k);
        int i = 0;
        for (;;)
        {
          if (i >= k - 1) {
            break label90;
          }
          if (!paramRouteInfo1.getHopTarget(i).equals(paramRouteInfo2.getHopTarget(i))) {
            break;
          }
          i += 1;
        }
        if (j > k) {
          return 4;
        }
      } while (((paramRouteInfo2.isTunnelled()) && (!paramRouteInfo1.isTunnelled())) || ((paramRouteInfo2.isLayered()) && (!paramRouteInfo1.isLayered())));
      if ((paramRouteInfo1.isTunnelled()) && (!paramRouteInfo2.isTunnelled())) {
        return 3;
      }
      if ((paramRouteInfo1.isLayered()) && (!paramRouteInfo2.isLayered())) {
        return 5;
      }
    } while (paramRouteInfo1.isSecure() != paramRouteInfo2.isSecure());
    return 0;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/org/apache/http/conn/routing/BasicRouteDirector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */