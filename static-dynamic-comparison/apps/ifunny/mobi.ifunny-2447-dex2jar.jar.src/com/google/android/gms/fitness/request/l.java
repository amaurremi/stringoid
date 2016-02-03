package com.google.android.gms.fitness.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.DataType;

public class l
        implements SafeParcelable {
    public static final Parcelable.Creator<l> CREATOR = new y();
    private final int a;
    private final DataType b;

    l(int paramInt, DataType paramDataType) {
        this.a = paramInt;
        this.b = paramDataType;
    }

    public DataType a() {
        return this.b;
    }

    int b() {
        return this.a;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        y.a(this, paramParcel, paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/fitness/request/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */