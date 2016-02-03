package com.google.android.gms.internal;

import android.graphics.drawable.Drawable;
import com.google.android.gms.b.a;
import com.google.android.gms.b.d;

@ii
public class bu
        extends bz
        implements bx {
    private final String a;
    private final Drawable b;
    private final String c;
    private final Drawable d;
    private final String e;
    private final double f;
    private final String g;
    private final String h;
    private final Object i = new Object();
    private bw j;

    public bu(String paramString1, Drawable paramDrawable1, String paramString2, Drawable paramDrawable2, String paramString3, double paramDouble, String paramString4, String paramString5) {
        this.a = paramString1;
        this.b = paramDrawable1;
        this.c = paramString2;
        this.d = paramDrawable2;
        this.e = paramString3;
        this.f = paramDouble;
        this.g = paramString4;
        this.h = paramString5;
    }

    public String a() {
        return this.a;
    }

    public void a(int paramInt) {
        synchronized (this.i) {
            if (this.j == null) {
                mx.b("Attempt to perform click before app install ad initialized.");
                return;
            }
            this.j.a("2", paramInt);
            return;
        }
    }

    public void a(bw parambw) {
        synchronized (this.i) {
            this.j = parambw;
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

    public double f() {
        return this.f;
    }

    public String g() {
        return this.g;
    }

    public String h() {
        return this.h;
    }

    public void i() {
        synchronized (this.i) {
            if (this.j == null) {
                mx.b("Attempt to record impression before app install ad initialized.");
                return;
            }
            this.j.a();
            return;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/internal/bu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */