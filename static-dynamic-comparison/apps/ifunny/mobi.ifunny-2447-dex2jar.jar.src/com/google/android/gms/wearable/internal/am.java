package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class am
        implements SafeParcelable {
    public static final Parcelable.Creator<am> CREATOR = new i();
    public final int a;
    public final String b;
    public final String c;
    public final long d;

    am(int paramInt, String paramString1, String paramString2, long paramLong) {
        this.a = paramInt;
        this.b = paramString1;
        this.c = paramString2;
        this.d = paramLong;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        i.a(this, paramParcel, paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/wearable/internal/am.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */