package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.ad;
import com.google.android.gms.common.internal.af;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.DataType;

import java.util.Collections;
import java.util.List;

public class lf
        implements SafeParcelable {
    public static final Parcelable.Creator<lf> CREATOR = new qv();
    private final int a;
    private final List<DataType> b;

    lf(int paramInt, List<DataType> paramList) {
        this.a = paramInt;
        this.b = paramList;
    }

    public List<DataType> a() {
        return Collections.unmodifiableList(this.b);
    }

    int b() {
        return this.a;
    }

    public int describeContents() {
        return 0;
    }

    public String toString() {
        return ad.a(this).a("dataTypes", this.b).toString();
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        qv.a(this, paramParcel, paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/internal/lf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */