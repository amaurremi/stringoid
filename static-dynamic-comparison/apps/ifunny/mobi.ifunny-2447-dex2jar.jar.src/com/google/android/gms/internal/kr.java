package com.google.android.gms.internal;

import android.content.Context;

final class kr
        implements Runnable {
    kr(Context paramContext, fi paramfi, ku paramku, nd paramnd, String paramString) {
    }

    public void run() {
        mz localmz = mz.a(this.a, new ay(), false, false, null, this.b.k);
        localmz.setWillNotDraw(true);
        this.c.a(localmz);
        nb localnb = localmz.f();
        localnb.a("/invalidRequest", this.c.a);
        localnb.a("/loadAdURL", this.c.b);
        localnb.a("/log", cg.g);
        localnb.a(this.d);
        mx.a("Loading the JS library.");
        localmz.loadUrl(this.e);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/internal/kr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */