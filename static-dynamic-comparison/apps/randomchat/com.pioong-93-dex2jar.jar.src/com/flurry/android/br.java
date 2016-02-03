package com.flurry.android;

import android.content.Context;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

final class br
  implements bq
{
  private final List<bq> dN;
  
  public br()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new cy());
    this.dN = Collections.unmodifiableList(localArrayList);
  }
  
  public final ao a(Context paramContext, FlurryAds paramFlurryAds, cz paramcz, AdUnit paramAdUnit)
  {
    Object localObject = null;
    Iterator localIterator = this.dN.iterator();
    while (localIterator.hasNext())
    {
      ao localao = ((bq)localIterator.next()).a(paramContext, paramFlurryAds, paramcz, paramAdUnit);
      localObject = localao;
      if (localao != null) {
        localObject = localao;
      }
    }
    return (ao)localObject;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/flurry/android/br.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */