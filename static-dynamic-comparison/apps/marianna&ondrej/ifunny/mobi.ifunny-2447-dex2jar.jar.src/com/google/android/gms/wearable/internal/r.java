package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wearable.c;

@Deprecated
public class r
        implements SafeParcelable {
    public static final Parcelable.Creator<r> CREATOR = new w();
    public final int a;
    public final int b;
    public final c c;

    r(int paramInt1, int paramInt2, c paramc) {
        this.a = paramInt1;
        this.b = paramInt2;
        this.c = paramc;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        w.a(this, paramParcel, paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/wearable/internal/r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */