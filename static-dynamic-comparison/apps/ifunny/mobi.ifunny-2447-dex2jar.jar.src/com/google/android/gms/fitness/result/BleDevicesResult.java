package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.r;
import com.google.android.gms.common.internal.ad;
import com.google.android.gms.common.internal.af;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.BleDevice;

import java.util.Collections;
import java.util.List;

public class BleDevicesResult
        implements r, SafeParcelable {
    public static final Parcelable.Creator<BleDevicesResult> CREATOR = new a();
    private final int a;
    private final List<BleDevice> b;
    private final Status c;

    BleDevicesResult(int paramInt, List<BleDevice> paramList, Status paramStatus) {
        this.a = paramInt;
        this.b = Collections.unmodifiableList(paramList);
        this.c = paramStatus;
    }

    private boolean a(BleDevicesResult paramBleDevicesResult) {
        return (this.c.equals(paramBleDevicesResult.c)) && (ad.a(this.b, paramBleDevicesResult.b));
    }

    public Status a() {
        return this.c;
    }

    public List<BleDevice> b() {
        return this.b;
    }

    int c() {
        return this.a;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object paramObject) {
        return (this == paramObject) || (((paramObject instanceof BleDevicesResult)) && (a((BleDevicesResult) paramObject)));
    }

    public int hashCode() {
        return ad.a(new Object[]{this.c, this.b});
    }

    public String toString() {
        return ad.a(this).a("status", this.c).a("bleDevices", this.b).toString();
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        a.a(this, paramParcel, paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/fitness/result/BleDevicesResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */