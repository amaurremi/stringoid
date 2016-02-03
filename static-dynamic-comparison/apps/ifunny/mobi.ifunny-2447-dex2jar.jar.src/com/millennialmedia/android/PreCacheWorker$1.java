package com.millennialmedia.android;

class PreCacheWorker$1
        implements AdCache.AdCacheTaskListener {
    PreCacheWorker$1(PreCacheWorker paramPreCacheWorker, DTOCachedVideo paramDTOCachedVideo) {
    }

    public void downloadCompleted(CachedAd paramCachedAd, boolean paramBoolean) {
        if (paramBoolean) {
        }
        for (; ; ) {
            try {
                AdCache.a(PreCacheWorker.a(this.b), paramCachedAd);
                PreCacheWorker.a(this.b, true);
                MMSDK.Event.a(this.a.c);
                notify();
                return;
            } finally {
            }
            MMSDK.Event.a(this.a.b);
        }
    }

    public void downloadStart(CachedAd paramCachedAd) {
        MMSDK.Event.a(this.a.a);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/millennialmedia/android/PreCacheWorker$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */