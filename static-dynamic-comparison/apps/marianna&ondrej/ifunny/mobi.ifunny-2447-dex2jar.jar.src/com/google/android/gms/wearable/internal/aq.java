package com.google.android.gms.wearable.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class aq
        implements SafeParcelable {
    public static final Parcelable.Creator<aq> CREATOR = new k();
    final int a;
    public final d b;

    aq(int paramInt, IBinder paramIBinder) {
        this.a = paramInt;
        if (paramIBinder != null) {
            this.b = e.a(paramIBinder);
            return;
        }
        this.b = null;
    }

    IBinder a() {
        if (this.b == null) {
            return null;
        }
        return this.b.asBinder();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        k.a(this, paramParcel, paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/wearable/internal/aq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */