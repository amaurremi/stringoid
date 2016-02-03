package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.ad;
import com.google.android.gms.common.internal.af;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class Subscription
        implements SafeParcelable {
    public static final Parcelable.Creator<Subscription> CREATOR = new t();
    private final int a;
    private final DataSource b;
    private final DataType c;
    private final long d;
    private final int e;

    Subscription(int paramInt1, DataSource paramDataSource, DataType paramDataType, long paramLong, int paramInt2) {
        this.a = paramInt1;
        this.b = paramDataSource;
        this.c = paramDataType;
        this.d = paramLong;
        this.e = paramInt2;
    }

    private boolean a(Subscription paramSubscription) {
        return (ad.a(this.b, paramSubscription.b)) && (ad.a(this.c, paramSubscription.c)) && (this.d == paramSubscription.d) && (this.e == paramSubscription.e);
    }

    public DataSource a() {
        return this.b;
    }

    public DataType b() {
        return this.c;
    }

    public int c() {
        return this.e;
    }

    public long d() {
        return this.d;
    }

    public int describeContents() {
        return 0;
    }

    int e() {
        return this.a;
    }

    public boolean equals(Object paramObject) {
        return (this == paramObject) || (((paramObject instanceof Subscription)) && (a((Subscription) paramObject)));
    }

    public int hashCode() {
        return ad.a(new Object[]{this.b, this.b, Long.valueOf(this.d), Integer.valueOf(this.e)});
    }

    public String toString() {
        return ad.a(this).a("dataSource", this.b).a("dataType", this.c).a("samplingIntervalMicros", Long.valueOf(this.d)).a("accuracyMode", Integer.valueOf(this.e)).toString();
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        t.a(this, paramParcel, paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/fitness/data/Subscription.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */