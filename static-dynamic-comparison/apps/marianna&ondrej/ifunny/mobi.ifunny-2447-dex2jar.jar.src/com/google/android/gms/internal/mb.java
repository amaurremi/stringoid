package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

import java.util.Locale;

public class mb
        implements SafeParcelable {
    public static final ra CREATOR = new ra();
    private final int a;
    private final String b;
    private final long c;
    private final short d;
    private final double e;
    private final double f;
    private final float g;
    private final int h;
    private final int i;
    private final int j;

    public mb(int paramInt1, String paramString, int paramInt2, short paramShort, double paramDouble1, double paramDouble2, float paramFloat, long paramLong, int paramInt3, int paramInt4) {
        a(paramString);
        a(paramFloat);
        a(paramDouble1, paramDouble2);
        paramInt2 = a(paramInt2);
        this.a = paramInt1;
        this.d = paramShort;
        this.b = paramString;
        this.e = paramDouble1;
        this.f = paramDouble2;
        this.g = paramFloat;
        this.c = paramLong;
        this.h = paramInt2;
        this.i = paramInt3;
        this.j = paramInt4;
    }

    private static int a(int paramInt) {
        int k = paramInt & 0x7;
        if (k == 0) {
            throw new IllegalArgumentException("No supported transition specified: " + paramInt);
        }
        return k;
    }

    private static void a(double paramDouble1, double paramDouble2) {
        if ((paramDouble1 > 90.0D) || (paramDouble1 < -90.0D)) {
            throw new IllegalArgumentException("invalid latitude: " + paramDouble1);
        }
        if ((paramDouble2 > 180.0D) || (paramDouble2 < -180.0D)) {
            throw new IllegalArgumentException("invalid longitude: " + paramDouble2);
        }
    }

    private static void a(float paramFloat) {
        if (paramFloat <= 0.0F) {
            throw new IllegalArgumentException("invalid radius: " + paramFloat);
        }
    }

    private static void a(String paramString) {
        if ((paramString == null) || (paramString.length() > 100)) {
            throw new IllegalArgumentException("requestId is null or too long: " + paramString);
        }
    }

    private static String b(int paramInt) {
        switch (paramInt) {
            default:
                return null;
        }
        return "CIRCLE";
    }

    public int a() {
        return this.a;
    }

    public short b() {
        return this.d;
    }

    public double c() {
        return this.e;
    }

    public double d() {
        return this.f;
    }

    public int describeContents() {
        ra localra = CREATOR;
        return 0;
    }

    public float e() {
        return this.g;
    }

    public boolean equals(Object paramObject) {
        if (this == paramObject) {
        }
        do {
            return true;
            if (paramObject == null) {
                return false;
            }
            if (!(paramObject instanceof mb)) {
                return false;
            }
            paramObject = (mb) paramObject;
            if (this.g != ((mb) paramObject).g) {
                return false;
            }
            if (this.e != ((mb) paramObject).e) {
                return false;
            }
            if (this.f != ((mb) paramObject).f) {
                return false;
            }
        } while (this.d == ((mb) paramObject).d);
        return false;
    }

    public String f() {
        return this.b;
    }

    public long g() {
        return this.c;
    }

    public int h() {
        return this.h;
    }

    public int hashCode() {
        long l = Double.doubleToLongBits(this.e);
        int k = (int) (l ^ l >>> 32);
        l = Double.doubleToLongBits(this.f);
        return ((((k + 31) * 31 + (int) (l ^ l >>> 32)) * 31 + Float.floatToIntBits(this.g)) * 31 + this.d) * 31 + this.h;
    }

    public int i() {
        return this.i;
    }

    public int j() {
        return this.j;
    }

    public String toString() {
        return String.format(Locale.US, "Geofence[%s id:%s transitions:%d %.6f, %.6f %.0fm, resp=%ds, dwell=%dms, @%d]", new Object[]{b(this.d), this.b, Integer.valueOf(this.h), Double.valueOf(this.e), Double.valueOf(this.f), Float.valueOf(this.g), Integer.valueOf(this.i / 1000), Integer.valueOf(this.j), Long.valueOf(this.c)});
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        ra localra = CREATOR;
        ra.a(this, paramParcel, paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/internal/mb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */