package com.google.android.gms.common.images;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Handler;
import android.os.SystemClock;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;
import java.util.concurrent.CountDownLatch;

final class d
        implements Runnable {
    private final Uri b;
    private final Bitmap c;
    private final CountDownLatch d;
    private boolean e;

    public d(ImageManager paramImageManager, Uri paramUri, Bitmap paramBitmap, boolean paramBoolean, CountDownLatch paramCountDownLatch) {
        this.b = paramUri;
        this.c = paramBitmap;
        this.e = paramBoolean;
        this.d = paramCountDownLatch;
    }

    private void a(ImageManager.ImageReceiver paramImageReceiver, boolean paramBoolean) {
        paramImageReceiver = ImageManager.ImageReceiver.a(paramImageReceiver);
        int j = paramImageReceiver.size();
        int i = 0;
        if (i < j) {
            e locale = (e) paramImageReceiver.get(i);
            if (paramBoolean) {
                locale.a(ImageManager.b(this.a), this.c, false);
            }
            for (; ; ) {
                if (!(locale instanceof g)) {
                    ImageManager.a(this.a).remove(locale);
                }
                i += 1;
                break;
                ImageManager.d(this.a).put(this.b, Long.valueOf(SystemClock.elapsedRealtime()));
                locale.a(ImageManager.b(this.a), ImageManager.c(this.a), false);
            }
        }
    }

    public void run() {
        com.google.android.gms.common.internal.b.a("OnBitmapLoadedRunnable must be executed in the main thread");
        boolean bool;
        if (this.c != null) {
            bool = true;
        }
        while (ImageManager.h(this.a) != null) {
            if (this.e) {
                ImageManager.h(this.a).a();
                System.gc();
                this.e = false;
                ImageManager.g(this.a).post(this);
                return;
                bool = false;
            } else if (bool) {
                ImageManager.h(this.a).b(new f(this.b), this.c);
            }
        }
        ???=(ImageManager.ImageReceiver) ImageManager.e(this.a).remove(this.b);
        if (???!=null){
            a((ImageManager.ImageReceiver) ? ??,bool);
        }
        this.d.countDown();
        synchronized (ImageManager.a()) {
            ImageManager.b().remove(this.b);
            return;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/common/images/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */