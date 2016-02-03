package com.google.android.gms.internal;

import android.view.View;
import com.google.android.gms.b.d;

@ii
public final class ht
        extends hv {
    private final a a;
    private final String b;
    private final String c;

    public ht(a parama, String paramString1, String paramString2) {
        this.a = parama;
        this.b = paramString1;
        this.c = paramString2;
    }

    public String a() {
        return this.b;
    }

    public void a(com.google.android.gms.b.a parama) {
        if (parama == null) {
            return;
        }
        this.a.a((View) d.a(parama));
    }

    public String b() {
        return this.c;
    }

    public void c() {
        this.a.a();
    }

    public void d() {
        this.a.b();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/internal/ht.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */