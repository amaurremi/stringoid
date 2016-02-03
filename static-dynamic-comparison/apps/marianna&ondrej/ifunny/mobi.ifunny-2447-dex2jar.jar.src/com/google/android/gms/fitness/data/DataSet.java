package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.ad;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class DataSet
        implements SafeParcelable {
    public static final Parcelable.Creator<DataSet> CREATOR = new f();
    private final int a;
    private final DataSource b;
    private final DataType c;
    private final List<DataPoint> d;
    private final List<DataSource> e;
    private boolean f = false;

    DataSet(int paramInt, DataSource paramDataSource, DataType paramDataType, List<RawDataPoint> paramList, List<DataSource> paramList1, boolean paramBoolean) {
        this.a = paramInt;
        this.b = paramDataSource;
        this.c = paramDataType;
        this.f = paramBoolean;
        this.d = new ArrayList(paramList.size());
        if (paramInt >= 2) {
        }
        for (; ; ) {
            this.e = paramList1;
            paramDataSource = paramList.iterator();
            while (paramDataSource.hasNext()) {
                paramDataType = (RawDataPoint) paramDataSource.next();
                this.d.add(new DataPoint(this.e, paramDataType));
            }
            paramList1 = Collections.singletonList(paramDataSource);
        }
    }

    public DataSet(RawDataSet paramRawDataSet, List<DataSource> paramList, List<DataType> paramList1) {
        this(3, (DataSource) a(paramList, paramRawDataSet.b), (DataType) a(paramList1, paramRawDataSet.c), paramRawDataSet.d, paramList, paramRawDataSet.e);
    }

    private static <T> T a(List<T> paramList, int paramInt) {
        if ((paramInt >= 0) && (paramInt < paramList.size())) {
            return (T) paramList.get(paramInt);
        }
        return null;
    }

    private boolean a(DataSet paramDataSet) {
        return (ad.a(this.c, paramDataSet.c)) && (ad.a(this.b, paramDataSet.b)) && (ad.a(this.d, paramDataSet.d)) && (this.f == paramDataSet.f);
    }

    public DataSource a() {
        return this.b;
    }

    List<RawDataPoint> a(List<DataSource> paramList) {
        ArrayList localArrayList = new ArrayList(this.d.size());
        Iterator localIterator = this.d.iterator();
        while (localIterator.hasNext()) {
            localArrayList.add(new RawDataPoint((DataPoint) localIterator.next(), paramList));
        }
        return localArrayList;
    }

    public DataType b() {
        return this.c;
    }

    public boolean c() {
        return this.f;
    }

    int d() {
        return this.a;
    }

    public int describeContents() {
        return 0;
    }

    List<RawDataPoint> e() {
        return a(this.e);
    }

    public boolean equals(Object paramObject) {
        return (paramObject == this) || (((paramObject instanceof DataSet)) && (a((DataSet) paramObject)));
    }

    List<DataSource> f() {
        return this.e;
    }

    public int hashCode() {
        return ad.a(new Object[]{this.c, this.b});
    }

    public String toString() {
        Object localObject = e();
        String str = this.b.i();
        if (this.d.size() < 10) {
        }
        for (; ; ) {
            return String.format("DataSet{%s %s}", new Object[]{str, localObject});
            localObject = String.format("%d data points, first 5: %s", new Object[]{Integer.valueOf(this.d.size()), ((List) localObject).subList(0, 5)});
        }
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        f.a(this, paramParcel, paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/fitness/data/DataSet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */