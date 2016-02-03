package com.facebook;

import com.facebook.internal.Utility;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

final class AppEventsLogger$4
        implements Runnable {
    public void run() {
        HashSet localHashSet = new HashSet();
        synchronized (AppEventsLogger.access$400()) {
            Iterator localIterator = AppEventsLogger.access$500().keySet().iterator();
            if (localIterator.hasNext()) {
                localHashSet.add(((AppEventsLogger.AccessTokenAppIdPair) localIterator.next()).getApplicationId());
            }
        }
        ???=((Set) localObject2).iterator();
        while (((Iterator) ? ??).hasNext()){
            Utility.queryAppSettings((String) ((Iterator) ? ? ?).next(), true);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/facebook/AppEventsLogger$4.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */