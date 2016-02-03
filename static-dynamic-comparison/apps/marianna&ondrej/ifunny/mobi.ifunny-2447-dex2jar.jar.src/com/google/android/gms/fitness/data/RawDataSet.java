package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.ad;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

import java.util.List;

public final class RawDataSet
        implements SafeParcelable {
    public static final Parcelable.Creator<RawDataSet> CREATOR = new p();
    final int a;
    final int b;
    final int c;
    final List<RawDataPoint> d;
    final boolean e;

    RawDataSet(int paramInt1, int paramInt2, int paramInt3, List<RawDataPoint> paramList, boolean paramBoolean) {
        this.a = paramInt1;
        this.b = paramInt2;
        this.c = paramInt3;
        this.d = paramList;
        this.e = paramBoolean;
    }

    public RawDataSet(DataSet paramDataSet, List<DataSource> paramList, List<DataType> paramList1) {
        this.a = 2;
        this.d = paramDataSet.a(paramList);
        this.e = paramDataSet.c();
        this.b = u.a(paramDataSet.a(), paramList);
        this.c = u.a(paramDataSet.b(), paramList1);
    }

    private boolean a(RawDataSet paramRawDataSet) {
        return (this.b == paramRawDataSet.b) && (this.c == paramRawDataSet.c) && (this.e == paramRawDataSet.e) && (ad.a(this.d, paramRawDataSet.d));
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object paramObject) {
        return (this == paramObject) || (((paramObject instanceof RawDataSet)) && (a((RawDataSet) paramObject)));
    }

    public int hashCode() {
        return ad.a(new Object[]{Integer.valueOf(this.b), Integer.valueOf(this.c)});
    }

    public String toString() {
        return String.format("RawDataSet{%s@[%s, %s]}", new Object[]{Integer.valueOf(this.b), Integer.valueOf(this.c), this.d});
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        p.a(this, paramParcel, paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/fitness/data/RawDataSet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */