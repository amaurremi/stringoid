package com.millennialmedia.android;

import android.content.Context;

import java.lang.ref.WeakReference;

class VideoAd$VideoIterator
        extends AdCache.Iterator {
    boolean a = false;
    private WeakReference<VideoAd> b;
    private WeakReference<Context> c;

    public VideoAd$VideoIterator(Context paramContext, VideoAd paramVideoAd) {
        this.b = new WeakReference(paramVideoAd);
        this.c = new WeakReference(paramContext);
    }

    void a() {
        if (!this.a) {
            Context localContext = (Context) this.c.get();
            if (localContext != null) {
                a(localContext);
            }
        }
        super.a();
    }

    void a(Context paramContext) {
        VideoAd localVideoAd = (VideoAd) this.b.get();
        if ((localVideoAd != null) && (AdCache.j(paramContext, VideoAd.a(localVideoAd) + "video.dat"))) {
            MMLog.a("VideoAd", String.format("VideoAd video file %s was deleted.", new Object[]{VideoAd.a(localVideoAd)}));
        }
    }

    boolean a(CachedAd paramCachedAd) {
        if ((paramCachedAd != null) && ((paramCachedAd instanceof VideoAd))) {
            VideoAd localVideoAd1 = (VideoAd) paramCachedAd;
            VideoAd localVideoAd2 = (VideoAd) this.b.get();
            if ((localVideoAd2 != null) && (VideoAd.a(localVideoAd1).equals(VideoAd.a(localVideoAd2)))) {
                this.a = true;
            }
        }
        return super.a(paramCachedAd);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/millennialmedia/android/VideoAd$VideoIterator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */