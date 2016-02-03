package com.google.android.gms.fitness.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.BleDevice;

public class b
        implements SafeParcelable {
    public static final Parcelable.Creator<b> CREATOR = new h();
    private final int a;
    private final String b;
    private final BleDevice c;

    b(int paramInt, String paramString, BleDevice paramBleDevice) {
        this.a = paramInt;
        this.b = paramString;
        this.c = paramBleDevice;
    }

    public String a() {
        return this.b;
    }

    public BleDevice b() {
        return this.c;
    }

    int c() {
        return this.a;
    }

    public int describeContents() {
        return 0;
    }

    public String toString() {
        return String.format("ClaimBleDeviceRequest{%s %s}", new Object[]{this.b, this.c});
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        h.a(this, paramParcel, paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/fitness/request/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */