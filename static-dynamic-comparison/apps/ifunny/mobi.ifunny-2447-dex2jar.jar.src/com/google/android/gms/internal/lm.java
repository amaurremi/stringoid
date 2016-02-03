package com.google.android.gms.internal;

import android.os.Bundle;

@ii
public class lm {
    private final Object a = new Object();
    private int b;
    private int c;
    private final lj d;
    private final String e;

    lm(lj paramlj, String paramString) {
        this.d = paramlj;
        this.e = paramString;
    }

    public lm(String paramString) {
        this(lj.a(), paramString);
    }

    public Bundle a() {
        synchronized (this.a) {
            Bundle localBundle = new Bundle();
            localBundle.putInt("pmnli", this.b);
            localBundle.putInt("pmnll", this.c);
            return localBundle;
        }
    }

    public void a(int paramInt1, int paramInt2) {
        synchronized (this.a) {
            this.b = paramInt1;
            this.c = paramInt2;
            this.d.a(this.e, this);
            return;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/internal/lm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */