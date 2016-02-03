package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wearable.c;

public class t
        implements SafeParcelable {
    public static final Parcelable.Creator<t> CREATOR = new y();
    public final int a;
    public final int b;
    public final c[] c;

    t(int paramInt1, int paramInt2, c[] paramArrayOfc) {
        this.a = paramInt1;
        this.b = paramInt2;
        this.c = paramArrayOfc;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        y.a(this, paramParcel, paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/wearable/internal/t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */