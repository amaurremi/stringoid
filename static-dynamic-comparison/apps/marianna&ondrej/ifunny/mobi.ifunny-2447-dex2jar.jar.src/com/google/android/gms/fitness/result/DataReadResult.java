package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.r;
import com.google.android.gms.common.internal.ad;
import com.google.android.gms.common.internal.af;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.Bucket;
import com.google.android.gms.fitness.data.DataSet;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.data.RawBucket;
import com.google.android.gms.fitness.data.RawDataSet;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataReadResult
        implements r, SafeParcelable {
    public static final Parcelable.Creator<DataReadResult> CREATOR = new b();
    private final int a;
    private final List<DataSet> b;
    private final Status c;
    private final List<Bucket> d;
    private int e;
    private final List<DataSource> f;
    private final List<DataType> g;

    DataReadResult(int paramInt1, List<RawDataSet> paramList, Status paramStatus, List<RawBucket> paramList1, int paramInt2, List<DataSource> paramList2, List<DataType> paramList3) {
        this.a = paramInt1;
        this.c = paramStatus;
        this.e = paramInt2;
        this.f = paramList2;
        this.g = paramList3;
        this.b = new ArrayList(paramList.size());
        paramList = paramList.iterator();
        while (paramList.hasNext()) {
            paramStatus = (RawDataSet) paramList.next();
            this.b.add(new DataSet(paramStatus, paramList2, paramList3));
        }
        this.d = new ArrayList(paramList1.size());
        paramList = paramList1.iterator();
        while (paramList.hasNext()) {
            paramStatus = (RawBucket) paramList.next();
            this.d.add(new Bucket(paramStatus, paramList2, paramList3));
        }
    }

    private boolean a(DataReadResult paramDataReadResult) {
        return (this.c.equals(paramDataReadResult.c)) && (ad.a(this.b, paramDataReadResult.b)) && (ad.a(this.d, paramDataReadResult.d));
    }

    public Status a() {
        return this.c;
    }

    public int b() {
        return this.e;
    }

    int c() {
        return this.a;
    }

    List<RawBucket> d() {
        ArrayList localArrayList = new ArrayList(this.d.size());
        Iterator localIterator = this.d.iterator();
        while (localIterator.hasNext()) {
            localArrayList.add(new RawBucket((Bucket) localIterator.next(), this.f, this.g));
        }
        return localArrayList;
    }

    public int describeContents() {
        return 0;
    }

    List<RawDataSet> e() {
        ArrayList localArrayList = new ArrayList(this.b.size());
        Iterator localIterator = this.b.iterator();
        while (localIterator.hasNext()) {
            localArrayList.add(new RawDataSet((DataSet) localIterator.next(), this.f, this.g));
        }
        return localArrayList;
    }

    public boolean equals(Object paramObject) {
        return (this == paramObject) || (((paramObject instanceof DataReadResult)) && (a((DataReadResult) paramObject)));
    }

    List<DataSource> f() {
        return this.f;
    }

    List<DataType> g() {
        return this.g;
    }

    public int hashCode() {
        return ad.a(new Object[]{this.c, this.b, this.d});
    }

    public String toString() {
        af localaf = ad.a(this).a("status", this.c);
        if (this.b.size() > 5) {
            localObject = this.b.size() + " data sets";
            localaf = localaf.a("dataSets", localObject);
            if (this.d.size() <= 5) {
                break label123;
            }
        }
        label123:
        for (Object localObject = this.d.size() + " buckets"; ; localObject = this.d) {
            return localaf.a("buckets", localObject).toString();
            localObject = this.b;
            break;
        }
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        b.a(this, paramParcel, paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/fitness/result/DataReadResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */