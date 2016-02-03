package com.google.android.gms.internal;

import android.graphics.drawable.Drawable;
import com.google.android.gms.b.a;
import com.google.android.gms.b.d;

@ii
public class bv
        extends cb
        implements bx {
    private final String a;
    private final Drawable b;
    private final String c;
    private final Drawable d;
    private final String e;
    private final String f;
    private final Object g = new Object();
    private bw h;

    public bv(String paramString1, Drawable paramDrawable1, String paramString2, Drawable paramDrawable2, String paramString3, String paramString4) {
        this.a = paramString1;
        this.b = paramDrawable1;
        this.c = paramString2;
        this.d = paramDrawable2;
        this.e = paramString3;
        this.f = paramString4;
    }

    public String a() {
        return this.a;
    }

    public void a(int paramInt) {
        synchronized (this.g) {
            if (this.h == null) {
                mx.b("Attempt to perform click before content ad initialized.");
                return;
            }
            this.h.a("1", paramInt);
            return;
        }
    }

    public void a(bw parambw) {
        synchronized (this.g) {
            this.h = parambw;
            return;
        }
    }

    public a b() {
        return d.a(this.b);
    }

    public String c() {
        return this.c;
    }

    public a d() {
        return d.a(this.d);
    }

    public String e() {
        return this.e;
    }

    public String f() {
        return this.f;
    }

    public void g() {
        synchronized (this.g) {
            if (this.h == null) {
                mx.b("Attempt to record impression before content ad initialized.");
                return;
            }
            this.h.a();
            return;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/internal/bv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */