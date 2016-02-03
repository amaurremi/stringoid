package com.google.android.gms.fitness.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.ad;
import com.google.android.gms.common.internal.af;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.DataSet;

public class DataInsertRequest
        implements SafeParcelable {
    public static final Parcelable.Creator<DataInsertRequest> CREATOR = new k();
    private final int a;
    private final DataSet b;

    DataInsertRequest(int paramInt, DataSet paramDataSet) {
        this.a = paramInt;
        this.b = paramDataSet;
    }

    private boolean a(DataInsertRequest paramDataInsertRequest) {
        return ad.a(this.b, paramDataInsertRequest.b);
    }

    public DataSet a() {
        return this.b;
    }

    int b() {
        return this.a;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object paramObject) {
        return (paramObject == this) || (((paramObject instanceof DataInsertRequest)) && (a((DataInsertRequest) paramObject)));
    }

    public int hashCode() {
        return ad.a(new Object[]{this.b});
    }

    public String toString() {
        return ad.a(this).a("dataSet", this.b).toString();
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        k.a(this, paramParcel, paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/fitness/request/DataInsertRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */