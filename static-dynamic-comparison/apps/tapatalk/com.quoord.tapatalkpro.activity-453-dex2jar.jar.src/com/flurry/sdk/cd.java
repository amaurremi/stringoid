package com.flurry.sdk;

import com.flurry.android.impl.ads.avro.protocol.v10.SdkAdEvent;
import com.flurry.android.impl.ads.avro.protocol.v10.SdkAdLog;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class cd {
    public static List<SdkAdLog> a(List<e> paramList) {
        ArrayList localArrayList = new ArrayList();
        if (paramList == null) {
            return localArrayList;
        }
        Iterator localIterator1 = paramList.iterator();
        while (localIterator1.hasNext()) {
            e locale = (e) localIterator1.next();
            SdkAdLog localSdkAdLog = new SdkAdLog();
            localSdkAdLog.a(Long.valueOf(locale.c()));
            if (locale.b() == null) {
                paramList = "";
                localSdkAdLog.a(paramList);
                paramList = new ArrayList();
            }
            for (; ; ) {
                Object localObject1;
                SdkAdEvent localSdkAdEvent;
                try {
                    Iterator localIterator2 = locale.d().iterator();
                    if (!localIterator2.hasNext()) {
                        break label269;
                    }
                    localObject1 = (c) localIterator2.next();
                    if (!((c) localObject1).b()) {
                        continue;
                    }
                    localSdkAdEvent = new SdkAdEvent();
                    localSdkAdEvent.a(((c) localObject1).a());
                    localSdkAdEvent.a(Long.valueOf(((c) localObject1).c()));
                    Object localObject2 = ((c) localObject1).d();
                    localObject1 = new HashMap();
                    localObject2 = ((Map) localObject2).entrySet().iterator();
                    if (!((Iterator) localObject2).hasNext()) {
                        break label250;
                    }
                    Map.Entry localEntry = (Map.Entry) ((Iterator) localObject2).next();
                    ((Map) localObject1).put(localEntry.getKey(), localEntry.getValue());
                    continue;
                    paramList = locale.b();
                } finally {
                }
                break;
                label250:
                localSdkAdEvent.a((Map) localObject1);
                paramList.add(localSdkAdEvent);
            }
            label269:
            localSdkAdLog.a(paramList);
            localArrayList.add(localSdkAdLog);
        }
        return localArrayList;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/flurry/sdk/cd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */