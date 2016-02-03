package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.ad;
import com.google.android.gms.common.internal.af;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class q
        implements SafeParcelable {
    public static final Parcelable.Creator<q> CREATOR = new s();
    final int a;
    private final Session b;
    private final DataSet c;

    q(int paramInt, Session paramSession, DataSet paramDataSet) {
        this.a = paramInt;
        this.b = paramSession;
        this.c = paramDataSet;
    }

    private boolean a(q paramq) {
        return (ad.a(this.b, paramq.b)) && (ad.a(this.c, paramq.c));
    }

    public Session a() {
        return this.b;
    }

    public DataSet b() {
        return this.c;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object paramObject) {
        return (paramObject == this) || (((paramObject instanceof q)) && (a((q) paramObject)));
    }

    public int hashCode() {
        return ad.a(new Object[]{this.b, this.c});
    }

    public String toString() {
        return ad.a(this).a("session", this.b).a("dataSet", this.c).toString();
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        s.a(this, paramParcel, paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/fitness/data/q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */