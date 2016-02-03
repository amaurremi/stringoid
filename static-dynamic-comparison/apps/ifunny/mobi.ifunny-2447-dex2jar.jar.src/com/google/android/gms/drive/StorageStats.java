package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class StorageStats
        implements SafeParcelable {
    public static final Parcelable.Creator<StorageStats> CREATOR = new e();
    final int a;
    final long b;
    final long c;
    final long d;
    final long e;
    final int f;

    StorageStats(int paramInt1, long paramLong1, long paramLong2, long paramLong3, long paramLong4, int paramInt2) {
        this.a = paramInt1;
        this.b = paramLong1;
        this.c = paramLong2;
        this.d = paramLong3;
        this.e = paramLong4;
        this.f = paramInt2;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        e.a(this, paramParcel, paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/drive/StorageStats.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */