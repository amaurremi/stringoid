package com.millennialmedia.android;

import android.content.Context;

import java.lang.ref.WeakReference;

class HandShake$2
        implements Runnable {
    HandShake$2(HandShake paramHandShake) {
    }

    public void run() {
        Context localContext2 = (Context) HandShake.a(this.a).get();
        Context localContext1 = localContext2;
        if (localContext2 == null) {
            localContext1 = (Context) HandShake.b(this.a).get();
        }
        if (localContext1 != null) {
            HandShake.a(localContext1);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/millennialmedia/android/HandShake$2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */