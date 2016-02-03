package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class ac
        implements SafeParcelable {
    public static final Parcelable.Creator<ac> CREATOR = new d();
    private final int a;
    private final s b;

    ac(int paramInt, IBinder paramIBinder) {
        this.a = paramInt;
        this.b = u.a(paramIBinder);
    }

    int a() {
        return this.a;
    }

    public IBinder b() {
        return this.b.asBinder();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        d.a(this, paramParcel, paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/fitness/request/ac.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */