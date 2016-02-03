package com.flurry.android;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;

final class ag
{
  private FlurryAds by;
  
  ag(FlurryAds paramFlurryAds)
  {
    this.by = paramFlurryAds;
  }
  
  final List<SdkAdLog> a(List<cz> paramList)
  {
    CopyOnWriteArrayList localCopyOnWriteArrayList1 = new CopyOnWriteArrayList();
    Iterator localIterator1 = paramList.iterator();
    while (localIterator1.hasNext())
    {
      cz localcz = (cz)localIterator1.next();
      SdkAdLog localSdkAdLog = new SdkAdLog();
      localSdkAdLog.b(Long.valueOf(localcz.au()));
      localSdkAdLog.c(localcz.at());
      CopyOnWriteArrayList localCopyOnWriteArrayList2 = new CopyOnWriteArrayList();
      for (;;)
      {
        SdkAdEvent localSdkAdEvent;
        try
        {
          Iterator localIterator2 = localcz.av().iterator();
          if (!localIterator2.hasNext()) {
            break;
          }
          Object localObject1 = (bu)localIterator2.next();
          if (!((bu)localObject1).ai()) {
            continue;
          }
          localSdkAdEvent = new SdkAdEvent();
          localSdkAdEvent.a(((bu)localObject1).getType());
          localSdkAdEvent.a(Long.valueOf(((bu)localObject1).M()));
          Object localObject2 = ((bu)localObject1).getParams();
          localObject1 = new HashMap();
          localObject2 = ((Map)localObject2).entrySet().iterator();
          if (((Iterator)localObject2).hasNext())
          {
            Map.Entry localEntry = (Map.Entry)((Iterator)localObject2).next();
            ((Map)localObject1).put(localEntry.getKey(), localEntry.getValue());
            continue;
          }
          localSdkAdEvent.a((Map)localObject1);
        }
        finally {}
        localCopyOnWriteArrayList2.add(localSdkAdEvent);
      }
      localSdkAdLog.g(localCopyOnWriteArrayList2);
      localCopyOnWriteArrayList1.add(localSdkAdLog);
    }
    this.by.d(paramList);
    return localCopyOnWriteArrayList1;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/flurry/android/ag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */