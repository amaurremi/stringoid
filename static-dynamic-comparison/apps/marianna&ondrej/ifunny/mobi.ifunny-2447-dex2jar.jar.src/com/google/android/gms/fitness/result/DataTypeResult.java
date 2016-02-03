package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.r;
import com.google.android.gms.common.internal.ad;
import com.google.android.gms.common.internal.af;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.DataType;

public class DataTypeResult
        implements r, SafeParcelable {
    public static final Parcelable.Creator<DataTypeResult> CREATOR = new d();
    private final int a;
    private final Status b;
    private final DataType c;

    DataTypeResult(int paramInt, Status paramStatus, DataType paramDataType) {
        this.a = paramInt;
        this.b = paramStatus;
        this.c = paramDataType;
    }

    private boolean a(DataTypeResult paramDataTypeResult) {
        return (this.b.equals(paramDataTypeResult.b)) && (ad.a(this.c, paramDataTypeResult.c));
    }

    public Status a() {
        return this.b;
    }

    public DataType b() {
        return this.c;
    }

    int c() {
        return this.a;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object paramObject) {
        return (this == paramObject) || (((paramObject instanceof DataTypeResult)) && (a((DataTypeResult) paramObject)));
    }

    public int hashCode() {
        return ad.a(new Object[]{this.b, this.c});
    }

    public String toString() {
        return ad.a(this).a("status", this.b).a("dataType", this.c).toString();
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        d.a(this, paramParcel, paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/fitness/result/DataTypeResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */