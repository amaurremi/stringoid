package com.google.android.gms.internal;

import android.os.Bundle;

@ii
public class tk {
    private tl a;
    private boolean b;
    private boolean c;

    public tk() {
        Bundle localBundle = lj.m();
        boolean bool1 = bool2;
        if (localBundle != null) {
            bool1 = bool2;
            if (localBundle.getBoolean("gads:block_autoclicks", false)) {
                bool1 = true;
            }
        }
        this.c = bool1;
    }

    public tk(boolean paramBoolean) {
        this.c = paramBoolean;
    }

    public void a() {
        this.b = true;
    }

    public void a(tl paramtl) {
        this.a = paramtl;
    }

    public void a(String paramString) {
        mx.a("Action was blocked because no click was detected.");
        if (this.a != null) {
            this.a.a(paramString);
        }
    }

    public boolean b() {
        return (!this.c) || (this.b);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/internal/tk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */