package com.amazon.device.ads;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantLock;

class hg
        implements Runnable {
    hg(he paramhe, SharedPreferences paramSharedPreferences) {
    }

    public void run() {
        he.a(this.b).lock();
        SharedPreferences.Editor localEditor = this.a.edit();
        localEditor.clear();
        Iterator localIterator = he.b(this.b).entrySet().iterator();
        while (localIterator.hasNext()) {
            Map.Entry localEntry = (Map.Entry) localIterator.next();
            hj localhj = (hj) localEntry.getValue();
            if (!localhj.d) {
                if (localhj.b == String.class) {
                    localEditor.putString((String) localEntry.getKey(), (String) localhj.c);
                } else if (localhj.b == Long.class) {
                    localEditor.putLong((String) localEntry.getKey(), ((Long) localhj.c).longValue());
                } else if (localhj.b == Integer.class) {
                    localEditor.putInt((String) localEntry.getKey(), ((Integer) localhj.c).intValue());
                } else if (localhj.b == Boolean.class) {
                    localEditor.putBoolean((String) localEntry.getKey(), ((Boolean) localhj.c).booleanValue());
                }
            }
        }
        he.a(this.b, localEditor);
        he.a(this.b).unlock();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/amazon/device/ads/hg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */