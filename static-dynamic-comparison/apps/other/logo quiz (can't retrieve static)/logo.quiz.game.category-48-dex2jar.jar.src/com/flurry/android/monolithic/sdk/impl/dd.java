package com.flurry.android.monolithic.sdk.impl;

import android.content.Context;
import com.flurry.android.impl.ads.FlurryAdModule;
import com.flurry.android.impl.ads.avro.protocol.v6.AdUnit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class dd
  implements co
{
  private final List<co> a;
  
  public dd()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new de());
    this.a = Collections.unmodifiableList(localArrayList);
  }
  
  public cn a_(Context paramContext, FlurryAdModule paramFlurryAdModule, m paramm, AdUnit paramAdUnit)
  {
    Object localObject = null;
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      cn localcn = ((co)localIterator.next()).a_(paramContext, paramFlurryAdModule, paramm, paramAdUnit);
      localObject = localcn;
      if (localcn != null) {
        localObject = localcn;
      }
    }
    return (cn)localObject;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/dd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */