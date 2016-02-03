package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class ab
        implements SafeParcelable {
    public static final Parcelable.Creator<ab> CREATOR = new c();
    public final int a;
    public final int b;
    public final ak c;

    ab(int paramInt1, int paramInt2, ak paramak) {
        this.a = paramInt1;
        this.b = paramInt2;
        this.c = paramak;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        c.a(this, paramParcel, paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/wearable/internal/ab.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */