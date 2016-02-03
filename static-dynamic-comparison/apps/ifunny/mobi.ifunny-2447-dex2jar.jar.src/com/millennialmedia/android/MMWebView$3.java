package com.millennialmedia.android;

import android.graphics.Bitmap;

import java.util.concurrent.Callable;

class MMWebView$3
        implements Callable<Void> {
    MMWebView$3(MMWebView paramMMWebView, MMAdImpl paramMMAdImpl) {
    }

    public Void call() {
        try {
            this.b.buildDrawingCache();
            Bitmap localBitmap = this.b.getDrawingCache();
            if (localBitmap != null) {
                localBitmap = Bitmap.createBitmap(localBitmap);
                this.a.a(localBitmap);
            }
            this.b.destroyDrawingCache();
        } catch (Exception localException) {
            for (; ; ) {
                MMLog.a("MMWebView", "Animation exception: ", localException);
            }
        }
        return null;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/millennialmedia/android/MMWebView$3.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */