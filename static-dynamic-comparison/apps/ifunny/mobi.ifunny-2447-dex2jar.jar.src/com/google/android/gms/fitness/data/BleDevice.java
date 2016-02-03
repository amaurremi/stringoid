package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.ad;
import com.google.android.gms.common.internal.af;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.qs;

import java.util.Collections;
import java.util.List;

public class BleDevice
        implements SafeParcelable {
    public static final Parcelable.Creator<BleDevice> CREATOR = new c();
    private final int a;
    private final String b;
    private final String c;
    private final List<String> d;
    private final List<DataType> e;

    BleDevice(int paramInt, String paramString1, String paramString2, List<String> paramList, List<DataType> paramList1) {
        this.a = paramInt;
        this.b = paramString1;
        this.c = paramString2;
        this.d = Collections.unmodifiableList(paramList);
        this.e = Collections.unmodifiableList(paramList1);
    }

    private boolean a(BleDevice paramBleDevice) {
        return (this.c.equals(paramBleDevice.c)) && (this.b.equals(paramBleDevice.b)) && (qs.a(paramBleDevice.d, this.d)) && (qs.a(this.e, paramBleDevice.e));
    }

    public String a() {
        return this.b;
    }

    public String b() {
        return this.c;
    }

    public List<String> c() {
        return this.d;
    }

    public List<DataType> d() {
        return this.e;
    }

    public int describeContents() {
        return 0;
    }

    int e() {
        return this.a;
    }

    public boolean equals(Object paramObject) {
        return (paramObject == this) || (((paramObject instanceof BleDevice)) && (a((BleDevice) paramObject)));
    }

    public int hashCode() {
        return ad.a(new Object[]{this.c, this.b, this.d, this.e});
    }

    public String toString() {
        return ad.a(this).a("name", this.c).a("address", this.b).a("dataTypes", this.e).a("supportedProfiles", this.d).toString();
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        c.a(this, paramParcel, paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/fitness/data/BleDevice.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */