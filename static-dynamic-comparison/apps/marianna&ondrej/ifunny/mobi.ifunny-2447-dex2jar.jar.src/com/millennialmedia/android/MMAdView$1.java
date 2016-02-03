package com.millennialmedia.android;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;

class MMAdView$1
        implements Runnable {
    MMAdView$1(MMAdView paramMMAdView) {
    }

    public void run() {
        float f = this.a.getContext().getResources().getDisplayMetrics().density;
        if (this.a.d <= 0) {
            this.a.d = ((int) (this.a.getWidth() / f));
        }
        if (this.a.c <= 0) {
            this.a.c = ((int) (this.a.getHeight() / f));
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/millennialmedia/android/MMAdView$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */