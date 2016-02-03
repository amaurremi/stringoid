package com.google.android.gms.fitness.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.af;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.DataPoint;
import com.google.android.gms.fitness.data.DataSet;
import com.google.android.gms.fitness.data.Session;

import java.util.Collections;
import java.util.List;

public class SessionInsertRequest
        implements SafeParcelable {
    public static final Parcelable.Creator<SessionInsertRequest> CREATOR = new ad();
    private final int a;
    private final Session b;
    private final List<DataSet> c;
    private final List<DataPoint> d;

    SessionInsertRequest(int paramInt, Session paramSession, List<DataSet> paramList, List<DataPoint> paramList1) {
        this.a = paramInt;
        this.b = paramSession;
        this.c = Collections.unmodifiableList(paramList);
        this.d = Collections.unmodifiableList(paramList1);
    }

    private boolean a(SessionInsertRequest paramSessionInsertRequest) {
        return (com.google.android.gms.common.internal.ad.a(this.b, paramSessionInsertRequest.b)) && (com.google.android.gms.common.internal.ad.a(this.c, paramSessionInsertRequest.c)) && (com.google.android.gms.common.internal.ad.a(this.d, paramSessionInsertRequest.d));
    }

    public Session a() {
        return this.b;
    }

    public List<DataSet> b() {
        return this.c;
    }

    public List<DataPoint> c() {
        return this.d;
    }

    int d() {
        return this.a;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object paramObject) {
        return (paramObject == this) || (((paramObject instanceof SessionInsertRequest)) && (a((SessionInsertRequest) paramObject)));
    }

    public int hashCode() {
        return com.google.android.gms.common.internal.ad.a(new Object[]{this.b, this.c, this.d});
    }

    public String toString() {
        return com.google.android.gms.common.internal.ad.a(this).a("session", this.b).a("dataSets", this.c).a("aggregateDataPoints", this.d).toString();
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        ad.a(this, paramParcel, paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/fitness/request/SessionInsertRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */