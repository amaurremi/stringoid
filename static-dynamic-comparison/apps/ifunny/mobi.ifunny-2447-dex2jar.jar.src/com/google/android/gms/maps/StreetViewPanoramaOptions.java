package com.google.android.gms.maps;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.a.a;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.StreetViewPanoramaCamera;

public final class StreetViewPanoramaOptions
        implements SafeParcelable {
    public static final c CREATOR = new c();
    private final int a;
    private StreetViewPanoramaCamera b;
    private String c;
    private LatLng d;
    private Integer e;
    private Boolean f = Boolean.valueOf(true);
    private Boolean g = Boolean.valueOf(true);
    private Boolean h = Boolean.valueOf(true);
    private Boolean i = Boolean.valueOf(true);
    private Boolean j;

    public StreetViewPanoramaOptions() {
        this.a = 1;
    }

    StreetViewPanoramaOptions(int paramInt, StreetViewPanoramaCamera paramStreetViewPanoramaCamera, String paramString, LatLng paramLatLng, Integer paramInteger, byte paramByte1, byte paramByte2, byte paramByte3, byte paramByte4, byte paramByte5) {
        this.a = paramInt;
        this.b = paramStreetViewPanoramaCamera;
        this.d = paramLatLng;
        this.e = paramInteger;
        this.c = paramString;
        this.f = a.a(paramByte1);
        this.g = a.a(paramByte2);
        this.h = a.a(paramByte3);
        this.i = a.a(paramByte4);
        this.j = a.a(paramByte5);
    }

    int a() {
        return this.a;
    }

    byte b() {
        return a.a(this.f);
    }

    byte c() {
        return a.a(this.g);
    }

    byte d() {
        return a.a(this.h);
    }

    public int describeContents() {
        return 0;
    }

    byte e() {
        return a.a(this.i);
    }

    byte f() {
        return a.a(this.j);
    }

    public StreetViewPanoramaCamera g() {
        return this.b;
    }

    public LatLng h() {
        return this.d;
    }

    public Integer i() {
        return this.e;
    }

    public String j() {
        return this.c;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        c.a(this, paramParcel, paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/maps/StreetViewPanoramaOptions.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */