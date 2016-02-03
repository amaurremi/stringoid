package com.greystripe.sdk;

import java.util.ArrayList;
import java.util.Iterator;

final class g
  implements Runnable
{
  g(c paramc, GSAd paramGSAd, GSAdErrorCode paramGSAdErrorCode) {}
  
  public final void run()
  {
    Iterator localIterator = c.b(this.c).iterator();
    while (localIterator.hasNext()) {
      ((GSAdListener)localIterator.next()).onFailedToFetchAd(this.a, this.b);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/greystripe/sdk/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */