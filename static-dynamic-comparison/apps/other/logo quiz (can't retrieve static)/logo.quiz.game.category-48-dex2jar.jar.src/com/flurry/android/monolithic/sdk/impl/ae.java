package com.flurry.android.monolithic.sdk.impl;

import com.flurry.android.impl.ads.FlurryAdModule;
import com.flurry.android.impl.ads.avro.protocol.v6.SdkAdEvent;
import com.flurry.android.impl.ads.avro.protocol.v6.SdkAdLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;

public class ae
{
  private final FlurryAdModule a;
  
  public ae(FlurryAdModule paramFlurryAdModule)
  {
    this.a = paramFlurryAdModule;
  }
  
  public List<SdkAdLog> a(List<m> paramList)
  {
    CopyOnWriteArrayList localCopyOnWriteArrayList = new CopyOnWriteArrayList();
    Iterator localIterator1 = paramList.iterator();
    while (localIterator1.hasNext())
    {
      m localm = (m)localIterator1.next();
      SdkAdLog localSdkAdLog = new SdkAdLog();
      localSdkAdLog.a(Long.valueOf(localm.c()));
      Object localObject1;
      if (localm.b() == null)
      {
        localObject1 = "";
        localSdkAdLog.a((CharSequence)localObject1);
        localObject1 = new CopyOnWriteArrayList();
      }
      for (;;)
      {
        Object localObject2;
        SdkAdEvent localSdkAdEvent;
        try
        {
          Iterator localIterator2 = localm.d().iterator();
          if (!localIterator2.hasNext()) {
            break label267;
          }
          localObject2 = (k)localIterator2.next();
          if (!((k)localObject2).b()) {
            continue;
          }
          localSdkAdEvent = new SdkAdEvent();
          localSdkAdEvent.a(((k)localObject2).a());
          localSdkAdEvent.a(Long.valueOf(((k)localObject2).c()));
          Object localObject3 = ((k)localObject2).d();
          localObject2 = new HashMap();
          localObject3 = ((Map)localObject3).entrySet().iterator();
          if (!((Iterator)localObject3).hasNext()) {
            break label248;
          }
          Map.Entry localEntry = (Map.Entry)((Iterator)localObject3).next();
          ((Map)localObject2).put(localEntry.getKey(), localEntry.getValue());
          continue;
          localObject1 = localm.b();
        }
        finally {}
        break;
        label248:
        localSdkAdEvent.a((Map)localObject2);
        ((List)localObject1).add(localSdkAdEvent);
      }
      label267:
      localSdkAdLog.a((List)localObject1);
      localCopyOnWriteArrayList.add(localSdkAdLog);
    }
    this.a.a(paramList);
    return localCopyOnWriteArrayList;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/ae.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */