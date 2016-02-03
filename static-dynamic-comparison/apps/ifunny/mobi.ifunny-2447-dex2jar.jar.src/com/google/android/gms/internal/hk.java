package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class hk
        implements SafeParcelable {
    public static final oc CREATOR = new oc();
    final int a;
    public final int b;
    final Bundle c;

    hk(int paramInt1, int paramInt2, Bundle paramBundle) {
        this.a = paramInt1;
        this.b = paramInt2;
        this.c = paramBundle;
    }

    public int describeContents() {
        oc localoc = CREATOR;
        return 0;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        oc localoc = CREATOR;
        oc.a(this, paramParcel, paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/internal/hk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */