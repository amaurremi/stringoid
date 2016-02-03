package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class MarkerOptions
        implements SafeParcelable {
    public static final o CREATOR = new o();
    private final int a;
    private LatLng b;
    private String c;
    private String d;
    private a e;
    private float f = 0.5F;
    private float g = 1.0F;
    private boolean h;
    private boolean i = true;
    private boolean j = false;
    private float k = 0.0F;
    private float l = 0.5F;
    private float m = 0.0F;
    private float n = 1.0F;

    public MarkerOptions() {
        this.a = 1;
    }

    MarkerOptions(int paramInt, LatLng paramLatLng, String paramString1, String paramString2, IBinder paramIBinder, float paramFloat1, float paramFloat2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6) {
        this.a = paramInt;
        this.b = paramLatLng;
        this.c = paramString1;
        this.d = paramString2;
        if (paramIBinder == null) {
        }
        for (paramLatLng = null; ; paramLatLng = new a(com.google.android.gms.b.b.a(paramIBinder))) {
            this.e = paramLatLng;
            this.f = paramFloat1;
            this.g = paramFloat2;
            this.h = paramBoolean1;
            this.i = paramBoolean2;
            this.j = paramBoolean3;
            this.k = paramFloat3;
            this.l = paramFloat4;
            this.m = paramFloat5;
            this.n = paramFloat6;
            return;
        }
    }

    int a() {
        return this.a;
    }

    IBinder b() {
        if (this.e == null) {
            return null;
        }
        return this.e.a().asBinder();
    }

    public LatLng c() {
        return this.b;
    }

    public String d() {
        return this.c;
    }

    public int describeContents() {
        return 0;
    }

    public String e() {
        return this.d;
    }

    public float f() {
        return this.f;
    }

    public float g() {
        return this.g;
    }

    public boolean h() {
        return this.h;
    }

    public boolean i() {
        return this.i;
    }

    public boolean j() {
        return this.j;
    }

    public float k() {
        return this.k;
    }

    public float l() {
        return this.l;
    }

    public float m() {
        return this.m;
    }

    public float n() {
        return this.n;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        if (com.google.android.gms.maps.a.b.a()) {
            p.a(this, paramParcel, paramInt);
            return;
        }
        o.a(this, paramParcel, paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/maps/model/MarkerOptions.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */