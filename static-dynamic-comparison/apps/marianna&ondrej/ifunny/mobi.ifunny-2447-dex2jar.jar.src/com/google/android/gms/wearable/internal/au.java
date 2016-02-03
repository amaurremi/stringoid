package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

import java.util.List;

public class au
        implements SafeParcelable {
    public static final Parcelable.Creator<au> CREATOR = new n();
    public final int a;
    public final int b;
    public final long c;
    public final List<am> d;

    au(int paramInt1, int paramInt2, long paramLong, List<am> paramList) {
        this.a = paramInt1;
        this.b = paramInt2;
        this.c = paramLong;
        this.d = paramList;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        n.a(this, paramParcel, paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/wearable/internal/au.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */