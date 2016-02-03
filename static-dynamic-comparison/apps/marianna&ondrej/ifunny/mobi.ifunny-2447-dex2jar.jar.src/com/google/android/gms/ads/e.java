package com.google.android.gms.ads;

import android.content.Context;
import android.content.res.Resources;
import com.google.android.gms.internal.ay;
import com.google.android.gms.internal.mv;

public final class e {
    public static final e a = new e(320, 50, "320x50_mb");
    public static final e b = new e(468, 60, "468x60_as");
    public static final e c = new e(320, 100, "320x100_as");
    public static final e d = new e(728, 90, "728x90_as");
    public static final e e = new e(300, 250, "300x250_as");
    public static final e f = new e(160, 600, "160x600_as");
    public static final e g = new e(-1, -2, "smart_banner");
    private final int h;
    private final int i;
    private final String j;

    public e(int paramInt1, int paramInt2) {
    }

    e(int paramInt1, int paramInt2, String paramString) {
        if ((paramInt1 < 0) && (paramInt1 != -1)) {
            throw new IllegalArgumentException("Invalid width for AdSize: " + paramInt1);
        }
        if ((paramInt2 < 0) && (paramInt2 != -2)) {
            throw new IllegalArgumentException("Invalid height for AdSize: " + paramInt2);
        }
        this.h = paramInt1;
        this.i = paramInt2;
        this.j = paramString;
    }

    public int a() {
        return this.i;
    }

    public int a(Context paramContext) {
        if (this.i == -2) {
            return ay.b(paramContext.getResources().getDisplayMetrics());
        }
        return mv.a(paramContext, this.i);
    }

    public int b() {
        return this.h;
    }

    public int b(Context paramContext) {
        if (this.h == -1) {
            return ay.a(paramContext.getResources().getDisplayMetrics());
        }
        return mv.a(paramContext, this.h);
    }

    public boolean c() {
        return this.i == -2;
    }

    public boolean d() {
        return this.h == -1;
    }

    public boolean equals(Object paramObject) {
        if (paramObject == this) {
        }
        do {
            return true;
            if (!(paramObject instanceof e)) {
                return false;
            }
            paramObject = (e) paramObject;
        }
        while ((this.h == ((e) paramObject).h) && (this.i == ((e) paramObject).i) && (this.j.equals(((e) paramObject).j)));
        return false;
    }

    public int hashCode() {
        return this.j.hashCode();
    }

    public String toString() {
        return this.j;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/ads/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */