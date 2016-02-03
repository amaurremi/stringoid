package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

import java.util.List;

public class v
        implements SafeParcelable {
    public static final Parcelable.Creator<v> CREATOR = new aa();
    public final int a;
    public final int b;
    public final List<ak> c;

    v(int paramInt1, int paramInt2, List<ak> paramList) {
        this.a = paramInt1;
        this.b = paramInt2;
        this.c = paramList;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        aa.a(this, paramParcel, paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/wearable/internal/v.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */