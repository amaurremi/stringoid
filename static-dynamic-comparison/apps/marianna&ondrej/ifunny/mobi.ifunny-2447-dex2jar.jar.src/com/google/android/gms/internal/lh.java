package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.DataSource;

public class lh
        implements SafeParcelable {
    public static final Parcelable.Creator<lh> CREATOR = new qw();
    private final int a;
    private final DataSource b;

    lh(int paramInt, DataSource paramDataSource) {
        this.a = paramInt;
        this.b = paramDataSource;
    }

    public DataSource a() {
        return this.b;
    }

    int b() {
        return this.a;
    }

    public int describeContents() {
        return 0;
    }

    public String toString() {
        return String.format("ApplicationUnregistrationRequest{%s}", new Object[]{this.b});
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        qw.a(this, paramParcel, paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/internal/lh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */