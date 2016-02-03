package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class l
        implements SafeParcelable {
    public static final Parcelable.Creator<l> CREATOR = new q();
    long a;
    long b;
    private final int c;

    l() {
        this.c = 1;
    }

    l(int paramInt, long paramLong1, long paramLong2) {
        this.c = paramInt;
        this.a = paramLong1;
        this.b = paramLong2;
    }

    public int a() {
        return this.c;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        q.a(this, paramParcel, paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/wallet/wobs/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */