package com.millennialmedia.android;

import android.content.Context;

import java.lang.ref.WeakReference;

class AdCacheThreadPool$AdCacheTask
        implements Comparable<AdCacheTask>, Runnable {
    private WeakReference<Context> b;
    private String c;
    private CachedAd d;
    private WeakReference<AdCache.AdCacheTaskListener> e;

    AdCacheThreadPool$AdCacheTask(AdCacheThreadPool paramAdCacheThreadPool, Context paramContext, String paramString, CachedAd paramCachedAd, AdCache.AdCacheTaskListener paramAdCacheTaskListener) {
        this.b = new WeakReference(paramContext.getApplicationContext());
        this.c = paramString;
        this.d = paramCachedAd;
        if (paramAdCacheTaskListener != null) {
            this.e = new WeakReference(paramAdCacheTaskListener);
        }
    }

    public int compareTo(AdCacheTask paramAdCacheTask) {
        return this.d.e - paramAdCacheTask.d.e;
    }

    public boolean equals(Object paramObject) {
        if (this == paramObject) {
            return true;
        }
        if (!(paramObject instanceof AdCacheTask)) {
            return false;
        }
        paramObject = (AdCacheTask) paramObject;
        return this.d.equals(((AdCacheTask) paramObject).d);
    }

    public void run() {
        String str1 = null;
        if (this.e != null) {
        }
        for (AdCache.AdCacheTaskListener localAdCacheTaskListener = (AdCache.AdCacheTaskListener) this.e.get(); ; localAdCacheTaskListener = null) {
            if (localAdCacheTaskListener != null) {
                localAdCacheTaskListener.downloadStart(this.d);
            }
            HandShake.a((Context) this.b.get()).d(this.c);
            boolean bool = this.d.b((Context) this.b.get());
            HandShake.a((Context) this.b.get()).e(this.c);
            Object localObject;
            if (!bool) {
                localObject = AdCache.e((Context) this.b.get(), this.c);
                if ((localObject != null) && (this.d.e().equals(localObject))) {
                    this.d.c((Context) this.b.get());
                    AdCache.b((Context) this.b.get(), this.c, null);
                }
            }
            for (; ; ) {
                if (localAdCacheTaskListener != null) {
                    localAdCacheTaskListener.downloadCompleted(this.d, bool);
                }
                return;
                localObject = (Context) this.b.get();
                String str2 = this.c;
                if (!this.d.f) {
                    str1 = this.d.e();
                }
                AdCache.b((Context) localObject, str2, str1);
                continue;
                AdCache.b((Context) this.b.get(), this.c, null);
            }
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/millennialmedia/android/AdCacheThreadPool$AdCacheTask.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */