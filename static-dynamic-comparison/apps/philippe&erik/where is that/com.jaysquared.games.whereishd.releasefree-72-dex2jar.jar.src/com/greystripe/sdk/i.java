package com.greystripe.sdk;

import java.util.ArrayList;
import java.util.Iterator;

final class i
  implements Runnable
{
  i(c paramc, GSAd paramGSAd) {}
  
  public final void run()
  {
    Iterator localIterator = c.b(this.b).iterator();
    while (localIterator.hasNext()) {
      ((GSAdListener)localIterator.next()).onAdDismissal(this.a);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/greystripe/sdk/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */