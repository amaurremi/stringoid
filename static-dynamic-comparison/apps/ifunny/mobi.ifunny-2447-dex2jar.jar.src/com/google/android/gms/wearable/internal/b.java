package com.google.android.gms.wearable.internal;

import android.content.IntentFilter;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class b
        implements SafeParcelable {
    public static final Parcelable.Creator<b> CREATOR = new o();
    final int a;
    public final d b;
    public final IntentFilter[] c;

    b(int paramInt, IBinder paramIBinder, IntentFilter[] paramArrayOfIntentFilter) {
        this.a = paramInt;
        if (paramIBinder != null) {
        }
        for (this.b = e.a(paramIBinder); ; this.b = null) {
            this.c = paramArrayOfIntentFilter;
            return;
        }
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
        o.a(this, paramParcel, paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/wearable/internal/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */