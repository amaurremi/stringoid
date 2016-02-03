package com.mopub.common;

import java.util.concurrent.Callable;

class d
        implements Callable<Void> {
    d(DiskLruCache paramDiskLruCache) {
    }

    public Void call() {
        synchronized (this.a) {
            if (DiskLruCache.a(this.a) == null) {
                return null;
            }
            DiskLruCache.b(this.a);
            if (DiskLruCache.c(this.a)) {
                DiskLruCache.d(this.a);
                DiskLruCache.a(this.a, 0);
            }
            return null;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/mopub/common/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */