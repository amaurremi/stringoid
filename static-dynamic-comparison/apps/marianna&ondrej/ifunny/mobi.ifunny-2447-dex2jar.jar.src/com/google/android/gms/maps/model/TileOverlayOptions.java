package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.model.a.a;

public final class TileOverlayOptions
        implements SafeParcelable {
    public static final aa CREATOR = new aa();
    private final int a;
    private a b;
    private d c;
    private boolean d = true;
    private float e;
    private boolean f = true;

    public TileOverlayOptions() {
        this.a = 1;
    }

    TileOverlayOptions(int paramInt, IBinder paramIBinder, boolean paramBoolean1, float paramFloat, boolean paramBoolean2) {
        this.a = paramInt;
        this.b = com.google.android.gms.maps.model.a.b.a(paramIBinder);
        if (this.b == null) {
        }
        for (paramIBinder = null; ; paramIBinder = new c(this)) {
            this.c = paramIBinder;
            this.d = paramBoolean1;
            this.e = paramFloat;
            this.f = paramBoolean2;
            return;
        }
    }

    int a() {
        return this.a;
    }

    IBinder b() {
        return this.b.asBinder();
    }

    public float c() {
        return this.e;
    }

    public boolean d() {
        return this.d;
    }

    public int describeContents() {
        return 0;
    }

    public boolean e() {
        return this.f;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        if (com.google.android.gms.maps.a.b.a()) {
            ab.a(this, paramParcel, paramInt);
            return;
        }
        aa.a(this, paramParcel, paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/maps/model/TileOverlayOptions.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */