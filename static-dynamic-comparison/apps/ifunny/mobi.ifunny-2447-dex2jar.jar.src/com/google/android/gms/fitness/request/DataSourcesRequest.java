package com.google.android.gms.fitness.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.ad;
import com.google.android.gms.common.internal.af;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.DataType;

import java.util.Collections;
import java.util.List;

public class DataSourcesRequest
        implements SafeParcelable {
    public static final Parcelable.Creator<DataSourcesRequest> CREATOR = new o();
    private final int a;
    private final List<DataType> b;
    private final List<Integer> c;
    private final boolean d;

    DataSourcesRequest(int paramInt, List<DataType> paramList, List<Integer> paramList1, boolean paramBoolean) {
        this.a = paramInt;
        this.b = paramList;
        this.c = paramList1;
        this.d = paramBoolean;
    }

    public List<DataType> a() {
        return Collections.unmodifiableList(this.b);
    }

    public boolean b() {
        return this.d;
    }

    int c() {
        return this.a;
    }

    List<Integer> d() {
        return this.c;
    }

    public int describeContents() {
        return 0;
    }

    public String toString() {
        af localaf = ad.a(this).a("dataTypes", this.b).a("sourceTypes", this.c);
        if (this.d) {
            localaf.a("includeDbOnlySources", "true");
        }
        return localaf.toString();
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        o.a(this, paramParcel, paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/fitness/request/DataSourcesRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */