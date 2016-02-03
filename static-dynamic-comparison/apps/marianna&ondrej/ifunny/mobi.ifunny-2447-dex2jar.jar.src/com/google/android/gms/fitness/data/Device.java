package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.ad;
import com.google.android.gms.common.internal.ag;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.qt;

public final class Device
        implements SafeParcelable {
    public static final Parcelable.Creator<Device> CREATOR = new i();
    private final int a;
    private final String b;
    private final String c;
    private final String d;
    private final String e;
    private final int f;

    Device(int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt2) {
        this.a = paramInt1;
        this.b = ((String) ag.a(paramString1));
        this.c = ((String) ag.a(paramString2));
        this.d = "";
        this.e = ((String) ag.a(paramString4));
        this.f = paramInt2;
    }

    public Device(String paramString1, String paramString2, String paramString3, int paramInt) {
        this(1, paramString1, paramString2, "", paramString3, paramInt);
    }

    public Device(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt) {
        this(paramString1, paramString2, paramString4, paramInt);
    }

    private boolean a(Device paramDevice) {
        return (ad.a(this.b, paramDevice.b)) && (ad.a(this.c, paramDevice.c)) && (ad.a(this.d, paramDevice.d)) && (ad.a(this.e, paramDevice.e)) && (this.f == paramDevice.f);
    }

    public String a() {
        return this.b;
    }

    public String b() {
        return this.c;
    }

    public String c() {
        return this.d;
    }

    public int d() {
        return this.f;
    }

    public int describeContents() {
        return 0;
    }

    String e() {
        return String.format("%s:%s:%s", new Object[]{this.b, this.c, this.e});
    }

    public boolean equals(Object paramObject) {
        return (this == paramObject) || (((paramObject instanceof Device)) && (a((Device) paramObject)));
    }

    Device f() {
        return new Device(qt.a(this.b), qt.a(this.c), qt.a(this.d), this.e, this.f);
    }

    public String g() {
        if (qt.a()) {
            return this.e;
        }
        return qt.a(this.e);
    }

    int h() {
        return this.a;
    }

    public int hashCode() {
        return ad.a(new Object[]{this.b, this.c, this.d, this.e, Integer.valueOf(this.f)});
    }

    public String toString() {
        return String.format("Device{%s:%s:%s}", new Object[]{e(), this.d, Integer.valueOf(this.f)});
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        i.a(this, paramParcel, paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/fitness/data/Device.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */